INSERT INTO user_tb(username, password, email)
VALUES ('ssar', '1234', 'ssar@nate.com'),
       ('love', '1234', 'love@nate.com');

INSERT INTO category_tb (title, user_id, create_date)
VALUES ('Category 1', 1, NOW()),
       ('Category 2', 2, NOW());

INSERT INTO board_tb (title, content, thumnail, user_id, category_id)
VALUES ('Title 1', 'Content for board 1', 'thumbnail1.jpg', 1, 1),
       ('Title 2', 'Content for board 2', 'thumbnail2.jpg', 2, 1),
       ('Title 3', 'Content for board 3', 'thumbnail3.jpg', 1, 2),
       ('Title 4', 'Content for board 4', 'thumbnail4.jpg', 2, 2),
       ('Title 5', 'Content for board 5', 'thumbnail5.jpg', 1, 1),
       ('Title 6', 'Content for board 6', 'thumbnail6.jpg', 2, 1),
       ('Title 7', 'Content for board 7', 'thumbnail7.jpg', 1, 2),
       ('Title 8', 'Content for board 8', 'thumbnail8.jpg', 2, 2),
       ('Title 9', 'Content for board 9', 'thumbnail9.jpg', 1, 1),
       ('Title 10', 'Content for board 10', 'thumbnail10.jpg', 2, 1);