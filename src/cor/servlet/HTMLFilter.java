package cor.servlet;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class HTMLFilter implements Filter {


    @Override
    public boolean doFilter(Msg msg, FilterChain filterChain) {
        msg.setRequest(msg.getRequest().replace("scripts", "") + " [HTML filter]");
        filterChain.doFilter(msg);
        msg.setResponse(msg.getResponse().replace("scripts", "") + " [HTML filter]");
        return true;
    }
}
