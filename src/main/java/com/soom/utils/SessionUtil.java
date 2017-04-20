package com.soom.utils;

import com.soom.entity.User;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-20 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class SessionUtil {
    private  static final String LOGIN_INFO = "LOGIN_INFO";

    public static void removeLoginInfo(HttpSession session) {
        session.removeAttribute(LOGIN_INFO);
        session.invalidate();
    }

    public static void removeLoginInfo() {
        RequestContextHolder.getRequestAttributes().removeAttribute(LOGIN_INFO, RequestAttributes.SCOPE_SESSION);
    }

    public static User getLoginInfo() {
        Object sessionOjb = RequestContextHolder.getRequestAttributes().getAttribute(LOGIN_INFO, RequestAttributes.SCOPE_SESSION);
        User user = sessionOjb == null ? null : (User) sessionOjb;
        return user;
    }

    public static void setLoginInfo(User user) {
        RequestContextHolder.getRequestAttributes().setAttribute(LOGIN_INFO, user, RequestAttributes.SCOPE_SESSION);
    }

    public static String getLoginUserId() {
        RequestAttributes obj = RequestContextHolder.getRequestAttributes();
        if (obj == null) {
            return "";
        }
        Object sessionOjb = obj.getAttribute(LOGIN_INFO, RequestAttributes.SCOPE_SESSION);
        return (sessionOjb == null) ? "" : ((User) sessionOjb).getId();
    }

    public static String getServerIp() {
        String localServerIp = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface networkInterface = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = networkInterface.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() &&
                            !inetAddress.isLinkLocalAddress() &&
                            inetAddress.isSiteLocalAddress()) {
                        localServerIp = inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {

        }
        return localServerIp;
    }

    public static String getClientIp() {
        try {
            Object obj = RequestContextHolder.currentRequestAttributes();
            if (obj instanceof ServletRequestAttributes) {
                ServletRequestAttributes attr = (ServletRequestAttributes) obj;
                HttpServletRequest request = attr.getRequest();
                String ip = request.getHeader("X-FORWARDED-FOR");
                if (StringUtil.isEmpty(ip)) {
                    ip = request.getHeader("Proxy-Client-IP");
                }
                if (StringUtil.isEmpty(ip)) {
                    ip = request.getHeader("WL-Proxy-Client-IP");  // 웹로직
                }
                if (StringUtil.isEmpty(ip)) {
                    ip = request.getRemoteAddr();
                }
                if (StringUtil.isEmpty(ip)) {
                    ip = "";
                }
                return ip;
            }
        } catch (IllegalStateException ise) {
        }
        return "";
    }
}
