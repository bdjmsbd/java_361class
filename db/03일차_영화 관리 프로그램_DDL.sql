# https://www.erdcloud.com/ 
# 논리적 모델링을 완료하면 자동으로 sql문이 생성됨

drop database if exists cgv;

create database if not exists cgv;

use cgv;

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
    `ps_num` INT primary key AUTO_INCREMENT NOT NULL,
    `ps_name` VARCHAR(30) NOT NULL,
    `ps_birth` DATE NULL,
    `ps_detail` LONGTEXT NOT NULL,
    `ps_country` VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS `character`;

CREATE TABLE `character` (
    `ch_num` INT primary key AUTO_INCREMENT NOT NULL,
    `ch_role` CHAR(2) NOT NULL,
    `ch_pic` VARCHAR(255) NULL,
    `ch_ps_num` INT NOT NULL
);

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
    `mo_num` INT primary key AUTO_INCREMENT NOT NULL,
    `mo_title` VARCHAR(255) NOT NULL,
    `mo_content` LONGTEXT NOT NULL,
    `mo_time` INT NOT NULL,
    `mo_age` VARCHAR(20) NOT NULL, # 전체, 12세 이상, 15세 이상, 청소년 관람 불가, 제한 상영가
    `mo_date` DATE NOT NULL
);

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
    `ge_name` VARCHAR(20) primary key NOT NULL
);

DROP TABLE IF EXISTS `movie_genre`;

CREATE TABLE `movie_genre` (
    `mg_num` INT primary key AUTO_INCREMENT NOT NULL,
    `mg_mo_num` INT NOT NULL,
    `mg_ge_name` VARCHAR(20) NOT NULL
);

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
    `co_name` VARCHAR(20) primary key  NOT NULL
);

DROP TABLE IF EXISTS `movie_country`;

CREATE TABLE `movie_country` (
    `mc_num` INT primary key AUTO_INCREMENT NOT NULL,
    `mc_co_name` VARCHAR(20) NOT NULL,
    `mc_mo_num` INT NOT NULL
);

DROP TABLE IF EXISTS `casting`;

CREATE TABLE `casting` (
    `ca_num` INT primary key AUTO_INCREMENT NOT NULL,
    `ca_name` VARCHAR(20) NOT NULL,
    `ca_ch_num` INT NOT NULL,
    `ca_mo_num` INT NOT NULL
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
    `fi_num` INT primary key AUTO_INCREMENT NOT NULL,
    `fi_name` VARCHAR(255) NOT NULL,
    `fi_type` VARCHAR(10) NOT NULL, # 트레일러, 썸네일
    `fi_mo_num` INT NOT NULL
);

DROP TABLE IF EXISTS `theater`;

CREATE TABLE `theater` (
    `th_num` INT primary key AUTO_INCREMENT NOT NULL,
    `th_name` VARCHAR(30) NOT NULL,
    `th_screen` INT NOT NULL,
    `th_seat` INT NOT NULL,
    `th_address` VARCHAR(255) NOT NULL,
    `th_region` VARCHAR(10) NOT NULL
);

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
    `sd_num` INT primary key AUTO_INCREMENT NOT NULL,
    `sd_time` TIME NOT NULL,
    `sd_date` DATE NOT NULL,
    `sd_early` INT NOT NULL,
    `sd_mo_num` INT NOT NULL,
    `sd_sc_num` INT NOT NULL
);

DROP TABLE IF EXISTS `screen`;

CREATE TABLE `screen` (
    `sc_num` INT primary key AUTO_INCREMENT NOT NULL,
    `sc_name` VARCHAR(30) NOT NULL,
    `sc_seat` INT NOT NULL,
    `sc_th_num` INT NOT NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
    `se_num` INT primary key AUTO_INCREMENT NOT NULL,
    `se_name` VARCHAR(3) NOT NULL,
    `se_sc_num` INT NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
    `me_id` VARCHAR(15) primary key NOT NULL,
    `me_pw` VARCHAR(255) NOT NULL,
    `me_authority` VARCHAR(5) NOT NULL
);

DROP TABLE IF EXISTS `ticketing`;

CREATE TABLE `ticketing` (
    `ti_num` INT primary key AUTO_INCREMENT NOT NULL,
    `ti_adult` INT NOT NULL default 0,
    `ti_teen` INT NOT NULL default 0,
    `ti_total` INT NOT NULL,
    `ti_me_id` VARCHAR(15) NOT NULL,
    `ti_sd_num` INT NOT NULL
);

DROP TABLE IF EXISTS `ticketing_list`;

CREATE TABLE `ticketing_list` (
    `tl_num` INT primary key AUTO_INCREMENT NOT NULL,
    `tl_se_num` VARCHAR(3) NOT NULL,
    `tl_ti_num` INT NOT NULL
);

DROP TABLE IF EXISTS `price`;

CREATE TABLE `price` (
    `pr_num` INT primary key AUTO_INCREMENT NOT NULL,
    `pr_type` VARCHAR(10) NOT NULL,
    `pr_price` INT NOT NULL
);

ALTER TABLE `character` ADD CONSTRAINT `FK_person_TO_character_1` FOREIGN KEY (
	`ch_ps_num`
)
REFERENCES `person` (
	`ps_num`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_movie_TO_movie_genre_1` FOREIGN KEY (
	`mg_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_genre_TO_movie_genre_1` FOREIGN KEY (
	`mg_ge_name`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `movie_country` ADD CONSTRAINT `FK_country_TO_movie_country_1` FOREIGN KEY (
	`mc_co_name`
)
REFERENCES `country` (
	`co_name`
);

ALTER TABLE `movie_country` ADD CONSTRAINT `FK_movie_TO_movie_country_1` FOREIGN KEY (
	`mc_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `casting` ADD CONSTRAINT `FK_character_TO_casting_1` FOREIGN KEY (
	`ca_ch_num`
)
REFERENCES `character` (
	`ch_num`
);

ALTER TABLE `casting` ADD CONSTRAINT `FK_movie_TO_casting_1` FOREIGN KEY (
	`ca_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_movie_TO_file_1` FOREIGN KEY (
	`fi_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_movie_TO_schedule_1` FOREIGN KEY (
	`sd_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_screen_TO_schedule_1` FOREIGN KEY (
	`sd_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `screen` ADD CONSTRAINT `FK_theater_TO_screen_1` FOREIGN KEY (
	`sc_th_num`
)
REFERENCES `theater` (
	`th_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_screen_TO_seat_1` FOREIGN KEY (
	`se_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_member_TO_ticketing_1` FOREIGN KEY (
	`ti_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_schedule_TO_ticketing_1` FOREIGN KEY (
	`ti_sd_num`
)
REFERENCES `schedule` (
	`sd_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_ticketing_TO_ticketing_list_1` FOREIGN KEY (
	`tl_ti_num`
)
REFERENCES `ticketing` (
	`ti_num`
);


ALTER TABLE `cgv`.`schedule` 
ADD COLUMN `sd_possible` INT NOT NULL default 0 AFTER `sd_possible`;

