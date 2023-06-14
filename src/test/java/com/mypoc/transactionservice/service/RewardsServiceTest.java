package com.mypoc.transactionservice.service;

import com.mypoc.transactionservice.TransactionServiceApplication;
import com.mypoc.transactionservice.openapi.model.GetAllRewardsResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TransactionServiceApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RewardsServiceTest {

    @Autowired
    RewardsService rewardsService;

    @Test
    public void testGetAllRewards() {
        GetAllRewardsResponse response = rewardsService.getAllRewards();
        Assertions.assertTrue(response.getRewards().stream().anyMatch(reward -> reward.getCustomerId() == 201));
    }
}
