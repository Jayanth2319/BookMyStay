
/**
 * BookMyStay - Hotel Booking Management System
 * 
 * Use Case 3: Centralized Room Inventory Management
 * Demonstrates how HashMap solves scattered state problems by
 * providing a single source of truth for room availability.
 * 
 * @author Jayanth
 * @version 3.1
 */

import java.util.HashMap;
import java.util.Map;

/** Inventory class encapsulating room availability logic */
class RoomInventory {
    private Map<String, Integer> inventory;

    /** Initialize inventory with predefined room counts */
    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    /** Get current availability for a room type */
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    /** Update availability for a room type */
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    /** Display full inventory state */
    public void displayInventory() {
        System.out.println("=== Current Room Inventory ===");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " -> Available: " + entry.getValue());
        }
    }
}

public class UseCase3InventorySetup {
    public static void main(String[] args) {
        System.out.println("=== Centralized Inventory Demo ===");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial state
        inventory.displayInventory();

        // Update availability
        inventory.updateAvailability("Single Room", 4);
        inventory.updateAvailability("Suite Room", 1);

        System.out.println("\nAfter Updates:");
        inventory.displayInventory();
    }
}
