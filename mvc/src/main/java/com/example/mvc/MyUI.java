package com.example.mvc;

import javax.servlet.annotation.WebServlet;

import com.example.controlador.Control;
import com.example.vista.StartView;
import com.example.vista.FormPSRapidoView;
import com.example.vista.FormPacienteView;
import com.example.vista.RegisterPS_options;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Navigator navegador;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	navegador = new Navigator(this,this);
    	Control mando= new Control();
    	
    	
    	navegador.addView(StartView.VIEW_NAME, new StartView(mando));
    	navegador.addView(RegisterPS_options.VIEW_NAME, new RegisterPS_options(mando) );
    	navegador.addView(FormPSRapidoView.VIEW_NAME, new FormPSRapidoView(mando) );
    	navegador.addView(FormPacienteView.VIEW_NAME, new FormPacienteView(mando) );
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
