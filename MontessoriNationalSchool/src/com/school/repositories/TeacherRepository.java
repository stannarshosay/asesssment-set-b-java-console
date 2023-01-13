package com.school.repositories;

import com.school.models.Teacher;

public class TeacherRepository {
	
	private Teacher teachers[];

	public TeacherRepository(int length) {		
		this.teachers = new Teacher[length];		
	}
	
	public void add(int index,Teacher teacher) {
		this.teachers[index] = teacher;
	}
	
	public Teacher getById(int id) {
		
		//curly braces not required if its just a statement inside
		
//		for (Teacher teacher : this.teachers)
//			if (teacher.getId() == id)
//				return teacher;
		
		for(Teacher teacher:this.teachers) {
			
			if(teacher.getId() == id) {
				return teacher;
			}
			
		}
		
		return null;
	}
	
	public void update(Teacher updatedTeacher,Teacher existingTeacher) {
		
		existingTeacher.setName(updatedTeacher.getName());
		existingTeacher.setAddress(updatedTeacher.getAddress());
		existingTeacher.setPhoneNumber(updatedTeacher.getPhoneNumber());
		existingTeacher.setExtraHours(updatedTeacher.getExtraHours());
		
	}
	
	public void update(long phoneNumber,Teacher existingTeacher) {
		
		existingTeacher.setPhoneNumber(phoneNumber);
		
	}

	public Teacher[] getTeachers() {
		return teachers;
	}
	

}
