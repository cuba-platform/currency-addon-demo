package com.company.addon.currency_demo.web.screens;

import com.haulmont.addon.currency.entity.Currency;
import com.haulmont.addon.currency.entity.CurrencyDescriptor;
import com.haulmont.addon.currency.entity.CurrencyRateAware;
import com.haulmont.addon.currency.service.CurrencyService;
import com.haulmont.addon.currency.web.gui.components.currency_field.CurrencyAddonField;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.components.AbstractWindow;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Screen extends AbstractWindow {

    @Inject
    private CurrencyAddonField currField;
    @Inject
    private Metadata metadata;
    @Inject
    private CurrencyService currencyService;
    @Inject
    private TimeSource timeSource;


    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        Currency currencyRateAware = metadata.create(Currency.class);

        currencyRateAware.setCurrency(currencyService.getDefaultCurrency());
        currencyRateAware.setDate(timeSource.currentTimestamp());
        currencyRateAware.setValue(BigDecimal.TEN);

        currField.setCurrencyRateAware(currencyRateAware);


    }

    public void onChange_currencyClick() {
        List<CurrencyDescriptor> availableCurrencies = currencyService.getAvailableCurrencies();
        Random random = new Random(System.currentTimeMillis());
        int randomIndex = random.nextInt(availableCurrencies.size());
        CurrencyDescriptor randomCurrency = availableCurrencies.get(randomIndex);

        showNotification("Change currency to " + randomCurrency.getSymbol(), NotificationType.HUMANIZED);

        currField.getCurrencyRateAware().setCurrency(randomCurrency);
        currField.modelChanged();
    }


    public void onGet_state_btnClick() {
        CurrencyRateAware currency = currField.getCurrencyRateAware();
        String message = String.format("State of field: %s, %s, %s",
                currency.getCurrency().getCode(),
                currency.getValue(),
                currency.getDate()
        );
        showNotification(message, NotificationType.HUMANIZED);
    }


}