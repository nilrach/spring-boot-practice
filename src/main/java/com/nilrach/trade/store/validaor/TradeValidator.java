package com.nilrach.trade.store.validaor;

import com.nilrach.trade.store.api.v1.model.Trade;
import org.springframework.stereotype.Component;

@Component
public class TradeValidator {
    public boolean validateTrade(Trade any) {
        return false;
    }
}
