package com.cecilireid.springchallenges;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Component
@Endpoint(id = "status")

public class CateringJobsEndpoint {
    private final CateringJobRepository cateringJobRepository;

    public CateringJobsEndpoint(CateringJobRepository cateringJobRepository) {
        this.cateringJobRepository = cateringJobRepository;
    }

    @ReadOperation
    public Map<Status, Long> getAllJobsForStatus() {
       /* Map<Status, Integer> mapStatus = new HashMap<>();
         Arrays.asList(Status.values()).stream()
                .forEach(status -> {mapStatus.put(status,cateringJobRepository.findByStatus(status).size() ); });
*/
        return cateringJobRepository.findAll()
                .stream()
                .collect(groupingBy(CateringJob::getStatus, Collectors.counting()));

    }
}
