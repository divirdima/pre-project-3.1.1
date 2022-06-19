package com.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.User;

@Component
@Repository
@Transactional
public class UserDaoHibernateImp implements UserDao{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public User getUserById(int id) {
		Query query = entityManager.createQuery("from User where id = :idParam");
		query.setParameter("idParam", id);
		return (User)query.getSingleResult();
	}

	@Override
	public void save(User user) {
		entityManager.persist(user);
	}

	@Override
	public void remove(int id) {
		entityManager.remove(entityManager.find(User.class, id));
	}

	@Override
	public void update(int id, User user) {
		Query query = entityManager.createQuery("update User "
				+ "set name = :namePar, wallet = :walletPar where id = :idParam");
		query.setParameter("namePar", user.getName());
		query.setParameter("walletPar", user.getWallet());
		query.setParameter("idParam", id);		
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Query query = entityManager.createQuery("from User");
	    return query.getResultList();
	}

}
