# insert
# 한 행(레코드)의 데이터를 추가할 때 사용
# 문법
# insert into 테이블명(속성1, ..., 속성n) value(값1, ..., 값n); -- 한 행 추가 
# insert into 테이블명(속성1, ..., 속성n) values(값1, ..., 값n), (값1, ..., 값n); -- 여러 행 추가
# insert into 테이블명 value(값1, ..., 값n); -- 속성 생략.

# 테이블명 호버해서 표 클릭하고 result grid에 직접 넣어주면 간편.
use student;

insert into student.student value(null, 1, 1, 1, "홍길동");
# insert into student.student value(null, 1, 1, 2, "고길동");

# auto_increment 부분의 속성을 빼면 value에 null 표시를 안해도 된다. 
insert into student.student(grade, class, num, name) values(1, 1, 3, "임꺽정");


# update
# 특정 행들의 값들을 변경할 때 사용
# update 테이블명 set 속성명1= 값1, ..., 속성명n = 값n where 조건
# = , !=, <> , is null, is not null
# and, or : and가 우선순위가 높음. 
# 날짜는 'yyyy-MM-dd hh:ss:mm' 형태라면 문자열 비교가 가능하다. [=, >=, <=, !=] 사용 가능.

update student set name ='또치' where student.studentNum = 2;

# 아래는 에러 발생 -> 수정/ 삭제는 where 조건이 기본키여야 한다. 콘솔은 가능, 워크벤치만 불가능
# preferences > sql editor에서 safe updates 해제 후 ok 껏다 키셈.
update student.student set name ='레렐' where student.grade =1 and student.class = 1 and student.num = 2;

# delete
# 조건에 만족하는 행들을 삭제할 때 사용, 조건을 생략하면 모든 데이터를 삭제함. 
# delete from 테이블명 where 조건;
delete from student where studentNum =4;

# 아래는 에러 발생 -> 수정/ 삭제는 where 조건이 기본키여야 한다. 콘솔은 가능, 워크벤치만 불가능
delete from student where grade = 1 and class =1 and num =3;
delete from student;

# truncate
# 초기화 옵션. [delete from 테이블명]과 다르게 auto_increment 숫자가 1부터 다시 시작됨. 

INSERT INTO `student`.`score` (`midTerm`, `finalTerm`, `performance`, `studentNum`, `sbjectNum`) VALUES ('100', '100', '100', '4', '1');
delete from score;

INSERT INTO `student`.`score` (`midTerm`, `finalTerm`, `performance`, `studentNum`, `sbjectNum`) VALUES ('100', '100', '100', '4', '1');
truncate score;
