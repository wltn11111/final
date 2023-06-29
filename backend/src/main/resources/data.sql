INSERT INTO posts(title, contents, author, created_date, modified_date)
VALUES ('title1', 'contents1', 'author1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts(title, contents, author, created_date, modified_date)
VALUES ('title2', 'contents2', 'author2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts(title, contents, author, created_date, modified_date)
VALUES ('title3', 'contents3', 'author3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts(title, contents, author, created_date, modified_date)
VALUES ('title4', 'contents4', 'author4', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts(title, contents, author, created_date, modified_date)
VALUES ('title5', 'contents5', 'author5', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO comments(contents, author, post_id, created_date, modified_date)
VALUES ('contents1', 'author1', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO comments(contents, author, post_id, created_date, modified_date)
VALUES ('contents2', 'author2', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO comments(contents, author, post_id, created_date, modified_date)
VALUES ('contents3', 'author3', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO comments(contents, author, post_id, created_date, modified_date)
VALUES ('contents4', 'author4', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO comments(contents, author, post_id, created_date, modified_date)
VALUES ('contents5', 'author5', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);