package Vue;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import Modele.ModelTable;
import Modele.Timeline;

public class PanelTable extends JPanel {

	private ModelTable modele;
	private JTable tableTimeline;
	private Timeline timeline;
	
	public PanelTable(Timeline parTimeline) {
		setBackground(Color.CYAN);
		timeline = parTimeline;
		
		modele = new ModelTable(timeline);
		tableTimeline = new JTable(modele);
		tableTimeline.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//tableTimeline.
		/*tableTimeline.addMouseListener(new MouseAdapter(){
		
			public void mouseClicked(MouseEvent evt){
				JTable table = (JTable)evt.getSource();
				ModelTable modele = (ModelTable)table.getModel();
				Point point= evt.getPoint();
				int rowIndex = table.rowAtPoint(point);
				int colIndex = table.columnAtPoint(point);
				JOptionPane.showMessageDialog(tableTimeline, modele.getValueAt(rowIndex, colIndex));
			}

		});*/
		//tableTimeline.setDefaultRenderer(Evenement.class, new CelluleRenderer());
		JScrollPane scroll = new JScrollPane(tableTimeline, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		
		this.add(scroll);
	}

	public void updateTable(Timeline parTimeline) {
		ModelTable parModele = new ModelTable(parTimeline);
		
		tableTimeline.setModel(parModele);
		
		//System.out.println(parTimeline.toString());
		//System.out.println(timeline.toString());

	}

}
