use internship;

-- 1.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên
select i.instructor_id,i.instructor_name,f.faculty_name
from instructor i
join faculty f on i.faculty_id = f.faculty_id;

-- 2.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của các giảng viên của khoa ‘DIA LY va QLTN’
select i.instructor_id,i.instructor_name,f.faculty_name khoa
from instructor i
join faculty f on i.faculty_id = f.faculty_id
where f.faculty_name='Dia ly va QLTN';

-- 3.	Cho biết số sinh viên của khoa ‘CONG NGHE SINH HOC’
select f.faculty_id,f.faculty_name, count(student_id)
from faculty f
join student s on f.faculty_id = s.faculty_id
where f.faculty_name='Cong nghe Sinh hoc';

-- 4.	Đưa ra danh sách gồm mã số, họ tên và tuổi của các sinh viên khoa ‘TOAN’
select s.student_id,s.student_name,year(curdate())- s.date_of_birth as tuoi
from student s;

-- 5.	Cho biết số giảng viên của khoa ‘CONG NGHE SINH HOC’
select f.faculty_id,f.faculty_name, count(instructor_id)
from faculty f
join instructor s on f.faculty_id = s.faculty_id
where f.faculty_name='Cong nghe Sinh hoc';

-- 6.	Cho biết thông tin về sinh viên không tham gia thực tập
select s.student_id,s.student_name
from student s
where s.student_id not in 
(select ins.student_id
from instructor_student ins);
 
 
 -- 7.	Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa
 select f.faculty_id, f.faculty_name, count(instructor_id) so_giang_vien
 from faculty f
 join instructor i on f.faculty_id = i.faculty_id
 group by f.faculty_name;
 
 -- 8.	Cho biết số điện thoại của khoa mà sinh viên có tên ‘Le van son’ đang theo học
 select f.*,s.student_name 
 from faculty f
 join student s on f.faculty_id = s.faculty_id
 where s.student_name = 'Le Van Son';
 
 -- PHAN II
 -- 1.	Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn
 select p.project_id,p.project_name,i.instructor_name
from project p
join instructor_student ins on p.project_id = ins.project_id
join instructor i on ins.instructor_id = i.instructor_id
where i.instructor_name = 'Tran son';

-- 2.	Cho biết tên đề tài không có sinh viên nào thực tập
 select p.project_id,p.project_name
from project p
left join instructor_student ins on p.project_id = ins.project_id
left join student i on ins.student_id = i.student_id
where ins.project_id is null;

-- 3.	Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên.
select i.instructor_id, i.instructor_name, f.faculty_name, count(ins.instructor_id) sinh_vien_huong_dan
from instructor i
join faculty f on i.faculty_id = f.faculty_id
join instructor_student ins on i.instructor_id = ins.instructor_id
group by ins.instructor_id
having sinh_vien_huong_dan >= 3;

-- 4.	Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất
select p.project_id, p.project_name, max(p.expense) kinh_phi_cao_nhat
from project p;

-- 5.	Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập
select p.project_id, p.project_name, count(ins.project_id) so_luong_tham_gia_de_tai
from project p
join instructor_student ins on p.project_id = ins.project_id
join student s on ins.student_id = s.student_id
group by ins.project_id
having so_luong_tham_gia_de_tai >= 3

