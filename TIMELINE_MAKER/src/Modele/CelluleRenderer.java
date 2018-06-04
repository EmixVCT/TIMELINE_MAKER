package Modele;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import Modele.Evenement;

public class CelluleRenderer extends JLabel implements TableCellRenderer{
	private Timeline timeline;
	private Icon icon;
	
	public CelluleRenderer(Timeline parTimaline) {
		super();

		timeline = parTimaline;
		setOpaque(true);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		
		this.setForeground(new java.awt.Color(180,100,40));
		
	}


	public Component getTableCellRendererComponent(JTable table, Object valeur, boolean estSelectionne, boolean aLeFocus, int ligne, int colonne) {
		if(valeur == null){
			setText("");
			setBackground(new Color(255,255,255));
			}
		else{
			Evenement valeurS =(Evenement)valeur;
			JLabel image = new JLabel( new ImageIcon());
			pane.setLayout(new BorderLayout, CENTER);
			pane.add(image); 
			//icon = new Icon();
			//this.setIcon(icon);
			this.setText(valeurS.toString());
			this.setFont(new Font("Calibri", Font.BOLD,15));
			this.setBackground(new Color(255,255,0));
		}
		
		return this;
	}

}
