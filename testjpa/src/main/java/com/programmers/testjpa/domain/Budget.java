package com.programmers.testjpa.domain;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PROTECTED;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Table(name = "budget")
public class Budget {

  @Id
  @GeneratedValue(strategy = AUTO)
  @Column(name = "budget_id")
  private Long id;

  @Column(name = "amount")
  private Long amount;

  @Column(name = "start_time")
  private Date startTime;

  @Column(name = "end_time")
  private Date endTime;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  public Budget(Long amount, Date startTime, Date endTime, User user) {
    this.amount = amount;
    this.startTime = startTime;
    this.endTime = endTime;
    this.user = user;
  }
}
