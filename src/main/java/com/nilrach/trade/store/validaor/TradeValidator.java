package com.nilrach.trade.store.validaor;

import com.nilrach.trade.store.model.Trade;
import com.nilrach.trade.store.util.TradeStoreUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.nilrach.trade.store.config.TradeStoreConstants.*;

@Component
public class TradeValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeValidator.class);

    public boolean validateTrade(Trade trade) {
        LOGGER.info("Validating trade.");
        checkMandatoryFields(trade);
        checkMaturityDateExpiry(trade);
        return true;
    }

    private void checkMaturityDateExpiry(Trade trade) {
        if(TradeStoreUtil.today().after(trade.getMaturityDate())) {
            throw new IllegalArgumentException(MATURITY_DATE_EXPIRED);
        }

    }

    private void checkMandatoryFields(Trade trade) {
        if (trade == null) {
            throw new IllegalArgumentException(TRADE_MANDATORY);
        }
        checkArgument(StringUtils.isNotEmpty(trade.getTradeId()), TRADE_ID_MANDATORY);
        checkArgument(StringUtils.isNotEmpty(trade.getVersion()), VERSION_MANDATORY);
        checkArgument(StringUtils.isNotEmpty(trade.getCounterPartyId()), COUNTER_PARTY_MANDATORY);
        checkArgument(StringUtils.isNotEmpty(trade.getBookId()), BOOK_ID_MANDATORY);
        checkArgument(trade.getMaturityDate() != null, MATURITY_DATE_MANDATORY);
    }
}
