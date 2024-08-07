
use university;

# 학과 코드, 이르므, 전공이 주어졌을 때 신입생을 등록하는 프로시저
drop procedure if exists insert_freshman;

delimiter //
create procedure insert_freshman(
	in _major_code char(3),
	in _major varchar(15),
    in _name varchar(30)
)
begin
	declare _year int;
    declare _num varchar(3);
    declare _st_num char(10);
	# 학번을 생성
    # 년도 + 학과코드 + 순서
    # 프로시저가 실행될 때 연도를 가져 옴. 
    set _year = (select year(now()));
    set _num = lpad((select count(*)+1 from student where st_major = _major),3,'0');
    set _st_num = concat(_year, _major_code, _num);
    insert into student values(_st_num, _name, _major, 1);
end //
delimiter ;

call insert_freshman('160' , '컴퓨터공학' , '논개');
select * from student;

# 학번, 강의번호, 중간, 기말, 과제, 출석이 주어지면 학점을 계산해서 출력하는 프로시저를 생성.

drop procedure if exists update_score;
delimiter //

create procedure update_score(
	in _co_st_num int,
	in _co_le_num int,
    in _co_midterm int,
    in _co_finalterm int,
    in _co_performance int,
    in _co_attendance int
)

begin
	declare _co_grade varchar(2);
    declare _num int;
	# 중간 0.4 기말 0.4 과제 0.1 출석 0.1
    # 95점이상 A+, 90점 A, 85점 B+, 80 B, 75 C+, C 70 , 65 D+, 60 D, 미만F
    set _num = ((0.4 *_co_midterm) + (0.4 * _co_finalterm) + (0.1 * _co_performance) + (0.1 * _co_attendance));
    if _num >= 95 then set _co_grade = 'A+';
	elseif _num >= 90 then set _co_grade = 'A';
	elseif _num >= 85 then set _co_grade = 'B+';
	elseif _num >= 80 then set _co_grade = 'B';
	elseif _num >= 75 then set _co_grade = 'C+';
	elseif _num >= 70 then set _co_grade = 'C';
	elseif _num >= 65 then set _co_grade = 'D+';
	elseif _num >= 60 then set _co_grade = 'D';
	else set _co_grade = 'F';
	end if;
    #select _num, _co_grade;
    UPDATE course 
	SET 
		co_midterm = _co_midterm,
		co_finalterm = _co_finalterm,
		co_performance = _co_performance,
		co_attendance = _co_attendance,
    
		co_grade = _co_grade
	WHERE
		co_st_num = _co_st_num AND co_le_num = _co_le_num;
end //
delimiter ;

call update_score(2024160005 ,1, 90, 80, 70, 60);
call update_score(2024160005 ,2, 100, 80, 70, 100);

show procedure status;

show create procedure insert_freshman;


# 프로시저 생성 
# 예매자 아이디, 예매 상영 시간번호, 성인수, 청소년수가 주어지면 티켓을 예매하는 프로시저를 생성하고 테스트 
# 해당 프로시저가 실행되면 '05일차_트리거'에서 생성한 트리거가 실행된다.
drop procedure if exists book_ticketing;
delimiter //

create procedure book_ticketing(
	# in _co_st_num int,
    in _me_id varchar(15),
    in _sd_num int,
    in _adult int,
    in _teen int
)

begin
	# declare _co_grade varchar(2);
    declare _total int;
    declare _sd_early int;
    declare _pr_type varchar(10);
    
    set _sd_early = (select sd_early from schedule where sd_num = _sd_num);
    
    if _sd_early = 1 then set _pr_type = '조조 ';
    else set _pr_type = '';
    end if;
    
    set _total = _adult * (select pr_price from price where pr_type = concat(_pr_type, '성인')) 
				+ _teen * (select pr_price from price where pr_type = concat(_pr_type, '청소년'));
    
--     if _sd_early = 1 then set _total = 12000 * _adult + 8000 * _teen;
--     else set _total = 14000 * _adult + 10000 * _teen;
--     end if;
    
    insert into ticketing values (null , _adult, _teen, _total, _me_id, _sd_num);
end //
delimiter ;

call book_ticketing('abc123','1',1,0);

show triggers;

