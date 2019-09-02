package controllers;


import dao.FarmDao;
import data.Farm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/farms_delete")
public class FarmDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FarmDao farmDao = new FarmDao();
        farmDao.delete(UUID.fromString(req.getParameter("id")));
        resp.sendRedirect(req.getContextPath() + "/farms");
    }
}
