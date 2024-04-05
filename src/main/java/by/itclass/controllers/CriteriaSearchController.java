package by.itclass.controllers;

import by.itclass.model.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/criteria")
public class CriteriaSearchController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var params = req.getParameterMap();
        var users = userService.getUsersByCriteria(params);
        if (!users.isEmpty()) {
            req.setAttribute("users", users);
        } else {
            req.setAttribute("message", "Users is not found");
        }
        req.getRequestDispatcher("/pages/users.jsp").forward(req, resp);
    }
}
