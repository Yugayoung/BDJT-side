-- 회원 테이블 생성
CREATE TABLE users (
    id VARCHAR2(15) PRIMARY KEY,
    name VARCHAR2(10) NOT NULL,
    password VARCHAR2(15) NOT NULL,
    birthdate DATE,
    github VARCHAR2(30) 
);


CREATE TABLE board (
    photo VARCHAR2(50),
    title VARCHAR2(15),
    url VARCHAR2(100),
    skill VARCHAR2(20),
    creationdate DATE,
    id VARCHAR2(20),
    FOREIGN KEY (id) REFERENCES users(id)
);

-- 회원 테이블 샘플
INSERT INTO users (id, name, password, birthdate, github)
VALUES ('user1', 'John', 'password1', TO_DATE('1990-05-15', 'YYYY-MM-DD'), 'https://github.com/user1');

INSERT INTO users (id, name, password, birthdate, github)
VALUES ('user2', 'Jane', 'p', TO_DATE('1985-09-22', 'YYYY-MM-DD'), 'https://github.com/user2');

INSERT INTO users (id, name, password, birthdate, github)
VALUES ('user3', 'billie', 'password3', TO_DATE('1991-01-10', 'YYYY-MM-DD'), 'https://github.com/user3');

INSERT INTO users (id, name, password, birthdate, github)
VALUES ('user4', 'mycle', 'password3', TO_DATE('1993-03-10', 'YYYY-MM-DD'), 'https://github.com/user4');

INSERT INTO users (id, name, password, birthdate, github)
VALUES ('user5', 'Michael', 'password3', TO_DATE('1985-03-10', 'YYYY-MM-DD'), 'https://github.com/user5');

INSERT INTO users (id, name, password, birthdate, github)
VALUES ('user6', 'chris', 'password3', TO_DATE('2001-03-10', 'YYYY-MM-DD'), 'https://github.com/user6');
commit;

-- 보드 테이블 샘플
INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test1.jpg', 'Sample Post 1', 'https://www.naver.com/', 'html', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user1');
    
INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test2.jpg', 'Sample Post 2', 'https://www.naver.com/', 'css', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user1');
    
INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test3.jpg', 'Sample Post 3', 'https://www.naver.com/', 'css', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user2');
    
INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test4.jpg', 'Sample Post 4', 'https://www.naver.com/', 'html', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user4');
    
INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test5.jpg', 'Sample Post 5', 'https://www.naver.com/', 'react', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user4');
    
INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test6.jpg', 'Sample Post 6', 'https://www.naver.com/', 'html', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user6');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test7.jpg', 'Sample Post 7', 'https://www.naver.com/', 'react', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user5');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test8.jpg', 'Sample Post 8', 'https://www.naver.com/', 'react', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user1');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test9.jpg', 'Sample Post 9', 'https://www.naver.com/', 'html', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user2');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test10.jpg', 'Sample Post 10', 'https://www.naver.com/', 'html', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user1');
INSERT INTO board (photo, title, url, skill, creationdate, id)

VALUES ('/BDJT-backproject/upload/test11.jpg', 'Sample Post 11', 'https://www.naver.com/', 'css', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user6');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test12.jpg', 'Sample Post 12', 'https://www.naver.com/', 'css', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user3');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test13.jpg', 'Sample Post 13', 'https://www.naver.com/', 'html', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user1');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test14.jpg', 'Sample Post 14', 'https://www.naver.com/', 'react', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user5');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test15.jpg', 'Sample Post 15', 'https://www.naver.com/', 'react', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user4');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test16.jpg', 'Sample Post 16', 'https://www.naver.com/', 'html', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user3');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test17.jpg', 'Sample Post 17', 'https://www.naver.com/', 'react', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user1');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test18.jpg', 'Sample Post 18', 'https://www.naver.com/', 'css', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user1');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test19.jpg', 'Sample Post 19', 'https://www.naver.com/', 'css', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user1');

INSERT INTO board (photo, title, url, skill, creationdate, id)
VALUES ('/BDJT-backproject/upload/test20.jpg', 'Sample Post 20', 'https://www.naver.com/', 'react', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'user1');


commit;

select * from users;