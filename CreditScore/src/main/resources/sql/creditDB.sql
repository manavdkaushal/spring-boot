create database credit;

use credit;

create table credit_card(
	ssn varchar(5) primary key,
    card_no bigint,
    cvv int,
    holder_name varchar(15)
);

create table credit_score(
	ssn varchar(5) primary key,
    score int
);

insert into credit_score values('10001', 750);
insert into credit_score values('10002', 800);
insert into credit_score values('10003', 650);
insert into credit_score values('10004', 500); 

------------------------------------------------

select * from credit_score;
select * from credit_card;
