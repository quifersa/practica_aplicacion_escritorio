package paneles;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAyuda extends JPanel{
	
	public PanelAyuda(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel textoAyuda = new JLabel("Para cualquier tipo de ayuda de soporte técnico, por "
										+ "favor contacte con el creador de la aplicación:");
		
		Font fuente = textoAyuda.getFont();
		
		textoAyuda.setFont(new Font(fuente.getFontName(), fuente.getStyle(), 15));

		gbc.gridy = 0;
		gbc.gridx = 0;
		this.add(textoAyuda, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("Contacto: Enrique Fernández"), gbc);
		
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Teléfono: 68754121341"), gbc);
		
	}
	
}
