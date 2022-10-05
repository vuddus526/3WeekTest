# Why: 과제 제출시에는 아래 질문을 고민해보고 답변을 함께 제출해주세요.

1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)<br>
수정에서는 param으로 id값을 넘겨주고 body로 JSON 입력받아 객체로 반환했습니다
삭제에서는 param으로 id값만 넘겨주었습니다

2. 어떤 상황에 어떤 방식의 request를 써야하나요?<br>
전체게시글 목록 조회 GET
게시글 작성 POST
게시글 조회 GET
게시글 비밀번호 확인 GET
게시글 수정 PUT
게시글 삭제 DELETE

3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?<br>
네 / 고유한 리소스 식별자로 각 리소스를 식별했습니다
url에 동사가 아닌 명사로 작성하고 소문자를 사용했습니다
즉 url규칙에 맞게 작성했습니다

4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)<br>
네
Controller : 요청받은 url을 매핑해주는 기능을 넣었습니다
Repository : DB 작업해주는 기능을 넣었습니다
Service : Controller와 Repository 사이의 로직 역할을 넣었습니다

5. 작성한 코드에서 빈(Bean)을 모두 찾아보세요!<br>
@Service @Controller @Repository

6. API 명세서 작성 가이드라인을 검색하여 직접 작성한 명세서와 비교해보세요
![image](https://user-images.githubusercontent.com/97796338/193968429-f025a5ec-2f21-4383-b807-65cf5edafba6.png)
![image](https://user-images.githubusercontent.com/97796338/193968598-845631f2-bea3-4262-99f9-7148a8134ab9.png)
