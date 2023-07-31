package com.test.designmode.singletondesign41.use;

import com.test.designmode.singletondesign41.Logger;

import java.io.IOException;

public class OrderController {

    public OrderController() throws IOException {
    }

    private Logger logger = new Logger();

    public void create(String order) throws IOException {
        // ...省略业务逻辑代码...
        logger.log("Created an order: " + order.toString());
    }
}
