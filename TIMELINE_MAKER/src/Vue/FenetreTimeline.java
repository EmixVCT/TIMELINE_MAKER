package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FenetreTimeline extends JFrame {
	private static JMenuItem interfaceTimeline = new JMenuItem("Timeline");
	private static JMenuItem interfaceCreation = new JMenuItem("Creation");
	private static JMenuItem itemFermer = new JMenuItem("Fermer");

	public FenetreTimeline(String parTitre) {
		super(parTitre);
		
		
		//barre des menus
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new BorderLayout());
		this.setJMenuBar(menuBar);
		
		PanelTimelineMaker contentPane = new PanelTimelineMaker();
		
		//ajout d'un item � la barre des menus
		interfaceTimeline.addActionListener(contentPane);
		interfaceTimeline.setActionCommand("timeline");
		if(!contentPane.getTimelineOpen())
			interfaceTimeline.setEnabled(false);
		interfaceTimeline.setBackground(new Color(255, 255, 255));

		
		interfaceCreation.addActionListener(contentPane);
		interfaceCreation.setActionCommand("creation");
		interfaceCreation.setBackground(new Color(255, 255, 255));

		
		itemFermer.addActionListener(contentPane);
		itemFermer.setActionCommand("fermer");
		itemFermer.setBackground(new Color(255, 255, 255));

		
		menuBar.add(interfaceTimeline,BorderLayout.WEST);
		menuBar.add(interfaceCreation,BorderLayout.CENTER);
		menuBar.add(itemFermer,BorderLayout.EAST);
		
		setContentPane(contentPane);
		setBackground(new Color(128, 208, 208));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,600);
		setResizable(false);
		setVisible(true);
		setLocation(200,100);
		}
			
	public static void main(String [] args){ //main
		
		new FenetreTimeline("Timeline maker"); //cree la fenetre avec le titre en argument
		}//ferme main
	
	
	public Insets getInsets (){
		return new Insets (30,5,5,5) ; // HAUT,GAUCHE,BAS,DROITE
		}

	public static void enableJMenuItemTimeline() {
		interfaceTimeline.setEnabled(true);
		
	}

}


