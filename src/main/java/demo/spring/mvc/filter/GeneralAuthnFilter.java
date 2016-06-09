package demo.spring.mvc.filter;

import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by raist on 2016/4/15.
 *
 */
//@WebFilter(filterName = "GeneralAuthnFilter",urlPatterns = {"/"},dispatcherTypes = {DispatcherType.REQUEST},asyncSupported = true)
public class GeneralAuthnFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("GeneralAuthnFilter destroy ...");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("GeneralAuthnFilter doFilter begin ...------------------------------------------------------");
//        HttpServletRequest  httpServletRequest = (HttpServletRequest)req;
//        if(httpServletRequest.getSession().getAttribute("loginUser")==null){
//            httpServletRequest.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);
//        }
        chain.doFilter(req, resp);
        System.out.println("GeneralAuthnFilter doFilter end ...--------------------------------------------------------");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("GeneralAuthnFilter init ...");
    }

}
