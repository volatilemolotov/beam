package clients

import (
	"encoding/json"
	"fmt"
	"sync"

	"github.com/confluentinc/confluent-kafka-go/kafka"

	"beam.apache.org/playground/backend/internal/emulators/producer/dataset_parsers"
)

type KafkaProducer struct {
	admin    *kafka.AdminClient
	producer *kafka.Producer
}

func NewKafkaProducer(port string) *KafkaProducer {
	conf := &kafka.ConfigMap{
		"bootstrap.servers": fmt.Sprintf("localhost:%s", port),
	}
	p, err := kafka.NewProducer(conf)
	if err != nil {
		fmt.Printf("Failed to create producer: %s\n", err.Error())
	}
	a, err := kafka.NewAdminClient(conf)
	if err != nil {
		fmt.Printf("Failed to create admin: %s\n", err.Error())
	}
	return &KafkaProducer{admin: a, producer: p}
}

func (p *KafkaProducer) ProduceDatasets() {
	jp := dataset_parsers.NewJsonParser()
	strings := jp.GetStrings()
	topicAmount := 1

	wg := sync.WaitGroup{}

	for i := 0; i < topicAmount; i++ {
		wg.Add(1)
		go func(i int) {
			fmt.Println("producing messages: ", i)
			defer wg.Done()

			wordsTopic := new(string)
			*wordsTopic = fmt.Sprintf("%s%d", "words", i)

			for _, entry := range strings.Strings {
				entryBytes, _ := json.Marshal(entry)
				if err := p.producer.Produce(&kafka.Message{
					TopicPartition: kafka.TopicPartition{Topic: wordsTopic, Partition: 0},
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
