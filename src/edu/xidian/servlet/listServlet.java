package edu.xidian.servlet;

import edu.xidian.entity.FoodType;
import edu.xidian.factory.BeanFactory;
import edu.xidian.service.IFoodTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/demo")
public class listServlet extends HttpServlet {
    // 调用的菜系Service
    public IFoodTypeService foodTypeService = BeanFactory.getInstance("foodTypeService", IFoodTypeService.class);
    // 跳转资源
    public String uri;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            // 调用Service查询所有的类别
            List<FoodType> list = foodTypeService.getAll();
            // 保存
            request.setAttribute("listFoodType", list);
            // 跳转的菜系列表页面
            uri = "/sys/type/foodtype_list.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            uri = "/error/error.jsp";
        }

        // 跳转
        goTo(request,response,uri);

    }
    /**
     * 跳转的通用方法
     */
    private void goTo(HttpServletRequest request, HttpServletResponse response, Object uri)
            throws ServletException, IOException {
        if (uri instanceof RequestDispatcher){
            ((RequestDispatcher)uri).forward(request, response);
        } else if (uri instanceof String) {
            response.sendRedirect(request.getContextPath() + uri);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
