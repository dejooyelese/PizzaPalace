package servlets;

import database.PizzaPalaceDBException;
import services.OrderService;
import models.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Pizza;

public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        OrderService os = new OrderService();
        Order o = null;
        Integer thisOrderNumber = 000;
        try {
            List<Order> orderList = os.getAllOrders();
            request.setAttribute("orderList", orderList);
        } catch (Exception ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            o = os.getOrder(thisOrderNumber);
        } catch (Exception ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }  
        try {
            request.setAttribute("orderNumber", o.toString());
        } catch (Exception ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           List<Pizza> pizzaList = os.getAllPizzaFromOrder(Integer.parseInt(request.getParameter("orderToEdit")));
           request.setAttribute("pizzaList", pizzaList);
        } catch (Exception ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/orders.jsp").forward(request, response);
    }
       

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrderService os = new OrderService();

        try {
            List<Order> orderList = os.getAllOrders();
            request.setAttribute("orderList", orderList);
        } catch (Exception ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(request.getParameter("editOrder") != null) {
            try {
                request.setAttribute("orderNumber", os.getOrder(Integer.parseInt(request.getParameter("orderToEdit"))));
            } catch (Exception ex) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else 
        if(request.getParameter("newOrder") != null) {
            try {
                os.insertOrder(0,"Standard");
            } catch (Exception ex) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        if(request.getParameter("deletePizza") != null) {
            try {
                os.deletePizza(Integer.parseInt(request.getParameter("pizzaToDelete")));
            } catch (Exception ex) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        if(request.getParameter("deleteOrder") != null) {
            try {
                os.deleteOrder(Integer.parseInt(request.getParameter("orderToDelete")));
            } catch (Exception ex) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        
        
        //Load the Tables
        try {
            List<Order> orderList = os.getAllOrders();
            request.setAttribute("orderList", orderList);
        } catch (Exception ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           List<Pizza> pizzaList = os.getAllPizzaFromOrder(Integer.parseInt(request.getParameter("orderToEdit")));
           request.setAttribute("pizzaList", pizzaList);
        } catch (Exception ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       getServletContext().getRequestDispatcher("/WEB-INF/orders.jsp").forward(request, response);
    }
       
}
