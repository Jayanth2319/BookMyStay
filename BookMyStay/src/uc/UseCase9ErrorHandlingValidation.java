import java.util.*;

// Custom Exception for invalid booking scenarios
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

class Reservation {
    private String reservationId;
    private String guestName;
    private String roomType;

    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getReservationId() {
        return reservationId;
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

    public boolean isValidRoomType(String roomType) {
        return inventory.containsKey(roomType);
    }

    public boolean isAvailable(String roomType) {
        return inventory.getOrDefault(roomType, 0) > 0;
    }

    public void decrement(String roomType) throws InvalidBookingException {
        int count = inventory.getOrDefault(roomType, 0);
        if (count <= 0) {
            throw new InvalidBookingException("Inventory error: No rooms available for type " + roomType);
        }
        inventory.put(roomType, count - 1);
    }
}

class BookingValidator {
    private InventoryService inventory;

    public BookingValidator(InventoryService inventory) {
        this.inventory = inventory;
    }

    public void validate(Reservation reservation) throws InvalidBookingException {
        if (reservation.getGuestName() == null || reservation.getGuestName().isEmpty()) {
            throw new InvalidBookingException("Invalid input: Guest name cannot be empty.");
        }
        if (!inventory.isValidRoomType(reservation.getRoomType())) {
            throw new InvalidBookingException(
                    "Invalid input: Room type " + reservation.getRoomType() + " does not exist.");
        }
        if (!inventory.isAvailable(reservation.getRoomType())) {
            throw new InvalidBookingException(
                    "Invalid input: No availability for room type " + reservation.getRoomType());
        }
    }
}

public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();
        BookingValidator validator = new BookingValidator(inventory);

        List<Reservation> requests = Arrays.asList(
                new Reservation("R001", "Alice", "Single"),
                new Reservation("R002", "", "Double"), // Invalid guest name
                new Reservation("R003", "Charlie", "Penthouse"), // Invalid room type
                new Reservation("R004", "David", "Double"), // May fail if inventory exhausted
                new Reservation("R005", "Eve", "Suite"));

        for (Reservation r : requests) {
            try {
                validator.validate(r);
                inventory.decrement(r.getRoomType());
                System.out.println("Reservation confirmed: " + r.getReservationId() +
                        " | Guest: " + r.getGuestName() +
                        " | Room Type: " + r.getRoomType());
            } catch (InvalidBookingException e) {
                System.out.println("Reservation failed for " + r.getReservationId() + ": " + e.getMessage());
            }
        }
    }
}
