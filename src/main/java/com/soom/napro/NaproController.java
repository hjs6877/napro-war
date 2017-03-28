package com.soom.napro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - �ۼ���, 2017-03-27 ���� �ۼ�<br/>
 *
 * @author Kevin
 * @see
 */
@Controller
@RequestMapping("/np")
public class NaproController {
    @RequestMapping
    public String naproHome(){
        return "napro_home";
    }

    @RequestMapping("/registration")
    public String registerNapro(){
        return "register_napro";
    }
}
