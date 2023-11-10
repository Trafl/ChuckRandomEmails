package com.example.demo.domain.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.model.dto.PhraseDTO;

@FeignClient(url = "https://api.chucknorris.io/jokes/random", name = "ChuckPhrase")
public interface ChuckNorrisIoClient {

	@GetMapping
	PhraseDTO getRandomPhrase();
}
