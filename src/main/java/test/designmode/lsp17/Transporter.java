package test.designmode.lsp17;


import org.apache.http.client.HttpClient;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class Transporter {
    private HashMap hashMap;

    public Transporter(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    public HashMap sendRequest1(HashMap request) {
        // ...use httpClient to send request
        return request;
    }

    public HashMap sendRequest2(HashMap request) {
        // ...use httpClient to send request
        return request;
    }
}
