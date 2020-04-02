create table tbl_member(
	email varchar(50) not null primary key,
	nickname varchar(50) not null,
	pwd varchar(100) not null,
	grade tinyint(2) default 0
) default charset=utf8;

create table tbl_product(
	pno bigint(20) not null auto_increment,
	category varchar(2) default null,
	pname varchar(100) not null,
	content varchar(2000) default null,
	pwriter varchar(200) not null,
	readcount int(11) default 0,
	regd8 timestamp not null default current_timestamp on update current_timestamp,
	modd8 timestamp not null default current_timestamp on update current_timestamp,
	imgfile varchar(2000) default null,
	primary key(pno)
) default charset=utf8;
