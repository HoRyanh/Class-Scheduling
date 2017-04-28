package Model;
import java.util.*;
import java.lang.*;

public class Favorited {
		
	private String userID, sectionID;



	public Favorited(String userID, String sectionID) {
		super();
		this.userID = userID;
		this.sectionID = sectionID;
	}

	public String getUserID() {
		return userID;
	}



	public void setUserID(String userID) {
		this.userID = userID;
	}



	public String getSectionID() {
		return sectionID;
	}



	public void setSectionID(String sectionID) {
		this.sectionID = sectionID;
	}



	@Override
	public String toString() {
		return "Favorited [userID=" + userID + ", sectionID=" + sectionID + "]";
	}

}
