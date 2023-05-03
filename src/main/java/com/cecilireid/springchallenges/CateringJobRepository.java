package com.cecilireid.springchallenges;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CateringJobRepository extends CrudRepository<CateringJob, Long> {
    List<CateringJob> findAll();
    List<CateringJob> findByStatus(Status status);
    Optional<CateringJob> findTopByOrderByIdAsc();

}
