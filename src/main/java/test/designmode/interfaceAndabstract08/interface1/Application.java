package test.designmode.interfaceAndabstract08.interface1;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

// 过滤器使用 demo
public class Application {
    // filters.add(new AuthencationFilter());
    // filters.add(new RateLimitFilter());
    private List<Filter> filters = new ArrayList<>();

    public void handleRpcRequest(HttpServletRequest req) {
        try {
            for (Filter filter : filters) {
                filter.doFilter(req);
            }
        } catch(Exception e) {
            // ... 处理过滤结果...
        }
        // ... 省略其他处理逻辑...
    }
}
