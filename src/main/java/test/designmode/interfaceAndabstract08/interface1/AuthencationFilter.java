package test.designmode.interfaceAndabstract08.interface1;

import javax.servlet.http.HttpServletRequest;

// 接口实现类：鉴权过滤器
public class AuthencationFilter implements Filter {
    @Override
    public void doFilter(HttpServletRequest req) throws Exception {
        //... 鉴权逻辑..
    }
}
