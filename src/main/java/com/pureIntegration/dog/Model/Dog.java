package com.pureIntegration.dog.Model;

import lombok.Data;


import java.util.List;
import java.util.Map;

@Data
public class Dog {
    private Long id;
    private Map<String, List<String>> dogs;
    private String status;
}
