package org.vermeg.bookStoreTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.dao.LivreDAO;
import org.vermeg.bookstore.model.Livre;

class LivreServiceTest {
	LivreDAO livreDao  = mock(LivreDAO.class);

	@Test
	void testgetAllLivres() {
	 List<Livre> livres= new ArrayList<Livre>();
	Livre livre1 = new Livre(2,5,"med", "bakk", null, "livre 1",
			15);
	Livre livre2 = new Livre(3,10,"pac", "bakk2", null, "livre 2",30);
	 livres.add(livre1);
	 livres.add(livre2);
	 when(livreDao.getAllLivres()).thenReturn(livres);
	 assertEquals(2,livres.size());
	 assertEquals("med",livres.get(0).getTitre());
	 assertEquals("pac",livres.get(1).getTitre());
	 assertEquals(livreDao.getAllLivres() , livres);
	}
	@Test
	void testgetLivre() {
	Livre  livre1 = new Livre(1,7,"med", "bakk", null, "livre  1",
			15);
	 int id=livre1.getId();
	 when(livreDao.getLivre(id)).thenReturn(livre1);
	 assertEquals(1,livre1.getId());
	 assertTrue(livreDao.getLivre(id) == livre1);
	}
	
	@Test
	void testaddLivre() {
	List<Livre> livres= new ArrayList<Livre>();
	Livre livre1 = new Livre(1,7,"med", "bakk", null, "livre 1",
			15);
	 int size=livres.size();
	 livres.add(livre1);
	 when(livreDao.addLivre(livre1)).thenReturn(livre1);
	 assertEquals(livreDao.addLivre(livre1),livre1);
	 assertTrue(livres.size()== size+1);
	}
	
	@Test
	void testupdateLivre() {
	Livre livre1 = new Livre(1,7,"med", "bakk", null, "livre 1",
			15);
	 livreDao.updateLivre(livre1);
	verify(livreDao,times(1)).updateLivre(livre1);
	}
	
	@Test
	void testDeleteLivre() {

	Livre livre1 = new Livre(01,7,"med", "bakk", null, "livre 1",
			15);
	 livreDao.deleteLivre(livre1.getId());
	verify(livreDao,times(1)).deleteLivre(livre1.getId());
	}
}
