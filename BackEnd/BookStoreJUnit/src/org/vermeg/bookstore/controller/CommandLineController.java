package org.vermeg.bookstore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.CommandLine;

import org.vermeg.bookstore.service.CommandLineService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/CommandLine")
public class CommandLineController {
	
	@Autowired
	CommandLineService CommandLineService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "Hello";
    }
	
	@RequestMapping(value = "/getAllCommandLine", method = RequestMethod.GET, produces = "application/json")
	public List<CommandLine> getCommandLine() {
		
		List<CommandLine> listOfCommandLine = CommandLineService.getAllCommandLine();
		
		return listOfCommandLine;
	}

	@RequestMapping(value = "/getCommandLine/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CommandLine getCommandLineById(@PathVariable int id) {
		return CommandLineService.getCommandLine(id);
	}

	@RequestMapping(value = "/addCommandLine", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCommandLine(@ModelAttribute("CommandLine")CommandLine CommandLine) {	
		if(CommandLine.getId()==0)
		{
			CommandLineService.addCommandLine(CommandLine);
		}
		else
		{	
			CommandLineService.updateCommandLine(CommandLine);
		}
		
		return "redirect:/getAllCommandLine";
	}

	@RequestMapping(value = "/updateCommandLine/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateCommandLine(@PathVariable("id") int id,@ModelAttribute("CommandLine") CommandLine CommandLine,Model model) {
		if(CommandLineService.getCommandLine(id)==null)
		{
			System.out.print( "l'utlisteur souhaité n'existe pas");
		}
		else
		{
			CommandLineService.updateCommandLine(CommandLine);
			System.out.print( "modification avec succées");
		}
		return "redirect:/getAllCommandLine";
	}

	@RequestMapping(value = "/deleteCommandLine/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteCommandLine(@PathVariable("id") int id) {
		CommandLineService.deleteCommandLine(id);
		 return "redirect:/getAllCommandLine";

	}	

}
