package com.example.demo.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.demo.domain.model.dto.UserDTOOutput;
import com.example.demo.domain.service.EmailService;
import com.example.demo.domain.service.EmailService.Message;
import com.example.demo.domain.service.feign.ChuckNorrisIoClient;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ChuckListener {

	private final ChuckNorrisIoClient chuckNorrisIoClient;

	private final EmailService emailService;

	@RabbitListener(queues = "chuck-ms-to-email")
	public void reciveMessage(@Payload UserDTOOutput user) {

		var phrase = chuckNorrisIoClient.getRandomPhrase().getValue();
		
		user.setPhrase(phrase);

		var subText = "Hello " + user.getName() + ", discover your phrase !!";

		var message = Message.builder()
				.subText(subText)
				.addressee(user.getEmail())
				.body("email-template.html")
				.variable("user", user)
				.build();

		emailService.sendEmail(message);
		
	}
}
