package com.dingwallsmith.finance.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.dingwallsmith.finance.provider.Provider;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UQ_provider_name", columnNames = { "provider_id", "name" }))
public class Account {
	public static final int NAME_MAX_LENGTH = 100;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "provider_id", foreignKey = @ForeignKey(name = "FK_provider_id"))
    private Provider provider;

    @NotNull
    @Column(length = NAME_MAX_LENGTH)
    private String name;
    
    public Account() {}
    
    public Account(Provider provider, String name) {
    	this.provider = provider;
    	this.name = name;
    }

	public String getName() {
		return name;
	}
}