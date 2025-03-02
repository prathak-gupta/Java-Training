package HMSystem;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DoctorsMenu {

    private DoctorDAO doctorDAO = new DoctorDAO();
    private Scanner scanner = new Scanner(System.in);

    public void doctorsMenu() {
        while (true) {
            System.out.println("Doctors Management System");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. View All Doctors");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    viewAllDoctors();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addDoctor() {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Doctor Speciality: ");
        String speciality = scanner.nextLine();
        System.out.print("Enter Doctor Contact: ");
        String contact = scanner.nextLine();

        Doctor doctor = new Doctor(name, speciality, contact);
        try {
            doctorDAO.addDoctor(doctor);
            System.out.println("Doctor added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding doctor: " + e.getMessage());
        }
    }

    private void updateDoctor() {
        System.out.print("Enter Doctor ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new Doctor Speciality: ");
        String speciality = scanner.nextLine();
        System.out.print("Enter new Doctor Contact: ");
        String contact = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, speciality, contact);
        try {
            doctorDAO.updateDoctor(doctor);
            System.out.println("Doctor updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating doctor: " + e.getMessage());
        }
    }

    private void deleteDoctor() {
        System.out.print("Enter Doctor ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            doctorDAO.deleteDocotr(id);
            System.out.println("Doctor deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting doctor: " + e.getMessage());
        }
    }

    private void viewAllDoctors() {
        try {
            List<Doctor> doctors = doctorDAO.getAllDoctors();
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving doctors: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DoctorsMenu menu = new DoctorsMenu();
        menu.doctorsMenu();
    }
}
