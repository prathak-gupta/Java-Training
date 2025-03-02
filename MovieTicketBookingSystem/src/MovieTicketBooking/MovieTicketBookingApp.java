package MovieTicketBooking;

import java.util.Scanner;

public class MovieTicketBookingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		
		int choice;
		while(true) {
			System.out.println("Welcome to Movie Ticket Booking System..\n1.Display Shows\n2.Book Show\n3.Show All Bookings\n4.Booking Confirmation\n5.Booking Cancellation\n6.Exit\nChoose option: ");
			choice =  sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Available shows Chart:");
			ShowAvailableMovies.displayShows();
			break;
		case 2:
			TicketBooking.createBooking();
			break;
		case 3:
			TicketBooking.showBookings();
			break;
		case 4:
			System.out.println("Enter your user_name: ");
			BookingConfirmation.checkConfirmation(sc.next());
			break;
		case 5:
			System.out.println("Enter your user_name: ");
			BookingCancellation.cancelBookings(sc.next());
			break;
		case 6:
			System.out.println("Thank you :)");
			return;
		default:
			System.out.println("Choose valid Input!");
			}
		}
	}

}
