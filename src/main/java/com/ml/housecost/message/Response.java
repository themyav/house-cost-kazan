package com.ml.housecost.message;

import org.springframework.stereotype.Component;

@Component
public class Response {
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    Integer price;
}
