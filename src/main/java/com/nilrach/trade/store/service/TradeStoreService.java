package com.nilrach.trade.store.service;

import com.nilrach.trade.store.entity.TradeEntity;
import com.nilrach.trade.store.model.Trade;
import com.nilrach.trade.store.model.TradeBuilder;
import com.nilrach.trade.store.repository.TradeRepository;
import com.nilrach.trade.store.validaor.TradeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeStoreService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeStoreService.class);

    private final TradeRepository tradeRepository;
    private final TradeValidator tradeValidator;

    @Autowired
    public TradeStoreService(TradeRepository tradeRepository, TradeValidator tradeValidator) {
        this.tradeRepository = tradeRepository;
        this.tradeValidator = tradeValidator;
    }

    public List<Trade> getAllTrades() {
        List<Trade> trades = new ArrayList<>();
        LOGGER.info("Fetching all trade records.");
        Iterable<TradeEntity> fetchedTrades = tradeRepository.findAll();
        if (fetchedTrades != null) {
            fetchedTrades.forEach(t -> trades.add(new TradeBuilder(t).build()));
        }
        return trades;
    }

    public boolean addTrade(Trade trade) {
        return tradeValidator.validateTrade(trade);
    }
}
