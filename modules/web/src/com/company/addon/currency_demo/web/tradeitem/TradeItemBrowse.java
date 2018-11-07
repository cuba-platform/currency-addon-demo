package com.company.addon.currency_demo.web.tradeitem;

import com.company.addon.currency_demo.entity.TradeItem;
import com.haulmont.addon.currency.entity.Currency;
import com.haulmont.addon.currency.entity.CurrencyDescriptor;
import com.haulmont.addon.currency.entity.CurrencyRateAware;
import com.haulmont.addon.currency.service.ConvertResult;
import com.haulmont.addon.currency.service.CurrencyService;
import com.haulmont.addon.currency.web.gui.components.currency_field.CurrencyAddonField;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.data.GroupDatasource;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public class TradeItemBrowse extends AbstractLookup {
    @Inject
    private CurrencyAddonField totalField;
    @Inject
    private GroupDatasource<TradeItem, UUID> tradeItemsDs;

    @Inject
    private CurrencyService currencyService;

    @Override
    public void init(Map<String, Object> params) {
        tradeItemsDs.addCollectionChangeListener(e -> {
            calculateTotal();
        });
    }


    private void calculateTotal() {
        CurrencyRateAware currencyRateAware = totalField.getCurrencyRateAware();
        CurrencyDescriptor targetCurrency = currencyRateAware.getCurrency();

        BigDecimal total = BigDecimal.ZERO;
        for (TradeItem tradeItem : tradeItemsDs.getItems()) {
            Currency cost = tradeItem.getCost();
            ConvertResult result = currencyService.convertAmountToCurrentRate(cost.getValue(), cost.getCurrency(), targetCurrency);
            total = total.add(result.getResultAmount());
        }

        currencyRateAware.setValue(total);
        totalField.setCurrencyRateAware(currencyRateAware);
    }
}