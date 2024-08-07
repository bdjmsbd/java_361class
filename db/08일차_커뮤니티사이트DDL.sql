drop database if exists community;

create database if not exists community;

use community;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(13) primary key	NOT NULL,
	`me_email`	varchar(30) unique not NULL,
	`me_pw`	varchar(15)	NULL not null,
	`me_authority`	varchar(5) default 'user' not NULL,
	`me_fail`	int default 0 not NULL,
	`me_cookie`	varchar(255)	NULL,
	`me_limit`	datetime	NULL,
	`me_ms_name` varchar(10)	 default "사용" NOT NULL,
	`me_report`	int	not NULL default 0,
	`me_stop`	datetime NULL
);

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
    `po_key` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `po_title` VARCHAR(50) NOT NULL,
    `po_content` LONGTEXT NOT NULL,
    `po_me_id` VARCHAR(13) NOT NULL,
    `po_co_key` INT NOT NULL,
    `po_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `po_report` INT NOT NULL DEFAULT 0,
    `po_view` INT NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`cm_key`	int primary key	NOT NULL,
	`cm_content`	varchar(200) not NULL,
	`cm_po_key`	int	NOT NULL,
	`cm_date`	datetime not NULL default current_Timestamp,
	`cm_me_id`	varchar(13)	NOT NULL,
	`cm_report`	int	not NULL default 0,
	`cm_ori_key`	int	NOT NULL,
	`cm_state`	int	not NULL default 0 # 0: 삭제 안됨, 1: 작성자가 삭제, 2: 관리자에 의해 삭제
);

DROP TABLE IF EXISTS `community`;

CREATE TABLE `community` (
	`co_key`	int primary key auto_increment	NOT NULL,
	`co_name`	varchar(50) unique not NULL
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_key`	int primary key auto_increment	NOT NULL,
	`fi_po_key`	int	NOT NULL,
	`fi_name`	varchar(255) not NULL,
    `fi_ori_name` varchar(255) not null
);

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
	`rp_key`	int primary key auto_increment	NOT NULL,
	`rp_me_id`	varchar(13)	NOT NULL,
	`rp_table`	varchar(10)	not NULL,
	`rp_target`	int	not NULL,
	`rp_rt_name`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `report_type`;

CREATE TABLE `report_type` (
	`rt_name`	varchar(15) primary key	NOT NULL
);

DROP TABLE IF EXISTS `member_state`;

CREATE TABLE `member_state` (
	`ms_name`	varchar(10) primary key	NOT NULL
);

DROP TABLE IF EXISTS `recommend`;

CREATE TABLE `recommend` (
    `re_key` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `re_state` INT NOT NULL,
    `re_po_key` INT NOT NULL,
    `re_me_id` VARCHAR(13) NOT NULL,
    unique(`re_po_key`, `re_me_id`)
);

ALTER TABLE `member` ADD CONSTRAINT `FK_member_state_TO_member_1` FOREIGN KEY (
	`me_ms_name`
)
REFERENCES `member_state` (
	`ms_name`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_member_TO_post_1` FOREIGN KEY (
	`po_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_community_TO_post_1` FOREIGN KEY (
	`po_co_key`
)
REFERENCES `community` (
	`co_key`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_post_TO_comment_1` FOREIGN KEY (
	`cm_po_key`
)
REFERENCES `post` (
	`po_key`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`cm_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_post_TO_file_1` FOREIGN KEY (
	`fi_po_key`
)
REFERENCES `post` (
	`po_key`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_member_TO_report_1` FOREIGN KEY (
	`rp_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_report_type_TO_report_1` FOREIGN KEY (
	`rp_rt_name`
)
REFERENCES `report_type` (
	`rt_name`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_post_TO_recommend_1` FOREIGN KEY (
	`re_po_key`
)
REFERENCES `post` (
	`po_key`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_member_TO_recommend_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);


