package modelo;

import com.example.controlador.Control;
import com.vaadin.data.util.ObjectProperty;

public class FormPaciente extends Formulario {
	String elTelefono="";
	String elArea="";
	
	ObjectProperty<String> elTelefonoProp;
	ObjectProperty<String> elAreaProp;
	
	public FormPaciente(Control c){
		super(c);
		
		elTelefonoProp= new ObjectProperty<>(elTelefono,String.class); 
		elAreaProp= new ObjectProperty<>(elArea,String.class);	
	}
	
	public ObjectProperty<String> getelTelefonoProp(){
		return elTelefonoProp;
	}
	public ObjectProperty<String> getelAreaProp(){
		return elAreaProp;
	}

}
