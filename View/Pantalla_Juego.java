package View;

import javax.swing.JFrame;

import Logica.Controlador;
import Logica.Funciones;


import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Pantalla_Juego implements Funciones {

	private JFrame frame;
	private Controlador controlador;
	public JMenu mnOpciones;
	public JMenuItem mntmNuevoJuego;
	public JCheckBox chckbxFizz;
	public JCheckBox chckbxBuzz;
	public JButton btnOk;
	private JLabel lblnumero;
	private JLabel lblNmeroParaEl;
	private JLabel lblNmeroParaEl_1;
	private JLabel lblTiempo;
	public JTextField txtfizz;
	public JTextField txtbuzz;
	public JButton btnGuardarCambios;
	public javax.swing.Timer Tiempo;
	private JLabel lbltiempo;
	public JTextField txttiempo;



	public Pantalla_Juego(Controlador control) {
		controlador=control;
		controlador.setPantalla(this);
		initialize();
		addEvents();
		
	}

	private void addEvents() {
		this.mnOpciones.addActionListener(controlador);
		this.mntmNuevoJuego.addActionListener(controlador);
		this.btnOk.addActionListener(controlador);
		this.btnGuardarCambios.addActionListener(controlador);
		
		
	}


	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setBounds(100, 100, 660, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		lbltiempo = new JLabel("");
		lbltiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltiempo.setForeground(new Color(51, 51, 51));
		lbltiempo.setBounds(566, 28, 66, 34);
		frame.getContentPane().add(lbltiempo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		frame.getContentPane().add(menuBar);
		
		mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		mntmNuevoJuego = new JMenuItem("Nuevo Juego");
		mnOpciones.add(mntmNuevoJuego);
		
		lblnumero = new JLabel("");
		lblnumero.setForeground(Color.BLUE);
		lblnumero.setBounds(259, 70, 98, 45);
		frame.getContentPane().add(lblnumero);
		lblnumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblnumero.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 20));
		
		btnOk = new JButton("");
		btnOk.setIcon(new ImageIcon(Pantalla_Juego.class.getResource("/Imagenes/button.png")));
		btnOk.setEnabled(false);
		btnOk.setBounds(259, 171, 89, 50);
		frame.getContentPane().add(btnOk);
		btnOk.setBorderPainted(false);
		btnOk.setOpaque(false);
		btnOk.setContentAreaFilled(false);
		
		chckbxFizz = new JCheckBox("");
		chckbxFizz.setBounds(271, 123, 40, 40);
		frame.getContentPane().add(chckbxFizz);
		this.chckbxFizz.setOpaque(false);
		
		chckbxBuzz = new JCheckBox("");
		chckbxBuzz.setBounds(271, 234, 97, 23);
		chckbxBuzz.setOpaque(false);
		frame.getContentPane().add(chckbxBuzz);
		
		lblNmeroParaEl = new JLabel("N\u00FAmero para el fizz");
		lblNmeroParaEl.setBounds(12, 350, 132, 14);
		frame.getContentPane().add(lblNmeroParaEl);
		
		txtfizz = new JTextField();
		txtfizz.setText("3");
		txtfizz.setBounds(188, 347, 126, 20);
		frame.getContentPane().add(txtfizz);
		txtfizz.setColumns(10);
		
		lblNmeroParaEl_1 = new JLabel("N\u00FAmero para el buzz");
		lblNmeroParaEl_1.setBounds(12, 324, 169, 14);
		frame.getContentPane().add(lblNmeroParaEl_1);
		
		txtbuzz = new JTextField();
		txtbuzz.setText("5");
		txtbuzz.setBounds(188, 321, 126, 20);
		frame.getContentPane().add(txtbuzz);
		txtbuzz.setColumns(10);
		
		btnGuardarCambios = new JButton("Jugar con estos valores");
		btnGuardarCambios.setBounds(376, 346, 182, 23);
		frame.getContentPane().add(btnGuardarCambios);
		
		lblTiempo = new JLabel("Tiempo");
		lblTiempo.setBounds(12, 376, 116, 14);
		frame.getContentPane().add(lblTiempo);
		
		txttiempo = new JTextField();
		txttiempo.setText("30");
		txttiempo.setBounds(188, 373, 126, 20);
		frame.getContentPane().add(txttiempo);
		txttiempo.setColumns(10);
		
		JLabel lblimagen = new JLabel("");
		lblimagen.setIcon(new ImageIcon(Pantalla_Juego.class.getResource("/Imagenes/Fondo.jpg")));
		lblimagen.setBounds(0, 0, 650, 441);
		frame.getContentPane().add(lblimagen);
	}


	@Override
	public void continuar_jugando(int numero) {
		this.lblnumero.setText(Integer.toString(numero));
		this.chckbxBuzz.setSelected(false);
		this.chckbxFizz.setSelected(false);
		
	}

	@Override
	public void terminar() {
		this.chckbxBuzz.setEnabled(false);
		this.chckbxFizz.setEnabled(false);
		this.Tiempo.stop();
		JOptionPane.showMessageDialog(frame, "Juego Terminado.Has perdido");
	}

	@Override
	public void actualizar_tiempo(int segundos) {
	
		lbltiempo.setText(Integer.toString(segundos));
		 
		
	}

	@Override
	public void mostrar_configuración(int fizz_number, int buzz_number) {
		this.txtfizz.setText(Integer.toString(fizz_number));
		this.txtbuzz.setText (Integer.toString(buzz_number));
		
		
	}

	@Override
	public void iniciar(int numero, int fizz_number, int buzz_number, int tiempo) {
		this.chckbxBuzz.setEnabled(true);
		this.chckbxFizz.setEnabled(true);
		this.btnOk.setEnabled(true);
		this.btnOk.setBorderPainted(false);
		this.lblnumero.setText(Integer.toString(numero));
		this.chckbxBuzz.setSelected(false);
		this.chckbxFizz.setSelected(false);
		this.txtbuzz.setText(Integer.toString(fizz_number));
		this.txtfizz.setText(Integer.toString(buzz_number));
		this.txttiempo.setText(Integer.toString(tiempo));
		
		
		Tiempo =new javax.swing.Timer(1000, controlador);
		Tiempo.start();
	}
	
	
}
