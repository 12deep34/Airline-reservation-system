import java.util.ArrayList; 
import java.util.InputMismatchException; 
import java.util.List; 
import java.util.Scanner; 
class Flight { 
private String flightNumber; 
private String origin; 
private String destination; 
private int availableSeats; 
public Flight(String flightNumber, String origin, String destination, int  
availableSeats) { 
this.flightNumber = flightNumber; 
this.origin = origin; 
this.destination = destination; 
this.availableSeats = availableSeats; 
} 
public String getFlightNumber() { 
return flightNumber; 
} 
public String getOrigin() { 
return origin; 
} 
public String getDestination() { 
return destination; 
} 
public int getAvailableSeats() { 
return availableSeats; 
} 
public void bookSeats(int numSeats) { 
if (numSeats <= availableSeats) { 
availableSeats -= numSeats; 
System.out.println("Booking successful!"); 
} else { 
22 
System.out.println("Insufficient seats available."); 
} 
} 
} 
class ReservationSystem { 
private List<Flight> flights; 
public ReservationSystem() { 
flights = new ArrayList<>(); 
} 
public void addFlight(Flight flight) { 
flights.add(flight); 
} 
public void displayAvailableFlights() { 
System.out.println("Available Flights:"); 
System.out.println("Flight Number | Origin | Destination | Available  
Seats"); 
for (Flight flight : flights) { 
System.out.println( 
flight.getFlightNumber() + " | " + flight.getOrigin() + "  
| " + flight.getDestination() + " | " 
+ flight.getAvailableSeats()); 
} 
} 
public void makeReservation(String flightNumber, int numSeats) { 
for (Flight flight : flights) { 
if (flight.getFlightNumber().equals(flightNumber)) { 
flight.bookSeats(numSeats); 
return; 
} 
} 
System.out.println("Flight not found."); 
} 
public void showDigiYatraID() { 
System.out.println("DigiYatra ID: DY2023001"); 
} 
23 
public void getCoupons() { 
System.out.println("Coupons: 10% off on your next flight booking!"); 
} 
} 
public class AirlineReservationSystem { 
public static void main(String[] args) { 
ReservationSystem reservationSystem = new ReservationSystem(); 
Flight flight1 = new Flight("F100", "New York", "Los Angeles", 100); 
Flight flight2 = new Flight("F200", "Chicago", "Miami", 50); 
reservationSystem.addFlight(flight1); 
reservationSystem.addFlight(flight2); 
Scanner scanner = new Scanner(System.in); 
while (true) { 
System.out.println("\nMenu:"); 
System.out.println("1. Display available flights"); 
System.out.println("2. Make a reservation"); 
System.out.println("3. Show DigiYatra ID"); 
System.out.println("4. Get Coupons"); 
System.out.println("5. Exit"); 
try { 
int choice = scanner.nextInt(); 
scanner.nextLine(); // Consume the newline character 
switch (choice) { 
case 1: 
reservationSystem.displayAvailableFlights(); 
break; 
case 2: 
System.out.print("Enter flight number: "); 
String flightNumber = scanner.nextLine(); 
System.out.print("Enter number of seats to book: "); 
int numSeats = scanner.nextInt(); 
scanner.nextLine(); // Consume the newline character 
reservationSystem.makeReservation(flightNumber,  
numSeats); 
break; 
24 
case 3: 
reservationSystem.showDigiYatraID(); 
break; 
case 4: 
reservationSystem.getCoupons(); 
break; 
case 5: 
System.out.println("Exiting. Thank you!"); 
scanner.close(); 
return; 
default: 
System.out.println("Invalid choice. Please try  
again."); 
} 
} catch (InputMismatchException e) { 
System.out.println("Invalid input. Please enter a number."); 
scanner.next(); // Consume the invalid input 
} 
} 
} 
} 
25 
