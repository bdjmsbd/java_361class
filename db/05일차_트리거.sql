use cgv;

# 상영 시간에 예약 가능한 초기 좌석 수를 상영관 좌석수로 수정하는 쿼리
UPDATE schedule
        JOIN
    screen ON sc_num = sd_sc_num 
SET 
    sd_possible = sc_seat;

# 예약된 좌석만큼 상영 시간에서 예약 가능한 좌석 수를 빼서 수정하는 쿼리
UPDATE schedule
        JOIN
    ticketing ON sd_num = ti_sd_num 
SET 
    sd_possible = sd_possible - ti_teen - ti_adult;
    
# 1번 스케쥴에서 예매된 좌석 수만큼 1번 스케쥴의 좌석을 수정하는 트리거

# 트리거가 호출될 때 실행될 쿼리
UPDATE schedule 
SET 
    sd_possible = sd_pssoble - (SELECT 
            SUM(ti_adult + ti_teenager)
        FROM
            ticketing
        WHERE
            ti_sd_num = sd_num)
WHERE
    sd_num = 1;
    
# 트리거 : 프로시저 호출 개념이 아니라서 실제 쿼리를 넣어줘야 한다.
drop trigger if exists ticketing_insert;
delimiter //
create trigger ticketing_insert
after insert on ticketing
for each row
begin
	UPDATE 
		schedule 
	SET 
		sd_possible = sd_possible - (new.ti_adult + new.ti_teen)
	WHERE
		sd_num = new.ti_sd_num;
end //
delimiter ;

insert into ticketing values(null, 2, 3, 58000, 'abc123', 2);
insert into ticketing_list values(null, 1,2), (null, 2,2), (null, 3,2), (null, 4,2), (null, 5,2);

show triggers;