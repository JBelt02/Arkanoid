package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.*;

import controller.CarpinteroControlador;
import controller.DistribuidorControlador;
import controller.MuebleControlador;
import controller.TipomuebleControlador;
import model.Carpintero;
import model.Distribuidor;
import model.Mueble;
import model.Tipomueble;

public class PanelMueble extends JPanel {

	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfSerie;
	private JTextField jtfColor;
	JComboBox<Distribuidor> jcbDistribuidor;
	JComboBox<Tipomueble> jcbTipoMueble;
	JComboBox<Carpintero> jcbCarpintero;
	Color color;
	
	public PanelMueble() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.WEST;
		gbc_toolBar.gridwidth = 2;
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		add(toolBar, gbc_toolBar);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMuebleEnPantalla(MuebleControlador.findFirst());			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMuebleEnPantalla(MuebleControlador.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMuebleEnPantalla(MuebleControlador.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelTipoMueble.class.getResource("/res/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMuebleEnPantalla(MuebleControlador.findLast());
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
		
		JLabel lblNewLabel = new JLabel("Gestion Mueble");
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
		
		JLabel lblNewLabel_3 = new JLabel("Serie : ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfSerie = new JTextField();
		GridBagConstraints gbc_jtfSerie = new GridBagConstraints();
		gbc_jtfSerie.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSerie.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSerie.gridx = 1;
		gbc_jtfSerie.gridy = 4;
		add(jtfSerie, gbc_jtfSerie);
		jtfSerie.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Color :");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfColor = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 0);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 5;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Distribuidor : ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jcbDistribuidor = new JComboBox();
		GridBagConstraints gbc_jcbDistribuidor = new GridBagConstraints();
		gbc_jcbDistribuidor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbDistribuidor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbDistribuidor.gridx = 1;
		gbc_jcbDistribuidor.gridy = 6;
		add(jcbDistribuidor, gbc_jcbDistribuidor);
		
		JLabel lblNewLabel_6 = new JLabel("Tipo Mueble :");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jcbTipoMueble = new JComboBox();
		GridBagConstraints gbc_jcbTipoMueble = new GridBagConstraints();
		gbc_jcbTipoMueble.insets = new Insets(0, 0, 5, 0);
		gbc_jcbTipoMueble.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbTipoMueble.gridx = 1;
		gbc_jcbTipoMueble.gridy = 7;
		add(jcbTipoMueble, gbc_jcbTipoMueble);
		
		JLabel lblNewLabel_7 = new JLabel("Carpintero :");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jcbCarpintero = new JComboBox();
		GridBagConstraints gbc_jcbCarpintero = new GridBagConstraints();
		gbc_jcbCarpintero.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCarpintero.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCarpintero.gridx = 1;
		gbc_jcbCarpintero.gridy = 8;
		add(jcbCarpintero, gbc_jcbCarpintero);
		
		JButton btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser Selectorcolor = new JColorChooser();
                color = Selectorcolor.showDialog(null, "Seleccione un Color", Color.BLUE);
                setBackground(color);
         

			}
		});
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnColor.gridx = 1;
		gbc_btnColor.gridy = 9;
		add(btnColor, gbc_btnColor);
		cargarDistribuidorEnJCombo();
		cargarTipoMuebleEnJCombo();
		cargarCarpinteroEnJCombo();
		

		cargarMuebleEnPantalla(MuebleControlador.findFirst());
	}
	
	/**
	 * 
	 * 
	 */
	private void cargarMuebleEnPantalla(Mueble t) {
		if (t != null) {
			jtfId.setText("" + t.getId());
			jtfNombre.setText(t.getNombre());
			jtfSerie.setText(t.getSerie());
			jtfColor.setText(t.getColor());
			
			for (int i = 0; i < this.jcbDistribuidor.getItemCount(); i++) {
				if (this.jcbDistribuidor.getItemAt(i).getId() == t.getDistribuidor().getId() ) {
					this.jcbDistribuidor.setSelectedIndex(i);
				}
			}
			for (int i = 0; i < this.jcbTipoMueble.getItemCount(); i++) {
				if (this.jcbTipoMueble.getItemAt(i).getId() == t.getTipomueble().getId() ) {
					this.jcbTipoMueble.setSelectedIndex(i);
				}
			}
			for (int i = 0; i < this.jcbCarpintero.getItemCount(); i++) {
				if (this.jcbCarpintero.getItemAt(i).getId() == t.getCarpintero().getId() ) {
					this.jcbCarpintero.setSelectedIndex(i);
				}
			}
			
			
		}
	}
	
	/**
	 * 
	 */
	private void cargarDistribuidorEnJCombo() {
		this.jcbDistribuidor.removeAllItems();
		
		List<Distribuidor> Distribuidores = DistribuidorControlador.findAll();
		for (Distribuidor Distribuidor : Distribuidores) {
			this.jcbDistribuidor.addItem(Distribuidor);
		}
	}
	/**
	 * 
	 */
	private void cargarTipoMuebleEnJCombo() {
		this.jcbTipoMueble.removeAllItems();
		
		List<Tipomueble> Tipomuebles = TipomuebleControlador.findAll();
		for (Tipomueble Tipomueble : Tipomuebles) {
			this.jcbTipoMueble.addItem(Tipomueble);
		}
	}
	/**
	 * 
	 */
	private void cargarCarpinteroEnJCombo() {
		this.jcbCarpintero.removeAllItems();
		
		List<Carpintero> Carpinteros = CarpinteroControlador.findAll();
		for (Carpintero Carpintero : Carpinteros) {
			this.jcbCarpintero.addItem(Carpintero);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private Mueble cargarMuebleDesdePantalla() {
		Mueble t = new Mueble();
		t.setId(Integer.parseInt(jtfId.getText()));
		t.setNombre(jtfNombre.getText());
		t.setColor(jtfColor.getText());
		t.setSerie(jtfSerie.getText());
		t.setCarpintero((Carpintero)jcbCarpintero.getSelectedItem());
		t.setTipomueble((Tipomueble)jcbTipoMueble.getSelectedItem());
		t.setDistribuidor((Distribuidor)jcbDistribuidor.getSelectedItem());
		
		return t ;
	}
	
	/**
	 * 
	 */
	private void guardar() {
		try {
			Mueble t = cargarMuebleDesdePantalla();
			
		
			MuebleControlador.guardar(t);
			jtfId.setText("" + t.getId());
			JOptionPane.showMessageDialog(null, "Guardado correcto");
		}
		catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "No ha sido posible guardar el Mueble: " + 
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
	    		Mueble pActual = cargarMuebleDesdePantalla();
	    		MuebleControlador.eliminar(pActual);
	    	  
	    	  	JOptionPane.showMessageDialog(null, "Eliminado correctamente");
	    	  
				// Cargo otro registro en pantalla
	    	  	Mueble pAnterior = MuebleControlador.findPrevious(pActual.getId());
				if (pAnterior != null) {
					cargarMuebleEnPantalla(pAnterior);
				}
				else {
					Mueble pSiguiente = MuebleControlador.findNext(pActual.getId());
					if (pSiguiente != null) {
						cargarMuebleEnPantalla(pSiguiente);
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
		jtfSerie.setText("");
		jtfColor.setText("");
		jcbDistribuidor.setSelectedIndex(0);
		jcbTipoMueble.setSelectedIndex(0);
		jcbCarpintero.setSelectedIndex(0);
		
	}
	
	
	
	
}
