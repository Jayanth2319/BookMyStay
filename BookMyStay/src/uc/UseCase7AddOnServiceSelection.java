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
}

class Service {
    private String name;
    private double cost;

    public Service(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}

class AddOnServiceManager {
    private Map<String, List<Service>> reservationServices;

    public AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }

    // Attach services to a reservation
    public void addServices(Reservation reservation, List<Service> services) {
        reservationServices.putIfAbsent(reservation.getReservationId(), new ArrayList<>());
        reservationServices.get(reservation.getReservationId()).addAll(services);
        System.out.println("Services added for Reservation ID: " + reservation.getReservationId());
    }

    // Calculate total additional cost
    public double calculateAdditionalCost(String reservationId) {
        List<Service> services = reservationServices.getOrDefault(reservationId, new ArrayList<>());
        double total = 0;
        for (Service s : services) {
            total += s.getCost();
        }
        return total;
    }

    // Display services for a reservation
    public void displayServices(String reservationId) {
        List<Service> services = reservationServices.getOrDefault(reservationId, new ArrayList<>());
        System.out.println("Services for Reservation ID: " + reservationId);
        for (Service s : services) {
            System.out.println("- " + s.getName() + " | Cost: " + s.getCost());
        }
    }
}

public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {
        Reservation r1 = new Reservation("R001", "Alice", "Single");
        Reservation r2 = new Reservation("R002", "Bob", "Suite");

        Service breakfast = new Service("Breakfast", 500.0);
        Service spa = new Service("Spa Access", 1500.0);
        Service pickup = new Service("Airport Pickup", 800.0);

        AddOnServiceManager manager = new AddOnServiceManager();

        // Guest Alice selects Breakfast + Pickup
        manager.addServices(r1, Arrays.asList(breakfast, pickup));

        // Guest Bob selects Spa
        manager.addServices(r2, Arrays.asList(spa));

        // Display services and costs
        manager.displayServices(r1.getReservationId());
        System.out.println("Total Additional Cost: " + manager.calculateAdditionalCost(r1.getReservationId()));

        manager.displayServices(r2.getReservationId());
        System.out.println("Total Additional Cost: " + manager.calculateAdditionalCost(r2.getReservationId()));
    }
}
