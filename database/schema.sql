create schema assessment; 

drop database if exists task; 

create database task; 

use task; 

-- create table user(
-- 	id int not null auto_increment,
-- 	user_id varchar(8),
--     username varchar(15),
--     name nvarchar(15),
--     constraint id_pk primary key(id)
--     constraint user_id_pk primary key(user_id)
-- );



create table user(
	id int not null auto_increment,
	user_id varchar(8),
    username varchar(15),
    name nvarchar(15),
    constraint user_id_pk primary key(user_id),
    key (id)
);

-- create table user(
-- 	id int not null auto_increment,
-- 	user_id varchar(8),
--     username varchar(15),
--     name nvarchar(15),
--     constraint username_pk primary key(username),
--     key (id)
-- );

select * from user; 

/*TASK 5*/
create table task(
	task_id int not null auto_increment,
    description varchar(255), 
    priority int not null check (priority between 1 and 3),
    due_date date,
    user_id varchar(8),
    username varchar(15),
	primary key(task_id),
    constraint user_id_fk foreign key (user_id) references user(user_id)
);

-- create table task(
-- 	task_id int not null auto_increment,
--     description varchar(255), 
--     priority int not null check (priority between 1 and 3),
--     due_date date,
--     user_id varchar(15),
-- 	primary key(task_id),
--     constraint username_fk foreign key (username) references user(username)
-- );

drop table task; 
select * from task; 


insert into task(description, priority, due_date, username) values ("Buy milk", 2, "2023-03-28", "freddy");
