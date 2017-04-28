package Functions;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.text.DateFormatter;
import Model.*;


public class DBConnecter {
	private static Connection connection;
	private static ResultSet result;
	private static boolean loginStatus = false;

	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed())
				connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static ResultSet getConnection(String cmd,String action) {
		try {
			if (connection == null || connection.isClosed()){
				connect();
			}
			PreparedStatement ste = connection.prepareStatement(cmd);  //avoid SQL injection
			switch(action){
			case "query":
				result = ste.executeQuery();
				break;
			case "update":
				ste.executeUpdate();
				connection.commit(); //It looks like Oracle's behavior is to roll back the transaction
				break;
			default:
				System.out.println("Invalid action!");
				break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classScheduling?verifyServerCertificate=false&useSSL=true", "root", "root");
			connection.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean userLogin(User acc){
		if (!acc.getUserID().isEmpty() || !acc.getPassWord().isEmpty()){
			ResultSet result = getConnection("select * from classscheduling.user where userID='"
					+ acc.getUserID() +"' and passwords='"+ acc.getPassWord()+"'", "query");
			try {
				if(result.next() && !result.getString("userID").isEmpty()){
					loginStatus = (acc.getPassWord().equals(result.getString("passwords")))? true : false;
					acc.setUserName(result.getString("name"));
				}
				else{
					return loginStatus; 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return loginStatus;
		}
		else{
			return false;
		}
	}
	
	public void logout(){
		loginStatus=false;
	}
	
public static ArrayList<Comment> loadComment(String CourseName,String Prof){
		
		ArrayList<Comment> list= new ArrayList<Comment>();
		ResultSet result= getConnection("select * from classscheduling.comment where courseNumber='"+CourseName+"' and professorName='"+Prof+"'", "query");
		
		try {
			while (result.next()){

				Comment com=new Comment(result.getString("commentID"),result.getString("courseNumber"),result.getString("professorName"), result.getDate("date"), result.getString("content"));
				list.add(com);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
public static ArrayList<Comment> loadComment(String CourseName){
	
	ArrayList<Comment> list= new ArrayList<Comment>();
	ResultSet result= getConnection("select * from classscheduling.comment where courseNumber='"+CourseName + "'", "query");
	
	try {
		while (result.next()){

			Comment com=new Comment(result.getString("commentID"),result.getString("courseNumber"),result.getString("professorName"), result.getDate("date"), result.getString("content"));
			list.add(com);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return list;
}

	public static boolean writeComment(Comment com){
		String ID = Integer.toString(generateInt(0,99999));
		java.sql.Date sqlDate = new java.sql.Date(com.getDate().getTime());//convert java time to sql time yyyy-mm-dd;
		getConnection("INSERT INTO classscheduling.comment (`commentID`, `courseNumber`, `professorName`, `date`, `content`) VALUES ('"+ID+"', '"+com.getCourseNumber()+"', '"+com.getProfessorName()+"', '"+sqlDate+"', '"+com.getContent()+"')","update");
		return true;
	}
	
	public static int generateInt(int low, int high) {
        return ( (int) ( (Math.random() * 1000000000 )  % ((high + 1) - low) )  + low );
    }
	
	public static List<ArrayList<Courses>> genAllClass(String subject) throws SQLException{
		switch(subject){
			case "ART-Art": subject="ART";break;
			case "CHN-Chinese": subject="CHN";break;
			case "ENG-English": subject="ENG";break;
			case "CSC-Computer Science": subject="CSC";break;
			case "ITL-ltalian": subject="ITL";break;
			case "MTH-Mathmatic": subject="MTH";break;
			case "PHY-Physics": subject="PHY";break;
			case "":subject="";break;
			default: ;
		}
		String q1;
		if(subject.equals("")){q1 = "";}else{ q1 = "select * from course where courseNumber like \"%"+subject+"%\";";}
		List<ArrayList<Courses>> allClass = Scheduling.sortByCourseNum(Scheduling.getClasses(q1, "select * from classtime"));
		return allClass;
	}

}
