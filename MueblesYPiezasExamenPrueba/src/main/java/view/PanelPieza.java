package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.MuebleControlador;
import controller.PiezaControlador;
import model.Mueble;
import model.Pieza;
import model.Tipomueble;
import javax.swing.JComboBox;

public class PanelPieza extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfCantidad;
	JComboBox<Mueble> jcbMueble;
	
	public PanelPieza() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				cargarPiezaEnPantalla(PiezaControlador.findFirst());
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPiezaEnPantalla(PiezaControlador.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPiezaEnPantalla(PiezaControlador.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPiezaEnPantalla(PiezaControlador.findLast());
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
		
		JLabel lblNewLabel = new JLabel("Gestion Pieza");
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
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad : ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfCantidad = new JTextField();
		GridBagConstraints gbc_jtfCantidad = new GridBagConstraints();
		gbc_jtfCantidad.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCantidad.gridx = 1;
		gbc_jtfCantidad.gridy = 4;
		add(jtfCantidad, gbc_jtfCantidad);
		jtfCantidad.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mueble que Pertenece");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbMueble = new JComboBox();
		GridBagConstraints gbc_jcbMueble = new GridBagConstraints();
		gbc_jcbMueble.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMueble.gridx = 1;
		gbc_jcbMueble.gridy = 5;
		add(jcbMueble, gbc_jcbMueble);
		
		cargarMuebleEnJCombo();
		cargarPiezaEnPantalla(PiezaControlador.findFirst());
	}
	/**
	 * 
	 */
	private void cargarMuebleEnJCombo() {
		this.jcbMueble.removeAllItems();
		
		List<Mueble> muebles = MuebleControlador.findAll();
		for (Mueble mueble : muebles) {
			this.jcbMueble.addItem(mueble);
		}
	}
	
	/**
	 * 
	 * 
	 */
	private void cargarPiezaEnPantalla(Pieza t) {
		if (t != null) {
			jtfId.setText("" + t.getId());
			jtfNombre.setText(t.getNombre());
			jtfCantidad.setText("" + t.getCantidad());
			
			for (int i = 0; i < this.jcbMueble.getItemCount(); i++) {
				if (this.jcbMueble.getItemAt(i).getId() == t.getMueble().getId() ) {
					this.jcbMueble.setSelectedIndex(i);
				}
			}
			
		}
	}
	/**
	 * 
	 * 
	 */
	private void nuevo() {
		jtfId.setText("0");
		jtfNombre.setText(" ");
		jtfCantidad.setText("0");
		jcbMueble.setSelectedIndex(0);
	}
	/**
	 * 
	 * @return
	 */
	private Pieza cargarPiezaDesdePantalla() {
		Pieza t = new Pieza();
		t.setId(Integer.parseInt(jtfId.getText()));
		t.setNombre(jtfNombre.getText());
		t.setCantidad(Integer.parseInt(jtfCantidad.getText()));
		t.setMueble((Mueble)jcbMueble.getSelectedItem());
		
		return t ;
	}
	
	/**
	 * 
	 */
	private void guardar() {
		try {
			Pieza t = cargarPiezaDesdePantalla();
			if(t.getNombre().trim().equals("")) {
				throw new Exception ("El nombre no puede estar vacio");
			}
			if(t.getCantidad()<0) {
				throw new Exception ("La Cantidad debe ser un numero positivo");
			}
			
		
			PiezaControlador.guardar(t);
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
	    		Pieza pActual = cargarPiezaDesdePantalla();
	    	  	PiezaControlador.eliminar(pActual);
	    	  
	    	  	JOptionPane.showMessageDialog(null, "Eliminado correctamente");
	    	  
				// Cargo otro registro en pantalla
	    	  	Pieza pAnterior = PiezaControlador.findPrevious(pActual.getId());
				if (pAnterior != null) {
					cargarPiezaEnPantalla(pAnterior);
				}
				else {
					Pieza pSiguiente = PiezaControlador.findNext(pActual.getId());
					if (pSiguiente != null) {
						cargarPiezaEnPantalla(pSiguiente);
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
	

}
