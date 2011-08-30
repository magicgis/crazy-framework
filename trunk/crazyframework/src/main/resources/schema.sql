-- ============ mybatis ============ 
-- drop table account;
create table account (
    userid varchar(80) not null,
    email varchar(80) not null,
    name varchar(80) not null,
    constraint pk_account primary key (userid)
);

INSERT INTO account VALUES('id1','beyondj2ee@gmail.com','justine');
INSERT INTO account VALUES('id2','beyondj2ee+mybatis@gmail.com','daniel');
commit;



