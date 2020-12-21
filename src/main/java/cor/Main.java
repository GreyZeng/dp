package cor;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class Main {
    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());
        Msg msg = new Msg();
        msg.setContent("scripts Hell World! 996");
        System.out.println("before filter , the content is : " + msg.getContent());
        filterChain.doFilter(msg);
        System.out.println("after filter , the content is : " + msg.getContent());
    }
}
