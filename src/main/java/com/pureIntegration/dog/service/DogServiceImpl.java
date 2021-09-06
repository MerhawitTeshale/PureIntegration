package com.pureIntegration.dog.service;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pureIntegration.dog.Model.Breed;
import com.pureIntegration.dog.Model.Dog;
import com.pureIntegration.dog.Model.OriginCountry;
import com.pureIntegration.dog.persistnce.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DogServiceImpl implements DogService{

    @Autowired
    DogRepository repository;

    @Override
    public Dog creatDog(Dog newDog) {
        return repository.save(newDog);
    }

    @Override
    public Dog getDogs() throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
       TypeReference<Map<String,List<String>>> typeReference=new TypeReference<Map<String, List<String>>>() {
       };
        InputStream inputStream=typeReference.getClass().getResourceAsStream("/static/dogData.json");

        Map<String, List<String>> mappped=new HashMap<>();
        try{

            mappped=objectMapper.readValue(inputStream,typeReference);

            Breed breed =new Breed();
            OriginCountry originCountry=new OriginCountry();


            List<String> country=new ArrayList<>();
            for(Map.Entry<String,List<String>> listEntry: mappped.entrySet()){
                breed.setName(listEntry.getKey());
                for(String cname:listEntry.getValue()){
                    country.add(cname);
                }
                breed.setOriginCountryList(country);
            }
        } catch (Exception e){
            //TODO:
        }
        Dog dog =new Dog();
        dog.setDogs(mappped);
        dog.setStatus("Success");

        return dog;

    }

    @Override
    public Dog addDog(Dog newDog) {
        return repository.save(newDog);
    }

    @Override
    public void deleteDog(Long id) {
        //Dog dog =repository.findAllById(id);
        //repository.delete(dog);
    }
}
