
# 회원 상태를 추가 : 기간 정지, 영구 정지, 사용
insert into member_state values("기간 정지"), ("영구 정지"), ("사용");

# 신고 타입을 추가
insert into report_type values("욕설"),("허위사실유포"),("광고"),("음란"),("커뮤니티 비적합"),("기타");

# '공지' 커뮤니티를 등록
insert into community(co_name) values ("공지");

# 회원가입 id: abc123 pw: abc123 email: abc123@naver.com
# 회원가입 id: qwe123 pw: qwe123 email: qwe123@naver.com
# 회원가입 id: def123 pw: def123 email: def123@naver.com
# 회원가입 id: admin123 pw: admin123 email: admin123@naver.com

insert into member (me_id, me_pw, me_email ) values
( "abc123", "abc123", "abc123@naver.com"),
( "qwe123", "qwe123", "qwe123@naver.com"),
( "def123", "def123", "def123@naver.com");
insert into member (me_id, me_pw, me_email, me_authority ) values
( "admin123", "admin123", "admin123@naver.com", "admin");

# 관리자가 축구, 야구, 배구, 올림픽 커뮤니티를 추가했을 때 필요한 쿼리
insert into community(co_name) values ("축구"), ("야구"), ("배구"), ("올림픽"), ("양궁");
# SELECT row_number() over(order by co_key asc) co_key, co_name FROM community;



# abc 회원이 축구 커뮤니티에 게시글을 2개 작성
# abc 회원이 야구 커뮤니티에 게시글을 1개 작성
# abc 회원이 배구 커뮤니티에 게시글을 1개 작성
# abc 회원이 올림픽 커뮤니티에 게시글을 3개 작성
# qwe123 회원이 축구 커뮤니티에 글 2개 작성.
# qwe123 회원이 올림픽 커뮤니티에 글 1개 작성.

drop procedure if exists insert_post;

delimiter //
create procedure insert_post(
    in _po_title varchar(50) ,
    in _po_content longtext,
    in _po_me_id varchar(13) ,
    in _po_co_name varchar(50) 
)
begin
	declare _po_co_key int;
    set _po_co_key = (select co_key from community where co_name = _po_co_name);
    
    insert into post (po_title, po_content, po_me_id, po_co_key) values(_po_title, _po_content, _po_me_id, _po_co_key);
end //
delimiter ;

call insert_post("축구 제목1", "축구 내용1", "abc123","축구");
call insert_post("축구 제목2", "축구 내용2", "abc123","축구");
call insert_post("야구 제목1", "야구 내용1", "abc123","야구");
call insert_post("배구 제목1", "배구 내용1", "abc123","배구");
call insert_post("올림픽 1111", "올림픽 1111111111", "abc123","올림픽");
call insert_post("올림픽 2222", "올림픽 2222222222", "abc123","올림픽");
call insert_post("올림픽 3333", "올림픽 3333333333", "abc123","올림픽");

call insert_post("축구 제목11", "축구 내용111", "qwe123","축구");
call insert_post("축구 제목222", "축구 내용212321", "qwe123","축구");
call insert_post("올림픽 qwe123", "올림픽 qwe123", "qwe123","올림픽");

# qwe123 회원이 1번 게시글을 클릭해서 상세를 확인했을 때 쿼리 
update post set po_view = po_view + 1 where po_key = 1;

# 1번 게시글에 qwe123 회원이 추천을 눌렀을 때 쿼리9
insert into recommend (re_state, re_po_key, re_me_id) values (1 , 1, "qwe123")
ON DUPLICATE KEY UPDATE re_state = abs(re_state -1);

# 1번 게시글에 qwe123 회원이 추천을 눌렀을 때 쿼리
insert into recommend (re_state, re_po_key, re_me_id) values (1 , 1, "qwe123")
ON DUPLICATE KEY UPDATE re_state = abs(re_state -1);

# 재 추천시 테이블을 삭제
# delete from recommend where re_po_key =1 and re_me_id = "qwe123";

