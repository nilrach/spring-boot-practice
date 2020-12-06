package com.nilrach.trade.store.validaor;

import com.nilrach.trade.store.api.v1.model.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.nilrach.trade.store.config.TradeStoreConstants.TRADE_MANDATORY;

@Component
public class TradeValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeValidator.class);

    public boolean validateTrade(Trade trade) {
        LOGGER.info("Validating trade.");
        if(trade==null) {
            throw new IllegalArgumentException(TRADE_MANDATORY);
        }
        return false;
    }
}
