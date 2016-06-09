package demo.spring.mvc.filter;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * Created by raist on 2016/5/26.
 *
 */
public class TestRequestFilter implements WebRequestInterceptor {
    @Override
    public void preHandle(WebRequest webRequest) throws Exception {
        System.out.println("Step into TestRequestFilter.preHandle()");
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
        System.out.println("Step into TestRequestFilter.postHandle()");
    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {
        System.out.println("Step into TestRequestFilter.afterCompletion()");
    }
}
