package Modele;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import Modele.Evenement;

public class CelluleRenderer extends JLabel implements TableCellRenderer{
	private Timeline timeline;

	
	public CelluleRenderer(Timeline parTimeline) {
		super();

		timeline = parTimeline;
		setOpaque(true);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		
		this.setForeground(new java.awt.Color(180,100,40));
		
	}


	public Component getTableCellRendererComponent(JTable table, Object valeur, boolean estSelectionne, boolean aLeFocus, int ligne, int colonne) {
		if(valeur == null){
			setText("");
			setIcon(null);
			setBackground(new Color(255, 255, 255));
			}
		else{
			Evenement evt =(Evenement)valeur;
			
			if (evt.getChPhoto().isEmpty()) {
				setText(evt.toString());
			}
			else {
				setIcon(new ImageIcon(new ImageIcon(evt.getChPhoto()).getImage().getScaledInstance(70,50,  Image.SCALE_SMOOTH)));
			}

		}
		
		return this;
	}

}
