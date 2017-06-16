package com.target.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created by rohit on 6/16/17.
 */
public class Product {

    private Long id;
    private String name;
    @JsonProperty("current_price")
    private Price currentPrice;

    public Product() {
    }

    public Product(long id, String name, BigDecimal value, CurrencyCode code) {
        this.id = id;
        this.name = name;
        this.currentPrice = new Price(value, code);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Price currentPrice) {
        this.currentPrice = currentPrice;
    }

    public static class Price {
        private BigDecimal value;
        @JsonProperty("currency_code")
        private CurrencyCode currencyCode;

        public Price() {
        }

        public Price(BigDecimal value, CurrencyCode currencyCode) {
            this.value = value;
            this.currencyCode = currencyCode;
        }

        public BigDecimal getValue() {
            return value;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }

        public CurrencyCode getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(CurrencyCode currencyCode) {
            this.currencyCode = currencyCode;
        }
    }

}
