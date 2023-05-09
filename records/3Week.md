# Title: [3Week] 고혁근
미션 요구사항 분석 & 체크리스트

필수미션

- [ ] 네이버클라우드플랫폼을 통한 배포(도메인 없이, IP로 접속)

- [x] 호감표시/호감사유변경 후, 개별 호감표시건에 대해서, 3시간 동안은 호감취소와 호감사유변경을 할 수 없도록 작업

추가미션

- [ ] 알림기능 구현


[접근 방법]
1. like 메서드에서 modifyAttractive(actor, username, attractiveTypeCode)메서드로 넘어가기 전에 3시간이 지나면 넘어갈 수 없게 구현했습니다.
2. likeablePerson 객체를 가져와서 isModifyUnlocked 이 true인지 false인지 확인하고 false 일 경우 "F-3"를 보여주게 만들었습니다.
3. list.html에서 몇시간이 남았는지 보여주는 getModifyUnlockDateRemainStrHuman()를 현재 시간과 modifyUnlockDate을 비교해서 남은 시간을 구해서 시간,분 단위로 작성했습니다.  




[특이사항]
1. likeablePersonService에서 3시간 동안 like로 호감변경을 하지 못하게 막았지만, likeperson 객체가 왜 한 번 생성한 후에 null이 되는지는 모르겠습니다. 그래서 null 오류를 잡아주는 코드를 작성했지만 이유를 잘모르겠습니다.