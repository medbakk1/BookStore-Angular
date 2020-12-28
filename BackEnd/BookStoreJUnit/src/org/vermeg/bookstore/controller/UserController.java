package org.vermeg.bookstore.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.User;
import org.vermeg.bookstore.service.UserService;

@RestController
@RequestMapping("/api/User")
public class UserController {
	
	@Autowired
	UserService UserService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "Hello";
    }
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
	public List<User> getUsers() {
		
		List<User> listOfUsers = UserService.getAllUsers();
		
		return listOfUsers;
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@PathVariable int id) {
		return UserService.getUser(id);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUser(@ModelAttribute("livre")User User) {	
		if(User.getId_User()==0)
		{
			UserService.addUser(User);
		}
		else
		{	
			UserService.updateUser(User);
		}
		
		return "redirect:/getAllUsers";
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateUser(@PathVariable("id") int id,@ModelAttribute("User") User User,Model model) {
		if(UserService.getUser(id)==null)
		{
			System.out.print( "l'utlisteur souhaité n'existe pas");
		}
		else
		{
			UserService.updateUser(User);
			System.out.print( "modification avec succées");
		}
		return "redirect:/getAllUsers";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteUser(@PathVariable("id") int id) {
		UserService.deleteUser(id);
		 return "redirect:/getAllUsers";

	}	

}
