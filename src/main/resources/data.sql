// Get item via serial number. Serial item table

INSERT INTO serial_item (
  item_id,
  csn,
  description,
  create_user_id,
  expire_user_id,
  expire_date,
  serial_item_id,
  serial_number,
) VALUES (
  (SELECT serial_item_seq.NEXTVAL
   FROM dual),
  'IPH10-256SG',
  'iPhone X 256GB Space Gray',
  1,
  1,
  SYSDATE + 1,
  2,
  1234567890
);

INSERT INTO serial_item (
  item_id,
  csn,
  description,
  create_user_id,
  expire_user_id,
  expire_date,
  serial_item_id,
  serial_number,
) VALUES (
  (SELECT serial_item_seq.NEXTVAL
   FROM dual),
  'IPH8-168RG',
  'iPhone 8 168GB Rose Gold',
  2,
  2,
  SYSDATE + 1,
  3,
  2345678901
);

INSERT INTO serial_item (
  item_id,
  csn,
  description,
  create_user_id,
  expire_user_id,
  expire_date,
  serial_item_id,
  serial_number,
) VALUES (
  (SELECT serial_item_seq.NEXTVAL
   FROM dual),
  'SAMN9-128LP',
  'Samsung Galaxy Note 9 128GB Lavender Purple',
  3,
  3,
  SYSDATE + 1,
  4,
  3456789012
);

INSERT INTO serial_item (
  item_id,
  csn,
  description,
  create_user_id,
  expire_user_id,
  expire_date,
  serial_item_id,
  serial_number,
) VALUES (
  (SELECT serial_item_seq.NEXTVAL
   FROM dual),
  'SAMS9-64B',
  'Samsung Galaxy S9+ 64GB Black',
  4,
  4,
  SYSDATE + 1,
  5,
  4567890123
);


// Get item. Item table

INSERT INTO item (
  item_id,
  csn,
  description,
  create_user_id,
  expire_user_id,
  expire_date,
  serial_item_id,
  serial_number,
) VALUES (
  (SELECT item_id_seq.NEXTVAL
   FROM dual),
  'IPH10-256SG',
  'iPhone X 256GB Space Gray',
  1,
  1,
  SYSDATE + 1,
  2,
  1234567890
);

INSERT INTO item (
  item_id,
  csn,
  description,
  create_user_id,
  expire_user_id,
  expire_date,
  serial_item_id,
  serial_number,
) VALUES (
  (SELECT item_id_seq.NEXTVAL
   FROM dual),
  'IPH8-168RG',
  'iPhone 8 168GB Rose Gold',
  2,
  2,
  SYSDATE + 1,
  3,
  2345678901
);

INSERT INTO item (
  item_id,
  csn,
  description,
  create_user_id,
  expire_user_id,
  expire_date,
  serial_item_id,
  serial_number,
) VALUES (
  (SELECT item_id_seq.NEXTVAL
   FROM dual),
  'SAMN9-128LP',
  'Samsung Galaxy Note 9 128GB Lavender Purple',
  3,
  3,
  SYSDATE + 1,
  4,
  3456789012
);

INSERT INTO item (
  item_id,
  csn,
  description,
  create_user_id,
  expire_user_id,
  expire_date,
  serial_item_id,
  serial_number,
) VALUES (
  (SELECT item_id_seq.NEXTVAL
   FROM dual),
  'SAMS9-64B',
  'Samsung Galaxy S9+ 64GB Black',
  4,
  4,
  SYSDATE + 1,
  5,
  4567890123
);