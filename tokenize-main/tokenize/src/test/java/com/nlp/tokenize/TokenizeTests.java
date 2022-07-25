package com.nlp.tokenize;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nlp.tokenize.controller.myController;

@DataJpaTest
public class TokenizeTests {
	@Autowired
	private TokenizeApplication token;
	@Test
	@PostMapping("/userinfo")
	public void saveUser(@RequestBody myController User) {
		token.save(User);
		Assertions.assertThat(myController.getUser()).doesNotHave(null);
	}
	
	
}
