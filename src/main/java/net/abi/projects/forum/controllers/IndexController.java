package net.abi.projects.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.dao.DuplicateKeyException;

import net.abi.projects.forum.data.crud.UserRepository;
import net.abi.projects.forum.data.dao.User;

@Controller
public class IndexController {
	
	@Autowired
	UserRepository userRepository;
	
	
    @RequestMapping("/")
    String index(){
        return "index";
    }
    
    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String handle, @RequestParam boolean banned, @RequestParam Long numberOfPosts,  RedirectAttributes ra) {
        boolean returnFlag = false;
        String message = "";
    	User user = new User();
        user.setHandle(handle);
        user.setBanned(banned);
        user.setNumberOfPosts(numberOfPosts);
        
        try{
        userRepository.save(user);
        }
		catch (DuplicateKeyException e) {
			returnFlag = true;
			message = e.getMessage();
		}

        if (returnFlag) {
        	ra.addFlashAttribute("message", message);
        	return "redirect:/error1";
        	
        	
		} 
			return "redirect:/show/" + user.getId();
		
    }
    
    @RequestMapping("/error1")
    public String error(Model model,  RedirectAttributes ra) {
        return "error";
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/user")
    public String product(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }
    
    
}