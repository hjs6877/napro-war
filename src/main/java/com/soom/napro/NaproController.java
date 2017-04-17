package com.soom.napro;

import com.soom.entity.NaproData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
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
    public String registerNaproForm(@RequestParam(name = "eventId", defaultValue = "0")int targetEventId,
                                    @RequestParam(name = "startDate", required = false, defaultValue = "")String startDate,
                                    Model model){
        List<NaproData> naproDataList = null;
        int eventId = 0;

        // TODO 등록되어 있는 Napro 데이터를 조회한다.
//            naproDataList = Napro Date 조회

        model.addAttribute("eventId", eventId);
        model.addAttribute("startDate", startDate);
        return "napro_register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerNapro(@RequestParam(name = "startDate")String startDate,
                                NaproData naproData, Model model){

        NaproData savedNaproData = naproService.registerNaproData(naproData, startDate);

        model.addAttribute("eventId", savedNaproData.getEventId());
        model.addAttribute("startDate", startDate);
        return "napro_register";
    }
}
