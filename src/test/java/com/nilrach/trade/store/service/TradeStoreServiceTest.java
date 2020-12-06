package com.nilrach.trade.store.service;

import com.nilrach.trade.store.repository.TradeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Assertion for business logic layer")
class TradeStoreServiceTest {

    @Mock
    private TradeRepository tradeRepository;

    @InjectMocks
    private TradeStoreService tradeStoreService;

    @Test
    public void shouldBeAbleToFindAllTradesFromDb() {
        tradeStoreService.getAllTrades();
        verify(tradeRepository, times(1)).findAll();
    }

}