package by.itclass.controllers;

import by.itclass.model.db.DbInMemory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var isFound = DbInMemory.isPresentByFio(req.getParameter("fio"));
        req.getRequestDispatcher(isFound ? "/pages/yes.html" : "http://google.com").forward(req, resp);
        //resp.sendRedirect(isFound ? "/pages/yes.html" : "http://google.com");
    }
}
