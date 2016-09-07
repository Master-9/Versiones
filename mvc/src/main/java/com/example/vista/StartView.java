package com.example.vista;

import com.example.controlador.Control;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

import modelo.Formulario;

import com.vaadin.ui.Button.ClickEvent;

public class StartView extends Vista {

	public final static String VIEW_NAME="";
	Navigator nav;
	Control c;
	
	public StartView(Control c){
		this.c= c;
		 Button btn_register_ps = new Button("Crear Usuario",new Button.ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					c.crearWindow(RegistrarUser.VIEW_NAME);
				}
			});

	        /*Nav button to login view*/
	        Button btn_login = new Button("Entrar", new Button.ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					c.crearWindow(Autenticar.VIEW_NAME);
				}
			});
	    
	        setSpacing(true);

	       
	        btn_login.setDescription("Ingresar");
	        btn_login.setHeight("40px");
	        btn_login.setWidth("130px");
	        
	        
	        btn_register_ps.setDescription("Crear un nuevo Usuario");
	        btn_register_ps.setHeight("40px");
	        btn_register_ps.setWidth("130px");
	        
	        
	        
	        final HorizontalLayout hor = new HorizontalLayout();
	        
	        
	        hor.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);
	        
	       
	        Resource logo = new ThemeResource("gsami3.jpg");
	        HorizontalLayout panelSupe= new HorizontalLayout();
	        panelSupe.addComponents(btn_login,btn_register_ps);
	        panelSupe.setWidth("280px");
	        
	        
	        HorizontalLayout panelIzq= new HorizontalLayout();
	        ComboBox pais= new ComboBox("Elija un Pais");
			pais.addItem("Venezuela");
			pais.addItem("Colombia");
			pais.addItem("Uruguay");
			pais.addItem("España");
			pais.addItem("Escocia");
			pais.addItem("Egipto");
			pais.addItem("Panana");
			pais.addItem("United States");
			pais.addItem("United Kingdom");
			pais.setNullSelectionAllowed(false);
			panelIzq.addComponents(pais);
			panelIzq.setStyleName("izq");
	       
	        
	        hor.addComponents(panelIzq,panelSupe);
	        hor.setStyleName("barraSup");
	        //panelSupe.setSpacing(true);
	        //panelSupe.setMargin(true);
	        hor.setSizeFull();
	        hor.setHeight("80px");
	        //panelSupe.setContent(hor);
	        

	        
	        
	        Panel barra= new Panel();
	        barra.setSizeUndefined();
	        barra.setIcon(logo);
	        addComponents(hor,barra);
	        setComponentAlignment(hor, Alignment.TOP_LEFT);
	        hor.setComponentAlignment(panelIzq, Alignment.TOP_LEFT);
	        
	        setComponentAlignment(barra, Alignment.MIDDLE_CENTER);
	      
	        
	        
	        //setMargin(true);
	        setSpacing(true);
	        setHeight("800px");
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public TextField getTextField(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComboBox getComboBox(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PopupDateField getPopupDateField(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFormulario(Formulario h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TextArea getTextArea(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

}
