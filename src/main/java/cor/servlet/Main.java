package cor.servlet;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class Main {
    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());
        Msg msg = new Msg();
        msg.setRequest("scripts Hell Request! 996");
        msg.setResponse("scripts Hell Response! 996");

        filterChain.doFilter(msg);
        System.out.println(msg.getRequest());
        System.out.println(msg.getResponse());

    }
}
