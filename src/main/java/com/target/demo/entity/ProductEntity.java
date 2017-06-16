package com.target.demo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.target.demo.model.CurrencyCode;

import java.math.BigDecimal;

/**
 * Created by rohit on 6/16/17.
 */
@DynamoDBTable(tableName = "product-table")
public class ProductEntity {

    @DynamoDBHashKey
    private Long id;

    @DynamoDBAttribute(attributeName = "current_price")
    private PriceEntity currentPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PriceEntity getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(PriceEntity currentPrice) {
        this.currentPrice = currentPrice;
    }

    @DynamoDBDocument
    public static class PriceEntity {
        private BigDecimal value;

        @DynamoDBTypeConvertedEnum
        @DynamoDBAttribute(attributeName="currency_code")
        private CurrencyCode currencyCode;

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
