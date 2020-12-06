package com.nilrach.trade.store.model;

import com.nilrach.trade.store.entity.TradeEntity;

import java.util.Date;

public class TradeBuilder {
    private String tradeId;
    private String version;
    private String counterPartyId;
    private String bookId;
    private Date maturityDate;
    private Date createdDate;
    private Boolean isExpired;

    public TradeBuilder() {
    }

    public TradeBuilder(TradeEntity tradeEntity) {
        this.tradeId = tradeEntity.getTradeId();
        this.version = tradeEntity.getVersion();
        this.counterPartyId = tradeEntity.getCounterPartyId();
        this.bookId = tradeEntity.getBookId();
        this.maturityDate = tradeEntity.getMaturityDate();
        this.createdDate = tradeEntity.getCreatedDate();
        this.isExpired = tradeEntity.isExpired();

    }

    public Trade build() {
        return new Trade(tradeId, version, counterPartyId, bookId, maturityDate, createdDate, isExpired);
    }

    public TradeBuilder tradeId(String tradeId) {
        this.tradeId = tradeId;
        return this;
    }
}
