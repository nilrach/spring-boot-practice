package com.nilrach.trade.store.api.v1.controller;

import com.nilrach.trade.store.api.v1.model.Trade;
import com.nilrach.trade.store.entity.TradeEntity;
import com.nilrach.trade.store.service.TradeStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class TradeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeController.class);
    private final TradeStoreService tradeStoreService;

    @Autowired
    public TradeController(TradeStoreService tradeStoreService) {
        this.tradeStoreService = tradeStoreService;
    }


    @GetMapping(path = "/trades", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trade>> getAllTrades() {
        LOGGER.info("Received request to get all trades.");
        List<TradeEntity> allTrades = tradeStoreService.getAllTrades();
        return new ResponseEntity<List<Trade>>(allTrades.stream().map(Trade::convert).collect(Collectors.toList()),
                HttpStatus.OK);
    }
}
