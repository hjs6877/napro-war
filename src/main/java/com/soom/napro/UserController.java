package com.soom.napro;

import com.soom.entity.User;
import com.soom.utils.SessionUtil;
import com.soom.utils.StringUtil;
import com.soom.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    public ResponseEntity naproLogin(User user, Result result){
        User resultUser = userService.findUserByIdAndPassword(user);
        Map<String, String> resultMap = new HashMap<>();
        try{
            if(resultUser == null){
                result.setCode(UserService.LOGIN_FAIL_CODE);
                result.setMessage(UserService.LOGIN_FAIL_MSG);
            }else{

                String allowAutoLogin = user.getAllowAutoLogin();
                String salt = UUID.randomUUID().toString();
                if(StringUtil.nullToWhiteSpace(allowAutoLogin).equals("Y")){

                    resultUser.setAllowAutoLogin(allowAutoLogin);
                    resultUser.setSalt(salt);

                    userService.modifyUser(resultUser);

                    resultMap.put("allowAutoLogin", allowAutoLogin);
                    resultMap.put("userId", resultUser.getId());
                    resultMap.put("salt", resultUser.getSalt());
                }else{
                    // TODO 중복 리팩토링 필요.
                    resultUser.setAllowAutoLogin(allowAutoLogin);
                    resultUser.setSalt(null);
                    userService.modifyUser(resultUser);
                }

                result.setCode(UserService.LOGIN_SUCCESS_CODE);
                result.setMessage(UserService.LOGIN_SUCCESS_MSG);

                resultUser.setNaproEventList(null);
                resultUser.setPassword("");
                SessionUtil.setLoginInfo(resultUser);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        result.setResultData(resultMap);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/login/auto", method = RequestMethod.POST)
    public ResponseEntity naproLoginAuto(User user, Result result){
        User resultUser = userService.findUserByIdAndSalt(user);

        try{
            if(resultUser == null){
                result.setCode(UserService.LOGIN_AUTO_DENY);
            }else{
                if(StringUtil.nullToWhiteSpace(resultUser.getAllowAutoLogin()).equals("Y")){
                    resultUser.setNaproEventList(null);
                    resultUser.setPassword("");
                    SessionUtil.setLoginInfo(resultUser);

                    result.setCode(UserService.LOGIN_AUTO_ALLOW);
                }else{
                    result.setCode(UserService.LOGIN_AUTO_DENY);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity naproLogout(HttpSession session, Result result){
        SessionUtil.removeSession(session);
        result.setCode(UserService.LOGOUT_SUCCESS_CODE);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
