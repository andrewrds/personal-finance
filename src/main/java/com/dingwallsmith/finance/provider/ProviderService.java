package com.dingwallsmith.finance.provider;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
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
    public void delete(String name) {
    	CriteriaBuilder b = session.getCriteriaBuilder();
    	CriteriaDelete<Provider> delete = b.createCriteriaDelete(Provider.class);
    	Root<Provider> root = delete.from(Provider.class);
    	delete.where(b.equal(root.get("name"), name));
    	session.createQuery(delete).executeUpdate();
    }

    public List<String> list() {
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<String> query = b.createQuery(String.class);
        Root<Provider> root = query.from(Provider.class);
        query.select(root.get("name")).orderBy(b.asc(root.get("name")));
        return session.createQuery(query).getResultList();
    }
    
    public Provider find(String name) {
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Provider> query = b.createQuery(Provider.class);
        Root<Provider> root = query.from(Provider.class);
        query.where(b.equal(root.get("name"), name));
        return session.createQuery(query).getSingleResult();
    }
}
