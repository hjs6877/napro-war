package com.soom.napro;

import com.soom.entity.NaproData;
import com.soom.entity.NaproEvent;
import com.soom.entity.User;
import com.soom.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/napro_home")
    public String naproHome(){
        return "napro_home";
    }

    @ResponseBody
    @RequestMapping(value = "/events")
    public List<NaproEvent> getEvents() {
        String userId = SessionUtil.getLoginUserId();
        User user = userDao.findById(userId);
        List<NaproEvent> naproEvents = user.getNaproEventList();

        return naproEvents;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerNaproForm(HttpSession session,
                                    @RequestParam(name = "eventId", defaultValue = "0")int targetEventId,
                                    @RequestParam(name = "start", required = false, defaultValue = "")String start,
                                    Model model){

        List<NaproData> naproDataList  = naproService.findNaproDataByEventId(targetEventId);
        if(naproDataList.size() > 0){
            naproDataList.sort(comparing(NaproData::getScore).reversed());
        }
        model.addAttribute("naproDataList", naproDataList);
        model.addAttribute("eventId", targetEventId);
        model.addAttribute("start", start);
        return "napro_register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerNapro(@RequestParam(name = "start")String start,
                                @RequestParam(name = "mode")String mode,
                                NaproData naproData,
                                RedirectAttributes redirectAttributes){
        String userId = SessionUtil.getLoginUserId();
        NaproEvent naproEvent = naproService.registerNaproData(userId, naproData, start);
        redirectAttributes.addAttribute("eventId", naproEvent.getId());
        redirectAttributes.addAttribute("start", start);

        return "redirect:/np/registration";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyNapro(@RequestParam(name = "start")String start,
                                @RequestParam(name = "mode")String mode,
                                NaproData naproData,
                                RedirectAttributes redirectAttributes){
        NaproEvent naproEvent = naproService.modifyNaproData(naproData);
        redirectAttributes.addAttribute("eventId", naproEvent.getId());
        redirectAttributes.addAttribute("start", start);

        return "redirect:/np/registration";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteNaproData(@RequestParam(name = "eventId", required = false)int eventId,
                                  @RequestParam(name = "naproDataId", required = false)int naproDataId,
                                  @RequestParam(name = "start")String start,
                                  RedirectAttributes redirectAttributes){
        String redirectUrl = "";
        if(eventId > 0 || naproDataId > 0){
            List<NaproData> naproData = naproService.findNaproDataByEventId(eventId);
            if(naproData.size() == 1){
                naproService.deleteNaproData(naproDataId);
                naproService.deleteNaproEvent(eventId);
                redirectUrl = "redirect:/np/napro_home";
            }else{
                naproService.deleteNaproData(naproDataId);
                redirectAttributes.addAttribute("eventId", eventId);
                redirectAttributes.addAttribute("start", start);
                redirectUrl = "redirect:/np/registration";
            }
        }else{
            redirectUrl = "redirect:/np/napro_home";
        }


        return redirectUrl;
    }
}
