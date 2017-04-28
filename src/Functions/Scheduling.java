package Functions;
import Model.*;

import java.awt.Label;
import java.sql.*;
import java.time.*;
import java.util.*;



public class Scheduling {
	private static ArrayList<Courses> loadPickedCourses(String loadClass, String act) throws SQLException{
		ResultSet resCourse = DBConnecter.getConnection(loadClass, act);
		ArrayList<Courses> pickedClasses = new ArrayList<>();
		while (resCourse.next()){
			pickedClasses.add(new Courses(resCourse.getString("courseNumber"), resCourse.getString("sectionID"),
					resCourse.getString("professorName"), resCourse.getInt("unit"), resCourse.getBoolean("state")));
		}
		resCourse.close();
		return pickedClasses;
	}
	
	private static ArrayList<ClassTime> loadClassTime(String loadCT, String act) throws SQLException{
		ResultSet resClassTime = DBConnecter.getConnection(loadCT, act);
		ArrayList<ClassTime> classTime = new ArrayList<>();
		while(resClassTime.next()){
			classTime.add(new ClassTime(resClassTime.getString("day"), resClassTime.getTime("starting"), 
						resClassTime.getTime("ending"), resClassTime.getString("sectionID"), resClassTime.getString("location")));
		}
		resClassTime.close();
		return classTime;
	}
	
	public static ArrayList<Courses> getClasses(String loadClass, String loadCT) throws SQLException{
		ArrayList<Courses> pickedClasses = new ArrayList<>();
		pickedClasses = loadPickedCourses(loadClass, "query");
		ArrayList<ClassTime> classTime = new ArrayList<>();
		classTime = loadClassTime(loadCT, "query");
		for(Courses course: pickedClasses){
			for(ClassTime ct: classTime){
				if(course.getSectionID() == ct.getSectionID()){
					pickedClasses.get(pickedClasses.indexOf(course)).setClassTime(ct);
				}
			}
		}
		return pickedClasses;
	}
	
	public static List sortByDay(ArrayList<Courses> pickedClasses){
		List<ArrayList<Courses>> separatedByDT= new ArrayList<>(); 
		List<ArrayList> existingDT = new ArrayList<>();
		int timeLine=0, sameDTClass=0;
		for(Courses course : pickedClasses){
			if(!existingDT.contains(course.getClassTime())){
				existingDT.add(timeLine, pickedClasses.get(pickedClasses.indexOf(course)).getClassTime());
				separatedByDT.add(timeLine, new ArrayList<Courses>());
				separatedByDT.get(timeLine).add(pickedClasses.get(pickedClasses.indexOf(course)));
				timeLine++; sameDTClass++;
			}else{
				separatedByDT.get(existingDT.indexOf(course.getClassTime())).add(pickedClasses.get(pickedClasses.indexOf(course)));
				sameDTClass++;
			}
		}
		return sortBySection(separatedByDT);
	}
	
	public static List<ArrayList<Courses>> sortByCourseNum(ArrayList<Courses> pickedClasses){
		List<ArrayList<Courses>> separatedByCN= new ArrayList<>(); 
		List<String> existingCN = new ArrayList<>();
		int coursesCol=0; 
		for(Courses course : pickedClasses){
			if(separatedByCN.isEmpty()){
				existingCN.add(coursesCol, pickedClasses.get(pickedClasses.indexOf(course)).getCourseName());
				separatedByCN.add(coursesCol, new ArrayList<Courses>());
				separatedByCN.get(coursesCol).add(pickedClasses.get(pickedClasses.indexOf(course)));
				coursesCol++;
			}else{
				if(!cnExisted(separatedByCN, course)){
					existingCN.add(coursesCol, pickedClasses.get(pickedClasses.indexOf(course)).getCourseName());
					separatedByCN.add(coursesCol, new ArrayList<Courses>());
					separatedByCN.get(coursesCol).add(pickedClasses.get(pickedClasses.indexOf(course)));
					coursesCol++;
				}else{
					separatedByCN.get(existingCN.indexOf(course.getCourseName())).add(pickedClasses.get(pickedClasses.indexOf(course)));
				}
			}
		}
		
		return sortBySection(separatedByCN);
	}
	
	
	private static boolean cnExisted(List<ArrayList<Courses>> separatedByCN, Courses cous){
		for(ArrayList<Courses> check: separatedByCN){
			if(check.get(0).getCourseName().equals(cous.getCourseName()) ){
				return true;
			}
		}
		return false;
	}
	
	private static List<ArrayList<Courses>> sortBySection(List<ArrayList<Courses>> separatedBy){
		ArrayList<Courses> temp = new ArrayList<Courses>(); int index; boolean flag = true;
		while(flag){
			flag=false;
			for(index=0;index<separatedBy.size()-1;index++){
				if(separatedBy.get(index).size() < separatedBy.get(index+1).size()){
					temp = separatedBy.get(index);
					separatedBy.set(index, separatedBy.get(index+1));
					separatedBy.set(index+1, temp);
					flag=true;
				}
			}
		}
		return separatedBy;
	}
	
	public static List<ArrayList<Courses>> makeSchedule(List<ArrayList<Courses>> separatedBy) {
		List<ArrayList<Courses>> allSchedules = new ArrayList<>(); 
		int numOfSection = 0, firstClassSection=0, classIndex, sectionIndex; 
		Outer:{
		while(true){
			inner:{
			ArrayList<Courses> possibleSchedule = new ArrayList<>();
			possibleSchedule.add(separatedBy.get(0).get(firstClassSection));
			mid:
			for(classIndex=1; classIndex<separatedBy.size(); classIndex++){
				numOfSection=separatedBy.get(classIndex).size();
				midp:
				for(sectionIndex=0; sectionIndex< numOfSection; sectionIndex++){
					if(!allSchedules.isEmpty() && classIndex==1 ){
						for(ArrayList<Courses> sche: allSchedules){
							if(sche.contains(separatedBy.get(1).get(sectionIndex))&&
									sche.contains(separatedBy.get(0).get(firstClassSection))){
								if(firstClassSection == separatedBy.get(0).size()-1 && 
										sectionIndex==numOfSection-1){
									break Outer;
								}
								if(sectionIndex==numOfSection-1){
									firstClassSection++;
									break inner;
								}
								continue midp;
							}
						}
						
					}
					if(isFitIn(possibleSchedule, separatedBy.get(classIndex).get(sectionIndex))){
						possibleSchedule.add(separatedBy.get(classIndex).get(sectionIndex));
						if(possibleSchedule.size() == separatedBy.size()){
							allSchedules.add(possibleSchedule);
							break inner;
						}
						continue mid;
					}
					if(firstClassSection == separatedBy.get(0).size()-1){
						break Outer;
					}
				}
				possibleSchedule.clear();
				firstClassSection++;
				break;
			}
			}
			}
			
		}
		return allSchedules;
	}
	
	private static boolean isFitIn( ArrayList<Courses> scheduleArray, Courses cous){
		if(scheduleArray.isEmpty()){ return true; }
		for(Courses scheduled: scheduleArray){
			if(scheduled.isOverlap(cous)){
				return false;
			}		
		}
		return true;
	}

}












