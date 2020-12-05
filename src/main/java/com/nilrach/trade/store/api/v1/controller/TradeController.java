package com.nilrach.trade.store.api.v1.controller;

import com.nilrach.trade.store.api.v1.model.Trade;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TradeController {

    @GetMapping(path = "/trades", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trade>> getAllTrades() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
