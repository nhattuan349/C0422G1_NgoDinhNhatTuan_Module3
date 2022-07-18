use Quanlysinhvien;

select * from subject;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from subject
where Credit = (select max(Credit) from subject);
-- cach khac
select Sub.*,max(Credit) as max_Credit
from subject Sub
group by Sub.Credit
having max_Credit >= all (select max(Credit)  from  subject group by credit);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select Sub.*, max(m.Mark) as max_Mark
from subject Sub 
join mark m on Sub.Sub_Id = m.Sub_Id
group by Sub.Sub_Id
having max_Mark >= all (select max(mark) from mark  group by Sub_Id);	 

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select S.Student_Id, S.Student_Name, avg(mark)
from student S 
join mark M on S.Student_Id = M.Student_Id
group by S.Student_Id,S.Student_Name
order by mark desc

