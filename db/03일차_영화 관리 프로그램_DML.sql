
# 사용자가 (아이디/비번) abc123/ abc123 회원 가입하는 쿼리
insert into member(me_id, me_pw, me_authority) values('abc123','abc123','user');

# 관리자가 admin1/admin1로 회원가입하는 쿼리
insert into member values('admin1', 'admin1', 'admin');

# 영화 정보 추가, (데드풀과 울버린)
# 1. 영화 추가 : 제목, 내용, 시간, 연령대, 개봉일
# 2. 국가를 등록 : 한국, 미국, 영국, 일본, 중국
# 3. 영화 참여 국가 등록 : 
# 4. 장르를 등록 : 액션, 코미디, 멜로, 공포, 스릴러
# 5. 추가할 영화의 장르 추가
# 6. 영화인을 등록: 출연 배우
# 7. 캐릭터를 등록: 배역 정보
# 8. 캐스팅 등록: 캐스팅 이름 등록, 감독은 감독으로 등록

insert into movie (mo_title, mo_content, mo_time, mo_age, mo_date) values('데드풀과 울버린', '히어로 생활에서 은퇴한 후, 평범한 중고차 딜러로 살아가던 ‘데드풀’이 예상치 못한 거대한 위기를 맞아 모든 면에서 상극인 ‘울버린’을 찾아가게 되며 펼쳐지는 도파민 폭발 액션 블록버스터', 127, '청소년 관람 불가', '2024-07-24');

insert into country values('한국'),('미국'),('영국'),('일본'),('중국');
insert into country values('캐나다'),('오스트레일리아'),('브라질');

insert into movie_country(mc_co_name, mc_mo_num) values(('미국'), (select mo_num from movie where mo_title = '데드풀과 울버린'));

insert into genre values('액션'),('코미디'),('멜로'),('공포'),('스릴러');

insert into movie_genre(mg_mo_num, mg_ge_name) values((select mo_num from movie where mo_title = '데드풀과 울버린'), (select ge_name from genre where ge_name = '액션'));
insert into movie_genre(mg_mo_num, mg_ge_name) values((select mo_num from movie where mo_title = '데드풀과 울버린'), '코미디');

insert into person (ps_name, ps_birth, ps_detail, ps_country) values
('숀 레비', '1968.07.23', '캐나다 출신의 영화 감독으로 코미디 영화를 주로 다루며, 드라마틱 요소와 코미디의 적절한 조합으로 좋은 반응을 이끌어낸다', '캐나다'),
('라이언 레이놀즈', '1976.10.23', '<엑스맨 탄생: 울버린> 등의 액션 블록버스터와 호러, 로맨틱 무비 등 다양한 장르의 작품들을 아우르며 실력과 인기를 동시에 쌓아가고 있는 라이언 레이놀즈', '오스트레일리아'),
('휴 잭맨', '1968.10.12', '호주 출신 배우인 휴 잭맨은 TV연속극 [이웃들]에 출연하면서 연기자로 데뷔식을 치렀다.', '캐나다'),
('엠마 코린', '1995.12.13', '영국의 배우', '영국'),
('모레나 바카린', '1979.06.02', '브라질 출신의 미국 여배우. 이국적인 미모로 꽤 인상깊다는 평을 받는다.', '브라질'),
('롭 딜레이니', '1977.01.19', '미국의 배우, 텔레비전 배우이다.', '미국');

insert into person (ps_name, ps_birth, ps_detail, ps_country) values
('카란 소니', '1985.01.08', '인도계 미국인 배우이자 코미디언.', '미국'),
('매튜 맥퍼딘', '1974.10.17', '영국의 배우. 2018년 이후 미국에서도 활동을 시작하였다.', '영국');


insert into `character`(ch_role, ch_ps_num) values
('감독', (select ps_num from person where ps_name = '숀 레비')),
('배우', (select ps_num from person where ps_name = '라이언 레이놀즈')),
('배우', (select ps_num from person where ps_name = '휴 잭맨')),
('배우', (select ps_num from person where ps_name = '엠마 코린')),
('배우', (select ps_num from person where ps_name = '모레나 바카린')),
('배우', (select ps_num from person where ps_name = '롭 딜레이니'));

insert into `character`(ch_role, ch_ps_num) values
('배우', (select ps_num from person where ps_name = '카란 소니')),
('배우', (select ps_num from person where ps_name = '매튜 맥퍼딘'));

