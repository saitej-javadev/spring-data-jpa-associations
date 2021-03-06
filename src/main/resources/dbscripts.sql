
-- for OneToMany

CREATE TABLE customer (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          NAME VARCHAR(20)
);

CREATE TABLE phone_number (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              customer_id INT,
                              number VARCHAR(20),
                              type VARCHAR(20),
                              FOREIGN KEY (customer_id)
                                  REFERENCES customer (id)
);


-- for ManyToMany

CREATE TABLE programmer (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            name VARCHAR(20),
                            salary INT
);

CREATE TABLE project (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(20)
);

CREATE TABLE programmers_projects (
                                      programmer_id INT,
                                      project_id INT,
                                      FOREIGN KEY (programmer_id)
                                          REFERENCES programmer (id),
                                      FOREIGN KEY (project_id)
                                          REFERENCES project (id)
);

-- for OneToOne


CREATE TABLE person (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        first_name VARCHAR(20),
                        last_name VARCHAR(20),
                        age INT
);

CREATE TABLE licence (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         type VARCHAR(20),
                         valid_from DATE,
                         valid_to DATE,
                         person_id INT,
                         FOREIGN KEY (person_id)
                             REFERENCES person (id)
);