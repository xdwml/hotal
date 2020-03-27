--创建数据库
CREATE DATABASE hotel CHARACTER SET utf8;
USE hotel;
--1.餐桌表
CREATE TABLE dinnerTable(
   id INT PRIMARY KEY AUTO_INCREMENT,  
   tableName VARCHAR(20),              
   tableStatus INT DEFAULT 0,	       
   orderDate DATETIME
);

--2.菜类别表
CREATE TABLE foodType(
   id INT PRIMARY KEY AUTO_INCREMENT,  
   typeName VARCHAR(20)           
);
--3.菜品种表
CREATE TABLE food(
   id INT PRIMARY KEY AUTO_INCREMENT,  
   foodName VARCHAR(20),
   foodType_id INT,
   price DOUBLE,
   mprice DOUBLE,
   introduce VARCHAR(200),
   img VARCHAR(100)       
);

--4.订单表
CREATE TABLE orders(
   id INT PRIMARY KEY AUTO_INCREMENT,  
   table_id INT,
   orderDate DATETIME,
   totalPrice DOUBLE,
   orderStatus INT DEFAULT 0      
);

--5.订单明细表(主要是菜品种)
CREATE TABLE orderDetail(
   id INT PRIMARY KEY AUTO_INCREMENT,  
   orderId INT,
   food_id INT,
   foodCount INT    
);

--添加菜品与菜类别的关系约束
ALTER TABLE food ADD CONSTRAINT fk_food_foodType_id FOREIGN KEY(foodType_id) REFERENCES foodType(id);

--订单表：与餐桌表的关系

ALTER TABLE orders ADD CONSTRAINT order_table_id FOREIGN KEY(table_id) REFERENCES dinnerTable(id);


--订单明细：与订单表的关系

ALTER TABLE orderDetail ADD CONSTRAINT orderDetail_order_id FOREIGN KEY(orderId) REFERENCES orders(id);

--订单明细：与菜信息的关系

ALTER TABLE orderDetail ADD CONSTRAINT orderDetail_food_id FOREIGN KEY(food_id) REFERENCES food(id);



