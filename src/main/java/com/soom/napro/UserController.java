package com.soom.napro;

import com.soom.entity.User;
import com.soom.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    public String naproLoginHome(HttpServletRequest request){
        return "napro_login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result naproLogin(HttpServletRequest request, User user, Result result){
        User resultUser = userService.findUserByIdAndUser(user);

        if(resultUser == null){
            // TODO 메시지 리팩토링 필요.
            result.setCode("login-fail");
            result.setMessage("아이디 또는 비밀번호를 다시 확인하세요.");
        }
        return result;
    }
}
