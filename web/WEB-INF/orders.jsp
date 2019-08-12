<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizza Palace</title>
    </head>
    <body>
        <h1>Welcome To Pizza Palace</h1>
        
        <p>${errorMessage}</p>
        
        <p>
            <form action="orders?newOrder" method="POST" >
            <input type="submit" value="New Order">
            </form>
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
                        <form action="orders?deleteOrder" method="POST" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="orderToDelete" value="${orderItem.orderNumber}">
                        </form>
                    </td>
                    <td>
                        <form action="orders?editOrder" method="POST">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="orderToEdit" value="${orderItem.orderNumber}">
                        </form>
                    </td>
                    <td>
                        <form action="orders" method="POST">
                            <input type="button" value="Print">
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
            
                <c:forEach var="pizzaItem" items="${pizzaList}">
                <tr>
                    <td>${pizzaItem.pizzaSize}</td>
                    <td>${"TO DO"}</td>
                    <td><fmt:formatNumber value = "${pizzaItem.bPrice}" type = "currency"/></td>
                    <td>
                        <form method="POST">
                            <input type="button" value="Edit">
                        </form>
                    </td>
                    <td>
                        <form action="orders?deletePizza" method="POST">
                            <input type="submit" value="Delete">
                            <input type="hidden" name="pizzaToDelete" value="${pizzaItem.pizzaNumber}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </table>    
        
        ------------------------<br>
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

                <p><input type="button" value="Add To Order">
                    <input type="hidden" name="action" value="add"></p>
            </form>
    </body>
</html>