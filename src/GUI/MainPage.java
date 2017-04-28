package GUI;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JList;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.*;

import Model.*;
import Functions.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MainPage {

	private JFrame frame;
	private int unitLimit = 0;
	private int maxLimit = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public MainPage() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 838, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		LoginPage loginDisp = new LoginPage();
		DisplayComment displayCom = new DisplayComment();
		Schedules scheDisp = new Schedules();
		
		
		DefaultListModel<ArrayList<Courses>> allClassModel = new DefaultListModel<ArrayList<Courses>>();
		DefaultListModel<ArrayList<Courses>> allPickedClassModel = new DefaultListModel<ArrayList<Courses>>();
		
		JButton btnCleanPicked = new JButton("Clear");
		JButton btnSubmit = new JButton("Submit");
		
		String[] tem = {"", "Spring 2017"};
		JComboBox term = new JComboBox(tem);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setBounds(347, 93, 459, 318);
		frame.getContentPane().add(splitPane);
		
		JList<String> availiableList = new JList<String>();
		availiableList.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		splitPane.setLeftComponent(availiableList);
		DefaultListModel<String>  allCT= new DefaultListModel<String>();
		availiableList.setModel(allCT);
		
		JList<String> pickedList = new JList<String>();
		pickedList.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		splitPane.setRightComponent(pickedList);
		DefaultListModel<String> picked = new DefaultListModel<String>();
		pickedList.setModel(picked);
		
		JLabel noSchedule = new JLabel("At least two calsses overlapping at all sections");
		
		String dbclass[]={"","ART-Art", "CHN-Chinese" , "ENG-English", "CSC-Computer Science","ITL-ltalian","MTH-Mathmatic","PHY-Physics",
				"------------", "SWK-Social Work", "STABD- Study Aborad", "SPN - Spanish", "SOC-Sociology",
				"SLS-Science Letter & Society", "POL-Political Science", "NRS-Nursing", "MUS-Music", "MKT-Marketing","MGT-Management",
				"MDT-Medical Technology","LNG-Language","GEO-Geology", "FRN-French","ESC-Environmental Science","ELT-Electrical Technology"};
		
		JComboBox subject = new JComboBox(dbclass);
		
		JLabel lblIns = new JLabel("Insitution");
		lblIns.setBounds(27, 69, 61, 16);
		frame.getContentPane().add(lblIns);
		
		String[] ins={"","College Of Staten Island"};
		JComboBox insitution = new JComboBox(ins);
		insitution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!insitution.getSelectedItem().equals("")){
					term.setEnabled(true);
				}else{term.setEnabled(false);}
			}
		});
		insitution.setBounds(100, 65, 221, 27);
		frame.getContentPane().add(insitution);
		
		
		JLabel lblNewLabel = new JLabel("Class Scheduling");
		lblNewLabel.setFont(new Font("Geeza Pro", lblNewLabel.getFont().getStyle(), lblNewLabel.getFont().getSize() + 5));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(347, 17, 173, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTerm = new JLabel("Term");
		lblTerm.setBounds(27, 107, 61, 16);
		frame.getContentPane().add(lblTerm);
		
		
		term.setEnabled(false);
		term.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!term.getSelectedItem().equals("")){
					subject.setEnabled(true);
					insitution.setEnabled(false);
				}else{
					subject.setEnabled(false);
					insitution.setEnabled(true);
					}
			}
		});
		term.setBounds(100, 103, 221, 27);
		frame.getContentPane().add(term);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(27, 146, 61, 16);
		frame.getContentPane().add(lblSubject);
		
		subject.setEnabled(false);
		subject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ArrayList<Courses>>allClass = new ArrayList<>();
				try {
						allClass = DBConnecter.genAllClass(subject.getSelectedItem().toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				allCT.clear(); String space="                             ";
				for(ArrayList<Courses> clas: allClass){
					allCT.addElement((String) clas.get(0).getCourseName() + space + clas.get(0).getUnit()) ;
					if(!allClassModel.contains(clas)){
						allClassModel.addElement(clas);
					}
				}
				noSchedule.setVisible(false);
			}
		});
		
		availiableList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=0;String pik="";
				if(!picked.contains((String) availiableList.getSelectedValue())){
					picked.addElement((String) availiableList.getSelectedValue());
					for(int i=0;i<picked.size();i++){
					for(int j=0;j<allClassModel.size();j++){
						String regex="(.*)"+(String) allClassModel.getElementAt(j).get(0).getCourseName()+"(.*)";
						if(!(index==picked.size())){
							pik =  (String)picked.getElementAt(index);}
						if(pik.matches(regex) && !allPickedClassModel.contains(allClassModel.getElementAt(j))){
							allPickedClassModel.addElement(allClassModel.getElementAt(j));
							unitLimit+=allClassModel.getElementAt(j).get(0).getUnit();
							index++;
						}else if(pik.matches(regex)){
							index++;
						}
					}
				}}
				
				if(picked.size()<=1 || unitLimit>maxLimit){
					btnSubmit.setEnabled(false);
				}else{btnSubmit.setEnabled(true);}
				noSchedule.setVisible(false);
			}
		});
		
		pickedList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pik = (String)pickedList.getSelectedValue();
				picked.removeElement((String)pickedList.getSelectedValue());
				for(int i=0; i< allPickedClassModel.size();i++){
					String regex="(.*)"+(String) allPickedClassModel.getElementAt(i).get(0).getCourseName()+"(.*)";
					if(pik.matches(regex)){
						unitLimit-=allPickedClassModel.getElementAt(i).get(0).getUnit();
						allPickedClassModel.removeElement(allPickedClassModel.getElementAt(i));
						break;
					}
				}
				if(picked.size()<=1 || unitLimit>maxLimit){
					btnSubmit.setEnabled(false);
				}else{btnSubmit.setEnabled(true);}
				noSchedule.setVisible(false);
			}
		});
		
		
		
		subject.setBounds(100, 142, 221, 27);
		frame.getContentPane().add(subject);
		
		JLabel lblDaysOfWeek = new JLabel("Days of Week");
		lblDaysOfWeek.setFont(new Font("Apple Braille", lblDaysOfWeek.getFont().getStyle(), 13));
		lblDaysOfWeek.setBounds(27, 203, 108, 16);
		frame.getContentPane().add(lblDaysOfWeek);
		
		JCheckBox chckbxMon = new JCheckBox("Mon");
		chckbxMon.setSelected(true);
		chckbxMon.setBounds(27, 222, 69, 23);
		frame.getContentPane().add(chckbxMon);
		
		JCheckBox chckbxTues = new JCheckBox("Tues");
		chckbxTues.setSelected(true);
		chckbxTues.setBounds(108, 222, 69, 23);
		frame.getContentPane().add(chckbxTues);
		
		JCheckBox chckbxWed = new JCheckBox("Wed");
		chckbxWed.setSelected(true);
		chckbxWed.setBounds(189, 222, 69, 23);
		frame.getContentPane().add(chckbxWed);
		
		JCheckBox chckbxThurs = new JCheckBox("Thurs");
		chckbxThurs.setSelected(true);
		chckbxThurs.setBounds(252, 222, 69, 23);
		frame.getContentPane().add(chckbxThurs);
		
		JCheckBox chckbxFri = new JCheckBox("Fri");
		chckbxFri.setSelected(true);
		chckbxFri.setBounds(27, 257, 69, 23);
		frame.getContentPane().add(chckbxFri);
		
		JCheckBox chckbxSat = new JCheckBox("Sat");
		chckbxSat.setSelected(true);
		chckbxSat.setBounds(108, 257, 69, 23);
		frame.getContentPane().add(chckbxSat);
		
		JCheckBox chckbxSun = new JCheckBox("Sun");
		chckbxSun.setSelected(true);
		chckbxSun.setBounds(189, 257, 69, 23);
		frame.getContentPane().add(chckbxSun);
		
		JLabel lblStarting = new JLabel("Starting");
		lblStarting.setBounds(27, 307, 54, 16);
		frame.getContentPane().add(lblStarting);
		
		String[] startEndAry = new String[25]; LocalTime startEnd = LocalTime.MIDNIGHT;
		for(int i=1; i<25; i++){
			startEndAry[i]= startEnd.toString();
			startEnd=startEnd.plusHours(1);
		}
		startEndAry[0]="";
		JComboBox starting = new JComboBox(startEndAry);
		starting.setFont(new Font("Apple LiGothic", Font.PLAIN, 15));
		starting.setSelectedIndex(1);
		starting.setToolTipText("");
		starting.setBounds(93, 303, 127, 27);
		frame.getContentPane().add(starting);
		
		JLabel lblEnding = new JLabel("Ending");
		lblEnding.setBounds(27, 335, 54, 16);
		frame.getContentPane().add(lblEnding);
		
		JComboBox ending = new JComboBox(startEndAry);
		ending.setFont(new Font("Apple LiGothic", Font.PLAIN, 15));
		ending.setSelectedIndex(24);
		ending.setBounds(93, 331, 127, 27);
		frame.getContentPane().add(ending);
		
		JLabel lblMaxUnit = new JLabel("Max Unit");
		lblMaxUnit.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxUnit.setBounds(27, 378, 61, 16);
		frame.getContentPane().add(lblMaxUnit);
		
		JLabel lblHello = new JLabel("Hello, ");
		lblHello.setBounds(27, 29, 117, 14);
		frame.getContentPane().add(lblHello);
		lblHello.setVisible(false);
		
		
		String[] units= new String[18];
		for(int i=0;i<18;i++){
			units[i]= Integer.toString(i+1);
		}
		JComboBox maxUnit = new JComboBox(units);
		maxUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maxLimit = maxUnit.getSelectedIndex()+1;
				if(picked.size()<=1 || unitLimit>maxLimit){
					btnSubmit.setEnabled(false);
				}else{btnSubmit.setEnabled(true);}
				noSchedule.setVisible(false);
			}
		});
		maxUnit.setFont(new Font("Apple LiGothic", Font.PLAIN, 15));
		maxUnit.setSelectedIndex(17);
		maxUnit.setBounds(93, 374, 74, 27);
		frame.getContentPane().add(maxUnit);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!loginDisp.checkLogin()){
					loginDisp.setVisible(true);
				}
				else{
					loginDisp.setLogin(false);
					btnLogIn.setText("Log in");
					lblHello.setVisible(false);
				}
			}
		});
		btnLogIn.setBounds(27, 423, 117, 29);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnWriteAComment = new JButton("Comment");
		btnWriteAComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayCom.setVisible(true);
			}
		});
		btnWriteAComment.setBounds(156, 423, 165, 29);
		frame.getContentPane().add(btnWriteAComment);
		
		JLabel lblAva = new JLabel("Availiable Classes");
		lblAva.setHorizontalAlignment(SwingConstants.CENTER);
		lblAva.setBounds(393, 65, 127, 16);
		frame.getContentPane().add(lblAva);
		
		
		JLabel lblPickedClasses = new JLabel("Picked Classes");
		lblPickedClasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickedClasses.setBounds(619, 65, 127, 16);
		frame.getContentPane().add(lblPickedClasses);
		
		JButton btnFavoritedSchdule = new JButton("Favorited Schdule");
		btnFavoritedSchdule.setBounds(370, 423, 165, 29);
		frame.getContentPane().add(btnFavoritedSchdule);
		
		
		btnSubmit.setEnabled(false);
		btnSubmit.setBounds(710, 423, 96, 29);
		frame.getContentPane().add(btnSubmit);
		
		
		noSchedule.setVisible(false);
		noSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		noSchedule.setBounds(525, 452, 307, 16);
		frame.getContentPane().add(noSchedule);
		btnCleanPicked.setBounds(602, 423, 96, 29);
		frame.getContentPane().add(btnCleanPicked);
		
		btnCleanPicked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unitLimit=0;
				allPickedClassModel.clear();
				picked.clear();
				if(picked.size()<=1 || unitLimit>maxLimit){
					btnSubmit.setEnabled(false);
				}else{btnSubmit.setEnabled(true);}
				noSchedule.setVisible(false);
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ArrayList<Courses>>allClassforScheduling = new ArrayList<>();
				List<ArrayList<Courses>>allSchedule = new ArrayList<>();
				for(int i=0;i<allPickedClassModel.size();i++){
					allClassforScheduling.add(allPickedClassModel.getElementAt(i));
				}
				allSchedule = Scheduling.makeSchedule(allClassforScheduling);
				if(allSchedule.isEmpty()){
					noSchedule.setVisible(true);
				}else{
					scheDisp.setAllSche(allSchedule);
					scheDisp.setVisible(true);
				}
				
			}
		});
		
		frame.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(LoginPage.checkLogin()){
					lblHello.setVisible(true);
					btnLogIn.setText("Log Out");
					lblHello.setText("Hello, "+loginDisp.getUser().getUserName());
				}
			}
		});
		
	}
}
