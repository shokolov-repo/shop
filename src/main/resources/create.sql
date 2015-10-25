DROP DATABASE IF EXISTS shop;
CREATE DATABASE shop;
USE shop;
CREATE TABLE USERS (
  ID         BIGINT AUTO_INCREMENT PRIMARY KEY,
  FIRST_NAME VARCHAR(20)        NOT NULL,
  LAST_NAME  VARCHAR(20),
  ADDRESS    VARCHAR(100),
  PHONE      VARCHAR(13),
  EMAIL      VARCHAR(30) UNIQUE NOT NULL,
  PASSWORD   VARCHAR(10)        NOT NULL,
  ROLE       VARCHAR(10)        NOT NULL
);
CREATE TABLE PRODUCTS (
  ID          BIGINT AUTO_INCREMENT PRIMARY KEY,
  TITLE       VARCHAR(20)   NOT NULL,
  PRICE       DOUBLE(10, 2) NOT NULL,
  QUANTITY    INT(10)       NOT NULL,
  DESCRIPTION VARCHAR(250)
);
CREATE TABLE ORDERS (
  ID          BIGINT AUTO_INCREMENT PRIMARY KEY,
  USER_ID BIGINT      NOT NULL,
  DATE_ORDER  DATE        NOT NULL,
  STATUS      VARCHAR(10) NOT NULL,
  FOREIGN KEY (USER_ID) REFERENCES USERS (ID)
);
CREATE TABLE PRODUCTS_SOLD (
  ORDER_ID BIGINT        NOT NULL,
  TITLE    VARCHAR(250)  NOT NULL,
  QUANTITY INT(10)       NOT NULL,
  PRICE    DOUBLE(10, 2) NOT NULL,
  FOREIGN KEY (ORDER_ID) REFERENCES ORDERS (ID)
);
CREATE TABLE COMMENTS (
  ID            BIGINT AUTO_INCREMENT PRIMARY KEY,
  PRODUCT_ID    BIGINT       NOT NULL,
  USER_ID   BIGINT       NOT NULL,
  USER_NAME VARCHAR(20)  NOT NULL,
  CONTENT       VARCHAR(250) NOT NULL,
  FOREIGN KEY (USER_ID) REFERENCES USERS (ID)
);


INSERT INTO USERS (FIRST_NAME, LAST_NAME, ADDRESS, PHONE, EMAIL, PASSWORD, ROLE)
VALUES ("chuck", "norris", "USA", "1234", "chuck@norris.us", "ranger", "admin");
INSERT INTO USERS (FIRST_NAME, LAST_NAME, ADDRESS, PHONE, EMAIL, PASSWORD, ROLE)
VALUES ("bruce", "lee", "China", "2345", "bruce@lee", "kee-ya", "seller");
INSERT INTO USERS (FIRST_NAME, LAST_NAME, ADDRESS, PHONE, EMAIL, PASSWORD, ROLE)
VALUES ("vasily", "terkin", "Russia", "3456", "vasily@terkin.ru", "bear", "user");
INSERT INTO PRODUCTS (TITLE, PRICE, QUANTITY, DESCRIPTION)
VALUES ("product1", "1.00", "5", "description product 1");
INSERT INTO PRODUCTS (TITLE, PRICE, QUANTITY, DESCRIPTION)
VALUES ( "product2", "2.00", "5", "description product 2");
INSERT INTO PRODUCTS (TITLE, PRICE, QUANTITY, DESCRIPTION)
VALUES ("product 3", "3.00", "5", "description product 3");
INSERT INTO ORDERS (USER_ID, DATE_ORDER, STATUS)
VALUES ("1", "2015-02-12", "sold");
INSERT INTO ORDERS (USER_ID, DATE_ORDER, STATUS)
VALUES ("2", "2015-02-13", "sold");
INSERT INTO ORDERS (USER_ID, DATE_ORDER, STATUS)
VALUES ("2", "2015-02-14", "check");
INSERT INTO PRODUCTS_SOLD (ORDER_ID, TITLE, QUANTITY, PRICE)
VALUES ("1", "1", "1", "1.00");
INSERT INTO PRODUCTS_SOLD (ORDER_ID, TITLE, QUANTITY, PRICE)
VALUES ("2", "1", "2", "1.00");
INSERT INTO COMMENTS (USER_ID, PRODUCT_ID, USER_NAME, CONTENT)
VALUES ("1", "1", "chuck", "content1chuk");
INSERT INTO COMMENTS (USER_ID, PRODUCT_ID, USER_NAME, CONTENT)
VALUES ("1", "2", "chuck", "content2chuk");
INSERT INTO COMMENTS (USER_ID, PRODUCT_ID, USER_NAME, CONTENT)
VALUES ("2", "1", "bruce", "content1bruce");

