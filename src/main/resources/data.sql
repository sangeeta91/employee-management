DROP TABLE IF EXISTS employee;
 
CREATE TABLE employee (
  id INT NOT NULL,
  name VARCHAR(250) NOT NULL,
  age INT NOT NULL,
  gender VARCHAR(2) NOT NULL,
  PRIMARY KEY(id)
   
);

DROP TABLE IF EXISTS credentials;
 
CREATE TABLE credentials (
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  PRIMARY KEY(username)
   
);

