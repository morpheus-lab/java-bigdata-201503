CREATE TABLE champ (
  no        NUMBER(11)                      NOT NULL,
  name      VARCHAR2(20)                    NOT NULL,
  type      VARCHAR2(255)                   NOT NULL,
  health    NUMBER(5)     DEFAULT 0         NOT NULL,
  damage    NUMBER(5)     DEFAULT 0         NOT NULL,
  regdate   DATE          DEFAULT SYSDATE   NOT NULL,
  CONSTRAINT PK_CHAMP         PRIMARY KEY (no),
  CONSTRAINT UK_CHAMP_NAME    UNIQUE (name)
);
