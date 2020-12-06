package com.nilrach.trade.store.validaor;

import com.nilrach.trade.store.model.Trade;
import com.nilrach.trade.store.model.TradeBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.nilrach.trade.store.config.TradeStoreConstants.TRADE_ID_MANDATORY;
import static com.nilrach.trade.store.config.TradeStoreConstants.TRADE_MANDATORY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
class TradeValidatorTest {
    @InjectMocks
    private TradeValidator tradeValidator;

    @Test
    public void shouldFailWhenTradeNotInitialied() {
        ensureException(null, TRADE_MANDATORY);
    }

    @Test
    public void shouldFailWhenMandatoryFieldsAreMissing() {
        ensureException((new TradeBuilder()).build(), TRADE_ID_MANDATORY);
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