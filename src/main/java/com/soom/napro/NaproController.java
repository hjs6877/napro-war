package com.soom.napro;

import com.soom.entity.NaproData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    private NaproService naproService;

    @RequestMapping
    public String naproHome(){
        return "napro_home";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerNaproForm(){
        return "napro_register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerNapro(@RequestParam(name = "eventId", required = false) int eventId, NaproData naproData, Model model){
        naproService.registerNaproData(eventId, naproData);
        return "napro_register";
    }
}
