package cor.servlet;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg, FilterChain filterChain) {
        msg.setRequest(msg.getRequest().replace("996", "") + " [Sensitive filter]");
        filterChain.doFilter(msg);
        msg.setResponse(msg.getResponse().replace("996", "") + " [Sensitive filter]");
        return true;
    }
}
