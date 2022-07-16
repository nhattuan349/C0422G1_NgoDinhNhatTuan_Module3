use ss2_bai2;

insert into customer(c_name,c_age)
values('Nhat Tuan','10'),
	('Huu Duc','20'),
	('Hoang Hai','50');


insert into order_ss2(c_id,o_date,o_total_price)
values(1,'2006-03-21',null),
	(2,'2006-03-23',null),
	(1,'2006-03-16',null);


insert into product(p_name,p_price)
values ('Ti Vi',3),
	('Tu Lanh',5),
	('Dieu Hoa',7),
	('Quat',1),
	('Bep Tu',2);


insert into oder_detail(o_id,p_id,od_qty)
values(1,14,'3'),
	(2,13,'7'),
	(3,12,'2'),
	(4,11,'1'),
	(5,10,'8'),
	(6,9,'4'),
	(7,8,'3');


select o.o_id,o.o_date,o.o_total_price as tong_tien
from order_ss2 o ;

select c.*,p.*
from customer c
join order_ss2 o on c.c_id=o.c_id
join oder_detail odt on o.o_id=odt.o_id
join product p on odt.p_id=p.p_id;

select c.*, count(o.c_id) as so_lan_mua_hang
from customer c
left join  order_ss2 o on c.c_id=o.c_id
group by c_id  having count(o.c_id)=0;

select o.o_id,o.o_date,sum(od_qty*p_price) as tong_tien
from order_ss2 o 
join oder_detail odt on o.o_id=odt.o_id
join product p on odt.p_id=p.p_id
group by o_id;