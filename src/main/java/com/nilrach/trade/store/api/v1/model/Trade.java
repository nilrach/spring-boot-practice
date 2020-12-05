package com.nilrach.trade.store.api.v1.model;


import com.nilrach.trade.store.entity.TradeEntity;

public class Trade {
    private final String tradeId;

    public Trade(String tradeId) {
        this.tradeId = tradeId;
    }

    public static Trade convert(TradeEntity tradeEntity) {
        Trade trade = new Trade(tradeEntity.getTradeId());
        return trade;
    }

    public String getTradeId() {
        return tradeId;
    }

}
