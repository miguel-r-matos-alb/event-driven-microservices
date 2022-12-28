package com.microservices.demo.kafka.to.elastic.service.consumer;

import com.microservices.demo.kafka.avro.model.TwitterAvroModel;
import org.apache.avro.specific.SpecificRecordBase;

import java.io.Serializable;
import java.util.List;

//public interface KafkaConsumer<T extends SpecificRecordBase> {
//    void receive(List<T> messages, List<Long> keys, List<Integer> partitions, List<Long> offsets);
//}

public interface KafkaConsumer<k extends Serializable, V extends SpecificRecordBase> {
    void receive(List<TwitterAvroModel> messages, List<Integer> keys, List<Integer> partitions, List<Long> offsets);
}
