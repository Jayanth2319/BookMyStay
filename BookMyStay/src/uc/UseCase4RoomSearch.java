
/**
 * BookMyStay - Hotel Booking Management System
 *
 * Use Case 4: Room Search & Availability Check
 * Demonstrates safe, read-only access to inventory and room details.
 *
 * @author Jayanth
 * @version 4.1
 */

import java.util.HashMap;
import java.util.Map;

/** Room domain model */
class Room {
    private String type;
    private int beds;
    private double price;

    public Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getBeds() {
        return beds;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Type: " + type + ", Beds: " + beds + ", Price: ₹" + price);
    }
}

/** Centralized inventory holder */
class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 0); // unavailable
        inventory.put("Suite Room", 1);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

/** Search service providing read-only access */
class SearchService {
    private RoomInventory inventory;
    private Map<String, Room> roomCatalog;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
        roomCatalog = new HashMap<>();
        roomCatalog.put("Single Room", new Room("Single Room", 1, 1500.0));
        roomCatalog.put("Double Room", new Room("Double Room", 2, 2500.0));
        roomCatalog.put("Suite Room", new Room("Suite Room", 3, 5000.0));
    }

    public void searchAvailableRooms() {
        System.out.println("=== Available Rooms ===");
        for (String type : roomCatalog.keySet()) {
            if (inventory.getAvailability(type) > 0) {
                roomCatalog.get(type).displayDetails();
                System.out.println("Available: " + inventory.getAvailability(type));
                System.out.println();
            }
        }
    }
}

public class UseCase4RoomSearch {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        SearchService searchService = new SearchService(inventory);

        // Guest initiates search
        searchService.searchAvailableRooms();
    }
}
