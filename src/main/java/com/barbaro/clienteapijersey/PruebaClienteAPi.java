/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbaro.clienteapijersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ericknavarro
 */
public class PruebaClienteAPi {
    
    
    public static final String URI_BASE = "http://localhost:8080/ApiDisfraces/api/";
    
    public static void main(String[] args) {
        
        /*
        Crea una instancia que permitirá reazlizar una petición HTTP
        let request = XMLHTTP
        */
        
        Client cliente = ClientBuilder.newClient();
        
        //Indicando la dirección a donde se ca a dirigira petición
        WebTarget target = cliente.target(URI_BASE);
        
        //Seleciona el recurso específico que voy a buscar
        WebTarget targetDisfraz = target.path("partes");
        
        //Conficgurar peticion que responde un MIME TYPE JSON
        //Obtener la petición
        Invocation.Builder request =  targetDisfraz.request(MediaType.APPLICATION_JSON_TYPE);
        
        //Obtener la respuesta de la petición de tipo GET
        Response response = request.get();
         
        //Procesar respuesta para conertirla en JSON
        String jsonResponse = response.readEntity(String.class);
        
        String palabra = "Tacoz de cabezay de doz pesoz";
        
        char a[] = jsonResponse.toCharArray();
        String b = "";
        
        
        for (int i = 0; i<a.length; i++){
            
            b += a[i];
            
            if(a[i] == ',' || a[i] == '{' || a[i] == '}'){
                
                System.out.print(b);
                System.out.println("");
                b = "";
                
            } 
        
        }
        
        
    }
    
}
