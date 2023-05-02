package com.cecilireid.springchallenges;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private final CateringJobRepository cateringJobRepository;

    public ScheduledTasks(CateringJobRepository cateringJobRepository) {
        this.cateringJobRepository = cateringJobRepository;
    }


    @Scheduled(cron = "*/10 * * * * *")
    public void reportOrderStats() {
        logger.info("Number of jobs : "+cateringJobRepository.findAll().size());
    }
}
