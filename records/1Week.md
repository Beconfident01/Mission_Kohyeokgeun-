# Title: [1Week] 고혁근
미션 요구사항 분석 & 체크리스트 

- [ ] 삭제 기능 구현

- [ ] 삭제 기능 테스트 케이스

- [ ] 해당 항목에 대한 소유권이 본인(로그인한 사람)에게 있는지 체크

- [ ] 삭제 후, 다시 호감목록 페이지로 돌아오기

- [ ] rq.redirectWithMsg 함수 사용

[접근 방법]
-LikeablePersonController 에서 delete함수를 만들어서 삭제 권한을 검사하고 LikeablePersonService의 delete메서드로 삭제르 시도했습니다.

삭제 버튼을 누르면 삭제를 처리하기 전에 소유권을 체크하고, 삭제 후, 다시 호감목록으로 돌아오게 하도록 시도했습니다.
rq.redirectWithMsg 함수 사용했습니다.
[특이사항]

삭제 버튼을 누르면 rq.redirectWithMsg 함수가 나오고 소유권도 체크하지만 삭제기능이 작동하지않았습니다.- 삭제 버튼을 누르면 rq.redirectWithMsg 함수가 나오고 소유권도 체크하지만 삭제기능이 작동하지않았습니다.