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