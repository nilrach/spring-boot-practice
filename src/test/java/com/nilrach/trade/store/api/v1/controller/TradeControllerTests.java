package com.nilrach.trade.store.api.v1.controller;

import com.nilrach.trade.store.model.Trade;
import com.nilrach.trade.store.model.TradeBuilder;
import com.nilrach.trade.store.service.TradeStoreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TradeController.class)
@AutoConfigureMockMvc
public class TradeControllerTests {

    @Autowired
    MockMvc mvc;

    @MockBean
    private TradeStoreService tradeStoreService;

    @Test
    public void shouldBeAbleToGetTrades() throws Exception {
        when(tradeStoreService.getAllTrades()).thenReturn(Arrays.asList(getValidTestTrade()));
        mvc.perform(MockMvcRequestBuilders
                .get("/api/v1/trades"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGiveNotFoundStatusWhenNoTrades() throws Exception {
        when(tradeStoreService.getAllTrades()).thenReturn(null);
        mvc.perform(MockMvcRequestBuilders
                .get("/api/v1/trades"))
                .andExpect(status().isNotFound());
    }

    private Trade getValidTestTrade() {
        Trade trade = new TradeBuilder().tradeId("T11").build();
        return trade;
    }
}
