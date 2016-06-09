package demo.spring.mvc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by raist on 2016/4/15.
 *
 */
//@WebFilter(filterName = "GeneralFilter",urlPatterns = {"/hello/login"},dispatcherTypes = {DispatcherType.REQUEST},asyncSupported = true)
public class GeneralFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("GeneralFilter destroy ...");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("GeneralFilter doFilter begin ...------------------------------------------------------");
        chain.doFilter(req, resp);
        System.out.println("GeneralFilter doFilter end ...--------------------------------------------------------");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("GeneralFilter init ...");
    }

}
