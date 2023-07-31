package com.test.designmode.singletondesign41.use;


import com.test.designmode.singletondesign41.Logger;

import java.io.IOException;

// Logger类的应用示例：
public class UserController {
    public UserController() throws IOException {
    }

    private Logger logger = new Logger();

    public void login(String username, String password) throws IOException {
        // ...省略业务逻辑代码...
        logger.log(username + " logined!");
    }
}
