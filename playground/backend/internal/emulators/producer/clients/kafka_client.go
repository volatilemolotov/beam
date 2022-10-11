package clients

import (
	"encoding/json"
	"fmt"

	"github.com/confluentinc/confluent-kafka-go/kafka"

	"beam.apache.org/playground/backend/internal/emulators/producer/dataset_parsers"
)

type KafkaProducer struct {
	client *kafka.Producer
}

func NewKafkaProducer() *KafkaProducer {
	p, err := kafka.NewProducer(&kafka.ConfigMap{
		"bootstrap.servers": "localhost:9092",
	})
	if err != nil {
		fmt.Printf("Failed to create producer: %s\n", err)
	}
	return &KafkaProducer{client: p}
}

func (p *KafkaProducer) ProduceDatasets() {
	jp := dataset_parsers.NewJsonParser()
	users := jp.GetUsers()
	strings := jp.GetStrings()

	deliveryChan := make(chan kafka.Event, 2)

	topic := new(string)
	*topic = "test"

	wordsTopic := new(string)
	*wordsTopic = "words"

	for _, user := range users.Users {
		userBytes, _ := json.Marshal(user)
		if err := p.client.Produce(&kafka.Message{
			TopicPartition: kafka.TopicPartition{Topic: topic, Partition: kafka.PartitionAny},
			Value:          userBytes},
			deliveryChan,
		); err != nil {
			fmt.Printf("Failed to produce message: %s\n", err)
		}
	}

	for _, entry := range strings.Strings {
		entryBytes, _ := json.Marshal(entry)
		if err := p.client.Produce(&kafka.Message{
			TopicPartition: kafka.TopicPartition{Topic: wordsTopic, Partition: kafka.PartitionAny},
			Value:          entryBytes},
			deliveryChan,
		); err != nil {
			fmt.Printf("Failed to produce message: %s\n", err)
		}
	}

	e := <-deliveryChan
	m := e.(*kafka.Message)

	if m.TopicPartition.Error != nil {
		fmt.Printf("Delivery failed: %v\n", m.TopicPartition.Error)
	} else {
		fmt.Printf("Delivered message to topic %s [%d] at offset %v\n",
			*m.TopicPartition.Topic, m.TopicPartition.Partition, m.TopicPartition.Offset)
	}
}
