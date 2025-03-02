package HMSystem;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PatientsMenu {
	public static void patientMenu()
	{
        Scanner scanner = new Scanner(System.in);
        PatientDAO patientDAO = new PatientDAO();
        int choice;

        do {
            System.out.println("Hospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. View All Patients");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addPatient(scanner, patientDAO);
                    break;
                case 2:
                    updatePatient(scanner, patientDAO);
                    break;
                case 3:
                    deletePatient(scanner, patientDAO);
                    break;
                case 4:
                    viewAllPatients(patientDAO);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

//        scanner.close();
    }

    private static void addPatient(Scanner scanner, PatientDAO patientDAO) {
        System.out.print("Enter first name: ");
        String fname = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lname = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();

        Patient patient = new Patient( fname, lname, age, gender, contactNumber);
        try {
            patientDAO.addPatient(patient);
            System.out.println("Patient added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding patient: " + e.getMessage());
        }
    }

    private static void updatePatient(Scanner scanner, PatientDAO patientDAO) {
        System.out.print("Enter patient ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new first name: ");
        String fname = scanner.nextLine();
        System.out.print("Enter new last name: ");
        String lname = scanner.nextLine();
        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter new contact number: ");
        String contactNumber = scanner.nextLine();

        Patient patient = new Patient( fname, lname, age, gender, contactNumber);
        try {
			patientDAO.updatePatient(patient);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Patient updated successfully.");
    }

    private static void deletePatient(Scanner scanner, PatientDAO patientDAO) {
        System.out.print("Enter patient ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        try {
            patientDAO.deletePatient(id);
            System.out.println("Patient deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting patient: " + e.getMessage());
        }
    }

    private static void viewAllPatients(PatientDAO patientDAO) {
        try {
            List<Patient> patients = patientDAO.getAllPatients();
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving patients: " + e.getMessage());
        }

	}
}
