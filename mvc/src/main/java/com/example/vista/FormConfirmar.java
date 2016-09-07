package com.example.vista;

import java.util.ArrayList;
import java.util.Date;

import org.vaadin.dialogs.ConfirmDialog;

import com.example.controlador.Control;
import com.example.vista.RegistrarUser;
import com.example.vista.StartView;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;

public class FormConfirmar extends Window{
	public final static String VIEW_NAME="formConfirmar";
	protected static final String MESSAGE_1 = "Registro Exitoso";
	Navigator nav;
    TextField nombreApellN;
	TextField correoN;
	TextField cedulaN;
	ComboBox rif_pN;
	TextField rifN;
	HorizontalLayout hl_rifN;
	PopupDateField rif_venceN;
	ComboBox estadocivilN;
	boolean ent;
	Control c;
	public Vista vistaGeneradora;	//uso esta clase
	
	public FormConfirmar(Control c){
		
		super("Datos");
		this.c= c;
		setModal(true);
		center();
		ent= false;
		
		//ArrayList<Component> aux= vistaGeneradora.getCampos();
		FormLayout formaa= new FormLayout();
		formaa.setMargin(true);
		formaa.setSizeUndefined();
		
		nombreApellN= new TextField("Nombre Completo:");
		nombreApellN.focus();	
		nombreApellN.setWidth("210px");
		formaa.addComponent(nombreApellN);
				
		//nombreApellN.setPropertyDataSource(vistaGeneradora.getTextField("nombreApell"));
			
		correoN= new TextField("Correo:");
		correoN.setImmediate(true);
		correoN.getCaption();
		correoN.setWidth("210px");
		correoN.addValidator(new EmailValidator("correo invalido"));
		formaa.addComponent(correoN);
		
		//correoN.setPropertyDataSource(vistaGeneradora.getTextField("correo"));
		
		cedulaN = new TextField();
		cedulaN.setCaption("Numero de Cédula");
		cedulaN.setWidth("210px");
		cedulaN.setNullRepresentation("");
		formaa.addComponent(cedulaN);
		
		//cedulaN.setPropertyDataSource(vistaGeneradora.getTextField("cedula"));
		
		rif_pN = new ComboBox("");
		rif_pN.addItem("V-");
		rif_pN.addItem("E-");
		rif_pN.addItem("J-");
		rif_pN.setWidth("80px");
		rif_pN.setNullSelectionAllowed(false);

		//rif_pN.setPropertyDataSource(vistaGeneradora.getComboBox("rif_p"));
		
		rifN = new TextField();
		rifN.setCaption("");
		rifN.setWidth("130px");
		rifN.setInputPrompt("RIF");
		
		//rifN.setPropertyDataSource(vistaGeneradora.getTextField("rif"));
		
		hl_rifN = new HorizontalLayout();
		hl_rifN.setCaption("RIF");
		hl_rifN.setHeight("100%");
		hl_rifN.addComponents(rif_pN, rifN);
		formaa.addComponent(hl_rifN);
		
		
		rif_venceN = new PopupDateField();
		rif_venceN.setValue(new Date());
		rif_venceN.setWidth("210px");
		rif_venceN.addValueChangeListener(e -> Notification.show("Nueva Fecha:",
        		String.valueOf(e.getProperty().getValue()),
        		Type.TRAY_NOTIFICATION));
		formaa.addComponent(rif_venceN);
		
		//rif_venceN.setPropertyDataSource(vistaGeneradora.getPopupDateField("rif_vence"));

		estadocivilN= new ComboBox("Estado Civil");
		estadocivilN.addItem("Soltero");
		estadocivilN.addItem("Casado");
		estadocivilN.addItem("Divorciado");
		estadocivilN.addItem("Viudo");
		estadocivilN.setWidth("210px");
		formaa.addComponent(estadocivilN);
		
		//estadocivilN.setPropertyDataSource(vistaGeneradora.getComboBox("estadocivil"));
		
		Button boton= new Button("Editar");
		boton.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				//setVisible(false);
				close();
			}
		});
		
		Button boton1= new Button("Confirmar");
		boton1.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub							
				
				
				
				ConfirmDialog.show(UI.getCurrent(), MESSAGE_1,"","Aceptar","Crear mas Usuarios",
				        new ConfirmDialog.Listener() {

				            public void onClose(ConfirmDialog dialog) {	
				            	ent= false;
				                if (dialog.isConfirmed()) {
				                    // Confirmed to continue	
				                	c.navegar((StartView.VIEW_NAME));
				                } else {
				                    // User did not confirm			            
				                	//c.crearWindow(RegistrarUser.VIEW_NAME);
				                	c.navegar((StartView.VIEW_NAME));
				            
				                }
				               
				            }
				            
				        });
				
				//Notification nota= new Notification("Registro Exitoso!",Notification.Type.HUMANIZED_MESSAGE);
				//nota.setDelayMsec(-1);
				//nota.show(Page.getCurrent());	
				
				close();			
			}
		});
		
		for(Component s:formaa){
			s.setEnabled(false);
		}
		//formaa.setEnabled(false);
		//Esta parte debe ser delegada a las subclases
		HorizontalLayout n= new HorizontalLayout();
		n.setSpacing(true);
		n.addComponents(boton, boton1);
		formaa.addComponent(n);
		//Fin de la parte
		
		setContent(formaa);
		
	}
	
	public void setVistaGeneradora(Vista v){
		vistaGeneradora= v;
	}
	
	public void enlazarConPersistencia(){
		nombreApellN.setPropertyDataSource(vistaGeneradora.getTextField("nombreApell"));
		correoN.setPropertyDataSource(vistaGeneradora.getTextField("correo"));
		cedulaN.setPropertyDataSource(vistaGeneradora.getTextField("cedula"));
		rif_pN.setPropertyDataSource(vistaGeneradora.getComboBox("rif_p"));
		rifN.setPropertyDataSource(vistaGeneradora.getTextField("rif"));
		rif_venceN.setPropertyDataSource(vistaGeneradora.getPopupDateField("rif_vence"));
		estadocivilN.setPropertyDataSource(vistaGeneradora.getComboBox("estadocivil"));
	}

}
