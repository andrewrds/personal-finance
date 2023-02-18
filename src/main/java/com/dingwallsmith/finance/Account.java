package com.dingwallsmith.finance;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.dingwallsmith.finance.provider.Provider;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "provider_id", foreignKey = @ForeignKey(name = "FK_provider_id"))
	private Provider provider;

	@NotNull
	private String description;
}