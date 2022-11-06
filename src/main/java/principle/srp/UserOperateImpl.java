package principle.srp;

/**
 * 不符合单一职责
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @since
 */
interface UserOperate {
    void login(UserInfo userInfo);

    void register(UserInfo userInfo);

    void logout(UserInfo userInfo);
}

public class UserOperateImpl implements UserOperate {
    @Override
    public void login(UserInfo userInfo) {
        // 用户登录
    }

    @Override
    public void register(UserInfo userInfo) {
        // 用户注册
    }

    @Override
    public void logout(UserInfo userInfo) {
        // 用户登出
    }


}

class UserInfo {

}
