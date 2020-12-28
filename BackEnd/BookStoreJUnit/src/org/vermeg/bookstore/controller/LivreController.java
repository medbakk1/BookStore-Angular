package org.vermeg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.service.LivreService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/livre")
public class LivreController {
	
	@Autowired
	LivreService livreService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "Hello";
    }
	
	@RequestMapping(value = "/getAllLivres", method = RequestMethod.GET, produces = "application/json")
	public List<Livre> getLivres() {
		
		List<Livre> listOfLivres = livreService.getAllLivres();
		
		return listOfLivres;
	}

	@RequestMapping(value = "/getLivre/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Livre getLivreById(@PathVariable int id) {
		return livreService.getLivre(id);
	}

	@RequestMapping(value = "/addLivre", method = RequestMethod.POST)
	public Livre addLivre(@RequestBody Livre livre) {	
		if(livre.getId()==0)
		{
			livreService.addLivre(livre);
		}
		else
		{	
			livreService.updateLivre(livre);
		}
		
		return livre;
	}

	@RequestMapping(value = "/updateLivre/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateLivre(@PathVariable("id") int id,@ModelAttribute("livre") Livre livre,Model model) {
		if(livreService.getLivre(id)==null)
		{
			System.out.print( "le livre souhait� n'existe pas");
		}
		else
		{
			livreService.updateLivre(livre);
			System.out.print( "modification avec succ�es");
		}
		return "redirect:/getAllLivres";
	}

	@RequestMapping(value = "/deleteLivre/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteLivre(@PathVariable("id") int id) {
		livreService.deleteLivre(id);
		 //return "redirect:/getAllLivres";

	}	
	@RequestMapping(value = "/calculprice/{id}/{qte}", method = RequestMethod.GET, headers = "Accept=application/json")
	public double calculprice(@PathVariable("id") int id,@PathVariable("qte") int qte) {
		System.out.println(qte);
		double calculprice=livreService.getLivre(id).getPrixUnitaire()*qte;
		return calculprice;
	}
	@RequestMapping(value = "/SommeTotal", method = RequestMethod.POST, headers = "Accept=application/json")
	public double SommeTotal(@RequestBody List<Integer> listLivres) {	
		double total=0;

		for (int i=0;i<listLivres.size();i++) {
		int id = listLivres.get(i);
			
			total= total+livreService.getLivre(id).getPrixUnitaire();		
		}		
		return total;
		}
	

}
