package com.nilrach.trade.store.service;

import com.nilrach.trade.store.entity.TradeEntity;
import com.nilrach.trade.store.repository.TradeRepository;
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

    @Autowired
    public TradeStoreService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public List<TradeEntity> getAllTrades() {
        List<TradeEntity> tradeEntities = new ArrayList<>();
        LOGGER.info("Fetching all trade records.");
        Iterable<TradeEntity> fetchedTrades = tradeRepository.findAll();
        if (fetchedTrades != null) {
            fetchedTrades.forEach(t -> tradeEntities.add(t));
        }
        return tradeEntities;
    }
}
