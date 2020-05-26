package edu.xidian.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test ")
public class FoodTypeServletTest extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("FoodTypeServlet;;;");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
