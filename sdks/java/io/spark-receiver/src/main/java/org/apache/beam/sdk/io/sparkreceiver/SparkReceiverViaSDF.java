package org.apache.beam.sdk.io.sparkreceiver;

import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PBegin;
import org.apache.beam.sdk.values.PCollection;

public class SparkReceiverViaSDF<K, V> extends PTransform<PBegin, PCollection<KV<K, V>>> {
    SparkReceiverIO.Read<K, V> sparkReceiverRead;
    Coder<K> keyCoder;
    Coder<V> valueCoder;

    SparkReceiverViaSDF(SparkReceiverIO.Read<K, V> sparkReceiverRead, Coder<K> keyCoder, Coder<V> valueCoder) {
        this.sparkReceiverRead = sparkReceiverRead;
        this.keyCoder = keyCoder;
        this.valueCoder = valueCoder;
    }

    @Override
    public PCollection<KV<K, V>> expand(PBegin input) {
        return null;
    }

}


// check org.apache.beam.sdk.io.kafka.KafkaIO.Read.ReadFromKafkaViaSDF