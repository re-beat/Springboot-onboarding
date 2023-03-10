package com.example.onboarding.poc2.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.example.onboarding.poc2.dto.ResponseDTO;
import com.example.onboarding.poc2.model.BooksModel;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BooksControllerTest {																												

	@LocalServerPort
    private int port;

    private String url;

    @Autowired
    private TestRestTemplate restTemplate;
        
    @Test
    public void test_insert() {
    	url = String.format("http://localhost:%d/books/insert", port);
    	BooksModel request = new BooksModel("test junit","test description junit", "test author junit");
    	
    	ResponseDTO result = this.restTemplate.postForObject(url, request, ResponseDTO.class);
    	assertThat(result.getCode().equals("200"));
    }
    
}
