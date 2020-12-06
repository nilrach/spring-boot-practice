package com.nilrach.trade.store.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TradeStoreUtil {
    public static Date today() {
        return Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date yesterday() {
        return Date.from(LocalDate.now().minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
