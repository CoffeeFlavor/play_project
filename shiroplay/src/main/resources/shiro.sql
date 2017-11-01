drop database if exists shiro;
create database shiro;

create table users (
  id SERIAL,
  username varchar(100),
  password varchar(100),
  password_salt varchar(100),
  constraint pk_users primary key(id)
)WITHOUT OIDS ;
create unique index idx_users_username on users(username);

create table user_roles(
  id SERIAL,
  username varchar(100),
  role_name varchar(100),
  constraint pk_user_roles primary key(id)
) WITHOUT OIDS ;
create unique index idx_user_roles on user_roles(username, role_name);

create table roles_permissions(
  id SERIAL,
  role_name varchar(100),
  permission varchar(100),
  constraint pk_roles_permissions primary key(id)
) WITHOUT OIDS ;
create unique index idx_roles_permissions on roles_permissions(role_name, permission);

insert into users(username,password)values('zhang','123');