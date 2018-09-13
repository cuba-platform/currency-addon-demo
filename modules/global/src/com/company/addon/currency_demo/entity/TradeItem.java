package com.company.addon.currency_demo.entity;

import com.haulmont.addon.currency.entity.Currency;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.CurrencyValue;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@NamePattern("%s|name")
@Table(name = "CURRENCYADDONDEMO_TRADE_ITEM")
@Entity(name = "currencyaddondemo$TradeItem")
public class TradeItem extends StandardEntity {
    private static final long serialVersionUID = 5144911732062073517L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Column(name = "BUY_AMOUNT", nullable = false)
    @CurrencyValue(currency = "USD")
    protected BigDecimal buyAmount;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SELL_AMOUNT_ID")
    protected Currency sellAmount;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public void setSellAmount(Currency sellAmount) {
        this.sellAmount = sellAmount;
    }

    public Currency getSellAmount() {
        return sellAmount;
    }


}