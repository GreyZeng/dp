package principle.srp;

/**
 * 符合单一职责原则
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @since 1.8
 */
public class UserOperate2 {
    public static void main(String[] args) {
        Register register = new RegisterImpl();
        register.register();
    }

    public static class RegisterImpl implements Register {

        @Override
        public void register() {
            // 用户注册
        }
    }


    public interface Register {
        void register();
    }


    public static class LogoutImpl implements Logout {

        @Override
        public void logout() {
            // 登出
        }
    }

    public interface Logout {
        void logout();

    }


    public static class LoginImpl implements Login {
        @Override
        public void login() {
            // 用户登录
        }
    }

    public interface Login {
        void login();

    }
}
