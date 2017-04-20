package com.soom.web.interceptor;

import com.soom.entity.User;
import com.soom.utils.SessionUtil;
import com.soom.web.ControllerExceptionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-20 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 로그인 여부를 체크한다.
        User user = SessionUtil.getLoginInfo();
        if (user == null) {
            request.setAttribute("ERROR_CODE", "");
            ControllerExceptionHandler.sendError(request, response);
            return false;
        }

        return true;
    }
}
