package com.soom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-03-28 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@Controller
public class WelcomeController {
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        System.out.println("aaaaaaa");
        model.put("message", this.message);
        return "welcome";
    }
}
