package demo.spring.mvc.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by raist on 2016/5/22.
 *
 */
@Controller
@RequestMapping("/hello")
//@SessionAttributes("loginUser")
public class HelloController {

    @RequestMapping("/mvc")
    public String helloMvc() {
        System.out.println("touch helloMvc() method");
        return "welcome";
    }

    @RequestMapping("/login")
    public ModelAndView modelAndView(String username, String password, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("username="+username);
        System.out.println("password="+password);
        httpSession.setAttribute("loginUser",username);
        modelAndView.setViewName("welcome");
        modelAndView.addObject("test_msg","This is a test message from controller.");
        return modelAndView;
    }

//    @RequestMapping("/login")
//    public ModelAndView modelAndView(String username, String password) {
//        ModelAndView modelAndView = new ModelAndView();
//        System.out.println("username="+username);
//        System.out.println("password="+password);
//        modelAndView.setViewName("welcome");
//        modelAndView.addObject("test_msg","This is a test message from controller.");
//        modelAndView.addObject("loginUser",username);
//        return modelAndView;
//    }

    @RequestMapping("/logout")
    public ModelAndView modelAndView(HttpSession httpSession) {
        httpSession.removeAttribute("loginUser");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/upload")
    public String showUploadPage(){
        return "upload";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String doUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            System.out.println("Upload file:"+file.getOriginalFilename());
//            FileUtils.copyInputStreamToFile(file.getInputStream(),new File("C:\\Users\\raist\\IdeaProjects\\DemoSpringMVC3",System.currentTimeMillis()+"_"+file.getOriginalFilename()));
//            FileUtils.copyInputStreamToFile(file.getInputStream(),new File("Upload",System.currentTimeMillis()+"_"+file.getOriginalFilename()));
            File f = new File("Upload",System.currentTimeMillis()+"_"+file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(),f);
//            System.out.println(f.getAbsolutePath());
//            System.out.println(f.getAbsoluteFile());
        }
        return "success";
    }

}
