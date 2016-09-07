package com.example.vista;

import com.example.controlador.Control;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;

import modelo.FormPSRapido;
import modelo.Formulario;

public class FormPSRapidoView extends Vista{

	public final static String VIEW_NAME="formPSRapido";
	
	TextField univ;
	TextField titulo;
	TextField especialidad;
	TextField colegio;
	FormPSRapido formul;
	FormPSRapidoView instancia;
	
	Navigator nav;
	Control c;
	
	public FormPSRapidoView(Control c) {
		this.c= c;
		
		c.addVista(FormPSRapidoView.VIEW_NAME,this);
		Panel pan= new Panel("Registro Rapido de Médico");
		pan.setSizeUndefined();
		forma.setMargin(true);
		pan.setContent(forma);
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);						
		forma.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);
		setMargin(true);
		
		instancia= this;
		
		univ= new TextField("Universidad de graduación:");
		univ.focus();
		univ.setWidth("210px");
		forma.addComponent(univ);
		titulo= new TextField("Título obtenido:");
		titulo.focus();
		titulo.setWidth("210px");
		forma.addComponent(titulo);
		especialidad= new TextField("Especialidades:");
		especialidad.focus();
		especialidad.setWidth("210px");
		especialidad.setInputPrompt("Internista, Neumonólogo");
		forma.addComponent(especialidad);
		colegio= new TextField("# de Colegio de Médicos:");
		colegio.focus();
		colegio.setWidth("210px");
		forma.addComponent(colegio);
		
		
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
		
		univ.setPropertyDataSource(formul.getlaUnivProp());
		//rif_pN.setPropertyDataSource(rif_p);
		titulo.setPropertyDataSource(formul.getelTituloProp());
		//rifN.setPropertyDataSource(rif);
		especialidad.setPropertyDataSource(formul.getlaEspecialidadProp());
		//rif_venceN.setPropertyDataSource(rif_vence);
		colegio.setPropertyDataSource(formul.getelColegioProp());
		//&estadocivilN.setPropertyDataSource(estadocivil);
	}

	public void setFormulario(Formulario h){
		formul= (FormPSRapido) h;
	}
	
	public TextField getTextField(String tipo){
		switch (tipo){
			case "nombreApell": return nombreApell;
			case "correo": return correo;
			case "cedula": return cedula;
			case "rif": return rif;
			//case "telefono": return telefono;
			default : return new TextField();
			
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

	@Override
	public TextArea getTextArea(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

}
