package com.cloud.project;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.Properties;

@SpringBootApplication
@RefreshScope
public class Producer {
	public static void main(String[] args) {
		SpringApplication.run(Producer.class, args);

		Properties props = new Properties();

		//Assign localhost id
		props.put("bootstrap.servers", "localhost:29092");

		//Set acknowledgements for producer requests.
		props.put("acks", "all");

		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");

		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");

		org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer
				<String, String>(props);

		for(int i = 0; i < 10; i++)
			producer.send(new ProducerRecord<>("topic",
					Integer.toString(i), Integer.toString(i)));
		System.out.println("Message sent successfully");
		producer.close();


	}

}
