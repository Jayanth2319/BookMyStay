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

<<<<<<< HEAD
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


=======
>>>>>>> 18efa680c124aa45c2e6c03235aef961fb09b260
## Author
Jayanth
=======
## Use Case 2: Basic Room Types & Static Availability

### Goal
Introduce object modeling through inheritance and abstraction before introducing data structures, allowing focus on domain design rather than optimization.

### Actor
User – runs the application to view predefined room types and their availability.

### Flow
1. User runs the application.
2. Room objects representing different room types are created.
3. Availability for each room type is stored using simple variables.
4. Room details and availability information are printed to the console.
5. Application terminates.

### Key Concepts Used
- **Abstract Class** – `Room` defines common attributes and enforces structure.
- **Inheritance** – `SingleRoom`, `DoubleRoom`, `SuiteRoom` extend `Room`.
- **Polymorphism** – Rooms referenced via `Room` type for uniform handling.
- **Encapsulation** – Attributes like beds, size, price are controlled.
- **Static Availability Representation** – Availability stored in simple variables.
- **Separation of Domain and State** – Objects represent rooms, variables represent availability.


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
