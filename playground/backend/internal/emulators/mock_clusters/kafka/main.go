package main

import (
	"fmt"

	"github.com/confluentinc/confluent-kafka-go/kafka"
)

func main() {
	brokerCount := 1
	mock, err := kafka.NewMockCluster(brokerCount)
	if err != nil {
		panic(err)
	}
	bootstrapServers := mock.BootstrapServers()
	fmt.Printf("bootstrap.servers=%s\n", bootstrapServers)

	mock.Close()
	select {}
}
