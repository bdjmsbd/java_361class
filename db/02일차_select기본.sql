use student;

SELECT * FROM student WHERE
    student.studentNum IN (SELECT 
            student.score.studentNum
        FROM
            student.score
        WHERE
            midterm >= 90);

INSERT INTO `student`.`student` (`grade`, `class`, `num`, `name`) VALUES ( '1', '1', '2', '둘리');
INSERT INTO `student`.`student` (`grade`, `class`, `num`, `name`) VALUES ( '1', '1', '15', '타조');

INSERT INTO `student`.`score` (`midTerm`, `finalTerm`, `performance`, `studentNum`, `sbjectNum`) VALUES ('80', '100', '100', '4', '3');
UPDATE `student`.`score` SET `performance` = '80' WHERE (`num` = '1');
INSERT INTO `student`.`score` (`midTerm`, `finalTerm`, `performance`, `studentNum`, `sbjectNum`) VALUES ('50', '100', '80', '5', '2');
INSERT INTO `student`.`score` (`midTerm`, `finalTerm`, `performance`, `studentNum`, `sbjectNum`) VALUES ('100', '100', '100', '5', '3');
INSERT INTO `student`.`score` (`midTerm`, `finalTerm`, `performance`, `studentNum`, `sbjectNum`) VALUES ('50', '50', '50', '5', '1');


select * from student where student.studentNum in 
	(select student.score.studentNum from student.score where midterm <= 50);

select * from student join student.score on student.studentNum = student.score.studentnum;
select * from student join student.score where student.studentNum = student.score.studentnum;

select * from score where midterm >= 90;
select midterm from score where midterm >= 90;   
select distinct midterm from score where midterm >= 90;    


select * from score where midterm in (50);   

-- 홍씨
select * from student where student.name like '홍%';
-- 이름 외자
select * from student where student.name like '__';
-- 사이~
select * from student where student.grade between 1 and 2 ;
-- 포함 
select * from student where student.name like '%길%';
select * from student where student.name like concat('%','길','%');
select * from student where student.name like concat('%리%');

insert into student.student(grade , class ,num, name) values (2,1,1,'고길동'),(3,1,1,'나둘리');

# 학년은 높은 학년 반,번호는 낮은 순으로 
SELECT 
    *
FROM
    student.student
# where student.student.num is not null
ORDER BY student.grade DESC , student.class ASC , student.num ASC;


# Limit (번지,) 갯수;
select * from student limit 1, 2;

SELECT 
    *
FROM
    student.student
ORDER BY student.grade ASC , student.class ASC , student.num ASC
LIMIT 2; # 2,2 4,2 ... 

# group by 속성명1 [, 속성명2, ...]
# having 

# 각 학년의 학생 수를 조회
select student.grade from student.student group by student.grade;
select student.grade from student.student having count(student.grade);  
select student.grade,count(student.grade) from student.student group by student.grade order by student.grade asc; 

# as : 이름 바꾸기~ 생략해서 쓸 수 있음
select student.grade '학년' from student.student group by student.grade having count(student.grade)>=2 order by student.grade asc; 
select student.grade as '학년' from student.student group by student.grade having count(student.grade)>=2 order by student.grade asc; 

# 성적이 있는 각 학생들의 평균을 구하는 예제
select student.*, avg(0.4 * midterm + 0.5*finalterm + 0.1*performance) from score join student on score.studentNum = student.studentnum group by studentNum;
select score.studentnum from score group by studentNum;

# 각 학생의 각 과목 성적을 조회
select student.name '이름', subject.grade '학년', subject.semester '학기', subject.name '과목', midterm '중간고사', finalterm '기말고사', performance '수행평가' from student join score on score.studentNum = student.studentnum join subject on subject.num = score.sbjectnum order by student.name asc;

# outer join : left, right
# - 두 테이블에 연결된 행 뿐 아니라 연결되지 않은 행들도 조회할 때 사용
# - 두 테이블에 연결될 행들만 조회 => inner join
# - left(right) join : 왼(오) 테이블 기준으로 오(왼) 테이블을 연결

select student.*, subject.grade '학년', subject.semester '학기', subject.name '과목', midterm '중간고사', finalterm '기말고사', performance '수행평가' from student left join score on score.studentNum = student.studentnum left join subject on subject.num = score.sbjectnum order by subject.grade desc, student.studentnum desc;

# 등록된 전체 학생수를 조회
select count(*) 학생수 from student;
# 학생들의 국어 성적을 조회 
select student.*, score.* from student left join score using(studentnum) left join subject on subject.num = score.sbjectnum where subject.name = '국어';

