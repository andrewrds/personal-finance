package com.dingwallsmith.finance.provider;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class ProviderService {
	@PersistenceContext
	private final EntityManager entityManager;

	@PersistenceContext
	private Session session;

	public ProviderService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public void create(String name) {
		entityManager.persist(new Provider(name));
	}

	public List<String> list() {
		CriteriaBuilder b = session.getCriteriaBuilder();
		CriteriaQuery<String> query = b.createQuery(String.class);
		Root<Provider> root = query.from(Provider.class);
		query.select(root.get("name")).orderBy(b.asc(root.get("name")));
		return session.createQuery(query).getResultList();
	}
}
