package Model;
import java.util.*;
import java.lang.*;

public class Professor {
		private String professorID, professorName, department;

		
		public Professor(String professorID, String professorName, String department) {
			super();
			this.professorID = professorID;
			this.professorName = professorName;
			this.department = department;
		}


		public String getProfessorID() {
			return professorID;
		}


		public void setProfessorID(String professorID) {
			this.professorID = professorID;
		}


		public String getProfessorName() {
			return professorName;
		}


		public void setProfessorName(String professorName) {
			this.professorName = professorName;
		}


		public String getDepartment() {
			return department;
		}


		public void setDepartment(String department) {
			this.department = department;
		}


		@Override
		public String toString() {
			return "Professor [professorID=" + professorID + ", professorName=" + professorName + ", department="
					+ department + "]";
		}
		
	
}
