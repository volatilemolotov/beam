package main

import (
	"time"

	"beam.apache.org/playground/backend/internal/emulators/producer/clients"
)

func main() {
	kafkaProducer := clients.NewKafkaProducer("50494")
	kafkaProducer.ProduceDatasets()
	time.Sleep(time.Second * 3)
}
