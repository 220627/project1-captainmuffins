CREATE TABLE reimbursement (
	reimb_id serial PRIMARY KEY,
	
	reimb_amount int,
	reimb_submitted TEXT, 
	
	type_id_fk int REFERENCES TYPES (type_id),
	user_id_fk int REFERENCES users_info (user_id),
	status_id_fk int REFERENCES statuses (status_id)
	
);

INSERT INTO reimbursement (reimb_amount, reimb_submitted, type_id_fk, user_id_fk, status_id_fk)
VALUES (56.00, '8/1/2022', 3, 2, 1)


CREATE TABLE users_info (
	user_id serial PRIMARY KEY,

	first_name TEXT,
	last_name TEXT,

	
	role_id_fk int REFERENCES roles (role_id)
);

INSERT INTO users_info (first_name, last_name, role_id_fk)
VALUES ('Scott', 'Flowers', 1),
	('Ramona','Adams', 1),
	('Envy', 'Pilgrim', 2);



CREATE TABLE statuses (
	status_id serial PRIMARY KEY,
	
	status TEXT
);

INSERT INTO statuses (status)
VALUES ('PENDING'),('APPROVED'), ('DENIED');


CREATE TABLE types (
	type_id serial PRIMARY KEY,
	
	type TEXT
);

INSERT INTO TYPES (type)
VALUES ('LODGING'),('TRAVEL'),('FOOD'), ('OTHER');

CREATE TABLE roles (
	role_id serial PRIMARY KEY,
	
	ROLE_title text
);

INSERT INTO roles (role_title)
VALUES ('EMPLOYEE'), ('MANAGER');


CREATE TABLE users (
	user_ID serial PRIMARY KEY,
	username TEXT,
	PASSWORD TEXT
);

INSERT INTO users (username, password)
VALUES ('SFlowers', 'basshead1'), ('RAdams', 'hmrspce9000'),('EPilgrim', 'scottsux0');


SELECT * FROM reimbursement;
SELECT * FROM users;
SELECT * FROM statuses;
SELECT * FROM TYPES; 
SELECT * FROM roles;
SELECT * FROM users_info;

DELETE FROM roles;
DROP TABLE users_info;
DROP TABLE reimbursement;
DROP TABLE TYPES;
DROP TABLE users;
DROP TABLE statuses;
DROP TABLE roles;