package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.model.Livre;

@Repository
public class LivreDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Livre> getAllLivres() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Livre> livreList = session.createQuery("from Livre").list();
		
		for (Livre l:livreList) {
			System.out.println("##### livre num�ro "+ "\t"+ l.getId() + "\t" + l.getReference()+ "\t" + l.getTitre() + "\t" + l.getDesignation() + "\t" + l.getReleaseDate() + "\t" + l.getPrixUnitaire());
		}
		
		return livreList;
	}

	public Livre getLivre(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Livre livre = (Livre) session.get(Livre.class, new Integer(id));
		return livre;
	}

	public Livre addLivre(Livre livre) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(livre);
		return livre;
	}

	public void updateLivre(Livre livre) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(livre);
	}

	public void deleteLivre(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Livre p = (Livre) session.load(Livre.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
