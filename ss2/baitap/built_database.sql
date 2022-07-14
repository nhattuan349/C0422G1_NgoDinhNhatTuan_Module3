drop database if exists ss2_bai2;
create database ss2_bai2;
use ss2_bai2;

create table customer(
c_id int auto_increment primary key,
c_name varchar(45),
c_age varchar(45)
);

create table order_ss2(
o_id int auto_increment primary key,
c_id int,
foreign key(c_id) references customer(c_id),
o_date date,
o_total_price int 
);

create table product(
p_id int auto_increment primary key,
p_name varchar(45),
p_price int
);

create table oder_detail(
o_id int ,
p_id int ,
od_qty varchar(45),
primary key(o_id,p_id),
foreign key(o_id) references order_ss2(o_id),
foreign key(p_id) references product(p_id));