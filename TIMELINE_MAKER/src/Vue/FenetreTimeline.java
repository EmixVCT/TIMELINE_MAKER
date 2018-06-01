package Vue;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JFrame;

public class FenetreTimeline extends JFrame {

	public FenetreTimeline(String parTitre) {
		super(parTitre);
		
		PanelTimelineMaker contentPane = new PanelTimelineMaker();
		
		setContentPane(contentPane);
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900,500);
		setVisible(true);
		setLocation(200,100);
		}
			
	public static void main(String [] args){ //main
		
		new FenetreTimeline("Timeline maker"); //cree la fenetre avec le titre en argument
		}//ferme main
	
	
	public Insets getInsets (){
		return new Insets (40,20,20,20) ; // HAUT,GAUCHE,BAS,DROITE
		}

}


