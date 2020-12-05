package com.nilrach.trade.store.api.v1.model;


import com.nilrach.trade.store.entity.TradeEntity;

public class Trade {
    private String tradeId;

    public static Trade convert(TradeEntity tradeEntity) {
        Trade trade = new Trade();
        trade.tradeId = tradeEntity.getTradeId();
        return trade;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }
}
