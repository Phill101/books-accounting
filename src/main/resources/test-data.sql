--role
INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, name) VALUES (2, 'ROLE_USER');

--user
INSERT INTO user (login, password, role_id) VALUES ('admin@gmail.com','12345', 1);
INSERT INTO user (login, password, role_id) VALUES ('test@outlook.com','12345', 2);
INSERT INTO user (login, password, role_id) VALUES ('test1@outlook.com','12345', 2);
INSERT INTO user (login, password, role_id) VALUES ('test2@outlook.com','12345', 2);
INSERT INTO user (login, password, role_id) VALUES ('test3@outlook.com','12345', 2);
INSERT INTO user (login, password, role_id) VALUES ('test4@outlook.com','12345', 2);
INSERT INTO user (login, password, role_id) VALUES ('test5@outlook.com','12345', 2);
INSERT INTO user (login, password, role_id) VALUES ('test6@outlook.com','12345', 2);
INSERT INTO user (login, password, role_id) VALUES ('test7@outlook.com','12345', 2);
INSERT INTO user (login, password, role_id) VALUES ('roleuser','12345', 2);

--category
INSERT INTO category (name) VALUES ('Medicine');
INSERT INTO category (name) VALUES ('IT');
INSERT INTO category (name) VALUES ('Classic');

--book
INSERT INTO book (name, author, lib_quantity, category_id) VALUES ('Medicine for novice', 'John Silver', 3, 1);
INSERT INTO book (name, author, lib_quantity, category_id) VALUES ('Medicine for pro', 'John Silver', 1, 1);
INSERT INTO book (name, author, lib_quantity, category_id) VALUES ('Medicine for students', 'John Silver', 11, 1);
INSERT INTO book (name, author, lib_quantity, category_id) VALUES ('Thinking in Java', 'Bruce Eckel', 2, 2);
INSERT INTO book (name, author, lib_quantity, category_id) VALUES ('Pro Spring 4', 'Chris Schaefer', 6, 2);
INSERT INTO book (name, author, lib_quantity, category_id) VALUES ('The Lost World', 'Arthur Conan Doyle', 3, 3);
INSERT INTO book (name, author, lib_quantity, category_id) VALUES ('Sherlock Holmes', 'Arthur Conan Doyle', 2, 3);

--many to many reference
INSERT INTO user_book (user_id, book_id) VALUES (2, 1);
INSERT INTO user_book (user_id, book_id) VALUES (3, 1);
INSERT INTO user_book (user_id, book_id) VALUES (4, 2);
INSERT INTO user_book (user_id, book_id) VALUES (5, 3);
INSERT INTO user_book (user_id, book_id) VALUES (6, 4);
INSERT INTO user_book (user_id, book_id) VALUES (7, 5);
INSERT INTO user_book (user_id, book_id) VALUES (8, 6);
INSERT INTO user_book (user_id, book_id) VALUES (9, 7);
