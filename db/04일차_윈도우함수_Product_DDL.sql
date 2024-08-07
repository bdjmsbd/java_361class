drop database if exists product;

create database if not exists product;

use product;

drop table if exists category;

create table if not exists category(
	ca_code char(2) primary key,
    ca_name varchar(10) not null
);

drop table if exists product;

create table if not exists product(
	pr_code char(3) primary key,
    pr_name varchar(10) not null,
    pr_price int not null default 0,
    pr_ca_code char(2), 
    foreign key(pr_ca_code) references category(ca_code)
);
insert into category values('ab','가전'), ('cd','의류'), ('ef','식품');

insert into product values
('ab1', '컴퓨터', 1200000,'ab'),
('ab2', '마우스', 17900,'ab'),
('cd1', '셔츠', 25000,'cd'),
('cd2', '청바지', 40000,'cd'),
('cd3', '양말', 1000,'cd'),
('ef1', '사과', 5000,'ef'),
('ef2', '복숭아', 5000,'ef'),
('ef3', '요아정', 10000,'ef');

# row_number() : 같이 값더라도 순위를 다르게 부여한다. 
select pr_name 제품, pr_code 코드, format(pr_price,0) 가격, row_number() over(order by pr_price asc) 순위 from product;

# rank() : 값이 같으면 순위가 같게, 다음 순위는 연속되지 않음
select pr_name 제품, pr_code 코드, format(pr_price,0) 가격, rank() over(order by pr_price asc) 순위 from product;
