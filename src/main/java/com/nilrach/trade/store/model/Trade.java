package com.nilrach.trade.store.model;


import java.util.Date;

public class Trade {
    private final String tradeId;
    private final String version;
    private final String counterPartyId;
    private final String bookId;
    private final Date maturityDate;
    private final Date createdDate;
    private final Boolean isExpired;

    Trade(String tradeId, String version, String counterPartyId, String bookId, Date maturityDate,
          Date createdDate, Boolean isExpired) {
        this.tradeId = tradeId;
        this.version = version;
        this.counterPartyId = counterPartyId;
        this.bookId = bookId;
        this.maturityDate = maturityDate;
        this.createdDate = createdDate;
        this.isExpired = isExpired;
    }

    public String getTradeId() {
        return tradeId;
    }

    public String getVersion() {
        return version;
    }

    public String getCounterPartyId() {
        return counterPartyId;
    }

    public String getBookId() {
        return bookId;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Boolean getExpired() {
        return isExpired;
    }
}
