package com.example.demo.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Email {

	private String from;
	private String to;
	private String subject;
	private String text;
}
