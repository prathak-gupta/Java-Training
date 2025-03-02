package HMSystem;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class HMSApplication {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	DoctorsMenu docMenu = new DoctorsMenu();
    	StaffMenu staffMenu = new StaffMenu();
        AppointmentMenu Appmenu = new AppointmentMenu();
        while (true) {
            System.out.println("Welcome to Hospital Management System");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Appointments");
            System.out.println("4. Manage Staff");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                	PatientsMenu.patientMenu();
                    break;
                case 2:
                	docMenu.doctorsMenu();
                    break;
                case 3:
				try {
					Appmenu.appointmentMenu();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    break;
                case 4:
                	staffMenu.staffMenu();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    }

