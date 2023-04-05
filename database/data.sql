use task; 

insert into user(user_id, username, name) values
	("1b80114c","fred","Fred"),
    ("cf66dae3","wilma","Wilma"),
    ("a8b9800d","barney","Barney"),
    ("66223e28","betty","Betty");
    
select * from user; 

select * from user where username = "fred"; 

insert into user(user_id, username, name) values ("1b80118g","freddy","Freddy");