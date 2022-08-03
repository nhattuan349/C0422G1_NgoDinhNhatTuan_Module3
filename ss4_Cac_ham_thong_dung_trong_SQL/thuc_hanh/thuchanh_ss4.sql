USE QuanLySinhVien;

-- Bước 2: Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi
SELECT Address, COUNT(Student_Id) AS 'Số lượng học viên'
FROM Student
GROUP BY Address;

-- Bước 3: Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG
SELECT S.Student_Id,S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name;

-- Bước 4: Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
-- Đầu tiên hiển thị điểm trung bình các môn học của mỗi học viên
SELECT S.Student_Id,S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name;

-- Sử dụng having để xét điều kiện điểm trung bình các môn học phải lớn hơn 15
SELECT S.Student_Id,S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name
HAVING AVG(Mark) > 15;

-- Bước 5: Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
-- Hiển thị danh sách điểm trung bình của các học viên
SELECT S.Student_Id, S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name;

-- Sử dụng Having và All để tìm học viên có điểm trung bình lớn nhất
SELECT S.Student_Id, S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.Student_Id);

