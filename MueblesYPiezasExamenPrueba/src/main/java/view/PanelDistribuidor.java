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


import controller.DistribuidorControlador;

import model.Distribuidor;

import javax.swing.JComboBox;

public class PanelDistribuidor extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfDireccion;
	private JTextField jtfCodigoPostal;
	private JTextField jtfLocalidad;
	private JTextField jtfProvincia;
	private JTextField jtfTelefono;
	private JTextField jtfEmail;
	JComboBox jcbActivo;
	
	public PanelDistribuidor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				cargarDistribuidorEnPantalla(DistribuidorControlador.findFirst());
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDistribuidorEnPantalla(DistribuidorControlador.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDistribuidorEnPantalla(DistribuidorControlador.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDistribuidorEnPantalla(DistribuidorControlador.findLast());
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
		
		JLabel lblNewLabel = new JLabel("Gestion Distribuidor");
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
		
		JLabel lblNewLabel_3 = new JLabel("Direccion : ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 4;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("C\u00F3digo Postal :");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfCodigoPostal = new JTextField();
		GridBagConstraints gbc_jtfCodigoPostal = new GridBagConstraints();
		gbc_jtfCodigoPostal.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCodigoPostal.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigoPostal.gridx = 1;
		gbc_jtfCodigoPostal.gridy = 5;
		add(jtfCodigoPostal, gbc_jtfCodigoPostal);
		jtfCodigoPostal.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Localidad : ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfLocalidad = new JTextField();
		GridBagConstraints gbc_jtfLocalidad = new GridBagConstraints();
		gbc_jtfLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLocalidad.gridx = 1;
		gbc_jtfLocalidad.gridy = 6;
		add(jtfLocalidad, gbc_jtfLocalidad);
		jtfLocalidad.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Provincia :");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfProvincia = new JTextField();
		GridBagConstraints gbc_jtfProvincia = new GridBagConstraints();
		gbc_jtfProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_jtfProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfProvincia.gridx = 1;
		gbc_jtfProvincia.gridy = 7;
		add(jtfProvincia, gbc_jtfProvincia);
		jtfProvincia.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Telefono :");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 8;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Email :");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 9;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Activo :");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 10;
		add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		jcbActivo = new JComboBox();
		GridBagConstraints gbc_jcbActivo = new GridBagConstraints();
		gbc_jcbActivo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbActivo.gridx = 1;
		gbc_jcbActivo.gridy = 10;
		add(jcbActivo, gbc_jcbActivo);
		
		cargarElementosEnJCombo();
		cargarDistribuidorEnPantalla(DistribuidorControlador.findFirst());
	}
	
	/**
	 * 
	 * 
	 */
	private void cargarDistribuidorEnPantalla(Distribuidor t) {
		if (t != null) {
			jtfId.setText("" + t.getId());
			jtfNombre.setText(t.getNombre());
			jtfDireccion.setText(t.getDireccion());
			jtfCodigoPostal.setText(t.getCodigoPostal());
			jtfLocalidad.setText(t.getLocalidad());
			jtfProvincia.setText(t.getProvincia());
			jtfEmail.setText(t.getEmail());
			jtfTelefono.setText(t.getTelefono());
			
			if(t.getActivo()) {
				jcbActivo.setSelectedIndex(0);
			}else {
				jcbActivo.setSelectedIndex(1);
			}
		}
	}
	@SuppressWarnings("unchecked")
	private void cargarElementosEnJCombo() {
		jcbActivo.addItem("Si");
		jcbActivo.addItem("No");
	}
	
	/**
	 * 
	 * @return
	 */
	private Distribuidor cargarDistribuidorDesdePantalla() {
		
		Distribuidor t = new Distribuidor();
		t.setId(Integer.parseInt(jtfId.getText()));
		t.setNombre(jtfNombre.getText());
		t.setEmail(jtfEmail.getText());
		t.setTelefono(jtfTelefono.getText());
		t.setCodigoPostal(jtfCodigoPostal.getText());
		t.setDireccion(jtfDireccion.getText());
		t.setLocalidad(jtfLocalidad.getText());
		t.setProvincia(jtfProvincia.getText());
		boolean band = true ;
		boolean band1 = false ;
		if(jcbActivo.getSelectedIndex() == 0) {
			t.setActivo(band);
		}
		if(jcbActivo.getSelectedIndex() == 1) {
			t.setActivo(band1);
		}
		
		return t ;
	}
	/**
	 * 
	 */
	private void guardar() {
		try {
			Distribuidor t = cargarDistribuidorDesdePantalla();
			if(t.getNombre().trim().equals("")) {
				throw new Exception ("El nombre no puede estar vacio");
			}
			
			if(t.getEmail().trim().equals("")) {
				throw new Exception ("El Email no puede estar vacio");
			}
			if (!(t.getEmail().matches(".+[@].+[.].+"))) {
				throw new Exception ("El correo electrónico no es válido");
			}
			
		
			DistribuidorControlador.guardar(t);
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
	    		Distribuidor pActual = cargarDistribuidorDesdePantalla();
	    		DistribuidorControlador.eliminar(pActual);
	    	  
	    	  	JOptionPane.showMessageDialog(null, "Eliminado correctamente");
	    	  
				// Cargo otro registro en pantalla
	    	  	Distribuidor pAnterior = DistribuidorControlador.findPrevious(pActual.getId());
				if (pAnterior != null) {
					cargarDistribuidorEnPantalla(pAnterior);
				}
				else {
					Distribuidor pSiguiente = DistribuidorControlador.findNext(pActual.getId());
					if (pSiguiente != null) {
						cargarDistribuidorEnPantalla(pSiguiente);
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
		jtfDireccion.setText("");
		jtfCodigoPostal.setText("");
		jtfLocalidad.setText("");
		jtfProvincia.setText("");
		jtfEmail.setText("");
		jtfTelefono.setText("");
		jcbActivo.setSelectedIndex(1);
		
	}
	
}
