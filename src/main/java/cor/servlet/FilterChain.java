package cor.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class FilterChain {
    private final List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(Msg msg) {
        if (index == filters.size()) {
            return;
        }
        Filter f = filters.get(index);
        index++;
        f.doFilter(msg, this);
    }
}
