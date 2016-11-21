CREATE TABLE message (
  ID           NUMBER(10)    NOT NULL,
  text  VARCHAR2(100)  NOT NULL);

ALTER TABLE message ADD (
  CONSTRAINT message_pk PRIMARY KEY (ID));

CREATE SEQUENCE message_seq START WITH 1;

CREATE OR REPLACE TRIGGER dept_bir 
BEFORE INSERT ON message 
FOR EACH ROW

BEGIN
  SELECT message_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;