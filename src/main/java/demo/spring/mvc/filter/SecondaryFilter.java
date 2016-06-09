package demo.spring.mvc.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by raist on 2016/5/25.
 *
 */
public class SecondaryFilter implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("Step into SecondaryFilter.preHandle()");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Step into SecondaryFilter.postHandle()");
//        modelAndView.addObject("test_msg","This is a message from interceptor,");
        if(modelAndView==null){
            System.out.println("ModelAndView is null for SecondaryFilter.");
        }else{
            System.out.println("ModelAndView==>ViewName:"+modelAndView.getViewName());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("Step into SecondaryFilter.afterCompletion()");
    }
}
