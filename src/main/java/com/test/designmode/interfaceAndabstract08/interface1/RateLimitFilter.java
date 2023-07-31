package com.test.designmode.interfaceAndabstract08.interface1;

import javax.servlet.http.HttpServletRequest;

// 接口实现类：限流过滤器
public class RateLimitFilter implements Filter {
    @Override
    public void doFilter(HttpServletRequest req) throws Exception {
        //... 限流逻辑...
    }
}