# qwe123 회원이 1,2,3 게시글은 추천을 4,5,6 게시글은 비추천을 누름.
insert into recommend (re_state, re_po_key, re_me_id) values (1 , 1, "qwe123")
ON DUPLICATE KEY UPDATE re_state = abs(re_state -1);
insert into recommend (re_state, re_po_key, re_me_id) values (1 , 2, "qwe123")
ON DUPLICATE KEY UPDATE re_state = abs(re_state -1);
insert into recommend (re_state, re_po_key, re_me_id) values (1 , 3, "qwe123")
ON DUPLICATE KEY UPDATE re_state = abs(re_state -1);
insert into recommend (re_state, re_po_key, re_me_id) values (-1 , 4, "qwe123")
ON DUPLICATE KEY UPDATE re_state = -abs(re_state +1);
insert into recommend (re_state, re_po_key, re_me_id) values (-1 , 5, "qwe123")
ON DUPLICATE KEY UPDATE re_state = -abs(re_state +1);
insert into recommend (re_state, re_po_key, re_me_id) values (-1 , 6, "qwe123")
ON DUPLICATE KEY UPDATE re_state = -abs(re_state +1);

# def123 회원이 3,4,5 게시글을 추천 7,8 게시글은 비추천을 누름.

insert into recommend (re_state, re_po_key, re_me_id) values (1 , 3, "def123")
ON DUPLICATE KEY UPDATE re_state = abs(re_state -1);
insert into recommend (re_state, re_po_key, re_me_id) values (1 , 4, "def123")
ON DUPLICATE KEY UPDATE re_state = abs(re_state -1);
insert into recommend (re_state, re_po_key, re_me_id) values (1 , 5, "def123")
ON DUPLICATE KEY UPDATE re_state = abs(re_state -1);
insert into recommend (re_state, re_po_key, re_me_id) values (-1 , 7, "def123")
ON DUPLICATE KEY UPDATE re_state = -abs(re_state +1);
insert into recommend (re_state, re_po_key, re_me_id) values (-1 , 8, "def123")
ON DUPLICATE KEY UPDATE re_state = -abs(re_state +1);

# abc123 회원 1,2,3 게시글을 추천
insert into recommend (re_state, re_po_key, re_me_id) values (1 , 1, "abc123")
ON DUPLICATE KEY UPDATE re_state = abs(re_state -1);
insert into recommend (re_state, re_po_key, re_me_id) values (1 , 2, "abc123")
ON DUPLICATE KEY UPDATE re_state = abs(re_state -1);
insert into recommend (re_state, re_po_key, re_me_id) values (1 , 3, "abc123")
ON DUPLICATE KEY UPDATE re_state = abs(re_state -1);

#  1 번 게시글에 각 회원 다음 순서로 댓글 작성
# abc123 : 작성자입니다. 
# - qwe123 : 반가워요.
# - def123 : 저도 반가워요.
# qwe123: 어떻게 활성화 시킬가요?
# def123 : 모르겠어요.
# abc123 : 노력해봐요.

insert into comment (cm_key, cm_content, cm_po_key, cm_me_id, cm_ori_key) 
select ifnull(max(cm_key),0)+1, "작성자입니다." , 1 , "abc123" , ifnull(max(cm_key),0)+1 from comment;
insert into comment (cm_key, cm_content, cm_po_key, cm_me_id, cm_ori_key) 
select count(*)+1, "반가워요." , 1 , "qwe123" , 1 from comment;
insert into comment (cm_key, cm_content, cm_po_key, cm_me_id, cm_ori_key) 
select count(*)+1, "저도 반가워요." , 1 , "def123" , 1 from comment;
insert into comment (cm_key, cm_content, cm_po_key, cm_me_id, cm_ori_key) 
select count(*)+1, "어떻게 활성화 시킬가요?" , 1 , "qwe123" , count(*)+1 from comment;
insert into comment (cm_key, cm_content, cm_po_key, cm_me_id, cm_ori_key) 
select count(*)+1, "모르겠어요." , 1 , "def123" , count(*)+1 from comment;
insert into comment (cm_key, cm_content, cm_po_key, cm_me_id, cm_ori_key) 
select count(*)+1, "노력해봐요." , 1 , "abc123" , count(*)+1 from comment;

# ifnull(max(cm_key),0)+1
# count(*)은 댓글이 삭제 될 경우 문제가 생기니, 위에 코드가 더 적절한 것 같다.

# 1번 게시글에서 6번 댓글을 기타 로 qwe123 회원이 신고함.
# 2번 게시글을 def123 회원이 기타 로 신고.
# table은 댓글인 지 게시물인 지 여부, target은 몇 번째 인 지.
insert into report (rp_me_id, rp_table, rp_target, rp_rt_name) values ( "qwe123", "comment", 6, "기타");
update comment set cm_report = cm_report + 1 where cm_key = 6;

insert into report (rp_me_id, rp_table, rp_target, rp_rt_name) values ( "def123", "post", 2, "기타");
update post set po_report = po_report + 1 where po_key = 2;

