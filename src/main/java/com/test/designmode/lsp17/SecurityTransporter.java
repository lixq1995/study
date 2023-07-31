package com.test.designmode.lsp17;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

public class SecurityTransporter extends Transporter {
    private String appId;
    private String appToken;

    public SecurityTransporter(HashMap hashMap, String appId, String appToken) {
        super(hashMap);
        this.appId = appId;
        this.appToken = appToken;
    }

    @Override
    public HashMap sendRequest1(HashMap request) {
        if (StringUtils.isNotBlank(appId) && StringUtils.isNotBlank(appToken)) {
            request.put("app-id", appId);
            request.put("app-token", appToken);
        }
        return super.sendRequest1(request);
    }

    @Override
    public HashMap sendRequest2(HashMap request) {
        if (StringUtils.isBlank(appId) || StringUtils.isBlank(appToken)) {
            throw new RuntimeException();
        }
        request.put("app-id", appId);
        request.put("app-token", appToken);
        return super.sendRequest2(request);

    }

}
