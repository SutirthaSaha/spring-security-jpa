create table user(
	id int primary key auto_increment,
	active boolean,
    password varchar(255),
    roles varchar(255),
    user_name varchar(255)
);