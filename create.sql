create table authorities (user_id number(19,0) not null, role varchar2(255 char) not null check (role in ('ROLE_USER','ROLE_ADMIN','ROLE_ARAS')), primary key (user_id, role));
create table authorities (user_id number(19,0) not null, role varchar2(255 char) not null check (role in ('ROLE_USER','ROLE_ADMIN','ROLE_ARAS')), primary key (user_id, role));
