package HMSystem;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AppointmentMenu {

    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    private Scanner scanner = new Scanner(System.in);

    public void appointmentMenu() throws SQLException {
        while (true) {
            System.out.println("Appointment Management System");
            System.out.println("1. Add Appointment");
            System.out.println("2. Update Appointment");
            System.out.println("3. Delete Appointment");
            System.out.println("4. View All Appointments");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addAppointment();
                    break;
                case 2:
                    updateAppointment();
                    break;
                case 3:
                    deleteAppointment();
                    break;
                case 4:
                    viewAllAppointments();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addAppointment() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String appointmentDate = scanner.nextLine();
        System.out.print("Enter Reason: ");
        String reason = scanner.next();

        Appointment appointment = new Appointment(patientId, doctorId, appointmentDate, reason);
        try {
            appointmentDAO.addAppointment(appointment);
        } catch (SQLException e) {
            System.out.println("Error adding appointment: " + e.getMessage());
        }
    }

    private void updateAppointment() {
        System.out.print("Enter Appointment ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter new Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new Appointment Date (YYYY-MM-DD): ");
        String appointmentDate = scanner.nextLine();
        System.out.print("Enter Reason: ");
        String reason = scanner.next();
        Appointment appointment = new Appointment(patientId, doctorId, appointmentDate, reason);
        try {
            appointmentDAO.updateAppointment(id, appointment);
        } catch (SQLException e) {
            System.out.println("Error updating appointment: " + e.getMessage());
        }
    }

    private void deleteAppointment() throws SQLException {
        System.out.print("Enter Appointment ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        appointmentDAO.deleteAppointment(id);
    }

    private void viewAllAppointments() {
        try {
        	System.out.println("Enter Appointment id: ");
        	Scanner sc = new Scanner(System.in);
            List<Appointment> appointments = appointmentDAO.getAllAppointments(sc.nextInt());
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving appointments: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        AppointmentMenu menu = new AppointmentMenu();
        try {
			menu.appointmentMenu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
