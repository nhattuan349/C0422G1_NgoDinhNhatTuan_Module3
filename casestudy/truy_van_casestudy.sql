
use furama ;
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống 
-- có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien
where (ho_ten like"T%" or ho_ten like"H%" or ho_ten like"K%") and char_length(ho_ten <=15);

-- task 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
-- và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang 
	where (round(datediff(curdate(),ngay_sinh)/365,0)>=18 
	and round(datediff(curdate(),ngay_sinh)/365,0)<=50 
	and dia_chi like "%Đà Nẵng"
	or dia_chi like "%Quảng Trị");
    
-- task 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select hd.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, count(hd.ma_khach_hang) as so_lan_thue
from hop_dong hd
join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
join loai_khach lk 	on kh.ma_loai_khach = lk.ma_loai_khach
where lk.ten_loai_khach = 'Diamond'
group by kh.ho_ten
order by so_lan_thue;

-- task 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach,
-- ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, 
-- tong_tien (Với tổng tiền được tính theo công thức như sau:
-- Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng.
-- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,
 ifnull(chi_phi_thue,0)+ifnull(so_luong*gia,0) as tong_tien
 from khach_hang kh
 left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
 left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
 left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
 left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
 left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
 group by kh.ma_khach_hang;	
 
-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue,
-- ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện
-- đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
join hop_dong hd on  dv.ma_dich_vu = hd.ma_dich_vu
group by dv.ma_dich_vu
having dv.ma_dich_vu not in
(select dv.ma_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where (month(hd.ngay_lam_hop_dong ) between 1 and 3) and year(hd.ngay_lam_hop_dong) = 2021
group by dv.ma_dich_vu);

/*
task 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 
nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
*/

select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu, hd.ngay_lam_hop_dong
from dich_vu dv
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where year(hd.ngay_lam_hop_dong) =2020
group by dv.ma_dich_vu
having dv.ma_dich_vu not in 
(select dv.ma_dich_vu
from dich_vu dv 
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where year(hd.ngay_lam_hop_dong)=2021);

/*
8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
*/
-- task 8 cach 1
select distinct ho_ten from khach_hang;
-- task 8 cach 2
select ho_ten from khach_hang
group by ho_ten;
-- task 8 cach 3
select ho_ten from khach_hang
union
select ho_ten from khach_hang;


/*
task 9.	Thực hiện thống kê doanh thu theo tháng, 
nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
*/
select month(ngay_lam_hop_dong) as thang, count(hd.ma_khach_hang) as so_lan_dat_phong_trong_thang
from hop_dong hd
where year (ngay_lam_hop_dong) = 2021
group by thang
order by ngay_lam_hop_dong;

/*
10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
(được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
*/

select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc,sum(ifnull(hdct.so_luong,0)) as so_luong_dich_vu_di_kem
from hop_dong hd
left join  hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem =  dvdk.ma_dich_vu_di_kem
group by ma_hop_dong
order by so_luong_dich_vu_di_kem desc;

/*
11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng 
bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
*/
select dvdk.*,kh.dia_chi,lk.ten_loai_khach
 from dich_vu_di_kem dvdk 
 join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
 join hop_dong hd   on hdct.ma_hop_dong = hd.ma_hop_dong
 join khach_hang kh on hd.ma_khach_hang = hd.ma_khach_hang
 join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
 where lk.ten_loai_khach = 'Diamond' and  (kh.dia_chi  like '%Vinh%' or kh.dia_chi like '%Quãng Ngãi%');
 
 /*
12.	Hiển thị thông tin
 ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem 
(được tính dựa trên việc sum so_luong ở dich_vu_di_kem),tien_dat_coc của tất cả các dịch vụ
 đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
*/

 select hd.ma_hop_dong,nv.ho_ten as ho_ten_nhan_vien,kh.ho_ten,kh.so_dien_thoai,dv.ma_dich_vu,dv.ten_dich_vu,
 sum(ifnull(hdct.so_luong,0)) as so_luong_dich_vu_di_kem,hd.tien_dat_coc
 from hop_dong hd
  join nhan_vien nv  on hd.ma_nhan_vien  = nv.ma_nhan_vien
  join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
  join dich_vu dv    on hd.ma_dich_vu    = dv.ma_dich_vu
  join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
 where (month(ngay_lam_hop_dong) between 10 and 12)  and year(ngay_lam_hop_dong)=2020
 group by hd.ma_hop_dong;
 
  /*
12.	Hiển thị thông tin
 ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, 
 so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem),tien_dat_coc của tất cả các dịch vụ
 đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
*/

select hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu, 
sum(ifnull(hdct.so_luong,0)) as sum_so_luong_dich_vu_di_kem, dv.tien_dat_coc
from hop_dong hd
join nhan_vien nv on  hd.ma_nhan_vien =  nv.ma_nhan_vien
join khach_hang kh on  hd.ma_khach_hang = kh.ma_khach_hang
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
where (month(ngay_lam_hop_dong) bet) 
 