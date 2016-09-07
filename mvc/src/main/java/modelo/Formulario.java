package modelo;

import java.util.Date;

import com.example.controlador.Control;
import com.vaadin.data.util.ObjectProperty;

public class Formulario {	
	Control c;
	String elNombreApell="";
	String elCorreo="";
	Integer laCedula= null;
	String elRif_p="";
	String elRif="";
	Date elRif_vence= new Date();
	String elEstadocivil="";
	
	ObjectProperty<String> elNombreApellProp; 
	ObjectProperty<String> elCorreoProp;
	ObjectProperty<Integer> laCedulaProp;
	ObjectProperty<String> elRif_pProp;		
	ObjectProperty<String> elRifProp;
	ObjectProperty<Date> elRif_venceProp;	
	ObjectProperty<String> elEstadocivilProp;	
	
	public Formulario(Control c){
		this.c= c;
		
		elNombreApellProp= new ObjectProperty<>(elNombreApell,String.class); 
		elCorreoProp= new ObjectProperty<>(elCorreo,String.class);
		laCedulaProp= new ObjectProperty<>(laCedula,Integer.class);
		elRif_pProp= new ObjectProperty<>(elRif_p,String.class);		
		elRifProp= new ObjectProperty<>(elRif,String.class);
		elRif_venceProp= new ObjectProperty<>(elRif_vence,Date.class);	
		elEstadocivilProp= new ObjectProperty<>(elEstadocivil,String.class);	
		
	}
	
	public ObjectProperty<String> getelNombreApellProp(){
		return elNombreApellProp;
	}
	public ObjectProperty<String> getelCorreoProp(){
		return elCorreoProp;
	}
	public ObjectProperty<Integer> getlaCedulaProp(){
		return laCedulaProp;
	}
	public ObjectProperty<String> getelRif_pProp(){
		return elRif_pProp;
	}
	public ObjectProperty<String> getelRifProp(){
		return elRifProp;
	}
	public ObjectProperty<Date> getelRif_venceProp(){
		return elRif_venceProp;
	}
	public ObjectProperty<String> getelEstadocivilProp(){
		return elEstadocivilProp;
	}
	
	
}
