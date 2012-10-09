package Pantallas;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JFrame;

import com.jpcomponents.JPCalendar;
import com.jpcomponents.events.IJPCalendarDateListener;
import com.jpcomponents.events.JPCalendarEvent;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;

public class Calendario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPCalendar cal=null;
	/**
	 * This is the default constructor
	 */
	public Calendario() {
		super();
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

			@Override
			public void onDateChanged(JPCalendarEvent arg0) {
				SimpleDateFormat formateador = new SimpleDateFormat("dd'-'MM'-'yyyy", new Locale("es_ES"));
				
		          String fecha=formateador.format(arg0.getCalendar().getTime());
				System.out.println(fecha);
				OrdenTrabajo.FechaConfeccion.setText(fecha);
				
				
				
			}
		
           

			
			

			
});


		
		return cal;
		
	}
	private JCalendar calendario(){
		JCalendar cal=new JCalendar();
	
		return cal;
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getCalendarioII());
		}
		return jContentPane;
	}

}
