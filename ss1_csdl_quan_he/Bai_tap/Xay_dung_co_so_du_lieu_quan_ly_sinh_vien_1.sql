create database student_management;
use student_management;

create table class(
id_class int auto_increment,
class_name varchar(55),
so_luong int,
primary key (id_class)
);

create table teacher(
id_teacher int primary key auto_increment,
luong_co_ban int,
so_tiet_day int
);

insert into class(class_name, so_luong) value("C0422G1",32),("C0322G1",22);
insert into teacher(luong_co_ban, so_tiet_day) value(8000000,30),(8000000,40);

select * from class;
select * from teacher;

alter table class add hoc_phi int;
alter table teacher add ten_giao_vien text;

update class set hoc_phi = 7500000
where class_name="C0422G1";

update teacher set ten_giao_vien = "Tiến"
where so_tiet_day=40; 

delete from class where class_name ="C0322G1";
delete from teacher where so_tiet_day = 30;

