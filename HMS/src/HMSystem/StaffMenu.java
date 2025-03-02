package HMSystem;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StaffMenu {

    private StaffDAO staffDAO = new StaffDAO();
    private Scanner scanner = new Scanner(System.in);

    public void staffMenu() {
        while (true) {
            System.out.println("Staff Management System");
            System.out.println("1. Add Staff");
            System.out.println("2. Update Staff");
            System.out.println("3. Delete Staff");
            System.out.println("4. View All Staff");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    updateStaff();
                    break;
                case 3:
                    deleteStaff();
                    break;
                case 4:
                    viewAllStaff();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addStaff() {
        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Staff Role: ");
        String role = scanner.nextLine();
        System.out.print("Enter Staff Contact: ");
        String contact = scanner.nextLine();

        Staff staff = new Staff(name, role, contact);
        try {
            staffDAO.addStaff(staff);
            System.out.println("Staff added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding staff: " + e.getMessage());
        }
    }

    private void updateStaff() {
        System.out.print("Enter Staff ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new Staff Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new Staff Role: ");
        String role = scanner.nextLine();
        System.out.print("Enter new Staff Contact: ");
        String contact = scanner.nextLine();

        Staff staff = new Staff(id, name, role, contact);
        try {
            staffDAO.updateStaff(staff);
            System.out.println("Staff updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating staff: " + e.getMessage());
        }
    }

    private void deleteStaff() {
        System.out.print("Enter Staff ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        try {
            staffDAO.deleteStaff(id);
            System.out.println("Staff deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting staff: " + e.getMessage());
        }
    }

    private void viewAllStaff() {
        try {
            List<Staff> staffList = staffDAO.getAllStaff();
            for (Staff staff : staffList) {
                System.out.println(staff);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving staff: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        StaffMenu menu = new StaffMenu();
        menu.staffMenu();
    }
}
