package Pantallas;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.jpcomponents.JPCalendar;
import com.jpcomponents.events.IJPCalendarDateListener;
import com.jpcomponents.events.JPCalendarEvent;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.text.JTextComponent;

public class Calendario extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPCalendar cal=null;
	private String fecha;
	private String nombreCampo;
	/**
	 * This is the default constructor
	 */
	public Calendario(JTextField campo) {
		super();
		this.nombreCampo=campo.getName();
		
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setContentPane(getJContentPane());
		
		
		this.setTitle("Calendario");
	}
	
	
	private JPCalendar getCalendarioII(){
		cal=new JPCalendar();
		cal.addDateChangeListener(new IJPCalendarDateListener() {

			
			public void onDateChanged(JPCalendarEvent arg0) {
				SimpleDateFormat formateador = new SimpleDateFormat("yyyy'-'MM'-'dd", new Locale("es_ES"));
				
		         fecha =formateador.format(arg0.getCalendar().getTime());
		        
				System.out.println(fecha);
				if(nombreCampo.equals("FechaConfeccion")){
				OrdenTrabajo.FechaConfeccion.setText(fecha);
				dispose();
				}
				if(nombreCampo.equals("Fechaprometida")){
					OrdenTrabajo.FechaPrometida.setText(fecha);
					dispose();
					}
		         
				
			}
				
});

		return cal;
		
	}
	
	
	String getFecha(){
		return this.fecha;
	}
	
	

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getCalendarioII());
		}
		return jContentPane;
	}

}
