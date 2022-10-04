package com.cursoJavaEx.projectwebservicesconsumer.client;

import java.time.LocalDateTime;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.cursoJavaEx.projectwebservicesconsumer.dto.EmpleadoDTO;



public class EmpleadoWSclient {
	public static  String url = "http://projectwebservices-env.eba-vnett5tt.us-east-1.elasticbeanstalk.com/cursoJavaEx/empleadosWS";
	
	public static void main(String[] args) {
		
		
		//:::::::::::::::::: GET::::::::::::::::
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url).path("consultarEmpleadoRecibiendoInfoResponse").path("3");
		
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		
		EmpleadoDTO employee = response.readEntity(EmpleadoDTO.class);
		
		System.out.println("Nombre Empleado: " + employee.getNombre());
		
		
		//:::::::::::::::: POST :::::::::::::::::::
		
//		Client client = ClientBuilder.newClient();
//		WebTarget webTarget = client.target("http://localhost:8080/project-webservice/cursoJavaEx/empleadosWS").path("guardarEmpleado");
//		
//		EmpleadoDTO emple = new EmpleadoDTO("6","Gorda","Pipa", "Motomami",3,LocalDateTime.now());
//		
//		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
//		Response response = invocationBuilder.post(Entity.entity(emple, MediaType.APPLICATION_JSON));
//		
//		System.out.println("Nombre Empleado: " + emple.getNombre());
	}

}
