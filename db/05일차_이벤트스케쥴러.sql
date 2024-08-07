use product;

drop table if exists test;
create table if not exists test(
	num int primary key auto_increment,
    date datetime not null default current_timestamp    
);

drop event if exists insert_event;

create event if not exists insert_event
on schedule every 20 second
starts '2024-07-25 12:34:00'
do insert into test values ();


select * from test;
select * from information_schema.events;

# 이벤트 스케쥴러가 off 상태라면
show variables like 'event%';

set global event_scheduler = on; # on or off
