package cor;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class HTMLFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        msg.setContent(msg.getContent().replace("scripts", ""));
        return true;
    }
}
