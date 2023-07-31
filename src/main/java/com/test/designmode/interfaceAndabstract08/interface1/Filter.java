package com.test.designmode.interfaceAndabstract08.interface1;

import javax.servlet.http.HttpServletRequest;

// 接口
public interface Filter {
    void doFilter(HttpServletRequest req) throws Exception;
}
