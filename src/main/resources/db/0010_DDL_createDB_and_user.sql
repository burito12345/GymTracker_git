create database if not exists posting;

use posting;

drop user if exists 'posting-user'@'localhost';
create user 'posting-user'@'localhost' identified by 'geheim';

grant all privileges on posting.* to 'postingpostpost-user'@'localhost'
with grant option;


drop table if exists Post;

create table post(
  	id int not null auto_increment primary key,
    message varchar(1024) not null
) ENGINE = InnoDB;


