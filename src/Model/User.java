package Model;
import java.util.*;
import java.lang.*;
import java.math.*;


public class User {
	
	private String userName, userID, passWord;

	public User(String newID, String newPw) {
		this.passWord = newPw;
		this.userID = newID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	@Override
	public String toString() {
		return "User [userName=" + userName + ", userID=" + userID + ", passWord=" + passWord + "]";
	}
		


}
