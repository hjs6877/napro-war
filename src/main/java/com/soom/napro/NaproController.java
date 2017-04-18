package com.soom.napro;

import com.soom.entity.NaproData;
import com.soom.entity.NaproEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static java.util.Comparator.comparing;

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

    @ResponseBody
    @RequestMapping(value = "/events")
    public List<NaproEvent> getEvents() {
        List<NaproEvent> naproEvents = naproService.findAllNaproEvent();
        return naproEvents;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerNaproForm(@RequestParam(name = "id", defaultValue = "0")int targetEventId,
                                    @RequestParam(name = "start", required = false, defaultValue = "")String start,
                                    Model model){

        // TODO 등록되어 있는 Napro 데이터를 조회한다.
        List<NaproData> naproDataList  = naproService.findNaproDataByeventId(targetEventId);
        if(naproDataList != null){
            naproDataList.sort(comparing(NaproData::getScore).reversed());
        }
        model.addAttribute("naproDataList", naproDataList);
        model.addAttribute("id", targetEventId);
        model.addAttribute("start", start);
        return "napro_register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerNapro(@RequestParam(name = "start")String start,
                                NaproData naproData, RedirectAttributes redirectAttributes){

        NaproEvent naproEvent = naproService.registerNaproData(naproData, start);
        redirectAttributes.addAttribute("id", naproEvent.getId());
        redirectAttributes.addAttribute("start", start);

        return "redirect:/np/registration";
    }
}
