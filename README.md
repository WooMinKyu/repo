1. 자신이 개발한 앱에 대한 설명
-Todo 리스트를 볼 수 있고 리스트를 추가할 수 있고 Todo를 완료한경우 완료로 상태를 변경 할 수 있게끔 만들었습니다. 완료를 잘못 한 경우를 대비하여 완료를 취소하는 기능도 추가하였습니다.
2. 소스 빌드 및 실행 방법 메뉴얼 (DB 스키마 포함)
-
CREATE TABLE `todo` (
  `tno` bigint NOT NULL AUTO_INCREMENT,
  `complete` bit(1) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
로 테이블을 생성 후 테스트코드로 데이터를 기입 후에 각 api들도 테스트코드와 RESTAPI를 확인할 수 있는 애플리케이션(Postman)을 이용하여 개발하였습니다.

3. 주력으로 사용한 컴포넌트에대한 설명 및 사용 이유 기입
-

4. Api 명세 작성 필수 → Swagger 등 사용해도 무방함
-
