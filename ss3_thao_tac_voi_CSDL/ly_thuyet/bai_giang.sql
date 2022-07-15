drop database if exists ss3_bai_giang;
create database ss3_bai_giang;
use ss3_bai_giang;

create table jame(
account_jame varchar(50) primary key,
password varchar(25)
);

create table class_type(
id_class_type int auto_increment primary key,
name varchar(50)
);

create table class(
id_class int auto_increment primary key,
foreign key (class_type_id) references class_type(id_class_type),
name_class varchar(45),
class_type_id int
);

create table student(
id_student int auto_increment primary key,
name varchar(45),
birthday date,
gender tinyint(1),
email varchar(45),
point int,
account_student varchar(45),
class_id int,
foreign key (class_id) references class(id_class),
foreign key (account_student) references jame(account_jame)
);


create table instructor(
id_instructor int auto_increment primary key,
name varchar(50),
birthday date,
salary float
);

create table instructor_class(
class_id int,
foreign key (class_id) references class(id_class),
instructor_id int,
foreign key (instructor_id) references instructor(id_instructor),
start_time date	
);



