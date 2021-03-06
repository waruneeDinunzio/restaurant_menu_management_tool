package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MenuModel;
import com.example.demo.repository.MenuRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class MenuController {
	
	@Autowired
	private MenuRepository menuRepo;
	
	//get all menu
	@GetMapping("/allmenus")
	
	public List<MenuModel> getAllMenus(){
		return menuRepo.findAll();
	}
	
	@PostMapping("/addmenu")
    public MenuModel newMunu(@RequestBody MenuModel s)
    {
		
		return menuRepo.save(s);
    }
	
	@GetMapping("/menu/{id}")
	public ResponseEntity<MenuModel> getMenuById(@PathVariable int id)
	{
		MenuModel s= menuRepo.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Menu not found"));
		return ResponseEntity.ok(s);                 
	}
	
	@GetMapping("/menus/{name}")
	public List<MenuModel> getMenuByTitle(@PathVariable String name)
	{
		//return studentRepo.findByName(name);
		
		List <MenuModel> menus=menuRepo.findByTitle(name);
		if(menus.isEmpty())
		{
			System.out.println(new ResourceNotFoundException("Menu(s) with the name "+ name +" not found"));
		}
		
		return menuRepo.findByTitle(name);
	}
	
	@PutMapping("/menu/{id}")
	public ResponseEntity<MenuModel> updateMune(@PathVariable int id, @RequestBody MenuModel menu)
	{
		MenuModel s= menuRepo.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Menu not found"));
	    s.setTitle(menu.getTitle());
	    s.setCategory(menu.getCategory());
	    s.setPrice(menu.getPrice());
	    s.setImage(menu.getImage());
	    s.setDescription(menu.getDescription());
	    MenuModel updatedMenu=menuRepo.save(s);
	    return ResponseEntity.ok(updatedMenu);
	}
	
	@DeleteMapping("/menu/{id}")
	public String deleteMenu(@PathVariable int id)
	{
		menuRepo.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Menu not found"));
	    menuRepo.deleteById(id);
	    return "The menu with id: "+ id +" is removed from the database.";
	}
	
	
}
