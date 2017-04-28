package Model;
import java.time.*;
import java.util.*;

public class Courses{
	private String courseName, sectionID, prof;
	private int unit; private boolean state;
	private ArrayList<ClassTime> classTime = new ArrayList<>();
	public Courses(String courseName, String sectionID, 
			String prof, int unit, boolean state, ArrayList<ClassTime> classTime){
		this.courseName = courseName;
		this.sectionID = sectionID;
		this.prof=prof;
		this.unit=unit;
		this.state=state;
		this.classTime=classTime;
	}
	public Courses(String courseName, String sectionID, 
			String prof, int unit, boolean state){
		this.courseName = courseName;
		this.sectionID = sectionID;
		this.prof=prof;
		this.unit=unit;
		this.state=state;
	}
	public String getCourseName (){
		return this.courseName;
	}
	
	public int getSectionID(){
		return Integer.parseInt(this.sectionID);
	}
	public String getProf(){
		return this.prof;
	}
	public int getUnit(){
		return this.unit;
	}
	public boolean getState(){
		return this.state;
	}
	
	public void setClassTime(ClassTime newClassTime){
		this.classTime.add(newClassTime);
	}
	public ArrayList<ClassTime> getClassTime(){
		return this.classTime;
	}
	
	public boolean isOverlap(Courses otherClass){
		boolean overlaped = true; 
		for(ClassTime ct: this.classTime){
			for(ClassTime oct: otherClass.getClassTime()){
				if(ct.getDay().equals(oct.getDay())){
					if(ct.getStarting().after(oct.getEnding()) || ct.getEnding().before(oct.getStarting())){
						overlaped=false;
					} else{ return true;}
				}else{overlaped=false;}
			}
		}
		return overlaped;
	}
	
	/*@Override
    public boolean equals(Object o){
		if (o instanceof Courses) {
			if(this.courseName.equals(((Courses)o).getCourseName())){
				return true;
			}
		}
		return false;
	}*/
	@Override
	public String toString() {
		return (courseName+ " " + sectionID + " - "+ classTime + " " + prof 
				+ " " +unit );
	}
}
