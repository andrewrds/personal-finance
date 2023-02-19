package com.dingwallsmith.finance.provider;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UQ_name", columnNames = { "name" }))
public class Provider {
    public static final int NAME_MAX_LENGTH = 100;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(length = NAME_MAX_LENGTH)
    private String name;
    
    public Provider() {
    }

    public Provider(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}