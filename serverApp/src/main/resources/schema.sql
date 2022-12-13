DROP DATABASE IF EXISTS rubixBooksDb;

CREATE DATABASE rubixBooksDb;

USE rubixBooksDb;


CREATE TABLE role (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) DEFAULT NULL
);

CREATE TABLE customer (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    address1 VARCHAR(255) NOT NULL,
    address2 VARCHAR(255),
    city VARCHAR(255) NOT NULL,  
    state VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    taxIdentifier VARCHAR(255) NOT NULL,
    active BOOLEAN
);

ALTER TABLE customer ADD UNIQUE customer_unq_idx (country, taxIdentifier);

CREATE TABLE user (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	email VARCHAR(255) DEFAULT NULL unique,
	firstName VARCHAR(255) DEFAULT NULL,
	lastName VARCHAR(255) DEFAULT NULL,
	password VARCHAR(255) DEFAULT NULL,
	customer_id INT NOT NULL,
     active Boolean,
	CONSTRAINT user_customer_fk FOREIGN KEY(customer_id) REFERENCES customer(id)
);

CREATE TABLE user_role (
	user_id BIGINT NOT NULL references user(id),
	role_id BIGINT NOT NULL references role(id)
);



CREATE TABLE client (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    address1 VARCHAR(255) NOT NULL,
    address2 VARCHAR(255),
    city VARCHAR(255) NOT NULL,  
    state VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    taxIdentifier VARCHAR(255),
    active BOOLEAN
 ); 
 ALTER TABLE client ADD UNIQUE client_unq_idx (country, taxIdentifier);
 
 CREATE TABLE customer_client (
 	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 	customer_id INT NOT NULL REFERENCES customer(id),
 	client_id INT NOT NULL REFERENCES client(id) 
 );
 

 CREATE TABLE invoice (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	client_id INT NOT NULL,
	invoiceNumber VARCHAR(255) NOT NULL,
	invoiceDate DATE NOT NULL,
	amount DOUBLE NOT NULL,
	payByDate DATE NOT NULL,
	creditDays LONG NOT NULL,
	CONSTRAINT invoice_client_fk FOREIGN KEY(client_id) REFERENCES client(id)
);
	
CREATE TABLE invoiceItem(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	invoice_id INT NOT NULL,
	serialNo INT NOT NULL,
	item VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	unitPrice DOUBLE NOT NULL,
	quantity DOUBLE NOT NULL,
	lineTotal DOUBLE NOT NULL,
	CONSTRAINT invoiceitem_invoice_fk FOREIGN KEY(invoice_id) REFERENCES invoice(id)
);
 

CREATE TABLE supplier (
  	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	name varchar(256) NOT NULL,
  	address1 varchar(100) DEFAULT NULL,
 	address2 varchar(200) DEFAULT NULL,
  	city varchar(100) DEFAULT NULL,
 	district varchar(200) DEFAULT NULL,
 	state varchar(100) DEFAULT NULL,
 	country varchar(100) DEFAULT NULL,
  	zipcode varchar(20) DEFAULT NULL,
  	phone varchar(20) DEFAULT NULL,
  	email varchar(200) DEFAULT NULL,
  	taxIdentifier varchar(255) DEFAULT NULL
);

ALTER TABLE supplier ADD UNIQUE supplier_unq_idx (country, taxIdentifier);


  CREATE TABLE bill (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	supplier_id BIGINT NOT NULL,
	billNo VARCHAR(255) NOT NULL,
	billDate DATE NOT NULL,
	amount DOUBLE NOT NULL,
	payByDate DATE NOT NULL,
	creditDays LONG NOT NULL,
	CONSTRAINT bill_supplier_fk FOREIGN KEY(supplier_id) REFERENCES supplier(id)
);
	
CREATE TABLE billItem (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	bill_id INT NOT NULL,
	serialNo INT NOT NULL,
	item VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	unitPrice DOUBLE NOT NULL,
	quantity DOUBLE NOT NULL,
	lineTotal DOUBLE NOT NULL,
	CONSTRAINT billItem_bill_fk FOREIGN KEY(bill_id) REFERENCES bill(id)
);
	



 CREATE TABLE payment  (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	bill_id INT NOT NULL,
	paidDate DATETIME NOT NULL,
	amount DOUBLE NOT NULL,
	CONSTRAINT payment_bill_fk FOREIGN KEY(bill_id) REFERENCES bill(id)
);


 CREATE TABLE receipt  (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	invoice_id INT NOT NULL,
	paidDate DATETIME NOT NULL,
	amount DOUBLE NOT NULL,
	CONSTRAINT receipt_invoice_fk FOREIGN KEY(invoice_id) REFERENCES invoice(id)
);
	
	
insert into role (name) values ('ROLE_USER');
insert into role (name) values ('ROLE_ADMIN');
