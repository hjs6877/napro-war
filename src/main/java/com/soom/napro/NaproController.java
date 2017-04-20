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
        User user = userDao.findOne(userId);
        List<NaproEvent> naproEvents = user.getNaproEventList();

        return naproEvents;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerNaproForm(HttpSession session,
                                    @RequestParam(name = "id", defaultValue = "0")int targetEventId,
                                    @RequestParam(name = "start", required = false, defaultValue = "")String start,
                                    Model model){

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
                                NaproData naproData,
                                RedirectAttributes redirectAttributes){
        String userId = SessionUtil.getLoginUserId();
        NaproEvent naproEvent = naproService.registerNaproData(userId, naproData, start);
        redirectAttributes.addAttribute("id", naproEvent.getId());
        redirectAttributes.addAttribute("start", start);

        return "redirect:/np/registration";
    }
}
