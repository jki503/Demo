package com.programmers.testjpa.domain;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = AUTO)
  @Column(name = "user_id")
  private Long id;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "username")
  private String username;

  @Builder
  public User(String email, String password, String username) {
    this.email = email;
    this.password = password;
    this.username = username;
  }
}
