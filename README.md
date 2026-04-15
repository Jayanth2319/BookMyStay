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

