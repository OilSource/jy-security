package com.security.jy.web.async;

import org.springframework.stereotype.Component;

@Component
public class MockQueue {

    private String placeOrder;

    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        System.out.println("接到下单的消息" +placeOrder);
        Thread.sleep(1000);
        this.completeOrder = placeOrder;
        System.out.println("下单请求处理完毕" +placeOrder);
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
