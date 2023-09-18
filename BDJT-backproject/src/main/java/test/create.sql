-- 회원 테이블 생성
CREATE TABLE users (
    id VARCHAR2(20) PRIMARY KEY,
    name VARCHAR2(5),
    password VARCHAR2(20),
    birthdate DATE,
    github VARCHAR2(30)
);

-- 게시판 테이블 생성
CREATE TABLE board (
    photo VARCHAR2(255),
    title VARCHAR2(15),
    url VARCHAR2(255),
    skill VARCHAR2(20),
    creationDate DATE,
    orderRcmnd NUMBER,
    id VARCHAR2(20),
    FOREIGN KEY (id) REFERENCES 회원(id)
);

-- 회원 테이블 샘플
INSERT INTO users (id, name, password, birthdate, github)
VALUES ('user1', 'John', 'password1', TO_DATE('1990-05-15', 'YYYY-MM-DD'), 'https://github.com/user1');

INSERT INTO users (id, name, password, birthdate, github)
VALUES ('user2', 'Jane', 'password2', TO_DATE('1985-09-22', 'YYYY-MM-DD'), 'https://github.com/user2');

INSERT INTO users (id, name, password, birthdate, github)
VALUES ('user3', 'Bob', 'password3', TO_DATE('1995-03-10', 'YYYY-MM-DD'), 'https://github.com/user3');

commit;

-- 보드 테이블 샘플
INSERT INTO board (photo, title, url, skill, creationDate, orderRcmnd, id)
VALUES ('photo1.jpg', 'Sample Post 1', 'https://example.com/post1', 'Java', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 5, 'user1');
    
INSERT INTO board (photo, title, url, skill, creationDate, orderRcmnd, id)
VALUES ('photo2.jpg', 'Sample Post 2', 'https://example.com/post2', 'Python', TO_DATE('2023-09-14', 'YYYY-MM-DD'), 3, 'user2');
    
INSERT INTO board (photo, title, url, skill, creationDate, orderRcmnd, id)
VALUES ('photo3.jpg', 'Sample Post 3', 'https://example.com/post3', 'JavaScript', TO_DATE('2023-09-13', 'YYYY-MM-DD'), 7, 'user3');

commit;

-- 조
select * from users u , board b where u.id = b.id; 

select * from users;