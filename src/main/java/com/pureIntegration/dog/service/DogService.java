package com.pureIntegration.dog.service;

import com.pureIntegration.dog.Model.Dog;

import java.io.IOException;

public interface DogService {

    public Dog creatDog(Dog newDog);
    public Dog getDogs() throws IOException;
    public Dog addDog(Dog newDog);
    public void deleteDog(Long id);

}
