package controllers;

import dao.FarmDao;
import data.Farm;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/farms_get")
public class FarmGet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FarmDao farmDao = new FarmDao();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        List<Farm> farms = farmDao.getAll();
        req.setAttribute("farms", farms);
        getServletContext().getRequestDispatcher("/farms.jsp").forward(req, resp);
    }
}
