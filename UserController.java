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
    
    @GetMapping("/prod")
    public String getProd(Model model) {
    	
    	prodotto p1 = new prodotto();
    	p1.setNome("Latte");
    	p1.setMarca("Parmalat");
    	p1.setPrezzo(2.3);
    	p1.setQnt(10);
   p1.setImg("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxISEBAQEg8QEg8WERIQDw8QEBAQEA8PFhIXGBUWFRUYHSggGBolGxUWITEhJSkrLi8vGB8zODMsOSgtLisBCgoKDg0OGxAQGi0lIB8tLS0rLS0wLS8tLTctLisrLS0uLy0wLystLSstNy0tLS0tLSstLS0tLS8tLS0tLS0tLf/AABEIAOEA4QMBEQACEQEDEQH/xAAbAAEAAgMBAQAAAAAAAAAAAAAABAUBAwYCB//EAEAQAAIBAgQCBwMICQQDAAAAAAABAgMRBBIhMQVBBhMiUWGBkTJCcQcjcpKhscHhFDNEUlNigqLRVMLS8CQlNP/EABoBAQEAAwEBAAAAAAAAAAAAAAABAgMEBQb/xAAzEQEAAgIAAwUECQUBAAAAAAAAAQIDEQQhMQUSQVFhEyKBoRUyUnGRscHR8RRCU+HwBv/aAAwDAQACEQMRAD8A+4gAAAAAAAAAAABickk22klq23ZJAiNqXGdLcDSTc8XSst3Burb6iZhOWkeLrpwHE36Un8vzVU/lN4Wv2qT+FDEfjEw/qMfm3/RHF/Y+cfuQ+U3hb/aZL40K/wCER/UY/Nfoji/sfOP3WuB6W4Gqk4YqnZ7Oealf66RlGWk+LRk7P4mn1qT8Of5LqMk0mmmnqmtU0bHH0ZAAAAAAAAAAAAAAAAAAAAAAAAAAD5r8s2NnGODoqVoTlUqTV2ruGTLfvXab+Njk4q3SH0n/AJ7FWZyZJjnGoj472+bY+telK87u3OV+45XuxGr9HPSlsRnMs05FIl0WCrWpXU7O3J2DGY3fnD6f8jWMlLC16Td40614J+7GcbtLwum/NnZw0+7MPnf/AEOKtc1bxH1o5/B9COl8+AAAAAAAAAAAAAAAAAAAAAAAAAD5h8rKvi8AnZrq6zs1fXND/BycT1h9L2FyxZfh+rjekkk6Dimm9LRjbvOfT1MUxF9y43qJfuy9GYxW3k22zYo/uj8XqOHn+5L6rE0t5LTNi+1H4u26KrLSSk0nrpK3eZxEw0cRetre7O3Z/JNP57iMV7Oai1bRbTN/DdZeT27Hu4p9J/R9IOt86AAAAAAAAAAAAAAAAAAAAAAAAADnukvBo1ZxrSpUp5I5Yuos2S8tey9HyMZrEzuYbqcRlx1mtLTET10hvhkVHTKtNo06cF9iMtQ1Ta09ZVlSMl7zMmDZQg37zAtFw6Ljd2envQhJfaiahlFpjpKf0f4TGi51I06cOsUXLJHLma2bS0W5jFYieTZfNkvERe0zrptclawAAAAAAAAAAAAAAAAAAAAAAAAAROKP5qXxiv7kCVVXn2fIqKGqyo9YeWoF/QneHkRVvg3enD6KXorEVuAAAAAAAAAAAAAAAAAAAAAAAAAACq41X1jBfSl9y/H0LCSpsVVvoVFbUAzTAs8LW5AXfB614uHNO6+D/MkrCxIoAAAAAAAAAAAAAAAAAAAAAAAAeZySTb2Sbb8EBzk5OcpTe7d/guS9LFYoOIKIUyoQIqdhgLHD1Mkoz5bS+i9yDoEyMmQAAAAAAAAAAAAAAAAAAAAAAACBxiraCjzk7f0rV/gvMsJKuyaAVmK3KiFIqEAJ+FILLJeJGSz4XVvTs949ny5EITAoAAAAAAAAAAAAAAAAAAAAAAApuIzzVbcopLzer+9ehYSXia0AqcXuVEKRUIATsJuQXFJaEZNnDpZajjykvtX/AFiSFqRQAAAAAAAAAAAAAAAAAAAAAABQQlmnKXfJvyvp9hWLZU2CqfFbsqIciozAip2F3AuKRFeHLLOEu6S9ALsigAAAAAAAAAAAAAAAAAAAAAHitK0ZPui36ICiwi0Kxhtq7BVNidyoiSKj1AgmYbcKuKOxFa8Rq2vAIuqMrxi+9J/YRk9gAAAAAAAAAAAAAAAAAAAAAacYm6dRLV5JJLv0AoaGJSXN/BMrEq4r+WXowKyvPwfoyiNKQRmEgqbh5eD9ALKliP5J/VZBipWV76/BpgXeDTVOCe9iMm4AAAAAAAAAAAAAAAAAAAAADViqmWE5LdRbXxsBQ0ad7tuV27uztqVizWgrby+swqrr7lRGkyjMCCXh/P1CLSjST5y+syKVqdtU35u4F1hqmaEZPdrUjJtAAAAAAAAAAAAAAAAAAAAAA1Yq3Vzvtllf4WAqcLgoyinmumtGtU/tKmnqvw2KXtPe235k2uldi+HZWln3V/Z/Mu00jTwNvf8A7fzG00xhsNGavGpdXs7LmZWia9YY1tW3OJT6HD1f2n6GO2ellS4bHvfoTZpyvSDpXhMM5xlPWN00pRWq33Me9PlLVfLFZ07ThtVTo0ppNKUIySe6uuZk2x0SQoAAAAAAAAAAAAAAAAAAAADVio3hNd8ZLTfYCn4PBShGalVtpaMpaNaPaxZRYVk7LwaZFV2Nq3e2ivbxCbcthukVOvGUEnCq01GEvef8su/wO6/BXxTEzzh5eLtLHnrNY5W8v2esFi1h1OdVuELWSad5Tvoorm7XLfHOXVac5TFmjh4m2TlH5z6Lro5xb9JjOSg4qM8qu021ZO77jRxPDzhmImd7dPBcZHE1m0RrU6dHTbOd2uM6Q9GsRJS6rEJRcpzUXSpPLKUnL3nrq2Y8/wDv5arRaPquv4RTccPRi91Tin8UjJsjomBQAAAAAAAAAAAAAAAAAAAAGuv7EvovbfYCr4Q1l0dT+uLSXwukWROqK9r7bkidExvk4rG3pVs0qkIRzXzSnGKavro3d/A76zGSmojc/c8m9Zw5NzaIjfXenJ4rgtRzk6KjUo5nkqRnDIo90nfsteJ3/wBZjpTeWe7MRz28i3Z2S+SfYx3qzPKYmFjxfhtas6ThJV8tKEJ5ZK6mt3Z8m+ZxcB2jwt+9FbR127u0+zeLtNJ1vURHx/2teAqNGnGk69LrXUcqlPrI6OySje9m1bv3ZszzbJfvxWda5TpjwkUwYoxzeO9vcxuPu15O6wkLRV9zzL23L3cdO7CB0hdqUpatJLsKMXduVr6xlyfcSvVsT+FTToUmtnCLW21vAkiWAAAAAAAAAAAAAAAAAAAAAB4r+zL6L+4Dn+A0naMlFKLW6VOzXlZ8jKyQt5w3fouVzFXzji3RCs5ynCqql3d9a2qj/q2f2Hr4e0KRGrV193R87xHY+Sbd6l9/f1/Hx+SRwbo9Vp0qqm4qU8loJtpZW9343PK7b1xuH2eP5+Po9Psfhr8HabZPHwhP4dwyak3Lsq0oqzu7tW/M8Ds7s/NhzRkyajXhve/9Pb4nPS+OaV8VFU6MVKSc6tWjToRazVpOVknJRWiXe16n3MdoY5jlE78nxE9hZptqbRrz/wBPoHDMFHC0GpVZOEU5znO9opLXKlstNjys2Wc1960+g4LhI4XF7OLTP3/p5R6MdI0/0eplyuWVWzpOPtLdPQ016utO4P8A/PRs211cUm92rc/ESJhAAAAAAAAAAAAAAAAAAAAAB4q+zL4P7gKXgOIjKn2cRGs1q5LKnFNaJpfBlmBzmIxdqtaSliP0mGOap04yqWnhrRc1GPsNZXLxTS8DfEco8tMXzHiPF5KlnoYmceswFWdRR4hiMTVVWNSjJOtKWWMKyUndQStd8mjbER3tT5+Uf9pHX4nhP/sMPhHicZKlPBV61b/yq0ZVa3WQWZuLVu+yslttoaO97sz6rpz/AAXFVIYPhOPdfGVK9SeJpV1GvUm6tKnTrqMI05NxzJU4209rV3ZttEd61eXh+iI2Ix2eiuqq3jV4dVlWpxxmIxknVVWhKPXymlHrlm1UYq1+5o21jVufhMeUefyYz0d9WrKtKtlU87ePjUpudapWvCE3TVTaMVeMXGCW1tXqao5a+H/fuzdXxGnCphFCMpRhOnFQkoVJOKsmtFZrRc2jm595Vtw5JUqdtsqtyMVSQAAAAAAAAAAAAAAAAAAAAAPM9n8GByXRilONs1ScotLszpuLTUf3ufqaqTPR38TFJiZiI+GlysJSpdZJPIp1HVqNy0dRqKb120itDbNvNw1rMzqIaJTjJJwknF3aa2ZI1K2rNZ1PVpkisWaYEqivEglVq0Kcc05WjtrfV9yXNktMVjctmPFbJbu1jcq6ePhiI1IQVRZcspXjDtJ3slmv3Ex5ItPJt4jhb4YibTHPy9Fvw9fNU/oozcyQAAAAAAAAAAAAAAAAAAAAABiWwHHYGpGioVKk0oxhmnJKp7Ki23ZJrxtuaPq85enMTliaUjnM8uiFGspRruVTNhW5YinUnU1UXHNFxWs1o7WkuWmpjqbx6eDjxTl4XPMT4TqfH71VW41iMPThSpUOsbk3GVRSslPWKjGDefn7ye2iEzbHWIjm9HBhw8Zlte8zWI15fn4fNRY7j/EJyceslB7OFGlGKvvvZy5rnzMJyXnxeri7P4Ksb1v1mf4j5I3X42HbnXxa1jvWrpXlHMtL221sYza0c9y31xcJb3a0r4+EeHJ0HBOleIpySqPrqfPMkppeElv538jKua0debl4jsnBkj3Pdn5fh+zq+M4qNSFGtGWak00n3S5prk9PsMss7iJjo8/gcVsdr47Rq0I2BmsleWZJWpXcrKOrmrNtNczPhussO1eVab9f0ddwt/M07bZV4G+XkJQAAAAAAAAAAAAAAAAAAAAAADj4ytCzy/q2rdtNpxfLZmi3R6mGIm0a319P5VuKlBQSyS8XFqDvmunn1eistuRjXJFa6bcvBWy5Ztvq5fF4+rCs+xDq9JJudSU3UUXG71SWj3jZ3V3cwtkmXdw/Z2OkTznc/wApFGtWk+3mgs0IZYpRqVJtucdajsrJXu99N27liZnqZKYq/V58pn0jwnp59NeHPy081MBWn2Z1IxhnTSkqcHmlnau4pRzZdd7duOupJrM9WVM+KnOsTvXrPTXnz1v03ynlyT8LwGCcMzqaNupJwSSjnyr3mtMspN+KXMezhJ46071r05+m/KOvKI+K/wCG4SLg8sLqKzNfjbvFa7hpz5ZraNz15N9L9XiLXjpTfZjKT3lyjqzdg6y8/tD6tN+v6Ol4X+pp/RRul5qUAAAAAAAAAAAAAAAAAAAAAAA+f8Ptlnld185FqNao1fbWm1Zu6fPQ0zMd3T1KRb2sWmPiOskrZZfBxepoelrc7c7jYZp51o07+Zi6q25aV2M4tNOeWrJTk5OajHnCLeyXZdtU1ZtGyNua8YoiI10ZwfE32Kcq9TMnCla84KLlByjFK+isrb7qwmLeCxOLxiNzPPl4zzSeH8RoyatO+kWtHZxlazT7u0mSccwy9vWejqsNxOSpYedKbp9ZCrVUJQinWlCVGMKMlJXTk6slZWa8js4fHGp3DwuPyd7JGvJ0dLBazaklGTas4ZtFJ2e5rpXXOGObNFoito6evmt8NG0Iq7dlu7XfobHLLaEAAAAAAAAAAAAAAAAAAAAAAPmvBcQ41ZQcEpuU037Mmk29mk35XObUw9yZrasOilWVtYoNcRz5S5nicE3Umo2snJrvSMJh247TERG3Hqo6nzn6JGLqWyuWIy9Z8zK1uz+5OX/UYxe2ujpvhxRafe3MdeXw8yhhc37Gu1nlri2s/tXe101ndtrX0M4vZrthwfan8J8fiuOC0Kc606NTCxi8kaulZ1E12oK1kraNrTkxXJbemGbBjjH36zuJnXTXg+gYKnGMYqNOKUXJw7KeRyd5ON/Zv4G2Ly8u+OszzWuFfYXn97NlejhzfXlOpbIyansAAAAAAAAAAAAAAAAAAAAADzN2TfgwOdw1R2V366lmEiZjo91JJrVRf9Mf8GPdhnGW8eMq+uo69im7pxd47p7odyvkyjiMsf3SoZdHsJ/pMP8AVqL/AHGHsMfk6fpTi/8AJLMOj2D/ANJQ9Kn/ACHsMfkv0rxf+SVnwzhuHoycqeHowbVm4xd2vNljFSOkNWTj+JyRq95le0aq7o/VRl3YaJyXnxeqtV2308NDJhMzKy4ZK9KPn97IqUAAAAAAAAAAAAAAAAAAAAABiUrJvklcDl3dtuKyxbuo2ukisWuan/K/OwESq5dy9QI8pPuKEZPuAk0W/DzZBNp5v3l5JsDa4Pm5eaUUBe4Cd6cdLaWt8NCMkgAAAAAAAAAAAAAAAAAAAAADzUjdNd6a+wDmabsisWKlZ94EGtVYEaVRlCM2BJozILGhWfeFbZyu15gXHD42px836tkVJAAAAAAAAAAAAAAAAAAAAAAAc9xbDuE2/ck7p8k3uipKrqVCoiVJgaJTARqAb6UwJtGYE7CU5TeWPm+SXiQdHCNkktkrIjJ6AAAAAAAAAAAAAAAAAAAAAAAYlFNWaTXNPVMCFW4RRlvTt9Fyj9idi7NIlTo3RfvVV8JR/FDaaaX0VpfxKv8AZ/gbNMx6K0v4lX1h/wARs030+jlFfxH8Zf4SGzSVS4VRjtTX9TcvvZNrpMjFJWSSXclZAZAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH//Z");
    	
    	
    	
    	model.addAttribute("prod", p1);
        return "prod";
       }
    
    
    
}