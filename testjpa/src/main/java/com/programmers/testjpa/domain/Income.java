package com.programmers.testjpa.domain;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Table(name = "income")
public class Income {

  @Id
  @GeneratedValue(strategy = AUTO)
  @Column(name = "income_id")
  private Long id;

  @Column(name = "register_date")
  private LocalDate registerDate;

  @Column(name = "amount")
  private Long amount;

  @Column(name = "content")
  private String content;

  @Column(name = "category_name")
  private String categoryName;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @Builder
  public Income(LocalDate registerDate, Long amount, String content,
      String categoryName, User user) {
    this.registerDate = registerDate;
    this.amount = amount;
    this.content = content;
    this.categoryName = categoryName;
    this.user = user;
  }
}
