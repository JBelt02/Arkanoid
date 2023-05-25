package view;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;



import java.awt.EventQueue;
import java.awt.GridBagConstraints;

public class VentanaPrincipal extends JFrame {
	
	public VentanaPrincipal() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setBounds(100, 100, 450, 367);
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		getContentPane().add(tabbedPane, gbc_tabbedPane);
		tabbedPane.add("Tipo de Mueble", new PanelTipoMueble());
		tabbedPane.add("Piezas", new PanelPieza());
		tabbedPane.add("Carpintero", new PanelCarpintero());
		tabbedPane.add("Distribuidor", new PanelDistribuidor());
		tabbedPane.add("Mueble", new PanelMueble());
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
