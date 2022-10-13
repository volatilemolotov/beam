package clients

import (
	"encoding/json"
	"fmt"
	"sync"

	"github.com/confluentinc/confluent-kafka-go/kafka"

	"beam.apache.org/playground/backend/internal/emulators/producer/dataset_parsers"
)

type KafkaProducer struct {
	client *kafka.Producer
}

func NewKafkaProducer(port string) *KafkaProducer {
	bootstrapAddr := fmt.Sprintf("localhost:%s", port)
	p, err := kafka.NewProducer(&kafka.ConfigMap{
		"bootstrap.servers": bootstrapAddr,
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

	wg := sync.WaitGroup{}

	for i := 0; i < 2; i++ {
		wg.Add(1)
		go func(i int) {
			fmt.Println("producing messages: ", i)
			defer wg.Done()

			topic := new(string)
			*topic = fmt.Sprintf("%s%d", "test", i)

			wordsTopic := new(string)
			*wordsTopic = fmt.Sprintf("%s%d", "words", i)

			for _, user := range users.Users {
				userBytes, _ := json.Marshal(user)
				if err := p.client.Produce(&kafka.Message{
					TopicPartition: kafka.TopicPartition{Topic: topic, Partition: kafka.PartitionAny},
					Value:          userBytes},
					nil,
				); err != nil {
					fmt.Printf("Failed to produce message: %s\n", err)
				}
			}

			for _, entry := range strings.Strings {
				entryBytes, _ := json.Marshal(entry)
				if err := p.client.Produce(&kafka.Message{
					TopicPartition: kafka.TopicPartition{Topic: wordsTopic, Partition: kafka.PartitionAny},
					Value:          entryBytes},
					nil,
				); err != nil {
					fmt.Printf("Failed to produce message: %s\n", err)
				}
			}
		}(i)
	}

	wg.Wait()
}
