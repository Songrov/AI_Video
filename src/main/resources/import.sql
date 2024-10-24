-- import.sql начальные данные для @Entity таблиц

MERGE INTO products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) VALUES (1, 'Coca-Cola 0.33 alluminium', 0.86, true);
merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (2, 'Red Bull 0.5 alluminium', 2.05, true);
merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (3, 'Neslte Kit-Kat white', 1.02, false);
merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (4, 'Raviolli with cheese', 0.99, true);
merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (5, 'Goat cheese', 1.4, true);
merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (6, 'Safety Matches', 0.04, false);
merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (7, 'Calamari burger', 0.55, true);

merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (8, 'Salmon sandwich', 2.44, true);
merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (9, 'Wasabi', 1.33, false);
merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (10, 'Chicken Rice', 1.77, true);
merge into PRODUCTS (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (11, 'Salami with pepper', 2.01, true);
merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (12, 'Shrimp coctail', 11.22, false);
merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (13, 'Salmon rolls', 8.71, true);
merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (14, 'Baguette with coriander', 2.31, true);
merge into products (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_IS_ACTIVE) KEY(ID) values (15, 'Pork sausages', 2.44, false);

merge into  COMMENTS (ID, CONTENT, PRODUCT_ID) KEY(ID) values (1, 'My favorite product', 1);
merge into  COMMENTS (ID, CONTENT, PRODUCT_ID) KEY(ID) values (2, 'Like this product too', 2);
merge into  COMMENTS (ID, CONTENT, PRODUCT_ID) KEY(ID) values (3, 'Another useful comment', 2);

merge into  CARDS (ID, NAME) KEY(ID) values (1, 'My cristmas products');

merge into  product_card (PRODUCT_ID, CARD_ID) KEY(PRODUCT_ID, CARD_ID) values (1,1);
merge into  product_card (PRODUCT_ID, CARD_ID) KEY(PRODUCT_ID, CARD_ID) values (2,1);
merge into  product_card (PRODUCT_ID, CARD_ID) KEY(PRODUCT_ID, CARD_ID) values (3,1);

merge into users(user_id, login, password) KEY(user_id) values (1, 'max', 'secret');
merge into users(user_id, login, password) KEY(user_id) values (2, 'alexandra', 'mystery');

merge into details(user_detail_id, user_id, email, dob, tel) key(user_detail_id) values(1,1,'max@gmail.com', '2005-05-07', '+7987654321');


