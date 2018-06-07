package Modele;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import Modele.Evenement;
/**
 * CelluleRenderer est la classe permet de mettre un TableCellRenderer sur une JTable
 * cette classe implement @see TableCellRenderer et extend de @see JLabel
 * 
 * @author Maxime VINCENT et Hugo HAMEL
 * 
 */
public class CelluleRenderer extends JLabel implements TableCellRenderer{
	
	private static final long serialVersionUID = 1L;
	/** 
    * <b>Constructeur de CelluleRenderer</b> 
    * Ne prend aucun parametre
    */ 
	public CelluleRenderer() {
		super();

		setOpaque(true);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		
		this.setForeground(new java.awt.Color(180,100,40));
		
	}

	/** 
    * <b>méthode getTableCellRendererComponent de la classe CelluleRenderer</b> 
    * @param table Objet de la classe JTable
    * @param valeur Objet dans la cellule
    * @param estSelectionne true ou false si la cellule est selectionné
    * @param aLeFocus true ou false si la cellule est focus
    * @param ligne numéraux de la ligne de la cellule
    * @param colonne numéraux de colonne de la cellule
    * La methode permet de donné un aspect specifique a la cellule de la JTable en fonction de sont contenue
    * @see JTable
    */ 
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
				setText(evt.toString());
				setIcon(new ImageIcon(new ImageIcon(evt.getChPhoto()).getImage().getScaledInstance(70,50,  Image.SCALE_SMOOTH)));
			}

		}
		
		return this;
	}

}
