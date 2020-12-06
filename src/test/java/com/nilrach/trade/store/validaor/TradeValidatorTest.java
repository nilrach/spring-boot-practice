package com.nilrach.trade.store.validaor;

import com.nilrach.trade.store.model.Trade;
import com.nilrach.trade.store.model.TradeBuilder;
import com.nilrach.trade.store.util.TradeStoreUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static com.nilrach.trade.store.config.TradeStoreConstants.*;
import static com.nilrach.trade.store.util.TradeStoreUtil.yesterday;
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

    @Test
    public void shouldFailWhenMaturityDateIsBeforeToday() {

        Trade trade = new TradeBuilder()
                .tradeId("T11")
                .version("11")
                .counterPartyId("CP-11")
                .bookId("B11")
                .maturityDate(yesterday()).build();
        ensureException(trade, MATURITY_DATE_EXPIRED);
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