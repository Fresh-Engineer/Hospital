# 建立数据库
create database hospital;
# 使用该数据库
use hospital;
# 建立管理员账户表
create table if not exists admin
(
    `id`       int         not null auto_increment primary key,
    `username` varchar(20) not null,
    `password` varchar(20) not null,
    `created`  timestamp,
    `updated`  timestamp
) default charset = utf8;

# 建立患者信息表
DROP TABLE IF EXISTS patient;
create table if not exists patient
(
    `p_id`    int(4) auto_increment primary key,
    `p_name`  varchar(20),
    `sex`     varchar(4),
    `age`     varchar(20),
    `phone`   varchar(20),
    `created` timestamp
) default charset = utf8;

# 建立住院患者信息表
create table if not exists ipd
(
    `ward_id` int(4) auto_increment primary key,
    `p_name`  varchar(20),
    `bed_id`  nvarchar(5),
    `cost`    varchar(11),
    `indated` timestamp
) default charset = utf8;

# 建立药品信息表
drop table if exists hospital.m_medicine;
create table m_medicine
(
    m_id            int(4) primary key,
    m_name          varchar(20),
    m_type          varchar(20),
    m_brand         varchar(20),
    m_price         int(4),
    m_specification varchar(20)
) default charset = utf8;

insert into m_medicine
values ('1', '双氯芬酸钠滴眼液', '角膜炎', '迪非', '21', '5ml');
insert into m_medicine
values ('2', '盐酸氮卓斯汀片', '鼻炎', '云峰', '16.5', '2mg');
insert into m_medicine
values ('3', '复方金银花颗粒', '风热感冒', '双蚁', '27', '10g*10');
insert into m_medicine
values ('4', '板蓝根颗粒', '病毒性感冒', '白云山', '15', '10g*20');

# 建立库存信息表
drop table if exists hospital.m_stock;
create table m_stock
(
    m_sid     int(4) primary key,
    m_name    varchar(20),
    m_pdate   date,
    m_edate   date,
    m_snumber int(4),
    m_place   varchar(20)
) default charset = utf8;

insert into m_stock
values ('1', '双氯芬酸钠滴眼液', '2020-1-1', '2022-1-1', '100', 'A1');
insert into m_stock
values ('2', '盐酸氮卓斯汀片', '2020-1-1', '2022-1-1', '100', 'A2');
insert into m_stock
values ('3', '复方金银花颗粒', '2020-1-1', '2022-1-1', '100', 'A3');
insert into m_stock
values ('4', '板蓝根颗粒', '2020-1-1', '2022-1-1', '100', 'A4');

# 建立费用信息表
create table cost
(
    cost_id int(4) auto_increment primary key,
    p_name  varchar(20),
    sex     varchar(20),
    age     varchar(30),
    phone   varchar(11),
    cost    varchar(30),
    state   varchar(20),
    created timestamp
) default charset = utf8;

insert into cost
values (null, 'user01', '男', '20', '18290809594', '34.3', '已支付', now());
insert into cost
values (null, 'user02', '女', '15', '18290802222', '123.3', '已支付', now());

# 建立挂号信息表
create table regis
(
    datetime date,
    userName varchar(20),
    sex      varchar(20),
    IDcard   varchar(30) primary key,
    phone    varchar(11),
    created  timestamp,
    updated  timestamp
);

insert into regis
values ('2021-12-26', 'regis01', '男', '65313020000220292X', '18290809594', now(), now());
insert into regis
values ('2021-12-27', 'regis02', '男', '65313040040440444X', '18290809594', now(), now());


drop table if exists user,course,department;

# 手术安排表
CREATE TABLE IF NOT EXISTS `sc3`
(
    `sno`   char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `ssno`  char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `srade` date                                                NOT NULL
) default charset = utf8;

INSERT INTO `sc3`
VALUES ('2001', '1', '2021-06-16');
INSERT INTO `sc3`
VALUES ('2002', '2', '2021-06-27');
INSERT INTO `sc3`
VALUES ('2003', '4', '2021-06-06');
INSERT INTO `sc3`
VALUES ('2004', '2', '2021-06-18');
INSERT INTO `sc3`
VALUES ('2004', '3', '2021-06-15');
INSERT INTO `sc3`
VALUES ('2005', '1', '2021-06-21');


# 医生表
CREATE TABLE IF NOT EXISTS `course2`
(
    `cnoo`     char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `cname`    char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `cteacher` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `ccredit`  smallint(6)                                         NULL DEFAULT NULL,
    PRIMARY KEY (`cnoo`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;


INSERT INTO `course2`
VALUES ('1', '专家', '张三', 20);
INSERT INTO `course2`
VALUES ('2', '专家', '李四', 50);
INSERT INTO `course2`
VALUES ('3', '专家', '王五', 100);
INSERT INTO `course2`
VALUES ('4', '专家', '沈六', 200);
INSERT INTO `course2`
VALUES ('5', '专家', '朱七', 150);


# 科室表
CREATE TABLE IF NOT EXISTS `department3`
(
    `kno`   char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `kname` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) DEFAULT CHARSET = utf8;

INSERT INTO `department3`
VALUES ('001', '脑科');
INSERT INTO `department3`
VALUES ('002', '外科');
INSERT INTO `department3`
VALUES ('003', '内科');
INSERT INTO `department3`
VALUES ('004', '神经科');
INSERT INTO `department3`
VALUES ('005', '儿科');
INSERT INTO `department3`
VALUES ('006', '五官科');

# 建立患者反馈表
create table blog_father
(
    father_id    int(10)      not null auto_increment,
    user_name    varchar(20)  not null,
    blog_content varchar(100) not null,
    date         TIMESTAMP    not null default CURRENT_TIMESTAMP,
    primary key (father_id)
);