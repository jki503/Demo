# Demo

</br>

- LocalDate에서 LocalDateTime으로 해야하는 이유
  - 날짜만 줄 경우 날짜에 따른 지출과 수입에 대한 정렬 기준이 사라진다.
  - 실제 우리가 의도했던 것은 registerDate(LocalDate)로 내림차순 정렬을 하려했다.
  - LocalDateTime으로 바꾸고 내림차순 정렬해주면 간단하다!(그렇게 어렵지 않아요!)

</br>

```java
public class Main {

  public static void main(String[] args) {

    //Front 요청, yyyy-MM-ddTHH:mm
    String dateTime = "2022-07-29T22:21";

    //이분이 Create와 update request에서 @JsonFormat or @DateFormating
    LocalDateTime time = LocalDateTime.parse(dateTime,
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.getDefault()));

    //BackEnd가 request 받는 것
    System.out.println(time);

    //BackEnd가 파싱해서 넘겨줄때
    // 스프링에서 reponse 어노테이션
    String timeString = time.toString();
    System.out.println(timeString);
  }

}
```

- 1. 프론트가 request 넘겨줄 때

```java
//Front 요청, yyyy-MM-ddTHH:mm
    String dateTime = "2022-07-29T22:21";

```

> 이 규격에 맞추어서 보내주시면 됩니다!

- 2. 백엔드가 받고 저장할때

```java
    //이분이 Create와 update request에서 @JsonFormat or @DateFormating
    LocalDateTime time = LocalDateTime.parse(dateTime,
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.getDefault()));
```

> 스프링 지원 받아서 어노테이션 작성하면 LocalDateTime 받을 수 있다.
> DateFormating보다 JsonFormat 사용 제안

- DateFormating보다 JsonFormat이 네이밍 더 좋다(개인적).
- 두 개의 어노테이션이 작성도어 있으면 JsonFormat가 우선권을 갖는다.

</br>

- 3. 파싱해서 넘겨줄 때

</br>

> 날짜와 시간을 잘라서 줄지?(어렵지 않아요! 가능합니다)

```java
 // 스프링에서 reponse에도 어노테이션
    String timeString = time.toString();
    System.out.println(timeString);
```

</br>

> 제가 개발속도가 제일 빨라 제가 쿼리 및 데이트 저장 조회 정렬 모두 작성할 것같습니다.  
> 어렵지 않아요! 프론트는 규격만 잘 보내주시면 되고,  
> 수입 담당자는 필드만 LocalDateTime으로 바꾸고 테스트에서도 생성자 파라미터 수정만 해주시면 됩니다.  
> 제 제안 고민해보시고 다시 논의해봐요!
