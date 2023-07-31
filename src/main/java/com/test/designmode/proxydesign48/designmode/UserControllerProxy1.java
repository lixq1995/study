package com.test.designmode.proxydesign48.designmode;

import com.test.designmode.proxydesign48.nodesignmode.MetricsCollector;
import com.test.designmode.proxydesign48.nodesignmode.pojo.RequestInfo;
import com.test.designmode.proxydesign48.nodesignmode.pojo.UserVo;

public class UserControllerProxy1 extends UserController {
    private MetricsCollector metricsCollector;

    public UserControllerProxy1() {
        this.metricsCollector = new MetricsCollector();
    }

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        UserVo userVo = super.login(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        UserVo userVo = super.register(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }
}
