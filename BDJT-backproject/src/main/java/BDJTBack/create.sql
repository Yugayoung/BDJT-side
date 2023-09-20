-- 회원 테이블 생성
CREATE TABLE users (
    id VARCHAR2(15) PRIMARY KEY,
    name VARCHAR2(5) NOT NULL,
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
VALUES ('user1', 'John', 'password1', TO_DATE('1990-05-15', 'YYYY-MM-DD'), 'github@gmail.com');

INSERT INTO users (id, name, password, birthdate, github)
VALUES ('user2', 'Jane', 'p', TO_DATE('1985-09-22', 'YYYY-MM-DD'), 'https://github.com/user2');

INSERT INTO users (id, name, password, birthdate, github)
VALUES ('user3', 'Bob', 'password3', TO_DATE('1995-03-10', 'YYYY-MM-DD'), 'https://github.com/user3');

commit;

-- 보드 테이블 샘플
INSERT INTO board (photo, title, url, skill, creationdate, orderRcmnd, id)
VALUES ('photo1.jpg', 'Sample Post 1', 'https://example.com/post1', 'Java', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 5, 'user1');
    
INSERT INTO board (photo, title, url, skill, creationdate, orderRcmnd, id)
VALUES ('photo2.jpg', 'Sample Post 2', 'https://example.com/post2', 'Python', TO_DATE('2023-09-14', 'YYYY-MM-DD'), 3, 'user2');
    
INSERT INTO board (photo, title, url, skill, creationdate, orderRcmnd, id)
VALUES ('photo3.jpg', 'Sample Post 3', 'https://example.com/post3', 'JavaScript', TO_DATE('2023-09-13', 'YYYY-MM-DD'), 7, 'user3');

commit;

select * from users;