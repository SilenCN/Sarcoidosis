create database Sarcoidosis;

create table User(id INTEGER primary key auto_increment,username VARCHAR(100) NOT NULL,password VARCHAR(100) NOT NULL ,createTime BIGINT default 0,nickname VARCHAR(100),enabled BOOLEAN default true );

insert into User(username, password, createtime, nickname, enabled) values ('admin','admin',0,'超级管理员',true);