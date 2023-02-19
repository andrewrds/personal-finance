package com.dingwallsmith.finance;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.dingwallsmith.finance.account.Account;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UQ_account_date", columnNames = { "account_id", "snapshotDate" }))
public class MonthlySnapshot {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "FK_account_id"))
    private Account account;

    @NotNull
    private LocalDate snapshotDate;

    @Null
    private BigDecimal balance;

    @Null
    private BigDecimal moneyIn;

    @Null
    private BigDecimal moneyOut;

}
