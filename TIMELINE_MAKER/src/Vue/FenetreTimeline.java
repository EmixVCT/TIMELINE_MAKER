package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FenetreTimeline extends JFrame {

	public FenetreTimeline(String parTitre) {
		super(parTitre);
		
		
		//barre des menus
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new BorderLayout());
		this.setJMenuBar(menuBar);
		
		PanelTimelineMaker contentPane = new PanelTimelineMaker();
		
		//ajout d'un item � la barre des menus
		JMenuItem interfaceTimeline = new JMenuItem("Timeline");
		interfaceTimeline.addActionListener(contentPane);
		interfaceTimeline.setActionCommand("timeline");
		
		JMenuItem interfaceCreation = new JMenuItem("Creation");
		interfaceCreation.addActionListener(contentPane);
		interfaceCreation.setActionCommand("creation");
		
		JMenuItem itemFermer = new JMenuItem("Fermer");
		itemFermer.addActionListener(contentPane);
		itemFermer.setActionCommand("fermer");
		
		menuBar.add(interfaceTimeline,BorderLayout.WEST);
		menuBar.add(interfaceCreation,BorderLayout.CENTER);
		menuBar.add(itemFermer,BorderLayout.EAST);
				
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


