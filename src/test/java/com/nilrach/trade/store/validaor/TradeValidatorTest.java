package com.nilrach.trade.store.validaor;

import com.nilrach.trade.store.api.v1.model.Trade;
import com.nilrach.trade.store.config.TradeStoreConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.nilrach.trade.store.config.TradeStoreConstants.TRADE_MANDATORY;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TradeValidatorTest {
    @InjectMocks
    private TradeValidator tradeValidator;

    @Test
    public void shouldFailWhenTradeNotInitialied() {
        ensureException(null, TRADE_MANDATORY);
    }

    private void ensureException(Trade trade, String exceptionMessage) {
        try {
            tradeValidator.validateTrade(trade);
            fail("This line shouldn't be reached. Should have failed validation with message"
            + exceptionMessage);
        } catch (IllegalArgumentException e) {
            assertEquals(exceptionMessage, e.getMessage());
        }
    }


}