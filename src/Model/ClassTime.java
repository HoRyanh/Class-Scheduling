package Model;

import java.sql.Time;
import java.time.DayOfWeek;

public class ClassTime {
	private DayOfWeek day;
	private Time starting, ending;
	private String sectionID, location;
	public ClassTime(String strDay, Time starting, Time ending,
			String sectionID, String location){
		switch(strDay){
		case "Mo":
			this.day= DayOfWeek.MONDAY;
			break;
		case "Tu":
			this.day= DayOfWeek.TUESDAY;
			break;
		case "We":
			this.day= DayOfWeek.WEDNESDAY;
			break;
		case "Th":
			this.day= DayOfWeek.THURSDAY;
			break;
		case "Fi":
			this.day= DayOfWeek.FRIDAY;
			break;
		case "Sa":
			this.day= DayOfWeek.SATURDAY;
			break;
		case "Su":
			this.day= DayOfWeek.SUNDAY;
			break;
		}
		
		this.starting = starting;
		this.ending= ending;
		this.sectionID= sectionID;
		this.location= location;
	}
	
	public DayOfWeek getDay(){
		return this.day;
	}
	
	public Time getStarting(){
		return this.starting;
	}
	
	public Time getEnding(){
		return this.ending;
	}
	
	public int getSectionID(){
		return Integer.parseInt(this.sectionID);
	}
	
	public String getLocation(){
		return this.location;
	}
	
	
	public boolean isEqual(ClassTime otherClassTime){
		if(this.day == otherClassTime.getDay() && this.starting == otherClassTime.getStarting() && this.ending == otherClassTime.getEnding()){
			return true;
		}
		return false;
	}
	@Override
    public boolean equals(Object o){
		if (o instanceof ClassTime) {
			if(this.day.equals(((ClassTime)o).getDay()) && this.starting.equals(((ClassTime)o).getStarting()) && 
					this.ending.equals(((ClassTime)o).getEnding())){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return (day+ " " + starting + " - "+ ending + " " + location + "\n");
	}
}
