package com.nilrach.trade.store.service;

import com.nilrach.trade.store.api.v1.model.Trade;
import com.nilrach.trade.store.repository.TradeRepository;
import com.nilrach.trade.store.validaor.TradeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Assertion for business logic layer")
class TradeStoreServiceTest {

    @Mock
    private TradeRepository tradeRepository;

    @Mock
    private TradeValidator tradeValidator;

    @InjectMocks
    private TradeStoreService tradeStoreService;

    @Test
    public void shouldBeAbleToFindAllTradesFromDb() {
        tradeStoreService.getAllTrades();
        verify(tradeRepository, times(1)).findAll();
    }

    @Test
    public void shouldValidateTradeBeforeAdding() {
        boolean isTradeAdded = tradeStoreService.addTrade(new Trade("1"));
        verify(tradeValidator, times(1)).validateTrade(any(Trade.class));
    }

}