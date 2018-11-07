package com.company.addon.currency_demo.entity;

import com.haulmont.addon.currency.entity.Currency;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    @Column(name = "DATE_", nullable = false)
    protected Date date;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "COST_ID")
    protected Currency cost;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }


    public void setCost(Currency cost) {
        this.cost = cost;
    }

    public Currency getCost() {
        return cost;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}