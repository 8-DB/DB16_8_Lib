CREATE TABLE 회원 (
	#회원번호 자동으로 1부터 증가하도록 설정
	회원번호 INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	이름 CHAR(20) CHAR SET utf8,
	주소 VARCHAR(100) CHAR SET utf8,
    #마일리지 처음 디폴트값 0
	마일리지 INT NOT NULL DEFAULT 0,
	핸드폰번호 CHAR(20));
    
CREATE TABLE 도서분류 (
	분류기호 INT PRIMARY KEY,
	분류명 CHAR(20) CHAR SET utf8);

CREATE TABLE 도서 (
	ISBN CHAR(13) PRIMARY KEY,
	도서이름 CHAR(20) CHAR SET utf8,
	출판사 CHAR(20) CHAR SET utf8,
	지은이 CHAR(20) CHAR SET utf8,
	분류기호 INT,
	FOREIGN KEY (분류기호) REFERENCES 도서분류 (분류기호));
    
CREATE TABLE 대출 (
	#대출코드 자동으로 1부터 증가하도록 설정
	대출코드 INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    회원번호 INT UNSIGNED NOT NULL,
    #대출기간은 CURDATE() 함수 사용
	대출기간 DATE,
    #도서대출가격은 100원으로 통일
	대출가격 INT NOT NULL DEFAULT 100,
	연체 INT,
	ISBN CHAR(13) NOT NULL,
    #대출시 'Y' 값
    대출현황 CHAR(1) DEFAULT 'Y',
    #CHECK 제약조건 대출현황은 'Y' 또는 'N'
    CHECK (대출현황 IN ('Y','N')),
	FOREIGN KEY (회원번호) REFERENCES 회원 (회원번호) on delete cascade,
	FOREIGN KEY (ISBN) REFERENCES 도서 (ISBN) on update cascade);
    
CREATE TABLE 예약 (
	대출현황 CHAR(1),
	회원번호 INT unsigned not null auto_increment,
	ISBN CHAR(13) NOT NULL UNIQUE,
	FOREIGN KEY (회원번호) REFERENCES 회원 (회원번호),
	FOREIGN KEY (ISBN) REFERENCES 도서 (ISBN) on update cascade);
   
DELIMITER #
CREATE TRIGGER 대출_after_insert
	AFTER INSERT ON 대출
    FOR EACH ROW
BEGIN
	UPDATE 회원 SET 회원.`마일리지`=회원.`마일리지`+10 WHERE 회원.`회원번호`=NEW.`회원번호`;
END#
DELIMITER ;

insert into 도서분류 values (1, '무협');
INSERT INTO 도서분류 VALUES (2, '스포츠');
INSERT INTO 도서분류 VALUES (3, '액션');
INSERT INTO 도서분류 VALUES (4, '공포/추리');

INSERT INTO 도서 VALUES ("9788925841359", "은혼 1", "학산문화사", "소라치 히데아키", 3);
INSERT INTO 도서 VALUES ("9788925897134", "은혼 2", "학산문화사", "소라치 히데아키", 3);
INSERT INTO 도서 VALUES ("9791125659402", "은혼 64", "학산문화사", "소라치 히데아키", 3);
INSERT INTO 도서 VALUES ("9788968222382", "하이큐!! 1", "대원씨아이", "후루다테 하루이치", 2);
INSERT INTO 도서 VALUES ("9788968223358", "하이큐!! 2", "대원씨아이", "후루다테 하루이치", 2);
INSERT INTO 도서 VALUES ("9788968225277", "하이큐!! 3", "대원씨아이", "후루다테 하루이치", 2);
INSERT INTO 도서 VALUES ("9788968228391", "하이큐!! 4", "대원씨아이", "후루다테 하루이치", 2);
INSERT INTO 도서 VALUES ("9791156250975", "하이큐!! 5", "대원씨아이", "후루다테 하루이치", 2);
INSERT INTO 도서 VALUES ("9788926314647", "명탐정 코난 1", "서울문화사", "아오야마 고쇼", 4);
INSERT INTO 도서 VALUES ("9788926321348", "명탐정 코난 2", "서울문화사", "아오야마 고쇼", 4);
INSERT INTO 도서 VALUES ("9788926314173", "명탐정 코난 3", "서울문화사", "아오야마 고쇼", 4);
INSERT INTO 도서 VALUES ("9788953292123", "명탐정 코난 4", "서울문화사", "아오야마 고쇼", 4);
INSERT INTO 도서 VALUES ("9788926314661", "명탐정 코난 5", "서울문화사", "아오야마 고쇼", 4);
INSERT INTO 도서 VALUES ("9788926314456", "명탐정 코난 6", "서울문화사", "아오야마 고쇼", 4);

INSERT INTO 회원 (`이름`,`주소`, `핸드폰번호`) VALUES ("김일리", "경기도 고양시 일산서구 탄현로 133", "010-1234-5678");
INSERT INTO 회원 (`이름`,`주소`, `핸드폰번호`) VALUES ("유은재", "서울특별시 서대문구 응암로1길 10", "010-2345-6789");
INSERT INTO 회원 (`이름`,`주소`, `핸드폰번호`) VALUES ("강백호", "서울특별시 은평구 불광천길 410-17", "010-3456-7890");