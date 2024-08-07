use shoppingmall;

# 제품 분류를 등록하는 쿼리
insert into category(ca_name) values('옷'),('모자'),('신발'),('악세서리'),('기타');


# 사용자 회원가입하는 쿼리
# id : abc123, pw : abc123, email : abc123@naver.com, 번호: 011-1234-5678
# id : qwe123, pw : qwe123, email : qwe123@naver.com, 번호: 011-1111-2222
insert into `member`(me_id, me_pw, me_email, me_phone, me_authority, me_fail) values 
('abc123', 'abc123', 'abc123@naver.com', '011-1234-5678', 'user', 0),
('qwe123', 'qwe123', 'qwe123@naver.com', '011-1111-2222', 'user', 0);

# 제품 등록하는 쿼리
# 분류 : 옷, 코드 : clo001, 상품명 : 시원한 티셔츠, 가격 : 20000, 내용 : 입으면 시원한 티셔츠
# 분류 : 옷, 코드 : clo002, 상품명 : 시원한 반바지, 가격 : 15000, 내용 : 여름전용 반바지
# 분류 : 옷, 코드 : clo003, 상품명 : 시원한 양말, 가격 : 20000, 내용 : 10개 묶음 시원한 의류 시리즈 마지막 용품
# 분류 : 모자, 코드 : cap001, 상품명 : 여름 모자, 가격 : 30000, 내용 : 그늘을 만들어줘요
# 분류 : 신발, 코드 : sho001, 상품명 : 싼 크록스, 가격 : 19000, 내용 : 인기 신발
# 분류 : 악세서리, 코드 : acc001, 상품명 : 금 목걸이, 가격 : 100000, 내용 : 부의 상징

insert into product(pr_code, pr_name, pr_detail, pr_price, pr_ca_key) values
("clo001", "시원한 티셔츠", "입으면 시원한 티셔츠", 20000, (select ca_key from category where ca_name = '옷')),
("clo002", "시원한 반바지", "여름전용 반바지", 15000, (select ca_key from category where ca_name = '옷')),
("clo003", "시원한 양말", "10개 묶음 시원한 의류 시리즈 마지막 용품", 20000, (select ca_key from category where ca_name = '옷')),
("cap001", "여름 모자", "그늘을 만들어줘요", 30000, (select ca_key from category where ca_name = '모자')),
("sho001", "싼 크록스", "인기 신발", 19000, (select ca_key from category where ca_name = '신발')),
("acc001", "금 목걸이", "부의 상징", 100000, (select ca_key from category where ca_name = '악세서리'));


## SELECT

# 분류별 등록된 제품 수를 조회하는 쿼리
select ca_name 분류, count(*) 수량 from product join category on ca_key = pr_ca_key group by pr_ca_key ;

select * from product right join category on ca_key = pr_ca_key;
select ca_name, count(pr_code) from product right join category on ca_key = pr_ca_key group by ca_key;


select count(ba_amount) + 3 from basket where ba_me_id = "abc123" and ba_pr_code = 1;


#abc회원이 clo001 제품을 장바구니에 3개 담았을 때 쿼리
# ba_me_id, ba_pr_code둘을 unique로 지정 해준다.
Insert into basket (ba_me_id, ba_pr_code, ba_amount) VALUES ('abc123', 'clo001', 3)
ON DUPLICATE KEY UPDATE ba_amount  = ba_amount + 3;

#abc회원이 clo001 제품을 장바구니에 2개 담았을 때 쿼리
#update basket set ba_amount = ba_amount + 2 where ba_me_id = "abc123" and ba_pr_code = "clo001";
Insert into basket (ba_me_id, ba_pr_code, ba_amount) VALUES ('abc123', 'clo001', 2)
ON DUPLICATE KEY UPDATE ba_amount  = ba_amount + 2;

# abc123회원이 ACC001 제품을 장바구니에 1개 담았을 때 쿼리 
Insert into basket (ba_me_id, ba_pr_code, ba_amount) VALUES ('abc123', 'ACC001', 1)
ON DUPLICATE KEY UPDATE ba_amount  = ba_amount + 1;

# abc123 회원이 장바구니에 있는 모든 제품을 구매했을 때 필요한 모든 쿼리 
insert into buy(bu_pr_Code, bu_me_id, bu_amount, bu_state, bu_Date)
values("clo001", "abc123", 5, '구매', now()),
("acc001", "Abc123", 1, "구매", now());

# 구매 했으므로 장바구니에서 항목을 제거해야 한다.
delete from basket where ba_pr_Code = "clo001" and ba_me_id = "abc123";
delete from basket where ba_pr_Code = "acc001" and ba_me_id = "abc123";

# abc123 회원이 id: abc123, pw: abc1234로 로그인 시도했을 때 실행해야 하는 쿼리
