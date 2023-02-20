package com.dingwallsmith.finance.provider;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class ProviderService {
	@PersistenceContext
	private final EntityManager entityManager;

	@PersistenceContext
	private final Session session;

	public ProviderService(EntityManager entityManager, Session session) {
		this.entityManager = entityManager;
		this.session = session;
	}

	@Transactional
	public void create(String name) {
		entityManager.persist(new Provider(name));
	}

	@Transactional
	public void delete(long id) {
		Provider provider = find(id);
		entityManager.remove(provider);
	}

	public List<Provider> list() {
		return session.createQuery("""
				FROM Provider as p
				ORDER BY p.name""", Provider.class)
				.getResultList();
	}

	public Provider find(long id) {
		return session.createQuery("""
				FROM Provider as p
				WHERE p.id = :id""", Provider.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
