package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api/process-payment"})
public class PaymentProcessServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
//        int orderId = Integer.parseInt(request.getParameter("orderId"));

        // TODO query order by orderId

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        if (response.getStatus() == 200) {
//            context.setVariable("order", orderId);
            // TODO send email
            // TODO export to JSON
            engine.process("product/confirmation.html", context, response.getWriter());
        } else {
            response.sendRedirect("/payment");
        }

    }
}
