package com.pureIntegration.dog;

import com.pureIntegration.dog.Model.Dog;
import com.pureIntegration.dog.service.DogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DogApplicationTests {

	@Autowired
	DogService dogService;
	@Test
	void getDogsTest() throws IOException {
		Dog dog =dogService.getDogs();
		assertNotNull(dog);
	}

}
