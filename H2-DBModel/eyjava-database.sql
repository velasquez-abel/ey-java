drop table if exists users; 

create table if not exists users(
user_id varchar(64) not null primary key,
full_name varchar(128) not null,
email varchar(128) not null unique,
password varchar(128) not null,
created_at datetime not null,
modified_at datetime not null,
last_login datetime null ,
uuid_token varchar(64) not null,
is_active boolean not null default true
);

drop table if exists phones;

create table if not exists phones(
phone_id varchar(64) not null primary key,
number varchar(16) not null,
city_code varchar(4) not null,
country_code varchar(4) not null,
user_id varchar(64) not  null,
foreign key(user_id) references users(user_id)
);
