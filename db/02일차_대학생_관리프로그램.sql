#db 삭제
drop database if exists university;
#db 생성
create database if not exists university;

#db 선택
use university;

#학생 테이블 삭제/ 생성
drop table if exists student;
create table if not exists student(
  st_num char(10) NOT NULL,
  st_name varchar(30) NOT NULL,
  st_major varchar(15) NOT NULL,
  st_grade int NOT NULL default 1,
  PRIMARY KEY (st_num)
);

#교수 테이블 삭제/생성
drop table if exists professor;
create table if not exists professor(
  pr_num char(10) NOT NULL,
  pr_name varchar(30) NOT NULL,
  pr_major varchar(15) NOT NULL,
  pr_room varchar(100),
  PRIMARY KEY (pr_num)
);

#강의 테이블 삭제 생성
drop table if exists lecture;
CREATE TABLE IF NOT EXISTS lecture (
    le_num INT NOT NULL AUTO_INCREMENT,
    le_title VARCHAR(30) NOT NULL,
    le_room VARCHAR(100),
    le_schedule VARCHAR(50),
    le_point INT,
    le_hours INT,
    le_major CHAR(5) not null,
    le_pr_num CHAR(10),
    PRIMARY KEY (le_num),
    FOREIGN KEY (le_pr_num)
        REFERENCES professor (pr_num)
);

#수강 테이블 삭제 생성
drop table if exists course;
CREATE TABLE IF NOT EXISTS course (
    co_num INT NOT NULL auto_increment,
    co_midterm INT default 0,
    co_finalterm INT default 0,
    co_performance INT default 0,
    co_assignment INT default 0,
    co_grade varCHAR(2) default 'F',
    co_attendance INT default 0,
    co_st_num char(10),
    co_le_num INT,
    PRIMARY KEY (co_num),
    FOREIGN KEY (co_st_num)
        REFERENCES student (st_num),
    FOREIGN KEY (co_le_num)
        REFERENCES lecture (le_num)
);

#연락처 테이블 삭제/ 생성
drop table if exists contact;
CREATE TABLE IF NOT EXISTS contact (
	ct_num int auto_increment,
    ct_addr varchar(100) not null,
    ct_detail varchar(100),
    ct_phone varchar(13) not null,
    ct_st_num char(10) not null,
    primary key(ct_num),
    foreign key(ct_st_num) references student (st_num)
);


#예제 데이터 삽입.
INSERT INTO student (st_num, st_name, st_major, st_grade) 
VALUES ('2024160001', '홍길동', '컴퓨터공학', '1'),
('2024160002', '임꺽정', '컴퓨터공학', '1'),
('2024160003', '유재석', '컴퓨터공학', '1'),
('2024160004', '둘리', '컴퓨터공학', '1'),
('2024160005', '고길동', '컴퓨터공학', '1');

INSERT INTO student (st_num, st_name, st_major, st_grade) 
VALUES ('2024135001', '나영석', '화학공학', '1'),
('2024135002', '강호동', '화학공학', '1'),
('2024135003', '이둘리', '화학공학', '1');

INSERT INTO student (st_num, st_name, st_major, st_grade) 
VALUES ('2024123001', '가나다', '기계공학', '1'),
('2024123002', '박둘리', '기계공학', '1'),
('2024123003', '마둘리', '기계공학', '1');

INSERT INTO professor (pr_num, pr_name, pr_major, pr_room) VALUES 
('2024160001', '박교수', '컴퓨터공학', '3관 101호'),
('2024135001', '이교수', '화학공학', '3관 201호'),
('2024123001', '김교수', '기계공학', '3관 301호');

INSERT INTO lecture (le_title, le_room, le_schedule, le_point, le_hours, le_major, le_pr_num) VALUES 
('컴퓨터개론', '1관101호', '월1A,2B', '2', '2', '전공 필수', '2024160001'),
('프로그래밍언어', '1관101호', '월5A,6B,수5A,6B', '3', '4', '전공 필수', '2024160001'),
('화학기초', '2관101호', '화1A,2B,금1A,2B', '3', '4', '전공 필수', '2024135001'),
('동역학', '4관101호', '수1A,4B', '3', '4', '전공 필수', '2024123001');

# 수강 등록
insert into course (co_st_num,co_le_num) values 
((select st_num from student where st_name = '고길동'), 
(select le_num from lecture where le_title = '컴퓨터개론')),
((select st_num from student where st_name = '임꺽정'), 
(select le_num from lecture where le_title = '컴퓨터개론')),
((select st_num from student where st_name = '고길동'), 
(select le_num from lecture where le_title = '프로그래밍언어')),
((select st_num from student where st_name = '임꺽정'), 
(select le_num from lecture where le_title = '프로그래밍언어')),
((select st_num from student where st_name = '둘리'), 
(select le_num from lecture where le_title = '컴퓨터개론')),
((select st_num from student where st_name = '홍길동'), 
(select le_num from lecture where le_title = '컴퓨터개론')),
((select st_num from student where st_name = '유재석'), 
(select le_num from lecture where le_title = '프로그래밍언어')), 
((select st_num from student where st_name = '강호동'), 
(select le_num from lecture where le_title = '화학기초')),  
((select st_num from student where st_name = '나영석'), 
(select le_num from lecture where le_title = '화학기초')),  
((select st_num from student where st_name = '가나다'), 
(select le_num from lecture where le_title = '동역학')),  
((select st_num from student where st_name = '마둘리'), 
(select le_num from lecture where le_title = '동역학')),  
((select st_num from student where st_name = '박둘리'), 
(select le_num from lecture where le_title = '동역학')),  
((select st_num from student where st_name = '가나다'), 
(select le_num from lecture where le_title = '프로그래밍언어'));
