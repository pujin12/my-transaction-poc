package com.mypoc.transactionservice.controller;

import com.mypoc.transactionservice.openapi.api.RewardsApi;
import com.mypoc.transactionservice.service.RewardsService;
import com.mypoc.transactionservice.openapi.model.GetAllRewardsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class RewardsController implements RewardsApi {

    @Autowired
    RewardsService rewardsService;

    @Override
    public ResponseEntity<GetAllRewardsResponse> getAllRewards() {
        return new ResponseEntity<>(rewardsService.getAllRewards(), HttpStatus.OK);
    }
}
