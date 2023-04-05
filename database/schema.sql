create schema assessment; 

drop database if exists task; 

create database task; 

use task; 

create table user(
	id int not null auto_increment,
	user_id varchar(8),
    username varchar(15),
    name nvarchar(15),
    constraint id_pk primary key(id)
);

select * from user; 





