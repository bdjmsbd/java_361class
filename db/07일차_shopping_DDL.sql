drop database if exists `Shoppingmall`;

create database if not exists `Shoppingmall`;

use Shoppingmall;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(13)	not NULL,
	`me_pw`	varchar(20)	not NULL,
	`me_email`	varchar(50)	not NULL,
	`me_phone`	varchar(15)	not NULL,
	`me_authority`	varchar(5)	not NULL,
    `me_fail` int not null
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`ca_key`	int	primary key auto_increment NOT NULL ,
	`ca_name`	varchar(10) unique NOT NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`pr_code`	varchar(10)	NOT NULL,
	`pr_name`	varchar(10)	not NULL,
	`pr_detail`	varchar(255)	not NULL,
	`pr_price`	int	not NULL,
	`pr_ca_key`	int	NOT NULL
);

DROP TABLE IF EXISTS `basket`;

CREATE TABLE `basket` (
	`ba_key`	int	NOT NULL primary key auto_increment,
	`ba_me_id`	varchar(13)	not NULL,
	`ba_pr_code`	varchar(10)	NOT NULL,
	`ba_amount`	int	NULL,
    
     UNIQUE KEY(ba_me_id,ba_pr_code)
);

DROP TABLE IF EXISTS `product_image`;

CREATE TABLE `product_image` (
	`pi_key`	int	NOT NULL,
	`pi_name`	varchar(150) NULL,
	`pi_pr_code`	varchar(10)	NOT NULL
);

DROP TABLE IF EXISTS `code`;

CREATE TABLE `code` (
	`co_me_id`	varchar(13)	NULL,
	`co_code`	char(6)	NOT NULL,
	`co_limit`	datetime	NULL
);

DROP TABLE IF EXISTS `buy`;

CREATE TABLE `buy` (
	`bu_key`	int	primary key auto_increment NOT NULL,
	`bu_pr_code`	varchar(10)	NOT NULL,
	`bu_me_id`	varchar(13)	NULL,
	`bu_state`	varchar(15)	NOT NULL,
	`bu_amount`	int	NULL,
	`bu_date`	date	NULL
);


ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
	`pr_code`
);

ALTER TABLE `product_image` ADD CONSTRAINT `PK_PRODUCT_IMAGE` PRIMARY KEY (
	`pi_key`
);

ALTER TABLE `code` ADD CONSTRAINT `PK_CODE` PRIMARY KEY (
	`co_me_id`
);

ALTER TABLE `product` ADD CONSTRAINT `FK_category_TO_product_1` FOREIGN KEY (
	`pr_ca_key`
)
REFERENCES `category` (
	`ca_key`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_member_TO_basket_1` FOREIGN KEY (
	`ba_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_product_TO_basket_1` FOREIGN KEY (
	`ba_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `product_image` ADD CONSTRAINT `FK_product_TO_product_image_1` FOREIGN KEY (
	`pi_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `code` ADD CONSTRAINT `FK_member_TO_code_1` FOREIGN KEY (
	`co_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `buy` ADD CONSTRAINT `FK_product_TO_buy_1` FOREIGN KEY (
	`bu_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `buy` ADD CONSTRAINT `FK_member_TO_buy_1` FOREIGN KEY (
	`bu_me_id`
)
REFERENCES `member` (
	`me_id`
);

