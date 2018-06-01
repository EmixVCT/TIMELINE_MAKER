package Vue;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreTimeline extends JFrame {

	public FenetreTimeline(String parTitre) {
		super(parTitre);
		
		PanelTimeline contentPane = new PanelTimeline();
		
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
		setLocation(200,300);
		}
			
	public static void main(String [] args){ //main
		
		new FenetreTimeline("Timeline maker"); //cree la fenetre avec le titre en argument
		}//ferme main
	
	
	public Insets getInsets (){
		return new Insets (50,30,15,30) ; // HAUT,GAUCHE,BAS,DROITE
		}

}


