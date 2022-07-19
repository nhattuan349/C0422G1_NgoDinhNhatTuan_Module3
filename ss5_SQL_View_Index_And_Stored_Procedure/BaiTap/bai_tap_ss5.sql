drop database if exists demo;
create database demo;
use demo;

create table Products(
id int auto_increment primary key,
product_Code int,
product_Name varchar(45),
product_Price double,
product_Amount int,
product_Description varchar(45),
product_Status varchar(45)
);

insert into Products (product_Code,product_Name,product_Price,product_Amount,product_Description,product_Status)
values 
(1, 'Điện Thoại', 1000, 10, 'Còn Hàng', 'Hàng Mới'),
(2, 'Điều Hoà', 2000, 20, 'Còn Hàng', 'Hàng Mới'),
(3, 'Tủ Lạnh', 3000, 30, 'Còn Hàng', 'Hàng Mới'),
(4, 'Máy Lọc Nước', 4000, 40, 'Còn Hàng', 'Hàng Mới');

-- Bước 3:
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create index  index_1 on Products(product_Code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index index_2 on Products(product_Name,product_Price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select product_Code from  products where product_Code = '2';

-- So sánh câu truy vấn trước và sau khi tạo index
drop  index index_2 on Products;
explain select * from Products p
where p.product_Name = 'Biep tu' and p.product_Price = '2000';

-- Bước 4:
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view  product_view as select product_Code, product_Name, product_Price, product_Status  from Products;

-- Tiến hành sửa đổi view
update product_view set product_Code=3,product_Name='Dieu Hoa', product_Price='10000', product_Status='Hang Moi'
where product_Code = 1;

-- Tiến hành xoá view
drop view product_view;

--  Bước 5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create  procedure product_all()
begin
select * from  Products;
end //
delimiter ; 

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure product_add (
in  product_Code int,
in product_Name varchar(50),
in product_Price double,
in product_Amount int,
in product_Description varchar(100),
in product_Status varchar(100))
begin
insert into Products (`product_Code`, `product_Name`, `product_Price`, `product_Amount`, `product_Description`, `product_Status`)
values (product_Code, product_Name, product_Price, product_Amount, product_Description, product_Status);
end //
delimiter ;

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create  procedure product_update (
in id_product int,
in product_Code int,
in product_Name varchar(50),
in product_Price double,
in product_Amount int,
in product_Description varchar(100),
in product_Status varchar(100))
begin
update products
	set `product_Code` = product_Code,
		`product_Name` = product_Name,
		`product_Price` = product_Price,
		`product_Amount` = product_Amount,
		`product_Description` = product_Description,
		`product_Status` = product_Status
where `id_product` = id_product;
end
// delimiter ;

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure product_delete( 
in id_product int )
begin
delete from Products
where `id_product` = id_product;
end
// delimiter ;


