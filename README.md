# spring-gift-point

* http://katecam-ppochaco.s3-website.ap-northeast-2.amazonaws.com/
* 우측 상단에서 신형진을 선택해 주세요.

---
## 프로그램 요구 사항
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * 기본적으로 Google Java Style Guide를 원칙으로 한다.
    * 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
* indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 3항 연산자를 쓰지 않는다.
* 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    * 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
* else 예약어를 쓰지 않는다.
    * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
* 구현한 기능에 대해 적절한 테스트 전략을 생각하고 작성한다.


## 기능 요구 사항
* 주문하기 코드를 옮겨 온다. 코드를 옮기는 방법에는 디렉터리의 모든 파일을 직접 복사하여 붙여 넣는 것부터 필요한 일부 파일만 이동하는 것, Git을 사용하는 것까지 여러 가지 방법이 있다. 코드 이동 시 반드시 리소스 파일, 프로퍼티 파일, 테스트 코드 등을 함께 이동한다.
* 작성한 API 문서를 기반으로 팀 내에서 지금까지 만든 API를 검토하고 통일하여 변경 사항을 반영한다.
  * 팀 내에서 일관된 기준을 정하여 API 명세를 결정한다.
  * 때로는 클라이언트의 편의를 위해 API 명세를 결정하는 것이 좋다.
* 지금까지 만든 선물하기 서비스를 배포하고 클라이언트와 연동할 수 있어야 한다.
* 지속적인 배포를 위한 배포 스크립트를 작성한다.
  * 클라이언트와 API 연동 시 발생하는 보안 문제에 대응한다.
  * 서버와 클라이언트의 Origin이 달라 요청을 처리할 수 없는 경우를 해결한다.
* 상품 구매에 사용할 수 있는 포인트 기능을 구현한다.
  * 포인트는 사용자별로 보유한다.
  * 관리자화면에서 포인트를 충전할 수 있다.
  * 사용자는 주문할 때 사용할 포인트를 정하여 할인받을 수 있다.
