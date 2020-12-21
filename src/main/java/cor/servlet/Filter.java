package cor.servlet;

public interface Filter {
    boolean doFilter(Msg msg, FilterChain filterChain);
}
