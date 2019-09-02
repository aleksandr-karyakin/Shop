DROP TABLE IF EXISTS orderItems;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS warehouse;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS users;

CREATE TABLE users(id int primary key auto_increment, name varchar(255) not null);

CREATE TABLE items(id int primary key auto_increment, name varchar(255) not null, price int not null, pictureURL varchar(255));

CREATE TABLE warehouse(item_id int not null, count int not null, foreign key (item_id) references items(id));

CREATE TABLE orders(id int primary key auto_increment, user_id int, date date default current_date(), status varchar(255) default 'NEW', foreign key (user_id) references users(id));

CREATE TABLE orderItems(id int primary key auto_increment, order_id int not null, item_id int not null, foreign key (order_id) references orders(id), foreign key (item_id) references items(id), unique(order_id, item_id));
