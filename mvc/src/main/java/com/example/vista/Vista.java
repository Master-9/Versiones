package com.example.vista;

import java.util.ArrayList;
import java.util.Date;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Notification.Type;

import modelo.Formulario;

public abstract class Vista extends VerticalLayout implements View {
	
	Navigator nav;
	//public final static String VIEW_NAME="";
	//protected Formulario formul;
	protected FormLayout forma;
	protected TextField nombreApell;
	protected TextField correo;
	protected TextField cedula;
	protected ComboBox rif_p;
	protected TextField rif;
	protected HorizontalLayout hl_rif;
	protected PopupDateField rif_vence;
	protected ComboBox estadocivil;
	protected Button btn_guardar;
	
	
	public Vista(){
		setHeight("800px");
		this.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		forma= new FormLayout();
		
		nombreApell= new TextField("Nombre Completo:");
		nombreApell.focus();	
		nombreApell.setWidth("210px");
		nombreApell.setInputPrompt("Ricardo Cáseres");
		forma.addComponent(nombreApell);
		
		//nombreApell.setPropertyDataSource(formul.getelNombreApellProp());	
		//FormConfirmar.nombreApellN.setPropertyDataSource(nombreApell);
		
		correo= new TextField("Correo:");
		correo.setImmediate(true);
		correo.getCaption();
		correo.setWidth("210px");
		correo.addValidator(new EmailValidator("correo invalido"));
		forma.addComponent(correo);
		
		//correo.setPropertyDataSource(formul.getelCorreoProp());
		//FormConfirmar.correoN.setPropertyDataSource(correo);
		
		cedula = new TextField();
		cedula.setCaption("Numero de Cédula");
		cedula.setWidth("210px");
		cedula.setInputPrompt("25123456");
		cedula.setRequired(true);
		forma.addComponent(cedula);
		
		//cedula.setPropertyDataSource(formul.getlaCedulaProp());
		//FormConfirmar.cedulaN.setPropertyDataSource(cedula);
		
		rif_p = new ComboBox("");
		rif_p.addItem("V-");
		rif_p.addItem("E-");
		rif_p.addItem("J-");
		rif_p.setWidth("80px");
		rif_p.setNullSelectionAllowed(false);
		
		//rif_p.setPropertyDataSource(formul.getelRif_pProp());
		//FormConfirmar.rif_pN.setPropertyDataSource(rif_p);

		rif = new TextField();
		rif.setCaption("");
		rif.setWidth("130px");
		rif.setInputPrompt("RIF");
		
		//rif.setPropertyDataSource(formul.getelRifProp());
		//FormConfirmar.rifN.setPropertyDataSource(rif);
		
		hl_rif = new HorizontalLayout();
		hl_rif.setCaption("RIF");
		hl_rif.setHeight("100%");
		hl_rif.addComponents(rif_p, rif);
		forma.addComponent(hl_rif);
		
		rif_vence = new PopupDateField();
		rif_vence.setValue(new Date());
		rif_vence.setWidth("210px");
		rif_vence.setDescription("Fecha de vencimiento del RIF");
		//rif_vence.addValueChangeListener(e -> Notification.show("Nueva Fecha:",
        		//String.valueOf(e.getProperty().getValue()),
        		//Type.TRAY_NOTIFICATION));
		forma.addComponent(rif_vence);
		
		//rif_vence.setPropertyDataSource(formul.getelRif_venceProp());
		//FormConfirmar.rif_venceN.setPropertyDataSource(rif_vence);
		
		estadocivil= new ComboBox("Estado Civil");
		estadocivil.addItem("Soltero");
		estadocivil.addItem("Casado");
		estadocivil.addItem("Divorciado");
		estadocivil.addItem("Viudo");
		estadocivil.setWidth("210px");
		forma.addComponent(estadocivil);
		
		btn_guardar= new Button("guardar");
	}
	
	public abstract void setFormulario(Formulario h);
	
	
	public ArrayList<Component> getCampos(){
		ArrayList<Component> res= new ArrayList<>();
		
			for(Component a:forma){
				res.add(a);
			}	
		return res;
	}
	
	public abstract TextField getTextField(String tipo);
	public abstract TextArea getTextArea(String tipo);
	public abstract ComboBox getComboBox(String tipo);
	public abstract PopupDateField getPopupDateField(String tipo);
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
