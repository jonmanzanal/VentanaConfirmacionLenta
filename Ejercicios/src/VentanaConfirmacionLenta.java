

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaConfirmacionLenta extends JFrame{
	private JLabel l;
	private JTextField texto;
	JButton boton;
	
	 VentanaConfirmacionLenta(){
		 this.setLayout(new FlowLayout());
		 l=new JLabel("Meta texto");
		 this.add(l);
		 texto=new JTextField(20);
		
		 this.add(texto);
		 boton=new JButton("Confirmar");
		 boton.setEnabled(true);
		 this.add(boton);
		 
		 this.setVisible(true);
		 this.setSize(250, 200);
		 boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boton.setEnabled(false);
				Runnable r=new Runnable() {
				
					@Override
					public void run() {
						try {
							procesoConfirmar();
							boton.setEnabled(true);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						 
					}
					 
				};
				Thread hilo = new Thread (r);
				hilo.start();
			     
			}
			
		});
		
	
	 }
	 private static Random r = new Random();
		
		private static void procesoConfirmar() {
			try {
				
				Thread.sleep( 5000 + 1000*r.nextInt(6) );
				System.out.println("guardado");
				
			} catch (InterruptedException e) {}
		}

	 
	 
	
	
	public static void main(String[] args) {
		new VentanaConfirmacionLenta();

	}

}
