package day6;

public interface TaxableInterface {
	// by default -> public static final..
	double taxRate = 0.20;
	
	
	double calculateTax(double salary);
}
