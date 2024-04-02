package by.itclass.controllers;

import by.itclass.model.db.DbInMemory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/jspSearch")
public class JspUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var fio = req.getParameter("fio");
        var user = DbInMemory.findUserByFio(fio);
        var rd = req.getRequestDispatcher("/pages/user.jsp");
        if (Objects.nonNull(user)) {
            req.setAttribute("us", user);
        } else {
            var message = String.format("User with name %s is not found", fio);
            req.setAttribute("mes", message);
        }
        rd.forward(req, resp);
    }
}
