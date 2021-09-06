package com.pureIntegration.dog.persistnce;

import com.pureIntegration.dog.Model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog,Long> {

}
