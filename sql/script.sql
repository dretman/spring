DROP TABLE IF EXISTS spitter;

CREATE TABLE SPITTER
 (  ID int(10) NOT NULL AUTO_INCREMENT,
    userName varchar(255) NOT NULL ,
    password varchar(255) NOT NULL ,
    fullName varchar(255) NOT NULL ,
    email varchar(255) NOT NULL ,
    isUpdatedById boolean  NOT NULL ,
    PRIMARY KEY ("ID"));

INSERT INTO SPITTER (USERNAME, PASSWORD, FULLNAME, EMAIL, ISUPDATEDBYID)
VALUES ('denis', 'denis1987', 'Denis Retman', 'denisretman@gmail.com', false);

INSERT INTO SPITTER (USERNAME, PASSWORD, FULLNAME, EMAIL, ISUPDATEDBYID)
VALUES ('denis', 'denis1987', 'Denis Retman', 'denisretman@gmail.com', false);

INSERT INTO SPITTER (USERNAME, PASSWORD, FULLNAME, EMAIL, ISUPDATEDBYID)
VALUES ('denis', 'denis1987', 'Denis Retman', 'denisretman@gmail.com', false);

INSERT INTO SPITTER (USERNAME, PASSWORD, FULLNAME, EMAIL, ISUPDATEDBYID)
VALUES ('denis', 'denis1987', 'Denis Retman', 'denisretman@gmail.com', false);

