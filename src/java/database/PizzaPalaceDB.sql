DROP DATABASE if exists PizzaPalaceDB;
CREATE DATABASE PizzaPalaceDB;

USE PizzaPalaceDB;

CREATE TABLE Orders (
    orderNumber INT NOT NULL AUTO_INCREMENT, 
    orderName VARCHAR(20) NOT NULL,
    PRIMARY KEY (orderNumber));

CREATE TABLE Pizzas (
    orderNumber INT NOT NULL,
    pizzaNumber INT NOT NULL AUTO_INCREMENT,
    pizzaSize VARCHAR(20) NOT NULL,
    bPrice DECIMAL(4,2) NOT NULL,
    Owner INT NOT NULL,
    PRIMARY KEY (pizzaNumber),
    CONSTRAINT fk_pizza_orders FOREIGN KEY (Owner) REFERENCES Orders(orderNumber)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE Toppings (
    toppingName VARCHAR(20) NOT NULL,
    sPrice DECIMAL(4,2) NOT NULL,
    mPrice DECIMAL(4,2) NOT NULL,
    lPrice DECIMAL(4,2) NOT NULL,
    CONSTRAINT PK_toppingName PRIMARY KEY (toppingName));
    

CREATE TABLE PT_bridge (
    toppingName VARCHAR(20) NOT NULL,
    pizzaNumber INT NOT NULL,
    CONSTRAINT PK_top_pizza PRIMARY KEY (toppingName, pizzaNumber));

INSERT INTO Orders(orderNumber, orderName)
VALUES(1, "Standard");
INSERT INTO Orders(orderNumber, orderName)
VALUES(2,"Standard");
INSERT INTO Orders(orderNumber, orderName)
VALUES(3,"Standard");

INSERT INTO Pizzas(orderNumber, pizzaNumber, pizzaSize, bPrice,Owner)
VALUES(1,1,"Large",16,1);

INSERT INTO Pizzas(orderNumber, pizzaNumber, pizzaSize, bPrice,Owner)
VALUES(1,2,"Large",16,1);

INSERT INTO Pizzas(orderNumber, pizzaNumber, pizzaSize, bPrice,Owner)
VALUES(3,3,"Large",16,3);

INSERT INTO Toppings(toppingName, sPrice, mPrice, lPrice)
VALUES("Cheese",0.25,0.75,1.00);

INSERT INTO Toppings(toppingName, sPrice, mPrice, lPrice)
VALUES("Pepperoni",0.50,0.75,1.00);

INSERT INTO Toppings(toppingName, sPrice, mPrice, lPrice)
VALUES("Ham",0.75,1.00,1.25);

INSERT INTO Toppings(toppingName, sPrice, mPrice, lPrice)
VALUES("Pineapplee",0.50,1.00,1.50);

INSERT INTO Toppings(toppingName, sPrice, mPrice, lPrice)
VALUES("Sausage",2.25,3.50,4.50);

INSERT INTO Toppings(toppingName, sPrice, mPrice, lPrice)
VALUES("Feta Cheese",2.00,3.00,4.00);

INSERT INTO Toppings(toppingName, sPrice, mPrice, lPrice)
VALUES("Tomatoes",2.25,3.75,4.75);

INSERT INTO Toppings(toppingName, sPrice, mPrice, lPrice)
VALUES("Olives",2.00,3.00,4.00);

COMMIT;
