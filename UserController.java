package app;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	
	ArrayList<prodotto> lista = new ArrayList<>();

    @GetMapping("/")
    public String getUser(Model model) {
    	
    String nome = "Carlo";	
    
    int somma = 54 + 32;
    
    ArrayList<String> lista = new ArrayList<>();
    lista.add("blue");
    lista.add("giallo");
    lista.add("verde");
    
    ArrayList<Integer> lista1 = new ArrayList<>();
    lista1.add(somma);
    lista1.add(4);
    lista1.add(3);
    
    model.addAttribute("nome", nome);
    model.addAttribute("lista", lista);
    // il primo parametro è come verrà visualizzato sull'html, il secondo parametro è il dato vero proprio
    model.addAttribute("add", somma);
    model.addAttribute("listaNumeri", lista1);
    
     return "hello";
    }
    
    
    @GetMapping("/salut")
    public String getSaluta(Model model) {
    	
     return "saluta";
    }
    
    @GetMapping("/form")
    public String getForm(Model model) {
    	
    	
    	prodotto p1 = new prodotto();
    	p1.setNome("Nutella");
    	p1.setMarca("Ferrero");
    	p1.setPrezzo(3.2);
    	p1.setQnt(10);
    	p1.setImg("nutella.jpg");
    	lista.add(p1);
    	
        return "form";
       }
    
    @PostMapping("/submit") 
    	public String getDate(@RequestParam("nome") String nome,
                @RequestParam("marca") String marca, @RequestParam("prezzo") String prezzo,
                @RequestParam("qnt") String qnt, @RequestParam("img") String img,  Model model) 	{
    	
    	model.addAttribute("nome", nome);
    	
    	Double prezzo1 = Double.parseDouble(prezzo);
    	Integer qnt1 = Integer.parseInt(qnt);
    	
    	prodotto p1 = new prodotto();
    	p1.setNome(nome);
    	p1.setMarca(marca);
    	p1.setPrezzo(prezzo1);
    	p1.setQnt(qnt1);
    	p1.setImg(img);
    	
    	
    	
    	lista.add(p1);
			
    	
    	return "post";
    	
    	
    	
    }
    @GetMapping("/show")
    public String getLista(Model model) {
    	model.addAttribute("lista", lista);
        return "lista";
       }
    
    @GetMapping("/prod")
    public String getProd(Model model) {
    	
    	prodotto p1 = new prodotto();
    	p1.setNome("Pizza");
    	p1.setMarca("Buitoni");
    	p1.setPrezzo(2.3);
    	p1.setQnt(10);
   p1.setImg("pizza.jpg");
    	
    	
    	
    	model.addAttribute("prod", p1);
        return "prod";
       }
    
    @PostMapping("/process")
    public String getProcess(Model model, @RequestParam("qnts")  String [] pezzi) {
    	ArrayList <prodottoAc> listaP = new ArrayList<>();
    	ArrayList <prodotto> prodottiAc = new ArrayList<>();
    	ArrayList <Integer> num = new ArrayList<>();
    	for (int i = 0; i < pezzi.length; i++) {
    		
    		if (!pezzi[i].equals("0")) {
    			
    			int pezzo = Integer.parseInt(pezzi[i]);
    			num.add(pezzo);
    			prodottiAc.add(lista.get(i));
    			prodottoAc p1 = new prodottoAc();
    			p1.setNome(lista.get(i).getNome());
    			p1.setPezzi(pezzo);
    			p1.setPrezzo(lista.get(i).getPrezzo());
    			listaP.add(p1);
    		}
    		
    		
    	}
    	
    	System.out.println("Hai acquistato ");
    	for (int i = 0; i < prodottiAc.size(); i++) {
    		System.out.println(prodottiAc.get(i).getNome());
    		System.out.println("In  tot: " + num.get(i) + " pezzi");
    	}
    	
    	model.addAttribute("listaP", listaP);
    	
    	
    
    	 
    	 return "buy";
    }
    
    
}