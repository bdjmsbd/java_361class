# 데이터베이스 생성
# if not exists를 추가하는 이유?
# => 생성하려는 DB가 이미 있는 경우 건너뛰기 위해서
# => 안하고 쿼리를 실행 시 DB가 있을 경우 에러가 발생하고, 뒤에 쿼리가 실행되지 않음. 


# create database if not exists DB명
# create schema if not exists DB명
# SCHEMAS에서 빈공간 우클릭 CREATE SCHEMAS 클릭
create database if not exists world;
create database if not exists sakila;
create database if not exists student;

# 데이터베이스 삭제
# drop database if exists DB명; 
# SCHEMAS에서 삭제할 DATABASE 우클릭 DROP SCHEMAS 클릭하고 DROP now 클릭
# drop database if exists student;

# 데이터베이스 수정 - 이름은 수정이 안됨. 문자 집합을 수정 => 웬만하면 냅두자.
# Alter schema DB명 기본문자집함 바꿀문자집함 기본COLLATE 바꿀COLLATE;
# SCHEMAS에서 수정할 DATABASE 호버하고, 연장 모양 클릭하고 수정

/* 
# unique => not null + primary key
# 테이블 추가
# Tables 우클릭 careate table, 다다다다
create table if not exists 테이블명(
	컬럼명 타입 [zerofill] [unique] [not null | null] [default 기본값] [primary key] [auto_increment],
    컬럼명 타입 ...,
    제약조건, 
    constrain 제약조건명 primary key(컬럼명),
    # primary key(컬럼명),
    constrain 제약조건명 foreign key(컬럼명) references 참조테이블(기본키),
    # foreign key(컬럼명) references 참조테이블(기본키),
    constrain 제약조건명 check(논리식),
    # check(논리식)
);
*/
use student;


create table if not exists student(
	studentNum int primary key auto_increment,
    grade int not null,
    class int not null,
    num int not null,
    name varchar(20) not null,
    -- primary key(컬럼명) 키본키 위에서 설정해서 굳이 추가할 필요가 없다.
     check(grade >= 1 and grade <= 3),
     check(class >= 1),
     check(num >= 1),
     check(char_length(name) >= 2)
);
--  `student`.`subject` 경로 직접 지정을 통해 엉뚱하지 않은 곳에서 생성됨.
-- `` 백택은 컬럼명이 키워드와 동일할때 사용한다. 사용하지 않으면 키워드로 인식
CREATE TABLE if not exists `student`.`subject` (
  `num` int NOT NULL AUTO_INCREMENT,
  `grade` int NOT NULL DEFAULT '1',
  `semester` int NOT NULL DEFAULT '1',
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`num`)
);


CREATE TABLE if not exists `score2` (
  `num` int NOT NULL AUTO_INCREMENT,
  `midTerm` int NOT NULL DEFAULT '0',
  `finalTerm` int NOT NULL DEFAULT '0',
  `performance` int NOT NULL DEFAULT '0',
  `studentNum` int NOT NULL,
  `sbjectNum` int NOT NULL,
  PRIMARY KEY (`num`),
  FOREIGN KEY (`studentNum`) REFERENCES `student` (`studentNum`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`sbjectNum`) REFERENCES `subject` (`num`) ON DELETE CASCADE ON UPDATE CASCADE
);


#테이블 삭제
-- # drop table if exists `student`.`student`;
drop table if exists `score2`;

# 테이블 수정 - 컬럼 추가
# alter table 테이블명 add 컬럼명 타입 [zerofill] [unique] [not null | null] [default 기본값] [primary key] [auto_increment]
alter table student.score add test int not null;

# 테이블 수정 - 컬럼 수정
# alter table 테이블명 change 기존컬럼명 새컬럼명 타입 [zerofill] [unique] [not null | null] [default 기본값] [primary key] [auto_increment]
alter table student.score change test totalScore int not null default 0;

# 테이블 수정 - 컬럼 삭제
# alter table 테이블명 drop 컬럼명
alter table student.score drop totalScore;

# 테이블 수정 - 제약조건 추가 
# alter table 테이블명 add constraint 제약조건명 제약조건;
alter table student.score add constraint check(midTerm >= 0 and midTerm <= 100);
alter table student.score drop constraint score_chk_1;

 SHOW CREATE TABLE student.score;