# create user 'id'@'host' identified by 'pwd';
# host : 
#	localhost - only internal
#	% - usable external

#	cgv db 관리를 위한 cgv_admin 계정을 추가 (비번: 'admin123')
create user 'cgv_admin'@'%' identified by 'admin123';

# 계정 조회
select user, host from mysql.user;

# 계정 비번 변경
# set password for 'id'@'host' = 'new pwd';
set password for 'cgv_admin'@'%' = 'admin1234';

# 계정 삭제
# drop user 'id'@'host'

drop user 'cgv_admin'@'%';

# 권한 부여
# 사용자에게 DB에 대한 권한을 부여, 데이터 추가/수정/삭제 테이블 추가/수정/삭제 등. 
# select / insert / update / delete / create alter / drop / refernces/ all privileages => 모든 권한
# grant '권한' on db명.테이블명 to 'id'@'host'
# cgv_admin 계정에 cgv DB는 모든 권한을 부여, 다른 DB에는 저화만 구현

grant all privileges on cgv.* to 'cgv_admin'@'%';
grant select on product.* to 'cgv_admin'@'%';
grant select on student.* to 'cgv_admin'@'%';
grant select on university.* to 'cgv_admin'@'%';

# 권한 제거
# 사용자에게 부여했던 DB에 대한 권한을 제거
# revoke 권한 on db명.table명 from 'id'@'host';

# product db에 select 권한을 제거
revoke select on product.* from 'cgv_admin'@'%';

