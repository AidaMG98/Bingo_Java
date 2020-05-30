drop database if exists bingo;
CREATE DATABASE if not exists bingo;
USE bingo;
drop table if exists bingo;
create table if not exists bingo
(id varchar(3),
 fecha date,
 nombre varchar(20),
 tipo int,
 bombo varchar(200),
 carton varchar(200),
 constraint pk_muebles primary key (id)
 );