package app;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	
	ArrayList<User> lista = new ArrayList<>();

    @GetMapping("/")
    public String getUser(Model model) {
    	
    String nome = "Carlo";	
    
    ArrayList<String> lista = new ArrayList<>();
    lista.add("blue");
    lista.add("giallo");
    lista.add("verde");
    
    model.addAttribute("nome", nome);
    model.addAttribute("lista", lista);
    
     return "hello";
    }
    
    
    @GetMapping("/salut")
    public String getSaluta(Model model) {
    	
     return "saluta";
    }
    
    @GetMapping("/form")
    public String getForm(Model model) {
    	
        return "form";
       }
    
    @PostMapping("/submit") 
    	public String getDate(@RequestParam("nome") String nome,
                @RequestParam("anni") String anni, Model model) 	{
    	
    	model.addAttribute("nome", nome);
    	model.addAttribute("anni", anni);
    	
    	User p1 = new User();
    	p1.setNome(nome);
    	p1.setAnni(anni);
    	
    	lista.add(p1);
			
    	
    	return "post";
    	
    	
    	
    }
    @GetMapping("/show")
    public String getLista(Model model) {
    	model.addAttribute("lista", lista);
        return "lista";
       }
    
    
}