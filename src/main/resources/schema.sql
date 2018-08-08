CREATE SEQUENCE item_id_seq;

CREATE TABLE item (
  item_id INTEGER(50) NOT NULL PRIMARY KEY,
  csn VARCHAR(50) NOT NULL,
  description VARCHAR(255) NOT NULL,
  create_user_id INTEGER(50) NOT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  expire_user_id INTEGER(50),
  expire_date TIMESTAMP
);