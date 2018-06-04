package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import Modele.Evenement;

public class PanelEvenement extends JPanel{
	private Evenement chEvenement;
	private JLabel image;
	private JLabel text;
	
	public PanelEvenement(Evenement parEvt) {
		chEvenement = parEvt;

		setBackground(new Color(128, 208, 208));
		setLayout(new BorderLayout());
				
		image = new JLabel( new ImageIcon(chEvenement.getChPhoto()));
		this.add(image,BorderLayout.WEST); 
		
		text = new JLabel(textEvt());
		text.setBorder(new EmptyBorder(0, 10, 0, 10));

		JScrollPane scroll = new JScrollPane(text,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED , ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		this.add(scroll,BorderLayout.CENTER);

		
	}

	public String textEvt() {
		String txt = "<html>\n";
		txt += "<h4> <i> " + chEvenement.getChDate().toString() + "<i> </h4>\n";
		txt += "<h3> " + chEvenement.getChTitre()+"</h3>";
		
		String mots[] = chEvenement.getChDescription().split(" ");
		int nbMotParLig = 12;
		int i = 0;
		for(String mot : mots) {
			if (i%nbMotParLig == 0) {
				txt += "<br/>";
			}
			txt += mot + " ";
			i++;
		}
		txt += "</html>";
		return txt;
				
	}
}