insert into casting (ca_name, ca_ch_num, ca_mo_num) values 
('감독',(select ch_num from `character` where ch_ps_num = (select ps_num from person where ps_name  = '숀 레비')), (select mo_num from movie where mo_title  = '데드풀과 울버린')),
('데드풀',(select ch_num from `character` where ch_ps_num  =  (select ps_num from person where ps_name  = '라이언 레이놀즈')), (select mo_num from movie where mo_title  = '데드풀과 울버린')),
('로건',(select ch_num from `character` where ch_ps_num  = (select ps_num from person where ps_name  =  '휴 잭맨')), (select mo_num from movie where mo_title  = '데드풀과 울버린')),
('카산드라 노바',(select ch_num from `character` where ch_ps_num  =  (select ps_num from person where ps_name  = '엠마 코린')), (select mo_num from movie where mo_title  = '데드풀과 울버린')),
('바네사 칼라일',(select ch_num from `character` where ch_ps_num  =  (select ps_num from person where ps_name  = '모레나 바카린')), (select mo_num from movie where mo_title  = '데드풀과 울버린')),
('피터',(select ch_num from `character` where ch_ps_num  =  (select ps_num from person where ps_name  = '롭 딜레이니')), (select mo_num from movie where mo_title  = '데드풀과 울버린')),
('도핀더',(select ch_num from `character` where ch_ps_num  =  (select ps_num from person where ps_name  = '카란 소니')), (select mo_num from movie where mo_title  = '데드풀과 울버린')),
('패러독스',(select ch_num from `character` where ch_ps_num  =  (select ps_num from person where ps_name  = '매튜 맥퍼딘')), (select mo_num from movie where mo_title  = '데드풀과 울버린'));

# CGV강남 등록. 상영관 : 3, 좌석 30
# 영등포 cgv 등록. 상영관 : 4, 좌석 44
# 강남] a1~a3, b1~b3, c1~c4 | a1~a4, b1~b4, c1~c2 | a1~a2, b1~b2, c1~c2, d1~d2, e1~e2
# 영등포] a1~a3, b1~b3, c1~c4 | a1~a4, b1~b4, c1~c2  | a1~a3, b1~b3, c1~c3, d1~d3 | a1~a6, b1~b6

insert into theater(th_name, th_screen, th_seat, th_address, th_region) values
('CGV강남', 3, 30, '서울특별시 강남구 강남대로 438 스타플렉스 4F~8F', '서울'),
('CGV영등포', 4, 44, '서울특별시 영등포구 영중로 15 타임스퀘어 4F', '서울');

insert into screen(sc_name, sc_seat, sc_th_num) values 
('1관', 10, (select th_num from theater where th_name = 'CGV강남')),
('2관', 10, (select th_num from theater where th_name = 'CGV강남')),
('3관', 10, (select th_num from theater where th_name = 'CGV강남')),

('1관', 10, (select th_num from theater where th_name = 'CGV영등포')),
('2관', 10, (select th_num from theater where th_name = 'CGV영등포')),
('3관', 12, (select th_num from theater where th_name = 'CGV영등포')),
('4관', 12, (select th_num from theater where th_name = 'CGV영등포'));

