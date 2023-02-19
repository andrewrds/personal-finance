package com.dingwallsmith.finance.account;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.dingwallsmith.finance.provider.Provider;
import com.dingwallsmith.finance.provider.ProviderService;

@Component
public class AccountService {
	@PersistenceContext
	private final EntityManager entityManager;

	@PersistenceContext
	private final Session session;

	private final ProviderService providerService;

	public AccountService(EntityManager entityManager, Session session, ProviderService providerService) {
		this.entityManager = entityManager;
		this.session = session;
		this.providerService = providerService;
	}

	@Transactional
	public void create(String providerName, String accountName) {
		Provider provider = providerService.find(providerName);
		entityManager.persist(new Account(provider, accountName));
	}

	@Transactional
	public void delete(String name) {
		CriteriaBuilder b = session.getCriteriaBuilder();
		CriteriaDelete<Account> delete = b.createCriteriaDelete(Account.class);
		Root<Account> root = delete.from(Account.class);
		delete.where(b.equal(root.get("name"), name));
		session.createQuery(delete).executeUpdate();
	}

	public List<String> listForProvider(String providerName) {
		return session.createQuery("FROM Account as a WHERE a.provider.name = :providerName", Account.class)
				.setParameter("providerName", providerName)
				.getResultList()
				.stream()
				.map(a -> a.getName())
				.toList();
	}
}
