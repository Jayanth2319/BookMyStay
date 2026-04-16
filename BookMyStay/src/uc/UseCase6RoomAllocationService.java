import java.util.*;

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

class InventoryService {
    private Map<String, Integer> inventory;

    public InventoryService() {
        inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Double", 1);
        inventory.put("Suite", 1);
    }

    public boolean isAvailable(String roomType) {
        return inventory.getOrDefault(roomType, 0) > 0;
    }

    public void decrement(String roomType) {
        inventory.put(roomType, inventory.get(roomType) - 1);
    }
}

class BookingService {
    private InventoryService inventory;
    private Map<String, Set<String>> allocatedRooms;

    public BookingService(InventoryService inventory) {
        this.inventory = inventory;
        this.allocatedRooms = new HashMap<>();
    }

    public void confirmBooking(Reservation reservation) {
        String roomType = reservation.getRoomType();

        if (inventory.isAvailable(roomType)) {
            String roomId = UUID.randomUUID().toString();

            allocatedRooms.putIfAbsent(roomType, new HashSet<>());
            allocatedRooms.get(roomType).add(roomId);

            inventory.decrement(roomType);

            System.out.println("Reservation confirmed for " + reservation.getGuestName() +
                    " | Room Type: " + roomType +
                    " | Room ID: " + roomId);
        } else {
            System.out.println("No availability for " + reservation.getGuestName() +
                    " | Room Type: " + roomType);
        }
    }
}

public class UseCase6RoomAllocationService {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();
        BookingService bookingService = new BookingService(inventory);

        Queue<Reservation> requestQueue = new LinkedList<>();
        requestQueue.add(new Reservation("Alice", "Single"));
        requestQueue.add(new Reservation("Bob", "Double"));
        requestQueue.add(new Reservation("Charlie", "Suite"));
        requestQueue.add(new Reservation("David", "Single")); // may fail if inventory runs out

        while (!requestQueue.isEmpty()) {
            bookingService.confirmBooking(requestQueue.poll());
        }
    }
}
