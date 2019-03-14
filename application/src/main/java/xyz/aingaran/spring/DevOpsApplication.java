package xyz.aingaran.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


@SpringBootApplication
@EnableJpaAuditing
public class DevOpsApplication {
	private static final Logger logger = LoggerFactory.getLogger(ElasticSearchApplication.class);
	private AtomicInteger number = new AtomicInteger(0);

	public static void main(String[] args) {
		SpringApplication.run(DevOpsApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void onStartUp() throws InterruptedException {
		for (int i = 0; i < 30; i++) {
			logger.info("Request number " + number.getAndIncrement() + " number was processed!");
			Thread.sleep(new Random().nextInt(200));
		}
	}

}
