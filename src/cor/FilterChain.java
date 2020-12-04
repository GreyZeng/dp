package cor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {
        for (Filter filter : filters) {
            if (!filter.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }
}
