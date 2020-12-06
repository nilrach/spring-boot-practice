package com.nilrach.trade.store.entity;

import com.nilrach.trade.store.model.Trade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "TRADES")
public class TradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TRADE_ID")
    private String tradeId;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "COUNTER_PARTY_ID")
    private String counterPartyId;

    @Column(name = "BOOK_ID")
    private String bookId;

    @Column(name = "MATURITY_DATE")
    private Timestamp maturityDate;

    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;

    @Column(name = "IS_EXPIRED")
    private Character isExpired;

    public TradeEntity() {
    }

    public TradeEntity(Trade trade) {
        this.tradeId = trade.getTradeId();
        this.version = trade.getVersion();
        this.bookId = trade.getBookId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCounterPartyId() {
        return counterPartyId;
    }

    public void setCounterPartyId(String counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Timestamp getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Timestamp maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Character getIsExpired() {
        return isExpired;
    }

    public Boolean isExpired() {
        return isExpired != null && Character.valueOf('Y').equals(isExpired) ? true : false;
    }

    public void setIsExpired(Character isExpired) {
        this.isExpired = isExpired;
    }
}
