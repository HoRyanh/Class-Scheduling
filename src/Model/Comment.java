package Model;
import java.util.*;
import java.lang.*;

public class Comment {
	
	private String commentID, courseNumber,professorName, content;
	private Date date;
	
	public Comment(String commentID, String courseNumber, String professorName, Date date, String content) {
		super();
		this.commentID = commentID;
		this.courseNumber = courseNumber;
		this.professorName = professorName;
		this.date = date;
		this.content = content;
	}
	
	public Comment(Comment com) {
		super();
		// TODO Auto-generated constructor stub
		this.commentID=com.commentID;
		this.courseNumber=com.courseNumber;
		this.professorName=com.professorName;
		this.date = com.date;
		this.content = com.content;
	}


	public String getCommentID() {
		return commentID;
	}


	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}


	public String getCourseNumber() {
		return courseNumber;
	}


	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}


	public String getProfessorName() {
		return professorName;
	}


	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "\n Course: "+courseNumber+" Prof: "+professorName+" Date: "+ date+"\n Content: "+content+"\n";
	}

	

}
