package me.vkku.loanissuance.clientInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("fraud-detection")
public interface FraudClient {

    @GetMapping("/frauds")
    public List<String> getFraudsters();

}
