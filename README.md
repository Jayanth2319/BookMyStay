# Book My Stay - Hotel Booking Management System

## Overview
Book My Stay is a Java-based hotel booking management system developed incrementally through use cases.  
Each use case introduces a specific concept in Core Java and demonstrates how fundamental data structures and programming principles are applied to real-world scenarios.

## Project Structure

BookMyStay/
 ├── README.md
 └── src/
      └── uc/
          ├── UseCase1HotelBookingApp.java
          ├── UseCase2RoomInitialization.java
          └── UseCase3InventorySetup.java


## Use Case 1: Application Entry & Welcome Message
**Goal:** Establish a clear and predictable starting point for the application.  
**Expected Output:**

Welcome to Book My Stay App!
Hotel Booking System v1.0


## Use Case 2: Basic Room Types & Static Availability
**Goal:** Introduce object modeling through inheritance and abstraction before data structures.  
**Expected Output:**

=== Room Types & Availability Demo ===
Type: Single Room, Beds: 1, Price: ₹1500.0
Available: Yes

Type: Double Room, Beds: 2, Price: ₹2500.0
Available: No

Type: Suite Room, Beds: 3, Price: ₹5000.0
Available: Yes


## Use Case 3: Centralized Room Inventory Management
**Goal:** Replace scattered availability variables with a centralized HashMap.  
**Expected Output:**

=== Centralized Inventory Demo ===
=== Current Room Inventory ===
Single Room -> Available: 5
Double Room -> Available: 3
Suite Room -> Available: 2

After Updates:
=== Current Room Inventory ===
Single Room -> Available: 4
Double Room -> Available: 3
Suite Room -> Available: 1

## Use Case 4: Room Search & Availability Check

### Goal
Enable guests to view available rooms and their details without modifying system state, reinforcing safe data access and clear separation of responsibilities.

### Actor
- **Guest** – initiates a search to view available room options.
- **Search Service** – handles read-only access to inventory and room information.

### Flow
1. Guest initiates a room search request.
2. The system retrieves availability data from the inventory.
3. Room details and pricing are obtained from room objects.
4. Unavailable room types are filtered out.
5. Available room types and their details are displayed.
6. System state remains unchanged.

### Key Concepts Used
- **Read-Only Access** – search does not alter inventory.
- **Defensive Programming** – filters out unavailable rooms.
- **Separation of Concerns** – search logic isolated from booking logic.
- **Inventory as State Holder** – only retrieves counts, no updates.
- **Domain Model Usage** – room objects provide descriptive info.
- **Validation Logic** – excludes zero-availability rooms.

### Expected Output
=== Available Rooms ===
Type: Single Room, Beds: 1, Price: ₹1500.0
Available: 2

Type: Suite Room, Beds: 3, Price: ₹5000.0
Available: 1

## Use Case 5: Booking Request (First-Come-First-Served)

**Goal:**  
Handle multiple booking requests fairly by introducing a request intake mechanism that preserves arrival order, reflecting real-world booking behavior during peak demand.

**Actors:**  
- **Reservation** – represents a guest’s intent to book a room.  
- **Booking Request Queue** – manages and orders incoming booking requests.  

**Flow:**  
1. Guest submits a booking request.  
2. The request is added to the booking queue.  
3. Requests are stored in arrival order.  
4. Queued requests wait for processing by the allocation system.  
5. No inventory mutation occurs at this stage.  

**Key Concepts Used:**  
- **Problem of Simultaneous Requests:** Peak demand can cause multiple requests to arrive nearly at the same time. Without ordering, allocation may be unfair.  
- **Queue Data Structure:** A `Queue<Reservation>` models waiting lines naturally.  
- **FIFO Principle:** Ensures earliest requests are processed first.  
- **Fairness:** No request can bypass another; all guests are treated equally.  
- **Request Ordering:** Queue preserves insertion order automatically.  
- **Decoupling Intake from Allocation:** Requests are collected first, processed later.  

**Key Requirements:**  
- Accept booking requests from guests.  
- Store requests in a queue structure.  
- Preserve arrival order.  
- Ensure no inventory updates occur at this stage.  
- Prepare requests for subsequent allocation.  

**Key Benefits:**  
- Fair and deterministic booking request handling.  
- Predictable system behavior under peak load.  
- Simplified request coordination before allocation.  

**Drawbacks of Previous Use Case:**  
- UC4 allowed room visibility but did not handle booking intent.  
- Without a request intake mechanism, simultaneous booking attempts could not be managed fairly.  

## Use Case 6: Reservation Confirmation & Room Allocation

**Goal:**  
Confirm booking requests by assigning rooms safely while ensuring inventory consistency and preventing double-booking under all circumstances.

**Actors:**  
- **Booking Service** – processes queued booking requests and performs room allocation.  
- **Inventory Service** – maintains and updates room availability state.  

**Flow:**  
1. Booking request is dequeued from the request queue.  
2. The system checks availability for the requested room type.  
3. A unique room ID is generated and assigned.  
4. The room ID is recorded to prevent reuse.  
5. Inventory count is decremented immediately.  
6. Reservation is confirmed.  

