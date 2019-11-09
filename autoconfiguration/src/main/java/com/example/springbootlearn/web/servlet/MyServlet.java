package com.example.springbootlearn.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/15
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

//这是servlet的异步线程
//异步线程并没有提高很多的处理速度，而是增加了吞吐量
@WebServlet(urlPatterns = "/servlet/myServlet", asyncSupported = true)
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();

        asyncContext.start(() -> {
            try {
                resp.getWriter().println("Hello World");
            } catch (IOException e) {
                e.printStackTrace();
            }
            asyncContext.complete();
        });


    }
}
