# Title: [2Week] 고혁근
미션 요구사항 분석 & 체크리스트

- [x] 중복 호감표시 금지 구현
- [x] 중복 검사 구현
- [x] rq.historyBack

- [ ] 호감상대 10명 제한 구현
- [x] 호감 상대 count 구현
- [x] rq.historyBack

- [ ] 호감표시 수정 구현
- [x] 호감사유 중복 검사 구현



[접근 방법]

1. Service에서 canActorAdd 메서드를 만들어 add를 하기 전에 중복을 검사 할 수 있도록 구현했습니다.
2. controller의 addform에서 member,username 인자들을 가져와 누가 누구에게 호감표시를 했는지, 호감사유는 무엇인지 stream으로 작성했습니다.
3. AppConfig에서 만든 likeablePersonFromMax를 가져와 service에서 canActorAdd 메서드에 넣어 중복 검사하기 전에 10명이 초과하면 제한할 수 있도록 시도했습니다.
4. canActorAdd 메서드 내에 if 문으로 호감표시 수정을 구현했습니다. 



[특이사항]
1. 중복 호감 표시를 금지하는 것은 구현했지만, 중복 호감 표시가 불가능하다는 알림을 보여주는 것은 구현하지 못했습니다.
2. Test에서는 AppConfig가 잘 작동하지만, 구현할 경우 제대로 적용이 되지 않았습니다.
3. 수정은 구현됐지만 수정을 하면 전에 있던 것과 현재 등록하는 호감이 같이 등록되어 2개가 동시에 생기게 되었습니다. 아마도 수정 메서드를 따로 구현을 하거나 수정이 되면 add메서드로 가지 않게 막는 로직을 만들어야 할 것 같습니다. 
