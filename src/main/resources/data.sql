INSERT INTO item (
  item_id,
  csn,
  description,
  create_user_id
) VALUES (
  (SELECT item_id_seq.NEXTVAL
   FROM dual),
  'IPH10-256SG',
  'iPhone X 256GB Space Gray',
  1
);