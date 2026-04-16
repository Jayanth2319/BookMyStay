import java.util.*;

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

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId +
                " | Guest: " + guestName +
                " | Room Type: " + roomType;
    }
}

class BookingHistory {
    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Add confirmed reservation to history
    public void addReservation(Reservation reservation) {
        history.add(reservation);
        System.out.println("Reservation added to history: " + reservation.getReservationId());
    }

    // Retrieve all reservations
    public List<Reservation> getHistory() {
        return history;
    }
}

class BookingReportService {
    private BookingHistory bookingHistory;

    public BookingReportService(BookingHistory bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

    // Generate a simple report
    public void generateReport() {
        System.out.println("\n--- Booking Report ---");
        List<Reservation> reservations = bookingHistory.getHistory();
        System.out.println("Total Reservations: " + reservations.size());
        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }
}

public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService(history);

        // Simulate confirmed bookings
        Reservation r1 = new Reservation("R001", "Alice", "Single");
        Reservation r2 = new Reservation("R002", "Bob", "Suite");
        Reservation r3 = new Reservation("R003", "Charlie", "Double");

        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);

        // Admin requests report
        reportService.generateReport();
    }
}
