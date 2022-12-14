package com.microservices.demo.twitter.to.kafka.service;

import com.microservices.demo.config.TwitterToKafkaServiceConfigData;
import com.microservices.demo.twitter.to.kafka.service.init.StreamInitializer;
import com.microservices.demo.twitter.to.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.retrytopic.RetryTopicConfiguration;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan (basePackages = "com.microservices.demo")
public class TwitterToKafkaServiceApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);

//    private final TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData;

    private final StreamRunner streamRunner;

    private final StreamInitializer streamInitializer;

    public TwitterToKafkaServiceApplication(StreamRunner runner, StreamInitializer initializer) {
//        this.twitterToKafkaServiceConfigData = configData;
        streamRunner = runner;
        streamInitializer = initializer;
//       RetryTopicConfiguration retryTopicConfiguration = null;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println("App starts.. (" + args + ") ");
        LOG.info("App starts.. (" + Arrays.toString(args) + ") ");
//        LOG.info(Arrays.toString(twitterToKafkaServiceConfigData.getTwitterKeywords().toArray(new String[] {})));
//        LOG.info(Arrays.toString(twitterToKafkaServiceConfigData.getWelcomeMessage().toArray(new String[] {})));
        streamInitializer.init();
        streamRunner.start();
    }
}
