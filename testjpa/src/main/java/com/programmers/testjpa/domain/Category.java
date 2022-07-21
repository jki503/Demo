package com.programmers.testjpa.domain;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class Category {

  @Id
  @GeneratedValue(strategy = AUTO)
  @Column(name = "category_id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Enumerated(STRING)
  @Column(name = "category_kind")
  private CategoryType categoryType;


  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @Builder
  public Category(String name, CategoryType categoryType, User user) {
    this.name = name;
    this.categoryType = categoryType;
    this.user = user;
  }
}
