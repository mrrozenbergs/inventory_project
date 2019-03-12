-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
  (1, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'user@mail.com', 'user', 'Name', 'Surname',
   1);
-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
  (2, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'xxx@gmail.com', 'xxx', 'XXX', 'XXX', 1);
-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES (3, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'name@gmail.com', 'namesurname', 'Name',
        'Surname', 1);

INSERT INTO ROLE (role_id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE (role_id, role)
VALUES (2, 'ROLE_USER');

INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 2);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (2, 2);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (3, 2);

INSERT INTO client (client_id, company_name, contacts, reg_no)
VALUES ('1', 'IKEA', '6700000', '12345678');
INSERT INTO client (client_id, company_name, contacts, reg_no)
VALUES ('2', 'Rimi', '6711111', '22233311');

INSERT INTO CLIENT_USERS (client_id, user_id)
VALUES (1, 1);
INSERT INTO CLIENT_USERS (client_id, user_id)
VALUES (1, 2);
INSERT INTO CLIENT_USERS (client_id, user_id)
VALUES (2, 3);

INSERT INTO PRODUCT (product_id, eannumber, instock, price, productname)
VALUES ('1', '123455', '100', '2.20', 'Soda');
INSERT INTO PRODUCT (product_id, eannumber, instock, price, productname)
VALUES ('2', '222222', '100', '4.50', 'Burger');
INSERT INTO PRODUCT (product_id, eannumber, instock, price, productname)
VALUES ('3', '333333', '100', '6.35', 'Salad');
INSERT INTO PRODUCT (product_id, eannumber, instock, price, productname)
VALUES ('4', '444444', '100', '8.70', 'Fish');
INSERT INTO PRODUCT (product_id, eannumber, instock, price, productname)
VALUES ('5', '555555', '100', '1.99', 'Fries');