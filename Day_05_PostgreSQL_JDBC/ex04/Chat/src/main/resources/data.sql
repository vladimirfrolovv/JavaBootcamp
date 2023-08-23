INSERT INTO chat.users (login, password)
VALUES ('user1', 'pass1'),
       ('user2', 'pass2'),
       ('user3', 'pass3'),
       ('user4', 'pass4'),
       ('user5', 'pass5'),
       ('user6', 'pass6'),
       ('user7', 'pass7');

INSERT INTO chat.room (id, chat_name, chat_creator)
VALUES (1, 'Chatroom A', 1),
       (2, 'Chatroom B', 2),
       (3, 'Chatroom C', 3),
       (4, 'Chatroom D', 4),
       (5, 'Chatroom E', 5),
       (6, 'Chatroom F', 6),
       (7, 'Chatroom G', 7);
INSERT INTO chat.message (sender, room_id, text_message, time)
VALUES (1, 1, 'Hello from user 1 in Chatroom A', '2023-08-14 10:00:00'),
       (2, 1, 'Hi, user 1! This is user 2.', '2023-08-14 10:05:00'),
       (2, 2, 'Welcome to Chatroom B', '2023-08-14 11:00:00'),
       (3, 3, 'User 3 saying hello from Chatroom C', '2023-08-14 12:00:00'),
       (4, 1, 'Greeting from user 4 in Chatroom A', '2023-08-14 12:30:00'),
       (5, 2, 'User 5 checking in Chatroom B', '2023-08-14 13:00:00'),
       (6, 3, 'Chatroom C is awesome!', '2023-08-14 14:00:00');