insert into seat(se_name, se_sc_num) values
('A1', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('A2', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('A3', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('B1', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('B2', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('B3', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('C1', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('C2', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('C3', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('C4', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),

('A1', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('A2', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('A3', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('A4', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('B1', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('B2', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('B3', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('B4', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('C1', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('C2', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 

('A1', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('A2', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('B1', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('B2', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('C1', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('C2', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('D1', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('D2', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('E1', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))), 
('E2', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남')));

insert into seat(se_name, se_sc_num) values
('A1', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('A2', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('A3', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B1', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B2', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B3', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('C1', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('C2', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('C3', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('C4', (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),

('A1', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('A2', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('A3', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('A4', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B1', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B2', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B3', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B4', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('C1', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('C2', (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 

('A1', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('A2', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('A3', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B1', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B2', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B3', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('C1', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('C2', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('C3', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('D1', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('D2', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('D3', (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 

('A1', (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('A2', (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('A3', (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('A4', (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('A5', (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('A6', (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B1', (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B2', (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B3', (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B4', (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B5', (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))), 
('B6', (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포')));

# 스케쥴 등록
# 영화 상영 시간 등록. 
# cgv 강남 - 7/27
# 1관 10:00(조조), 12:35, 15:10, 17:45, 20:20
# 2관 10:30(조조), 15:00, 20:00, 23:00
# 3관 09:00(조조), 11:35, 14:10, 16:45, 19:20

# cgv 영등포 - 7/27
# 1관 08:00(조조), 10:40, 16:00, 18:40
# 2관 09:40(조조), 15:00, 23:00
# 3관 08:40(조조), 17:00
# 4관 16:00

#use cgv;


insert into schedule(sd_time, sd_date, sd_early, sd_mo_num, sd_sc_num) values
('10:00', '2024-07-27', 1, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('12:35', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('15:10', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('17:45', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('20:20', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),

('10:30', '2024-07-27', 1, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('15:30', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('20:00', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('23:00', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),

('09:00', '2024-07-27', 1, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('11:35', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('14:10', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('16:45', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),
('19:20', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV강남'))),

('08:00', '2024-07-27', 1, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('10:40', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('16:00', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('18:40', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '1관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),

('09:40', '2024-07-27', 1, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('15:00', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('23:00', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '2관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),

('08:40', '2024-07-27', 1, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'))),
('17:00', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '3관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포')));

set @tmp_mo_num = (select mo_num from movie where mo_title  = '데드풀과 울버린');
set @tmp_sc_num = (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포'));

insert into schedule(sd_time, sd_date, sd_early, sd_mo_num, sd_sc_num) values
('16:40', '2024-07-27', 0, (select mo_num from movie where mo_title  = '데드풀과 울버린'), (select sc_num from screen where sc_name = '4관' and sc_th_num = (select th_num from theater where th_name = 'CGV영등포')));

insert into schedule(sd_time, sd_date, sd_early, sd_mo_num, sd_sc_num) values
('20:40', '2024-07-27', 0, @tmp_mo_num, @tmp_sc_num);

# 데드풀과 울버린 영화의 CGV 강남에서 7/27dp 상영하는 시간표를 조회하는 쿼리
select sd_time from `schedule` where sd_mo_num = (select mo_num from movie where mo_title  = '데드풀과 울버린') and sd_sc_num in ((select sc_num from screen where sc_th_num = (select th_num from theater where th_name = 'CGV강남')));


SELECT 
    mo_title 영화, th_name 영화관, sc_name 상영관, sd_date 상영일, sd_time 시간 
FROM
    schedule
        JOIN
    screen ON sd_sc_num = sc_num
        JOIN
    theater ON sc_th_num = th_num
        JOIN
    movie ON sd_mo_num = mo_num
WHERE
    sd_Date = '2024-07-27'
        AND th_name = 'cgv강남'
        AND mo_title = '데드풀과 울버린';
        
SELECT 
    mo_title 영화, th_name 영화관, sc_name 상영관, sd_date 상영일, sd_time 시간 
FROM
    schedule, screen, theater, movie
WHERE
    sd_Date = '2024-07-27'
        AND th_name = 'cgv강남'
        AND mo_title = '데드풀과 울버린' 
        and sd_sc_num = sc_num 
        and sc_th_num = th_num 
        and sd_mo_num = mo_num;


# CGV강남 1관에 등록된 좌석을 조회하는 쿼리
SELECT * from seat join screen on se_sc_num = sc_num where sc_name='1관';
SELECT * from seat join screen on se_sc_num = sc_num join theater on th_num = sc_th_num where sc_name='1관' and th_name='cgv강남';
SELECT se_name 좌석명 from seat join screen on se_sc_num = sc_num join theater on th_num = sc_th_num where sc_name='1관' and th_name='cgv강남';

#요금 등록
insert into price(pr_type, pr_price) values('성인', 14000), ('청소년', 10000), ('조조 성인', 12000), ('조조 청소년', 8000);

# abc123 회원이 'cgv강남' '1관' '10:00'에 상영하는 데드풀3 성인 2장을 예매하는 쿼리 
# 좌석은 a1, a2
#@set tmp_ti_sd_num = (select );

set @tmp_sd_num = (
SELECT distinct
    sd_num
FROM
    schedule
        JOIN
    movie ON mo_num = sd_mo_num
        JOIN
    screen ON sd_sc_num = sc_num
        JOIN
    theater ON sc_th_num = th_num
WHERE
    mo_title = '데드풀과 울버린' AND sc_name = '1관'
        AND th_name = 'cgv강남'
        and sd_time = '10:00');
        
set @tmp_price = (
select pr_price*2
from price
where pr_type = '조조 성인');

insert into ticketing(ti_adult, ti_total, ti_me_id, ti_sd_num) values (2, @tmp_price * 2, 'abc123', @tmp_sd_num);

select * from ticketing;

insert into ticketing_list(tl_se_num, tl_ti_num) values ( 1 , 1); # a1, 1
insert into ticketing_list(tl_se_num, tl_ti_num) values ( 2 , 1); # a2, 2

select * from member where me_id = 'abc123';
SELECT 
    mo_title '영화', th_name '극장', sc_name '상영관', sd_time '시간', se_name '좌석 번호' 
FROM
    member
        JOIN
    ticketing ON ti_me_id = me_id
        JOIN
    ticketing_list ON tl_ti_num = ti_num
        JOIN
    `schedule` ON sd_num = ti_sd_num
        JOIN
    screen ON sc_num = sd_sc_num
        JOIN
    theater ON th_num = sc_th_num
        JOIN
    seat ON tl_se_num = se_num
        JOIN
    movie ON sd_mo_num = mo_num
WHERE
    me_id = 'abc123';

# 서브 쿼리를 이용
select * from schedule
	join screen on sd_sc_num = sc_num
    join theater on sc_th_num = th_num; 

use cgv;
select 
	mo_title 영화, th_name 영화관, sc_name 상영관, sd_date 상영일, sd_time 시간 
from schedule
	join 
    (select * from screen) sc #screen
    #screen 
    on sd_sc_num = sc_num
    join (select * from theater where th_name = 'cgv강남') th #theater
    on sc_th_num = th_num 
    join (select * from movie where mo_title = '데드풀과 울버린') mo #movie
    on mo_num = sd_mo_num
where
 sd_Date = '2024-07-27';

# 데드풀과 울버린 CGV 강남점 1관 7/27 10:00에 예약된 좌석을 조회하는 쿼리 
# 1번 스케쥴에 예약된 좌석을 조회하는 쿼리

# 내 답안
select se_name '예약된 좌석번호' from seat 
join (select * from ticketing_list) tl2 on tl_se_num = se_num
join (select * from ticketing where ti_sd_num =1) ti2 on  ti_num = tl_ti_num;

# 강사 답안
select se_name '예약된 좌석번호' 
from 
	(select * from ticketing where ti_sd_num = 1) t2 
join ticketing_list on ti_num = tl_ti_num 
join seat on tl_se_num = se_num;

# CGV강남점 1관의 좌석을 조회하는 쿼리
# 1번 상영관에 좌석들을 조회하는 쿼리
select * from seat where se_sc_num = 1;

# 데드풀과 울버린 CGV 강남점 1관 7/27 10:00에 예약 가능한 좌석을 조회하는 쿼리

SELECT 
    se_name '좌석 번호' 
FROM
    seat
WHERE
    se_sc_num = 1
        AND se_name NOT IN (SELECT 
            se_name
        FROM
            (SELECT 
                *
            FROM
                ticketing
            WHERE
                ti_sd_num = 1) t2
                JOIN
            ticketing_list ON ti_num = tl_ti_num
                JOIN
            seat ON tl_se_num = se_num);

# 1번 스케쥴에서 예약 가능한 좌석의 수
SELECT 
    COUNT(se_name) '빈 자리 갯수'
FROM
    seat
WHERE
    se_sc_num = 1
        AND se_name NOT IN (SELECT 
            se_name
        FROM
            (SELECT 
                *
            FROM
                ticketing
            WHERE
                ti_sd_num = 1) t2
                JOIN
            ticketing_list ON ti_num = tl_ti_num
                JOIN
            seat ON tl_se_num = se_num);
        
# 장르별로 등록된 영화의 갯수를 조회하는 쿼리

select ge_name, count(mg_num) 수 from movie_genre right join genre on ge_name = mg_ge_name group by ge_name; # group by mg_ge_name ;

# 개봉한 영화를 조회하는 쿼리 
set @tDay = date_sub(now(),interval 1 day);
set @tDay = now();
select * from movie where mo_date <= @tDay;

# 오늘부터 한 달 사이에 개봉한 영화를 조회하는 쿼리를 작성
select * from movie where (mo_date - @tDay) >= 30;
select * from movie where mo_date between @tDay and date_add(@tDay,interval 1 month);
# 오를부터 한 달 전 사이에 개봉한 영화
select * from movie where mo_date between date_sub(now(),interval 1 month) and now();








