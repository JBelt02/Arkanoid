package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JToolBar;

import controller.TipomuebleControlador;
import model.Tipomueble;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTipoMueble extends JPanel {
	
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	
	public PanelTipoMueble() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				cargarTipoMuebleEnPantalla(TipomuebleControlador.findFirst());
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTipoMuebleEnPantalla(TipomuebleControlador.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTipoMuebleEnPantalla(TipomuebleControlador.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTipoMuebleEnPantalla(TipomuebleControlador.findLast());
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
		
		JLabel lblNewLabel = new JLabel("Gestion Tipo Mueble");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
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
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion : ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 3;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		cargarTipoMuebleEnPantalla(TipomuebleControlador.findFirst());
	}
	/**
	 * 
	 * 
	 */
	private void cargarTipoMuebleEnPantalla(Tipomueble t) {
		if (t != null) {
			jtfId.setText("" + t.getId());
			jtfDescripcion.setText(t.getDescripcion());
		}
		
	}
	/**
	 * 
	 * 
	 */
	private void nuevo() {
		jtfId.setText("0");
		jtfDescripcion.setText(" ");
	}
	private Tipomueble cargarTipomuebleDesdePantalla() {
		Tipomueble t = new Tipomueble();
		t.setId(Integer.parseInt(jtfId.getText()));
		t.setDescripcion(jtfDescripcion.getText());
		
		return t ;
	}
	
	/**
	 * 
	 */
	private void guardar() {
		try {
			Tipomueble t = cargarTipomuebleDesdePantalla();
			
			if(t.getDescripcion().trim().equals("")) {
				throw new Exception ("La descripcion no puede estar vacia");
			}
			
			TipomuebleControlador.guardar(t);
			jtfId.setText("" + t.getId());
			JOptionPane.showMessageDialog(null, "Guardado correcto");
		}
		catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "No ha sido posible guardar el tipomueble: " + 
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
	    		Tipomueble pActual = cargarTipomuebleDesdePantalla();
	    	  	TipomuebleControlador.eliminar(pActual);
	    	  
	    	  	JOptionPane.showMessageDialog(null, "Eliminado correctamente");
	    	  
				// Cargo otro registro en pantalla
				Tipomueble pAnterior = TipomuebleControlador.findPrevious(pActual.getId());
				if (pAnterior != null) {
					cargarTipoMuebleEnPantalla(pAnterior);
				}
				else {
					Tipomueble pSiguiente = TipomuebleControlador.findNext(pActual.getId());
					if (pSiguiente != null) {
						cargarTipoMuebleEnPantalla(pSiguiente);
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
