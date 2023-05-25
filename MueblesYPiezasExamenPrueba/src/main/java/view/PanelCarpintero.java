package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.CarpinteroControlador;

import model.Carpintero;






public class PanelCarpintero extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	
	public PanelCarpintero() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		add(toolBar, gbc_toolBar);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarCarpinteroEnPantalla(CarpinteroControlador.findFirst());
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarCarpinteroEnPantalla(CarpinteroControlador.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarCarpinteroEnPantalla(CarpinteroControlador.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarCarpinteroEnPantalla(CarpinteroControlador.findLast());
			}
		});
		btnUltimo.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/gotoend.png")));
		toolBar.add(btnUltimo);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		btnNuevo.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/nuevo.png")));
		toolBar.add(btnNuevo);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/guardar.png")));
		toolBar.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/eliminar.png")));
		toolBar.add(btnEliminar);
		
		JLabel lblNewLabel = new JLabel("Gestion Carpintero");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id : ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.anchor = GridBagConstraints.NORTH;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 2;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre : ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 3;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido 1 : ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 4;
		add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido 2 :");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfApellido2 = new JTextField();
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 5;
		add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email : ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono :");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 7;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		cargarCarpinteroEnPantalla(CarpinteroControlador.findFirst());
	}
	/**
	 * 
	 * 
	 */
	private void cargarCarpinteroEnPantalla(Carpintero t) {
		if (t != null) {
			jtfId.setText("" + t.getId());
			jtfNombre.setText(t.getNombre());
			jtfApellido1.setText(t.getApellido1());
			jtfApellido2.setText(t.getApellido2());
			jtfEmail.setText(t.getEmail());
			jtfTelefono.setText(t.getTelefono());
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	private Carpintero cargarCarpinteroDesdePantalla() {
		Carpintero t = new Carpintero();
		t.setId(Integer.parseInt(jtfId.getText()));
		t.setNombre(jtfNombre.getText());
		t.setApellido1(jtfApellido1.getText());
		t.setApellido2(jtfApellido2.getText());
		t.setEmail(jtfEmail.getText());
		t.setTelefono(jtfTelefono.getText());
		
		return t ;
	}
	
	/**
	 * 
	 */
	private void guardar() {
		try {
			Carpintero t = cargarCarpinteroDesdePantalla();
			if(t.getNombre().trim().equals("")) {
				throw new Exception ("El nombre no puede estar vacio");
			}
			if(t.getApellido1().trim().equals("")) {
				throw new Exception ("El Primer Apellido no puede estar vacio");
			}
			if(t.getApellido2().trim().equals("")) {
				throw new Exception ("El Segundo Apellido no puede estar vacio");
			}
			if(t.getEmail().trim().equals("")) {
				throw new Exception ("El Email no puede estar vacio");
			}
			if (!(t.getEmail().matches(".+[@].+[.].+"))) {
				throw new Exception ("El correo electrónico no es válido");
			}
			
		
			CarpinteroControlador.guardar(t);
			jtfId.setText("" + t.getId());
			JOptionPane.showMessageDialog(null, "Guardado correcto");
		}
		catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "No ha sido posible guardar la Pieza: " + 
			ex.getMessage());
		}

	}
	
	/**
	 * 
	 */
	private void eliminar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opción se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar?", "Eliminación", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	try {
	    		Carpintero pActual = cargarCarpinteroDesdePantalla();
	    		CarpinteroControlador.eliminar(pActual);
	    	  
	    	  	JOptionPane.showMessageDialog(null, "Eliminado correctamente");
	    	  
				// Cargo otro registro en pantalla
	    	  	Carpintero pAnterior = CarpinteroControlador.findPrevious(pActual.getId());
				if (pAnterior != null) {
					cargarCarpinteroEnPantalla(pAnterior);
				}
				else {
					Carpintero pSiguiente = CarpinteroControlador.findNext(pActual.getId());
					if (pSiguiente != null) {
						cargarCarpinteroEnPantalla(pSiguiente);
					}
					else { // No quedan registros, has eliminado el único
						nuevo();
					}
				}
    		} catch (Exception e) {
    			JOptionPane.showMessageDialog(null, "Error al eliminar");
    		}          
	    }

	}
	private void nuevo() {
		jtfId.setText("0");
		jtfNombre.setText("");
		jtfApellido1.setText("");
		jtfApellido2.setText("");
		jtfEmail.setText("");
		jtfTelefono.setText("");
		
	}
	
	
}
