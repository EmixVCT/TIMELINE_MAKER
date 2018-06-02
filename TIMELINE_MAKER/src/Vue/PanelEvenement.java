package Vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Evenement;

public class PanelEvenement extends JPanel{
	private Evenement chEvenement;
	private JLabel image;
	private JLabel text;
	
	public PanelEvenement(Evenement parEvt) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		chEvenement = parEvt;
		
		image = new JLabel( new ImageIcon(chEvenement.getChPhoto()));
		this.add(image,BorderLayout.WEST); 
		
		text = new JLabel(textEvt());
		this.add(text,BorderLayout.CENTER);
		
	}

	public String textEvt() {
		String txt = "<html>\n";
		txt += "<h4> <i> " + Integer.toString(chEvenement.getChDate().getAnnee()) + "<i> <h4>";
		return txt;
				
	}
}
