CREATE TABLE users(
   username text not null ,
   password char(60) not null ,
   firstname text not null,
   lastname text,
   address text,
   phone text,
   mailid text not null,
   usertype INT not null ,
   PRIMARY KEY(mailid, username, phone )
);

insert into users values ('admin', 'admin', 'mayank', 'bhati', 'bhanvra', '8888', 'bhanvra@wair.com', 1);

CREATE TABLE books(
   name text not null ,
   barcode text not null ,
   author text not null,
   price text not null,
   quantity text not null ,
   PRIMARY KEY(name, barcode)
);