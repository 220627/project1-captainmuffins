CREATE TABLE reimbursement (
	reimb_id serial PRIMARY KEY,
	
	reimb_amount int,
	reimb_submitted timestamp, 
	
	user_id_fk int REFERENCES users (user_id),
	status_id_fk int REFERENCES statuses (status_id),
	type_id_fk int REFERENCES TYPES (type_id)

);

CREATE TABLE users (
	user_id serial PRIMARY KEY,
	
	username TEXT,
	PASSWORD TEXT,
	first_name TEXT,
	last_name TEXT,
	email TEXT,
	
	role_id_fk int REFERENCES roles (role_id)
);

INSERT INTO users (username, PASSWORD, first_name, last_name, email, role_id_fk)
VALUES ('SFlowers', 'basshead1', 'Scott', 'Flowers', 'sflowers@lootcrew.com', 3),
	('RAdams','hmrspce9000', 'Ramona','Adams', 'radams@lootcrew.com', 3),
	('EPilgrim', 'scottsux0', 'Envy', 'Pilgrim', 'epilgrim@lootcrew.com', 4);


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
	
	ROLE text
);

INSERT INTO roles (ROLE)
VALUES ('EMPLOYEE'), ('MANAGER');

SELECT * FROM reimbursement;
SELECT * FROM users;
SELECT * FROM statuses;
SELECT * FROM TYPES; 
SELECT * FROM roles;

DELETE FROM roles;
DELETE FROM users;
