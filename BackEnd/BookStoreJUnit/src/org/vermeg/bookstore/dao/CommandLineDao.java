package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.model.CommandLine;

@Repository
public class CommandLineDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<CommandLine> getAllCommandLine() {
		Session session = this.sessionFactory.getCurrentSession();
		List<CommandLine> CommandLineList = session.createQuery("from CommandLine").list();
		
		for (CommandLine CommandLine:CommandLineList) {
			System.out.println("##### l'id de CommandLine est"+ "\t"+ CommandLine.getNum() + "\t" + CommandLine.getId()+ "\t"  + CommandLine.getPriceCommandLine() + "\t" + CommandLine.getDate_commandeligne() + "\t" + CommandLine.getQte());
		}
		
		return CommandLineList;
	}

	public CommandLine getCommandLine(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		CommandLine CommandLine = (CommandLine) session.get(CommandLine.class, new Integer(id));
		return CommandLine;
	}

	public CommandLine addCommandLine(CommandLine CommandLine) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(CommandLine);
		return CommandLine;
	}

	public void updateCommandLine(CommandLine CommandLine) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(CommandLine);
	}

	public void deleteCommandLine(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		CommandLine t = (CommandLine) session.load(CommandLine.class, new Integer(id));
		if (null != t) {
			session.delete(t);
		}
	}	
}
