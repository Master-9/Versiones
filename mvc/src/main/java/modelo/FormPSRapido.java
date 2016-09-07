package modelo;

import com.example.controlador.Control;
import com.vaadin.data.util.ObjectProperty;

public class FormPSRapido extends Formulario{
	String laUniv="";
	String elTitulo="";
	String laEspecialidad="";
	String elColegio="";
	
	ObjectProperty<String> laUnivProp;
	ObjectProperty<String> elTituloProp;
	ObjectProperty<String> laEspecialidadProp;
	ObjectProperty<String> elColegioProp;
	
	public FormPSRapido(Control c){
		super(c);
		laUnivProp= new ObjectProperty<>(laUniv,String.class); 
		elTituloProp= new ObjectProperty<>(elTitulo,String.class);	
		laEspecialidadProp= new ObjectProperty<>(laEspecialidad,String.class); 
		elColegioProp= new ObjectProperty<>(elColegio,String.class);	
		
	}
	
	public ObjectProperty<String> getlaUnivProp(){
		return laUnivProp;
	}
	public ObjectProperty<String> getelTituloProp(){
		return elTituloProp;
	}
	public ObjectProperty<String> getlaEspecialidadProp(){
		return laEspecialidadProp;
	}
	public ObjectProperty<String> getelColegioProp(){
		return elColegioProp;
	}

}
