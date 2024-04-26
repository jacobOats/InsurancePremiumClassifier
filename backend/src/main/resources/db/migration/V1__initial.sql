CREATE TABLE if not exists organization (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50),
	address VARCHAR(100),
	PRIMARY KEY(id)
);

CREATE TABLE if not exists employee (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	manager_id INT,
	organization_id INT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(manager_id) REFERENCES employee(id),
	FOREIGN KEY(organization_id) REFERENCES organization(id)
);

CREATE TABLE if not exists client (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	address VARCHAR(100),
	employee_id INT,
	PRIMARY KEY (id),
	FOREIGN KEY(employee_id) REFERENCES employee(id)
);

CREATE TABLE if not exists vehicle (
	id int not null auto_increment,
	vin VARCHAR(100) NOT NULL,
	client_id INT NOT NULL,
	make VARCHAR(50),
	model VARCHAR(50),
	year INT,
	miles INT,
	plate VARCHAR(10),
	PRIMARY KEY(id),
	FOREIGN KEY(client_id) REFERENCES client(id)
);

CREATE TABLE if not exists payment (
	id INT NOT NULL AUTO_INCREMENT,
	client_id INT NOT NULL,
	amount DECIMAL(9, 2),
	due_date DATE,
	missed BOOLEAN DEFAULT FALSE,
	vehicle_id INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY(client_id) REFERENCES client(id),
	FOREIGN KEY(vehicle_id) REFERENCES vehicle(id)
);

CREATE TABLE if not exists claim (
	id INT NOT NULL AUTO_INCREMENT,
	claim_date DATE NOT NULL,
	client_id INT NOT NULL,
	vehicle_id INT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(client_id) REFERENCES client(id),
	FOREIGN KEY(vehicle_id) REFERENCES vehicle(id)
);