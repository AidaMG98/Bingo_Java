drop database if exists bingo;
CREATE DATABASE if not exists bingo;
USE bingo;
drop table if exists bingo;
create table if not exists bingo
(id varchar(10),
 fecha date,
 nombre varchar(20),
tipo int,
bombo varchar(300),
carton varchar(300),
 constraint pk_muebles primary key (id)
 );
 
 select * from bingo;
 