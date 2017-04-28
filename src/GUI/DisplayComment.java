package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Functions.DBConnecter;
import Model.Comment;

public class DisplayComment extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField ClassN;
	private JTextField professorN;
	private CommentPage comPage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayComment dialog = new DisplayComment();
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
	public DisplayComment() {
		
		setBounds(100, 100, 424, 424);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblClassName = new JLabel("Class Name (Ex. CSC126)");
			lblClassName.setFont(new Font("AppleGothic", Font.PLAIN, 15));
			lblClassName.setBounds(10, 11, 198, 16);
			contentPanel.add(lblClassName);
		}
		{
			ClassN = new JTextField();
			ClassN.setBounds(213, 4, 198, 28);
			contentPanel.add(ClassN);
			ClassN.setColumns(10);
		}
		{
			JLabel lblProfessorName = new JLabel("Professor Name (First Last)");
			lblProfessorName.setFont(new Font("AppleGothic", Font.PLAIN, 15));
			lblProfessorName.setBounds(10, 50, 191, 16);
			contentPanel.add(lblProfessorName);
		}
		{
			professorN = new JTextField();
			professorN.setColumns(10);
			professorN.setBounds(213, 44, 198, 28);
			contentPanel.add(professorN);
		}
		{
			JLabel lblComment = new JLabel("Comment");
			lblComment.setFont(new Font("Apple Color Emoji", lblComment.getFont().getStyle(), lblComment.getFont().getSize()));
			lblComment.setBounds(10, 130, 125, 16);
			contentPanel.add(lblComment);
		}
		
		JTextPane ClassComment1 = new JTextPane();
		ClassComment1.setEditable(false);
		ClassComment1.setFont(new Font("Apple Color Emoji", ClassComment1.getFont().getStyle(), ClassComment1.getFont().getSize()));
		ClassComment1.setBounds(10, 154, 401, 220);
		contentPanel.add(ClassComment1);
		
		JButton Find = new JButton("Find");
		Find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Comment> comList;
				if(!ClassN.getText().isEmpty() && !professorN.getText().isEmpty()){
					comList=new ArrayList<Comment>(DBConnecter.loadComment(ClassN.getText(), professorN.getText()));
				}
				else{
					comList=new ArrayList<Comment>(DBConnecter.loadComment(ClassN.getText()));
				}
				if(!comList.isEmpty()){
					ClassComment1.setText(comList.toString());
				}
				else{
					ClassComment1.setText("No Course Founded!");
				}
				
			}
		});
		Find.setBounds(291, 114, 117, 29);
		contentPanel.add(Find);
		
		JButton AddComment = new JButton("Add Comment");
		AddComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!ClassN.getText().isEmpty() && !professorN.getText().isEmpty()){
					comPage=new CommentPage();
					CommentPage.setComment("",ClassN.getText(),professorN.getText(),new java.util.Date(),"");
					comPage.setVisible(true);
				}
			}
		});
		AddComment.setBounds(166, 114, 117, 29);
		contentPanel.add(AddComment);

	}
}
