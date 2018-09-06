package com.company.addon.currency_demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.addon.currency.entity.CurrencyValueEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.haulmont.addon.currency.entity.annotation.CurrencyDate;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.CurrencyValue;

@NamePattern("%s|name")
@Table(name = "CURRENCYADDONDEMO_TRADE_ITEM")
@Entity(name = "currencyaddondemo$TradeItem")
public class TradeItem extends StandardEntity {
    private static final long serialVersionUID = 5144911732062073517L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "BUY_DATE", nullable = false)
    protected Date buyDate;

    @NotNull
    @Column(name = "BUY_AMOUNT", nullable = false)
    @CurrencyValue(currency = "USD")
    @CurrencyDate("buyDate")
    protected BigDecimal buyAmount;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SELL_AMOUNT_ID")
    protected CurrencyValueEntity sellAmount;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public void setSellAmount(CurrencyValueEntity sellAmount) {
        this.sellAmount = sellAmount;
    }

    public CurrencyValueEntity getSellAmount() {
        return sellAmount;
    }


}