**Key Concepts Used:**  
- **Problem of Double Booking:** Without controlled allocation, the same room may be assigned to multiple guests, causing collisions.  
- **Set Data Structure:** A `Set<String>` stores allocated room IDs, enforcing uniqueness automatically.  
- **Uniqueness Enforcement:** Checking against the set guarantees no room is reused.  
- **Mapping Room Types to Assigned Rooms:** A `HashMap<String, Set<String>>` maps room types to allocated IDs for grouped tracking.  
- **Atomic Logical Operations:** Allocation and inventory update occur together to avoid partial state.  
- **Inventory Synchronization:** Availability is updated immediately after allocation.  

**Key Requirements:**  
- Retrieve booking requests from the queue in FIFO order.  
- Generate and assign a unique room ID for each confirmed reservation.  
- Prevent reuse of room IDs across allocations.  
- Update inventory immediately after successful allocation.  
- Maintain system consistency throughout allocation.  

**Key Benefits:**  
- Guaranteed uniqueness of room assignments.  
- Immediate synchronization between booking and inventory.  
- Elimination of double-booking scenarios.  

**Drawbacks of Previous Use Case:**  
- UC5 handled request ordering but did not confirm bookings.  
- Without allocation and uniqueness enforcement, queued requests could still result in conflicting assignments

## Use Case 7: Add-On Service Selection

**Goal:**  
Extend the booking model to support optional services, demonstrating how real-world business features can be added without modifying core booking or allocation logic.

**Actors:**  
- **Guest** – selects optional services for an existing reservation.  
- **Add-On Service** – represents an individual optional offering.  
- **Add-On Service Manager** – manages the association between reservations and selected services.  

**Flow:**  
1. Guest selects one or more add-on services.  
2. Selected services are added to a list.  
3. The list of services is mapped to the corresponding reservation ID.  
4. Additional cost for the reservation is calculated.  
5. Core booking and inventory state remain unchanged.  

**Key Concepts Used:**  
- **Business Extensibility:** Real-world bookings often include additional offerings beyond the primary product.  
- **One-to-Many Relationship:** A single reservation can have multiple associated services.  
- **Map and List Combination:** `Map<String, List<Service>>` allows efficient lookup of services for a reservation.  
- **Composition over Inheritance:** Services are composed with reservations rather than inherited, supporting flexible growth.  
- **Separation of Core and Optional Features:** Add-on services are managed independently of room allocation and inventory.  
- **Cost Aggregation:** Service costs are calculated separately and combined when needed.  

**Key Requirements:**  
- Allow multiple services to be attached to a single reservation.  
- Store selected services using a reservation-to-services mapping.  
- Calculate total additional cost for selected services.  
- Ensure add-on logic does not modify booking or inventory state.  
- Support easy addition of new service types.  

**Key Benefits:**  
- Flexible attachment of optional services to reservations.  
- Clean mapping between bookings and value-added features.  
- Easy expansion of services without core booking changes.  

**Drawbacks of Previous Use Case:**  
- UC6 confirmed room allocation but treated bookings as static entities.  
- Without add-on support, the system could not model common real-world booking enhancements.  

## Use Case 8: Booking History & Reporting

**Goal:**  
Introduce historical tracking of confirmed bookings to provide operational visibility, enable audits, and support reporting, reinforcing a persistence-oriented mindset without introducing external storage.

**Actors:**  
- **Admin** – reviews booking history and reports for operational purposes.  
- **Booking History** – maintains a record of confirmed reservations.  
- **Booking Report Service** – generates summaries and reports from stored booking data.  

**Flow:**  
1. A booking is successfully confirmed.  
2. The confirmed reservation is added to booking history.  
3. Booking history maintains records in insertion order.  
4. Admin requests booking information or reports.  
5. Stored reservations are retrieved and displayed as required.  

**Key Concepts Used:**  
- **Operational Visibility:** Real systems require visibility into past transactions.  
- **List Data Structure:** A `List<Reservation>` stores confirmed bookings in chronological order.  
- **Ordered Storage:** Bookings are stored in the order they are confirmed, reflecting real-world timelines.  
- **Historical Tracking:** Stored bookings form an audit trail for later review and verification.  
- **Reporting Readiness:** Structured booking data enables reporting without reprocessing live flows.  
- **Separation of Data Storage and Reporting:** History stores data, while reporting logic is handled separately.  
- **Persistence Mindset (Without Storage Medium):** Data is stored in memory but treated as long-lived, preparing for future persistence layers.  

**Key Requirements:**  
- Store each confirmed reservation in booking history.  
- Maintain bookings in the order they are confirmed.  
- Allow retrieval of stored reservations for review.  
- Generate summary reports from booking history.  
- Ensure reporting does not modify stored booking data.  

**Key Benefits:**  
- Complete and traceable booking audit trail.  
- Simplified reporting and administrative analysis.  
- Improved support for customer issue resolution.  

**Drawbacks of Previous Use Case:**  
- UC7 extended booking functionality but did not retain historical data.  
- Without booking history, completed transactions could not be reviewed or analyzed.  
