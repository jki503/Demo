package com.programmers.testjpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
