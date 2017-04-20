package com.soom.napro;

import com.soom.entity.User;
import com.soom.utils.SessionUtil;
import com.soom.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-19 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@Controller
@RequestMapping("/np")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String naproLoginHome(){
        System.out.println("## login home");
        if(SessionUtil.getLoginInfo() != null){
            return "redirect:/np/napro_home";
        }
        return "napro_login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result naproLogin(User user, Result result){
        User resultUser = userService.findUserByIdAndPassword(user);

        if(resultUser == null){
            result.setCode(UserService.LOGIN_FAIL_CODE);
            result.setMessage(UserService.LOGIN_FAIL_MSG);
        }else{
            resultUser.setPassword("");
            user.setNaproEventList(null);
            result.setCode(UserService.LOGIN_SUCCESS_CODE);
            result.setMessage(UserService.LOGIN_SUCCESS_MSG);

            SessionUtil.setLoginInfo(user);
        }
        return result;
    }
}
