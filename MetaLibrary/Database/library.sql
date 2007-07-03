drop table if exists user;
#table user
create table user (
	id int unique,
	username char(16) unique,
	password char(16),
	email char(32),
	priviledge int default 0,
	primary key(id)
);

drop table if exists book;
#table book
create table book (
	id int unique,
	title varchar(128) not null,
	author varchar(128) not null,
	isbn char(18) not null,
	catalog varchar(64),
	description varchar(512),
	cover mediumblob,
	primary key(id)
);

drop table if exists borrow;
#table borrow
create table borrow (
	id int unique,
	userid int,
	bookid int,
	borrowdate timestamp,
	constraint user_fk foreign key(userid) references user(id) on delete cascade,
	constraint book_fk foreign key(bookid) references book(id) on delete cascade,
	primary key(id)
);

insert into user values(1, "admin", "1985", "bbiao@msn.com", 7);
insert into user values(2, "zz", "integer", "zz1985@gmail.com", 3);

insert into book values(1, "CSS Mastery", "Andy Budd", "7-115-15316-7", NULL, NULL, NULL);
insert into book values(2, "Tomcat Java Web", "Guo Jing", "7-5053-9392-8", NULL, NULL, NULL);
