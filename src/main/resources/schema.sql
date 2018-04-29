create table Comment (
	comment_id integer not null auto_increment,
	username varchar(100) not null,
	text varchar(140) not null,
	insert_date date,
	PRIMARY KEY (comment_id)
);

INSERT INTO comment (username, text, insert_date) values ('mayuko', 'hello i am mayuko', now());
INSERT INTO comment (username, text, insert_date) values ('joma', 'wecome to the joma show', now());