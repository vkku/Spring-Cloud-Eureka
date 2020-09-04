package me.vkku.frauddetection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FraudDetectionController {

    @GetMapping("/frauds")
    public List<String> fraudNaming(){
        return Arrays.asList("Saurabh", "Saurabh's Clone");
    }

}
