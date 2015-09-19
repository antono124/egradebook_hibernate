CREATE TABLE student
(
  student_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
  username VARCHAR(400) NOT NULL,
  password VARCHAR(400) NOT NULL,
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE student_info
(
  student_id BIGINT NOT NULL PRIMARY KEY,
  first_name VARCHAR(400),
  last_name VARCHAR(400),
  semester VARCHAR(50),
  address VARCHAR(1000),
  city VARCHAR(400),
  country VARCHAR(400),
  phone_1 VARCHAR(100),
  phone_2 VARCHAR(100),
  FOREIGN KEY (student_id) REFERENCES student(student_id)
);

create table class
(
  class_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  description varchar(500),
  semester VARCHAR(50),
  UNIQUE (name)
);


create table student_class
(
  student_id BIGINT,
  class_id BIGINT,
  FOREIGN KEY (student_id) REFERENCES student(student_id),
  FOREIGN KEY (class_id) REFERENCES class(class_id)
);


CREATE TABLE results
(
  result_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  grade INT,
  student_id BIGINT,
  class_id BIGINT,
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (student_id) REFERENCES student(student_id),
  FOREIGN KEY (class_id) REFERENCES class(class_id)
);

