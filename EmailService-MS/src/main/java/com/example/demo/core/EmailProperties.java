package com.example.demo.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class EmailProperties {

	@Value("ivopivoteste@gmail.com")
	private String sender;
}
