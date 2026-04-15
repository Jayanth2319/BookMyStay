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
