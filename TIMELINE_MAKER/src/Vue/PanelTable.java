package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import Modele.CelluleRenderer;
import Modele.Evenement;
import Modele.ModelTable;
import Modele.Timeline;
/**
 * PanelTable est un JPanel géré par un BorderLayout contenant une JTable
 * Cette classe est caractérisée par les informations suivante :
 * <ul>
 * <li>une timeline</li>
 * <li>une Jtable</li>
 * <li>un modelTable</li>
 * <li>un cardlayout</li>
 * <li>un panelTimeline</li>
 * </ul>
 * @author Maxime VINCENT et Hugo HAMEL
 */
public class PanelTable extends JPanel {

	private static final long serialVersionUID = 1L;
	private ModelTable modele;
	private JTable tableTimeline;
	private Timeline timeline;
	private CardLayout gestionnaireEvts;
	private JPanel panelEvts;
	private PanelTimeline panelTimeline;
	
	/**
	 * Constructeur de la classe PanelTable
	 * @param parTimeline une timeline
	 * @param parGestionnaireEvts un gestionnaire d'evenement (cardLayout)
	 * @param parPanelEvts un JPanel
	 * @param parPanelTimeline un PanelTimeLine
	 * Construit une Jtable en ajoutant un {@link MouseListener} permettant de syncroniser la JTable a PanelTimeline
	 */
	public PanelTable(Timeline parTimeline,CardLayout parGestionnaireEvts,JPanel parPanelEvts,PanelTimeline parPanelTimeline) {
		setLayout(new BorderLayout());
		setBackground(new Color(128, 208, 208));
		timeline = parTimeline;
		gestionnaireEvts = parGestionnaireEvts;
		panelEvts = parPanelEvts;
		panelTimeline = parPanelTimeline;
		
		modele = new ModelTable(timeline);
		tableTimeline = new JTable(modele);
		tableTimeline.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableTimeline.getTableHeader().setReorderingAllowed(false);
		tableTimeline.getTableHeader().setResizingAllowed(false);
		tableTimeline.setPreferredScrollableViewportSize(new Dimension(800,50*4));
		tableTimeline.setRowHeight(50);

		tableTimeline.addMouseListener(new MouseAdapter(){
		
			public void mouseClicked(MouseEvent evt){
				JTable table = (JTable)evt.getSource();
				ModelTable modele = (ModelTable)table.getModel();
				Point point= evt.getPoint();
				int rowIndex = table.rowAtPoint(point);
				int colIndex = table.columnAtPoint(point);
				if (modele.getValueAt(rowIndex, colIndex) != null) {
					Evenement evt1 = (Evenement) modele.getValueAt(rowIndex, colIndex);
					gestionnaireEvts.show(panelEvts, evt1.getChTitre());
					panelTimeline.setDateCourante(evt1.getChDate());
					}
				}

		});
		tableTimeline.setDefaultRenderer(Evenement.class, new CelluleRenderer());
		JScrollPane scroll = new JScrollPane(tableTimeline,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER , ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
		scroll.setAutoscrolls(true);
		this.add(scroll,BorderLayout.CENTER);
	}
	/**
	 * Méthode qui met a jour le model de la table
	 * @param parTimeline un Objet de la classe {@link Timeline}
	 */
	public void updateTable(Timeline parTimeline) {
		ModelTable parModele = new ModelTable(parTimeline);
		tableTimeline.setModel(parModele);
	}

}
