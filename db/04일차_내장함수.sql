# 문자열 함수
# 길이관련 함수

# length(문자열) : 문자열의 바이트 수를 반환
select length("안녕"); # 6바이트
select length("12"); # 2바이트

# char_length(문자열) : 문자열의 길이를 반환
select char_length("안녕"); # 2
select char_length("12"); # 2

# concat(문자열1, 문자열2, ... ) : 문자열을 이어붙여 하나의 문자열을 만듦
select concat("안녕","하","세요",'.');

# field(찾을 문자열, 문자열1, 문자열2, ... ) : 문자열 중에 찾을 문자열과 일치하는 문자열이 몇 번째에 있는 지 반환 
select field('안녕', '안녕하세요', '안녕', '호호안녕'); # 2

# instr(문자열1, 문자열2) : 문자열1에서 문자열2이 몇 번 째부터 시작하는 지 반환. 없으면 0
# locate(문자열1, 문자열2) : 문자열2에서 문자열1이 몇 번 째부터 시작하는 지 반환. 없으면 0

select instr("안녕하세요.", "하");
select locate("하", "안녕하세요");

# format(숫자, 소수점 자릿 수) : 숫자를 소수점 자리 수까지 표현, 3자리 마다 ','를 추가한다.
select format(1234567.890123, 2);

# bin(숫자), oct(숫자), hex(숫자) : 2, 8, 16 진수
select bin(31), oct(31), hex(31);

# lpad(문자열, 자리, 채울 문자열) : 문자열이 자리수 보다 작으면 문자열에 채울 문자열을 왼쪽에 추가하여 자릿 수를 맞춘다.
# rpad(문자열, 자리, 채울 문자열) : 문자열이 자리수 보다 작으면 문자열에 채울 문자열을 오른쪽에 추가하며 자릿 수를 맞춘다.
select lpad('asdfe', 10, 'er');
select rpad('asdfe', 10, 'er');

# rgb(255,20,3)을 16진수로 변경해서 #XXXXXX로 표현하는 쿼리
select concat('#', lpad(hex(255),2,0), lpad(hex(20),2,0), lpad(hex(3),2,0)) 'rgb(255,20,3)';

# insert(문자열, 위치, 길이, 대체문자열) : 문자열에서 위치부터 길이 만큼 문자열을 제거 한 후 대체 문자열을 추가
select insert('누구나 하는 C언어', instr('누구나 하는 C언어', 'c') , 3, 'Java');
# replace(문자열, 교체할 문자열, 대체할 문자열) 
select replace(@str, 'jpg', 'gif');
# upper(문자열): 대문자로, lower(문자열): 소문자로
select upper('hi'), lower('Good');
# reverse(문자열): 문자열을 역순으로
select reverse(@str);
# repeat(문자열, 횟수) : 횟수만큼 반복
select repeat(@str,3);

# 문자열 추출
# left(문자열, 숫자) : 문자열에서 왼쪽부터 숫자만큼 문자열을 반환
# right(문자열, 숫자) : 문자열을 오른쪽 부터 숫자만큼 문자열을 반환
set @str = "test.jpg";
select left(@str, 4), right(@str, 3);

# substring(문자열, 시작 위치, 길이) : 문자열에서 시작 위치부터 길이 만큼의 문자열을 반환
select substring(@str, 1,4), substring(@str, 6, 3);

# 시간 함수
# now(), sysdate(), current_timestamp
# current_timestamp는 속성의 타입이 datetime인 경우 기본 값으로 현재시간을 추가하록 설정
select now(), sysdate();

# addtime, subtime
select addtime(now(), '2:00:00'), subtime(now(), '2:00:00');

/*
# => current_timestamp test
drop table if exists test_ts;
create table if not exists test_ts (
	c_time datetime default current_timestamp
);
insert test_ts values();
*/

# year(시간) : 년 추출, month(시간) : 월 추출, day(시간) : 일 추출. 
select year(now()), month(now()), day(now());

# hour(시간), minute(시간), second(시간), microsecond(시간) : 시/분/초/밀리초 추출
select hour(now()), minute(now()), second(now()), microsecond(addtime(now(), '.123456789'));

# datediff(시간1, 시간2) : 시간1 - 시간2, 일로 반환
# timediff(시간1, 시간2) : 시간1- 시간2, 시/분/초로 반환 => 변수의 날짜 타입이 둘이 일치해야 한다. 
select datediff(now(), '2024-07-27 12:34:56.789');
select datediff(now(), (addtime(now(), '96:34:56.789')));
select timediff('15:09:00', '02:00.123');
select timediff(now(), '2024-07-24 10:00:00');

# interval
# 복합 시간 유형 : 여러 종류의 단위를 한번에 나타냄.
# year_month : 년 월
# day_hour : 일 시간
# day_minute : 일 시간:분
# day_microsecond : 일 시간:분:초.마이크로초
select date_add(now(), interval 1 month);
select date_add(now(), interval "1 1" year_month);
select date_add(now(), interval "1 10" day_hour);
select date_add(now(), interval "1 10:29" day_minute);

# 수학 함수
# floor(숫자) : 소수점 첫 번째 자리 내림.
# ceil(숫자) : 소수점 첫 번째 자리에서 올림. 
# round(숫자) : 소수점 첫 번째 자리에서 반올림.
# abs(숫자) : 절댓값

select floor(-1.23), ceil(-1.23), round(-1.49999999), abs(-1.23);


