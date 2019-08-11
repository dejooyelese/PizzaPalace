<%-- 
    Document   : orders
    Created on : Aug 10, 2019, 12:00:15 PM
    Author     : Dejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizza Palace</title>
    </head>
    <body>
        <h1>Welcome To Pizza Palace</h1>
        
        <p>${errorMessage}</p>
        
        <p><input type="submit" value="New Order">
            <input type="hidden" name="action" value="add">
            
            <input type="submit" value="Print Current Order">
            <input type="hidden" name="action" value="add">
        </p>
        
        
        ------------------------<br>
        <table>
            <tr>
                <th>Order Number</th>
                <th>Delete</th>
                <th>Edit</th>
                <th>Print</th>
            </tr>
            
                <c:forEach var="orderItem" items="${orderList}" >
                <tr>
                    <td>${orderItem.orderNumber}</td>
                    <td>
                        <form action="orders" method="get" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedOrder" value="$}">
                        </form>
                    </td>
                    <td>
                        <form action="orders?edit" method="POST">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="orderToEdit" value="${orderItem.orderNumber}">
                        </form>
                    </td>
                    <td>
                        <form action="orders" method="get">
                            <input type="submit" value="Print">
                            <input type="hidden" name="action" value="print">
                            <input type="hidden" name="selectedOrder" value="$}">
                        </form>
                    </td>
                </tr>
                 </c:forEach>
        </table>
        ------------------------<br>
 
        <h2>Order Number: ${orderNumber}</h2>   
        <table>
            <tr>
                <th>Pizza Size</th>
                <th>Toppings</th>
                <th>Price</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="pizza" items="${pizzas}">
                <tr>
                    <td>${pizza.pizzaSize}</td>
                    <td>${TODO}</td>
                    <td>${pizza.bPrice}</td>
                    <td>
                        <form action="orders" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedOrder" value="$}">
                        </form>
                    </td>
                    <td>
                        <form action="orders" method="post">
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="print">
                            <input type="hidden" name="selectedOrder" value="$}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </table>                    
            <h3>Add Pizza</h3>
            <form action="pizzas" method="POST">
                <p>Size:</p>   
                        <input type="radio" name="size" value="small"> Small<br>
                        <input type="radio" name="size" value="medium"> Medium<br>
                        <input type="radio" name="size" value="large"> Large<br>
                
                <p>Basic Toppings:</p>
                        <input type="checkbox" name="topping" value="cheese"> Cheese <br>
                        <input type="checkbox" name="topping" value="pepperoni"> Pepperoni<br>
                        <input type="checkbox" name="topping" value="ham"> Ham <br>
                        <input type="checkbox" name="topping" value="pineapple"> Pineapple <br>
                      
                <p>Deluxe Toppings:</p>          
                        <input type="checkbox" name="topping" value="sausage"> Sausage <br>
                        <input type="checkbox" name="topping" value="feta"> Feta Cheese<br>
                        <input type="checkbox" name="topping" value="tomatoes"> Tomatoes <br>
                        <input type="checkbox" name="topping" value="olives"> Olives<br>
                        
                
                <p><input type="submit" value="Add To Order">
                    <input type="hidden" name="action" value="add"></p>
            </form>
            
            
<!--            <h3>Edit User</h3>
            <form action="users" method="POST">
                username: <input type="text" name="username" value="${selectedUser.username}" readonly><br>
                password: <input type="password" name="password" value="${selectedUser.password}"><br>
                first name: <input type="text" name="firstname" value="${selectedUser.firstname}"><br>
                last name: <input type="text" name="lastname" value="${selectedUser.lastname}"><br>
                email: <input type="email" name="email" value="${selectedUser.email}"><br>
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Save">
            </form>-->
    </body>
</html>