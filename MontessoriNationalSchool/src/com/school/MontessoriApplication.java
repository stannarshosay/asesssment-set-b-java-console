package com.school;

import java.util.Scanner;

import com.school.models.ContractualTeacher;
import com.school.models.PermanentTeacher;
import com.school.models.Teacher;
import com.school.repositories.TeacherRepository;

public class MontessoriApplication {

	private static final int LENGTH = 3;
	private static final String APPLICATION_NAME = "Montessori National School";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean shouldQuit = false;

		System.out.println("Welcome To " + MontessoriApplication.APPLICATION_NAME);
		System.out.println("=====================================\n");

		TeacherRepository repo = new TeacherRepository(MontessoriApplication.LENGTH);

		System.out.println("Enter details of " + MontessoriApplication.LENGTH + " Teachers");

		for (int i = 0; i < MontessoriApplication.LENGTH; i++) {

			System.out.println("\nEnter the type of Teacher");
			System.out.println("1) Permanent");
			System.out.println("2) Contractual");

			int option = scanner.nextInt();
			
			Teacher teacher;
			
			if(option==1) {
				
				System.out.println("Are you a senior teacher?(Y/N)");
							
				boolean isSenior = (scanner.next().toLowerCase().charAt(0) == 'y');				          
				teacher = new PermanentTeacher(isSenior);				
				
			}else {
				System.out.println("What is the duration of the contract(Years)?");
				
				teacher = new ContractualTeacher(scanner.nextInt());
			}

			System.out.println("Enter ID :");
			teacher.setId(scanner.nextInt());

			scanner.nextLine();

			System.out.println("Enter Name : ");
			teacher.setName(scanner.nextLine());

			System.out.println("Enter Address : ");
			teacher.setAddress(scanner.nextLine());

			System.out.println("Enter Phone Number : ");
			teacher.setPhoneNumber(scanner.nextLong());

			System.out.println("Enter Extra hours : ");
			teacher.setExtraHours(scanner.nextInt());

			// add the teacher to the repository
			repo.add(i, teacher);

		}

		System.out.println("\nTeachers Added Successfully!\n=====================\n");
		
		while (!shouldQuit) {

			System.out.println("\n1) List by id");
			System.out.println("2) Update by id");
			System.out.println("3) Update phone number by id");
			System.out.println("4) List all");
			System.out.println("5) Quit");

			switch (scanner.nextInt()) {
			case 1: {

				System.out.println("\nEnter the ID :");
				Teacher teacher = repo.getById(scanner.nextInt());

				if (teacher != null) {

					System.out.println(teacher.display());

				} else {

					System.out.println("Oops! No such record found..");
				}

				break;
			}
			case 2: {

				System.out.println("\nEnter the ID :");
				Teacher teacher = repo.getById(scanner.nextInt());

				if (teacher != null) {

					System.out.println(teacher.display());

					Teacher updatedTeacher;
										
					if(teacher instanceof PermanentTeacher) {
						
						System.out.println("Are you a senior teacher?(Y/N)");
									
						boolean isSenior = (scanner.next().toLowerCase().charAt(0) == 'y');				          
						updatedTeacher = new PermanentTeacher(isSenior);				
						
					}else {
						System.out.println("What is the duration of the contract(Years)?");
						
						updatedTeacher = new ContractualTeacher(scanner.nextInt());
					}
					
					System.out.println("Enter Name : ");
					updatedTeacher.setName(scanner.nextLine());

					System.out.println("Enter Address : ");
					updatedTeacher.setAddress(scanner.nextLine());

					System.out.println("Enter Phone Number : ");
					updatedTeacher.setPhoneNumber(scanner.nextLong());

					System.out.println("Enter Extra hours : ");
					updatedTeacher.setExtraHours(scanner.nextInt());
					
					repo.update(updatedTeacher, teacher);

				} else {

					System.out.println("Oops! No such record found..");
				}

				break;
			}
			case 3: {
				
				System.out.println("\nEnter the ID :");
				Teacher teacher = repo.getById(scanner.nextInt());

				if (teacher != null) {

					System.out.println(teacher.display());					

					System.out.println("Enter Phone Number : ");
					long phoneNumber = scanner.nextLong();
					
					repo.update(phoneNumber, teacher);

				} else {

					System.out.println("Oops! No such record found..");
				}
				
				break;
			}
			case 4:{
				
				Teacher teachers[] = repo.getTeachers();
				
				for(Teacher teacher : teachers) {
					
					System.out.println(teacher.display());
					
				}
				
				break;
			}
			case 5:{
				
				//Use this to save time
//				System.exit(0);
				
				System.out.println("Are you sure you want to exit?(Y/N)");
				
				shouldQuit = (scanner.next().toLowerCase().charAt(0) == 'y');
				
				break;
			}
			default: {
				System.out.println("Invalid Option!");
			}
			}

		}
		
		System.out.println("\n**********\nTHANK YOU\n**********");

	}

}
