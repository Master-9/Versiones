package com.example.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.vista.Vista;
import com.example.vista.Autenticar;
import com.example.vista.FormConfirmar;
import com.example.vista.FormPSRapidoView;
import com.example.vista.FormPacienteView;
//import com.example.vista.FormPacienteView;
import com.example.vista.RegisterPS_options;
import com.example.vista.RegistrarUser;
import com.example.vista.StartView;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import modelo.FormPSRapido;
import modelo.FormPaciente;
import modelo.Formulario;

public class Control {
	Navigator nav;
	Map<String,Vista> mapaVistas;
	
	public Control(){
		mapaVistas= new HashMap<String,Vista>();
	}
	private ArrayList<Vista> views= new ArrayList<>();
	public  void addVista(String nombre,Vista v){
		mapaVistas.put(nombre, v);
		views.add(v);
	}
	
	public void navegar(String destino){
		nav= UI.getCurrent().getNavigator();
		nav.navigateTo(destino);
	}
	
	public Window crearWindow(String tipo){
		UI ui= UI.getCurrent();
		Window uu= null;
		switch (tipo){
			case "registrarUser": uu= new RegistrarUser(this);
			break;
			case "autenticar": uu= new Autenticar(this);
			break;
			case "formConfirmar": uu= new FormConfirmar(this);
			break;
		}
	    ui.addWindow(uu);
	    return uu;
	}
	
	public void enruta(String v){
		UI ui = UI.getCurrent();
		nav = ui.getNavigator();
		switch (v){
			case "Medico": nav.navigateTo(RegisterPS_options.VIEW_NAME);
						   break;
			case "Paciente": //views.get(0).setFormulario(new FormPaciente(this));
							 mapaVistas.get(FormPacienteView.VIEW_NAME).setFormulario(new FormPaciente(this));
							 //crearWindow("formConfirmar");
							 nav.navigateTo(FormPacienteView.VIEW_NAME);
							 break;
			case "Contador": nav.navigateTo(StartView.VIEW_NAME);
							 break;
			case "formPSRapido": //views.get(1).setFormulario(new FormPSRapido(this));
			 					 mapaVistas.get(FormPSRapidoView.VIEW_NAME).setFormulario(new FormPSRapido(this));
			 					 //crearWindow("formConfirmar");
			 					 nav.navigateTo(FormPSRapidoView.VIEW_NAME);
			 					 break;
			default : navegar(v);
					  break;	
		}	
	}
	
	//public Vista getVista(int n){
		//return views.get(n);
	//}
	
	
	
	
}
