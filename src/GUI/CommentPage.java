package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Functions.DBConnecter;
import Model.Comment;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.UUID;
import java.awt.event.ActionEvent;

public class CommentPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Comment newComment;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CommentPage dialog = new CommentPage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CommentPage() {
		setBounds(100, 100, 426, 406);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("How was your class?");
			lblNewLabel.setFont(new Font("Apple LiGothic", lblNewLabel.getFont().getStyle(), 22));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(87, 6, 241, 34);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblComment = new JLabel("Add Comment");
			lblComment.setFont(new Font("Apple Color Emoji", lblComment.getFont().getStyle(), lblComment.getFont().getSize()));
			lblComment.setBounds(10, 38, 125, 16);
			contentPanel.add(lblComment);
		}
		
		JTextPane ClassComment = new JTextPane();
		ClassComment.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		ClassComment.setBounds(18, 63, 390, 283);
		contentPanel.add(ClassComment);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newComment.setContent(ClassComment.getText());
				newComment.setDate(new java.util.Date());
				DBConnecter.writeComment(newComment);
				dispose();
			}
		});
		btnSubmit.setBounds(291, 347, 117, 29);
		contentPanel.add(btnSubmit);
	}
	public static void setComment(String commentID, String courseNumber, String professorName, Date date, String content){
		newComment= new Comment(commentID,courseNumber,professorName,date,content);
	}
}
