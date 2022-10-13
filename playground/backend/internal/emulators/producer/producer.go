package main

import (
	"beam.apache.org/playground/backend/internal/emulators/producer/clients"
)

func main() {
	kafkaProducer := clients.NewKafkaProducer("9092")
	kafkaProducer.ProduceDatasets()
}
