package org.vermeg.bookStoreTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.StatementCreatorUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.vermeg.bookstore.controller.LivreController;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.service.LivreService;

import com.fasterxml.jackson.databind.ObjectMapper;


	class TestControllerLivre {

		@Mock 
		private LivreService livreService ;
		
		@InjectMocks 
		private LivreController livreController  ;
		
		@Autowired
		private MockMvc mockMvc ;
		
		@BeforeEach
		 public void Setup() {
			 MockitoAnnotations.initMocks(this);	
			
			 mockMvc = MockMvcBuilders.standaloneSetup(livreController).build();
		 } 
		 


		@Test
		void testGetLivres() throws Exception {
			List<Livre> livres = new ArrayList<>() ;
		
			livres.add(new Livre(5,8, "l'amour", "med bakk", null , "ok",10));
			livres.add(new Livre(6,8, "l'amour", "med bakk", null , "ok",10));
		when(livreService.getAllLivres()).thenReturn((List)livres ) ;
		 mockMvc.perform(get("/api/livre/getAllLivres"))
	     .andExpect(status().isOk())
	     .andExpect(jsonPath("$", hasSize(2)))
	     .andDo(print()) ;
}

		

		
			
	
		@Test  
void testCalculatePrice () throws Exception {			
			int idLivre = 5 ;
			
			Livre livre=new Livre(5,8, "l'amour", "med bakk", null , "ok",10); 
			when(livreService.getLivre(idLivre)).thenReturn(livre ) ;
			 mockMvc.perform(get("/api/livre/calculprice/5/20")).andExpect(status().isOk()).andDo(print());
			
			
		}
		
		@Test
		void addLivre() throws Exception {
			Livre livre;
			
			livre=new Livre(5,8, "l'amour", "med bakk", null , "ok",10);
			livreService.addLivre(livre);
			verify(livreService, times(1)).addLivre(livre);
	}
		
		
		@Test
		void updateLivre() throws Exception {
			Livre livre;
			
			livre=new Livre(5,8, "l'amour", "med bakk", null , "ok",10);
			livreService.updateLivre(livre);
			verify(livreService, times(1)).updateLivre(livre);
	}
		
			
		@Test
		void deleteLivre() throws Exception {
			Livre livre;
			
			livre=new Livre(5,8, "l'amour", "med bakk", null , "ok",10);
			livreService.deleteLivre(5);
			verify(livreService, times(1)).deleteLivre(5);
	}
		
		
		}
