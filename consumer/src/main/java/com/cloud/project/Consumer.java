package com.cloud.project;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.CooperativeStickyAssignor;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@SpringBootApplication
@EnableFeignClients
public class Consumer {
	public static void main(String[] args) {
		SpringApplication.run(Consumer.class, args);
		String topic = "topic";

		// create Producer Properties
		Properties properties = new Properties();

		// connect to Localhost
//        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");

		//Assign localhost id
		properties.put("bootstrap.servers", "localhost:29092");

		//Set acknowledgements for producer requests.
		properties.put("acks", "all");


		// create consumer configs
		properties.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.setProperty("auto.offset.reset", "earliest");
		properties.setProperty("partition.assignment.strategy", CooperativeStickyAssignor.class.getName());
//        properties.setProperty("group.instance.id", "...."); // strategy for static assignments


		// create a consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

		// get a reference to the main thread
		final Thread mainThread = Thread.currentThread();

		// adding the shutdown hook
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Detected a shutdown, let's exit by calling consumer.wakeup()...");
				consumer.wakeup();

				// join the main thread to allow the execution of the code in the main thread
				try {
					mainThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		try {
			// subscribe to a topic
			consumer.subscribe(List.of(topic));
			// poll for data
			while (true) {
				ConsumerRecords<String, String> records =
						consumer.poll(Duration.ofMillis(1000));

				for (ConsumerRecord<String, String> record : records) {
					System.out.println("Key: " + record.key() + ", Value: " + record.value());
					System.out.println("Partition: " + record.partition() + ", Offset: " + record.offset());
				}

			}

		} catch (WakeupException e) {
			System.out.println("Consumer is starting to shut down");
		} catch (Exception e) {
			System.out.println("Unexpected exception in the consumer");
		} finally {
			consumer.close(); // close the consumer, this will also commit offsets
			System.out.println("The consumer is now gracefully shut down");
		}


	}
}
