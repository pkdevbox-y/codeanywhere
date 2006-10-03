drop database ca;
create database ca;
use ca;

#table abstractfile
create table abstractfile (
	id int unique,
	path char(64) unique,			#path
	name char(24),					#filename
	primary key(id)
);

#table folder
create table folder (
	id int,
	parentfolder int,
	primary key(id),
	constraint folder_base_fk foreign key(id) references abstractfile(id) on delete cascade
	#constraint folder_parentfolder_fk foreign key(parentfolder) references folder(id) on delete cascade
);

#table file
create table file (
	id int,
	parentfolder int,
	primary key(id),
	constraint file_base_fk foreign key(id) references abstractfile(id) on delete cascade
	#constraint file_parentfolder_fk foreign key(parentfolder) references folder(id) on delete cascade
);
	
alter table folder add constraint folder_parentfolder_fk foreign key(parentfolder) references folder(id) on delete cascade;
alter table file add constraint file_parentfolder_fk foreign key(parentfolder) references folder(id) on delete cascade;

insert into abstractfile values (0, "/", NULL);
insert into folder values(0, NULL);