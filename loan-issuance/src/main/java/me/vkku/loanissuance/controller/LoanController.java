package me.vkku.loanissuance.controller;

import me.vkku.loanissuance.clientInterface.FraudClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class LoanController {

    @LoadBalanced
    RestTemplate restTemplate;
    FraudClient fraudClient;

    public LoanController(RestTemplate restTemplate, FraudClient fraudClient){

        this.restTemplate = restTemplate;
        this.fraudClient = fraudClient;

    }

    @GetMapping("/resttemplate/{id}/fraud")
    public List<String> getFraudsters(@PathVariable("id") int id){
        final String baseUrl = "http://fraud-detection";
        return this.restTemplate.getForObject(baseUrl + "/frauds", List.class);
    }

    @GetMapping("/openfeign/loan/{id}/fraud")
    public List<String> getFraudUsingFeign(@PathVariable("id") int id){
        return fraudClient.getFraudsters();
    }



}
