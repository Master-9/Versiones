package com.example.vista;

import java.util.ArrayList;
import java.util.Date;

import com.example.controlador.Control;
import com.example.vista.FormConfirmar;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;

import modelo.FormPSRapido;
import modelo.FormPaciente;
import modelo.Formulario;

import com.vaadin.ui.Notification.Type;

public class FormPacienteView extends Vista{
	public final static String VIEW_NAME="formPaciente";
	Navigator nav;	
	Control c;
	TextField telefono;
	TextArea area;
	FormPaciente formul;
	
	FormPacienteView instancia;
	
	public FormPacienteView(Control c){
		this.c = c;
		c.addVista(FormPacienteView.VIEW_NAME,this);
		Panel pan= new Panel("Registro de Paciente");
		pan.setSizeUndefined();
		forma.setMargin(true);
		pan.setContent(forma);
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);						
		forma.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);
		setMargin(true);
	
		instancia= this;
						
		//estadocivil.setPropertyDataSource(formul.getelEstadocivilProp());
		//FormConfirmar.estadocivilN.setPropertyDataSource(estadocivil);
		
		telefono = new TextField();
		telefono.setCaption("Teléfono");
		telefono.focus();
		telefono.setWidth("210px");
		forma.addComponent(telefono);
		
		area= new TextArea();
		area.setCaption("Direccion");
		area.focus();
		area.setWidth("210px");
		forma.addComponent(area);
		
		
		rif_vence.addValueChangeListener(e -> Notification.show("Nueva Fecha:",
        		String.valueOf(e.getProperty().getValue()),
        		Type.TRAY_NOTIFICATION));
		
		
		btn_guardar.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {				
				// TODO Auto-generated method stub
																					
				FormConfirmar vv= (FormConfirmar)c.crearWindow(FormConfirmar.VIEW_NAME);
				vv.setVistaGeneradora(instancia);
				vv.enlazarConPersistencia();
			}
		});
		
		forma.addComponent(btn_guardar);
		
		addComponent(pan);
		
		
		
		
	}
	
	public FormLayout getForma(){
		return forma;
	}
	
	public TextField getTextField(String tipo){
		switch (tipo){
			case "nombreApell": return nombreApell;
			case "correo": return correo;
			case "cedula": return cedula;
			case "rif": return rif;
			case "telefono": return telefono;
			default : return new TextField();
			
		}	
	}
	
	public TextArea getTextArea(String tipo){
		switch (tipo){
			case "area": return area;
			default : return new TextArea();	
		}
	}
	
	public ComboBox getComboBox(String tipo){
		switch(tipo){
			case "rif_p": return rif_p;
			case "estadocivil": return estadocivil;
			default : return new ComboBox();
		}
	}
	
	public PopupDateField getPopupDateField(String tipo){
		switch(tipo){
		case "rif_vence": return rif_vence;
		default : return new PopupDateField();
		}
	}
	
	public void setFormulario(Formulario h){
		formul= (FormPaciente) h;
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		nombreApell.setPropertyDataSource(formul.getelNombreApellProp());		
		cedula.setNullRepresentation("");
		correo.setPropertyDataSource(formul.getelCorreoProp());
		//correoN.setPropertyDataSource(correo);
		cedula.setPropertyDataSource(formul.getlaCedulaProp());
		//cedulaN.setPropertyDataSource(cedula);
		rif_p.setPropertyDataSource(formul.getelRif_pProp());
		//rif_pN.setPropertyDataSource(rif_p);
		rif.setPropertyDataSource(formul.getelRifProp());
		//rifN.setPropertyDataSource(rif);
		rif_vence.setPropertyDataSource(formul.getelRif_venceProp());
		//rif_venceN.setPropertyDataSource(rif_vence);
		estadocivil.setPropertyDataSource(formul.getelEstadocivilProp());
		//&estadocivilN.setPropertyDataSource(estadocivil);
		
		telefono.setPropertyDataSource(formul.getelTelefonoProp());
		area.setPropertyDataSource(formul.getelAreaProp());

	}
}
