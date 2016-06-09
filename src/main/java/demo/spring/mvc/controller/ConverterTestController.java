package demo.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by raist on 2016/5/31.
 *
 */
@Controller
@RequestMapping("/convert")
public class ConverterTestController {

    @RequestMapping("/boolean")
    public @ResponseBody
    String getBoolean(@RequestParam(name = "input", required = false) Boolean input) {
        return input.toString();
    }

}
