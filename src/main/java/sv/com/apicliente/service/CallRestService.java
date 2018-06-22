package sv.com.apicliente.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import sv.com.apicliente.model.Inventario;

@RequestMapping("/inventario")
@RestController
public class CallRestService{

	@GetMapping(value = "/")
    public static void consTodo() {
		RestTemplate restemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		String SourceUrl = "https://pacific-scrubland-61848.herokuapp.com/inventario/";
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<Inventario[]> response = restemplate.exchange(SourceUrl, HttpMethod.GET, entity, Inventario[].class);
		
		if(response.getStatusCode()==HttpStatus.OK) 
		{
			
			for(Inventario inventario : response.getBody())
			{
				System.out.println("ID:" + inventario.getId() + " ID Producto: " + inventario.getProducto() + " Existencias: " + inventario.getExistencias() + " Fecha: " + inventario.getFecha());
				
			}
			
		}
    }
	
	@GetMapping(value = "/{id}")
    public static void consById(@PathVariable(value = "id") Long Id) {
		RestTemplate restemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		String SourceUrl = "https://pacific-scrubland-61848.herokuapp.com/inventario/" + Id;
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<Inventario> response = restemplate.exchange(SourceUrl, HttpMethod.GET, entity, Inventario.class);
		
		if(response.getStatusCode()==HttpStatus.OK) 
		{
			
				System.out.println("ID:" + Id);
				
			
		}
    }
	
	@PostMapping(value = "/")
    public static void guarInven() {
		RestTemplate restemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String SourceUrl = "https://pacific-scrubland-61848.herokuapp.com/inventario/";
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		Inventario inventario = new Inventario();
		Long producto = 0L;
		Integer existencias = 0;
		String fecha = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        
        System.out.println("Ingrese Producto ID: ");
        producto = Long.parseLong(entradaEscaner.nextLine (), 10);
        inventario.setProducto(producto);
        
        System.out.println("Ingrese Existencias: ");
        existencias = Integer.parseInt(entradaEscaner.nextLine ());
		inventario.setExistencias(existencias);
		
		System.out.println("Ingrese Existencias: ");
		fecha = entradaEscaner.nextLine ();
	    Date date=Date.valueOf(fecha); 
		inventario.setFecha(date); 
		ResponseEntity<Inventario> response = restemplate.exchange(SourceUrl, HttpMethod.POST, new HttpEntity<>(inventario, headers), Inventario.class);
		//Inventario response = restemplate.postForObject(SourceUrl, new HttpEntity<>(inventario, headers), Inventario.class);
		if(response.getStatusCode()==HttpStatus.OK) 
		{

				System.out.println("ID: " + inventario.getId() + " Producto: " + inventario.getProducto() + " Existencias: " + inventario.getFecha());

		}
    }
	
	@DeleteMapping(value = "/")
    public static void elimInven() {
		RestTemplate restemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String SourceUrl = "https://pacific-scrubland-61848.herokuapp.com/inventario/";
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		String entityUrl = SourceUrl + "/" + entradaTeclado;
		restemplate.delete(entityUrl);

				System.out.println("Se elimino el Inventario con ID: " + entradaTeclado);
    }

}
