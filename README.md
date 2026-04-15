<<<<<<< HEAD
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

>>>>>>> 04d63952ce2bf9c104239c1054eddb0cf77d3866
