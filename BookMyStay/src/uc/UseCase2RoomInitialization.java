/**
 * BookMyStay - Hotel Booking Management System
 * 
 * Use Case 2: Basic Room Types & Static Availability
 * Demonstrates inheritance, abstraction, and polymorphism.
 * 
 * @author Jayanth
 * @version 2.1
 */

// Abstract class representing a generalized Room
abstract class Room {
    protected String roomType;
    protected int numberOfBeds;
    protected double price;

    public Room(String roomType, int numberOfBeds, double price) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
    }

    /** Abstract method to display room details */
    public abstract void displayRoomInfo();
}

// Concrete room classes
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 1500.0);
    }

    @Override
    public void displayRoomInfo() {
        System.out.println("Type: " + roomType + ", Beds: " + numberOfBeds + ", Price: ₹" + price);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 2500.0);
    }

    @Override
    public void displayRoomInfo() {
        System.out.println("Type: " + roomType + ", Beds: " + numberOfBeds + ", Price: ₹" + price);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 5000.0);
    }

    @Override
    public void displayRoomInfo() {
        System.out.println("Type: " + roomType + ", Beds: " + numberOfBeds + ", Price: ₹" + price);
    }
}

public class UseCase2RoomInitialization {
    public static void main(String[] args) {
        System.out.println("=== Room Types & Availability Demo ===");

        // Availability stored as simple variables
        boolean singleAvailable = true;
        boolean doubleAvailable = false;
        boolean suiteAvailable = true;

        // Initialize room objects
        Room single = new SingleRoom();
        Room doubleR = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Display details
        single.displayRoomInfo();
        System.out.println("Available: " + (singleAvailable ? "Yes" : "No") + "\n");

        doubleR.displayRoomInfo();
        System.out.println("Available: " + (doubleAvailable ? "Yes" : "No") + "\n");

        suite.displayRoomInfo();
        System.out.println("Available: " + (suiteAvailable ? "Yes" : "No"));
    }
}
