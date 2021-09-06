package com.pureIntegration.dog.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Breed {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ElementCollection
    List<String> originCountryList=new ArrayList<>();
}
