package test.designmode.proxydesign48.designmode;

import com.test.designmode.proxydesign48.nodesignmode.pojo.UserVo;

public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}

