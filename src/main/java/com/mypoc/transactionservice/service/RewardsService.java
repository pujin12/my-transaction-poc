package com.mypoc.transactionservice.service;

import com.mypoc.transactionservice.entity.Transaction;
import com.mypoc.transactionservice.openapi.model.GetAllRewardsResponse;
import com.mypoc.transactionservice.openapi.model.Reward;
import com.mypoc.transactionservice.repo.TransactionRepo;
import io.micrometer.tracing.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RewardsService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    Tracer tracer;

    public GetAllRewardsResponse getAllRewards() {
        log.info("Trace id {}", tracer.currentSpan().context().traceId());
        GetAllRewardsResponse rewardsResponse = new GetAllRewardsResponse();
        List<Transaction> transactions = transactionRepo.findAll();
        List<Reward> rewardDtos = transactions.stream().map(transaction -> {
            Reward rewardDto = new Reward();
            rewardDto.setCustomerId(transaction.getCustomer().getCustomerId());
            return rewardDto;
        }).collect(Collectors.toList());
        rewardsResponse.setRewards(rewardDtos);
        return rewardsResponse;
    }
}
