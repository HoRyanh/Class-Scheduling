package GUI;

import java.awt.EventQueue;
import javax.swing.JDialog;

import Model.*;
import Functions.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class Schedules extends JDialog {
	private JTable table;
	private List<ArrayList<Courses>>allSchedule = new ArrayList<>();
	String colName[]={"Class Name", "Section", "Day & Time & Location", "Professor", "Unit"};
	private DefaultTableModel scheduleModle = new DefaultTableModel(colName,0){
	      public Class getColumnClass(int columnIndex) {return String.class; }
	      };
	private int currentSche = 0;
	private JLabel totalSchedules;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schedules dialog = new Schedules();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Schedules() {
		setBounds(100, 100, 738, 374);
		getContentPane().setLayout(null);
		
		JLabel scheduleLabel = new JLabel("Schedule    #");
		scheduleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scheduleLabel.setFont(new Font("AppleGothic", Font.PLAIN, 15));
		scheduleLabel.setBounds(28, 19, 110, 27);
		getContentPane().add(scheduleLabel);
		
		JLabel numOfSchedule = new JLabel("1");
		numOfSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		numOfSchedule.setFont(new Font("AppleGothic", Font.PLAIN, 15));
		numOfSchedule.setBounds(131, 19, 34, 27);
		getContentPane().add(numOfSchedule);
		
		
		JLabel lblOf = new JLabel("Of");
		lblOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblOf.setFont(new Font("AppleGothic", Font.PLAIN, 15));
		lblOf.setBounds(160, 19, 34, 27);
		getContentPane().add(lblOf);
		
		
		totalSchedules = new JLabel("0");
		totalSchedules.setHorizontalAlignment(SwingConstants.CENTER);
		totalSchedules.setFont(new Font("AppleGothic", Font.PLAIN, 15));
		totalSchedules.setBounds(194, 19, 34, 27);
		getContentPane().add(totalSchedules);
		
		JButton btnFavorite = new JButton("Favorite");
		btnFavorite.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		btnFavorite.setBounds(519, 20, 85, 29);
		getContentPane().add(btnFavorite);
		
		JButton lastSchedule = new JButton("");
		lastSchedule.setEnabled(false);
		lastSchedule.setIcon(new ImageIcon(Schedules.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Outdent-Black.png")));
		lastSchedule.setFont(new Font("AppleGothic", Font.BOLD, 13));
		lastSchedule.setBounds(479, 19, 43, 29);
		getContentPane().add(lastSchedule);
		
		JButton nextSchedule = new JButton("");
		nextSchedule.setIcon(new ImageIcon(Schedules.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Indent-Black.png")));
		nextSchedule.setFont(new Font("AppleGothic", Font.BOLD, 13));
		nextSchedule.setBounds(601, 19, 43, 29);
		getContentPane().add(nextSchedule);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 56, 708, 277);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		
		
		table.setModel(scheduleModle);
		table.setRowHeight(50);
		table.setDefaultRenderer(String.class, new MultiLineCellRenderer());
		TableColumn column = null; 
		for (int i = 0; i < 5; i++) {
		    column = table.getColumnModel().getColumn(i);
		    if (i == 2) {
		        column.setPreferredWidth(240); 
		    } else if(i == 3){
		    	column.setPreferredWidth(70);
		    }else if(i==4){
		    	column.setPreferredWidth(5);
		    }else {
		        column.setPreferredWidth(20);
		    }
		}
		
		lastSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentSche--;
				numOfSchedule.setText(Integer.toString(currentSche+1));
				if(currentSche <= 0){ lastSchedule.setEnabled(false);}else{lastSchedule.setEnabled(true);}
				if(currentSche >=(allSchedule.size()-1)){nextSchedule.setEnabled(false);}else{nextSchedule.setEnabled(true);}
				
				for(int i=scheduleModle.getRowCount()-1; i>=0; i--){
					scheduleModle.removeRow(i);
				}
				
				String firstCT; String[] first= new String[5];
				for(Courses cos: allSchedule.get(currentSche)){
					firstCT="";
					for(ClassTime ct: cos.getClassTime()){
						firstCT += ct.getDay() +"  "+ct.getStarting()+" - "+ct.getEnding()+"  " +ct.getLocation() +"\n";
					}
					first[0]= cos.getCourseName();
					first[1]= Integer.toString(cos.getSectionID());
					first[2]= firstCT;
					first[3]= cos.getProf();
					first[4]= Integer.toString(cos.getUnit());
					scheduleModle.addRow(first);
				}
			}
		});
		
		nextSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentSche++;
				numOfSchedule.setText(Integer.toString(currentSche+1));
				if(currentSche>=(allSchedule.size()-1)){nextSchedule.setEnabled(false);}else{nextSchedule.setEnabled(true);}
				if(currentSche <= 0){ lastSchedule.setEnabled(false);}else{lastSchedule.setEnabled(true);}
				for(int i=scheduleModle.getRowCount()-1; i>=0; i--){
					scheduleModle.removeRow(i);
				}
				String firstCT; String[] first= new String[5];
				for(Courses cos: allSchedule.get(currentSche)){
					firstCT="";
					for(ClassTime ct: cos.getClassTime()){
						firstCT += ct.getDay() +"  "+ct.getStarting()+" - "+ct.getEnding()+"  " +ct.getLocation() +"\n";
					}
					first[0]= cos.getCourseName();
					first[1]= Integer.toString(cos.getSectionID());
					first[2]= firstCT;
					first[3]= cos.getProf();
					first[4]= Integer.toString(cos.getUnit());
					scheduleModle.addRow(first);
				}
			}
		});
		
	}
	public void setAllSche(List<ArrayList<Courses>> allSche){
		this.allSchedule = allSche;
		totalSchedules.setText(Integer.toString(allSchedule.size()));
		
		for(int i=scheduleModle.getRowCount()-1; i>=0; i--){
			scheduleModle.removeRow(i);
		}
		
		String firstCT; String[] first= new String[5];
		for(Courses cos: allSchedule.get(currentSche)){
			firstCT="";
			for(ClassTime ct: cos.getClassTime()){
				firstCT += ct.getDay() +"  "+ct.getStarting()+" - "+ct.getEnding()+"  " +ct.getLocation() +"\n";
			}
			first[0]= cos.getCourseName();
			first[1]= Integer.toString(cos.getSectionID());
			first[2]= firstCT;
			first[3]= cos.getProf();
			first[4]= Integer.toString(cos.getUnit());
			scheduleModle.addRow(first);
		} 
	}
}
