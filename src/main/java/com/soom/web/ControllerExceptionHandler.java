package com.soom.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-20 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class ControllerExceptionHandler {
    public static void sendError(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/np/login");
        if (requestDispatcher != null) {
            requestDispatcher.forward(request, response);
        }
    }
}
