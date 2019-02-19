#--------------------------------------------
DROP TABLE IF EXISTS `user_base_info`;

create table user_base_info (
  uuid      varchar(32) not NULL,
  nickname  varchar(32) not NULL,
  gender    varchar(2),
  birthday  varchar(8),
  country   varchar(8),
  state     varchar(32),
  city      varchar(64),
  niversity varchar(128),
  signature varchar(512)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table user_base_info add primary key(uuid);

#--------------------------------------------
DROP TABLE IF EXISTS `user_info_attach`;

create table user_info_attach(
  uuid varchar(32) not null,
  registerData varchar(8) not null,
  password varchar(32) not null,
  pwdErrorTimes int,
  image varchar(128)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table user_info_attach add primary key(uuid);
alter table user_info_attach add constraint fk1 foreign key(uuid) REFERENCES user_base_info(uuid);


#--------------------------------------------
DROP TABLE IF EXISTS `user_contact_info`;

create table user_contact_info(
  uuid varchar(32) not null,
  category varchar(8) not null,
  numbers varchar(64) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table user_contact_info add primary key(uuid);
alter table user_contact_info add constraint fk2 foreign key(uuid) REFERENCES user_base_info(uuid);

#--------------------------------------------
DROP TABLE IF EXISTS `iweb_log_info`;

create table iweb_log_info(
  tranDate varchar(8) not null,
  reference varchar(32) not null,
  action varchar(32),
  code varchar(32),
  ipAddress varchar(64),
  time varchar(32),
  doClass varchar(128),
  retCode varchar(12),
  retMessage varchar(128),
  errorReason text,
  reqJson text,
  resJson text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;