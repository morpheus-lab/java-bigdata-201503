CREATE TABLE posts
(
  id       NUMBER(11),
  subject  VARCHAR2(255)    NOT NULL,
  writer   VARCHAR2(127)    NOT NULL,
  content  VARCHAR2(4000)   NOT NULL,
  wrtdtm   DATE             DEFAULT SYSDATE    NOT NULL,
  cnt      NUMBER(9)        DEFAULT 0          NOT NULL,
  CONSTRAINT PK_POSTS PRIMARY KEY (id)
);

CREATE TABLE attach
(
  id             NUMBER(11),
  post_id        NUMBER(11)     NOT NULL,
  original_name  VARCHAR2(255)  NOT NULL,
  saved_name     VARCHAR2(255)  NOT NULL,
  file_type      VARCHAR2(50),
  CONSTRAINT PK_ATTACH PRIMARY KEY (id),
  CONSTRAINT FK_ATTACH_POST_ID FOREIGN KEY(post_id) REFERENCES posts(id)
);

CREATE SEQUENCE seq_posts;
CREATE SEQUENCE seq_attach;