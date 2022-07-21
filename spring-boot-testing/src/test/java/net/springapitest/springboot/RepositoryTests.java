package net.springapitest.springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.properties.PropertyMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import antlr.collections.List;

@DataJpaTest
public class RepositoryTests {

	@Autowired
	private Repository repository;
	
	@Test
	@PostMapping("/user")
	public void saveUser(@RequestBody user User) {
		repository.save(User);
		Assertions.assertThat(user.getId()).doesNotHave(null);
	}
	
	@Test
	public void getListOfUser()
	{
		List<user> User=repository.findAll(); 
		Assertions.assertThat(User.size()).isGreaterThan(0);
	}
}
