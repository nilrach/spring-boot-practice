package com.nilrach.trade.store.service;

import com.nilrach.trade.store.entity.TradeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeStoreService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeStoreService.class);

    public List<TradeEntity> getAllTrades() {
        LOGGER.info("Fetching all trade records.");
        return null;
    }
}
