# Mini Hospital Emergency Management System

## Introduction
This project is a simple Java console application that demonstrates four important data structures used in data structures and algorithms:

- Binary Search Tree (BST)
- Queue
- Stack
- Singly Linked List

The system manages hospital patient records, emergency patients waiting for treatment, completed treatment history, and previous patient visit history.

## Objectives
- Register and store patients by Patient ID
- Search for a patient using ID
- Delete a patient record
- Manage emergency patients using FIFO queue
- Record completed treatments using LIFO stack
- Store previous visits for each patient using a singly linked list
- Provide a user-friendly console menu

## Data Structures Used

### Binary Search Tree
A Binary Search Tree is used to store patient records. Each patient is placed based on Patient ID. This makes searching faster than checking every patient one by one. Patients are displayed in ascending order using in-order traversal.

### Queue
A queue follows the FIFO rule: First In, First Out. This is suitable for emergency patients because the patient who arrives first is treated first.

### Stack
A stack follows the LIFO rule: Last In, First Out. This is suitable for treatment history because the most recently completed treatment is usually viewed or removed first.

### Singly Linked List
A singly linked list stores previous hospital visits for each patient. Each node contains a visit and a pointer to the next node. This allows adding, removing, and searching visits easily.

## Features
- Register new patient
- Search patient by ID
- Delete patient
- Display all patients in ascending order
- Add patient to emergency queue
- Treat next emergency patient
- Display emergency waiting queue
- Add treatment record
- Remove latest treatment record
- Display completed treatment history
- Add patient visit
- Remove patient visit
- Search patient visit
- Display patient visit history
- Handle invalid and empty structures properly

## Project Structure

MiniHospitalEmergencySystem/
├── src/
│   ├── Main.java
│   ├── Patient.java
│   ├── PatientBST.java
│   ├── EmergencyQueue.java
│   ├── TreatmentRecord.java
│   ├── TreatmentStack.java
│   ├── Visit.java
│   └── VisitHistory.java
└── README.md

## How to Run
1. Open VS Code.
2. Open the project folder.
3. Open the terminal.
4. Compile the project:

```bash
javac .\src\*.java
```

5. Run the application:

```bash
java -cp .\src Main
```

## Sample Output
```text
========================================
MINI HOSPITAL EMERGENCY MANAGEMENT
========================================
1. Register New Patient
2. Search Patient
3. Delete Patient
4. Display All Patients
5. Add Patient to Emergency Queue
6. Treat Next Emergency Patient
7. Display Emergency Queue
8. Add Treatment Record
9. Remove Latest Treatment
10. Display Treatment History
11. Add Patient Visit
12. Remove Patient Visit
13. Search Patient Visit
14. Display Patient Visit History
15. Exit
Enter your choice:
```

## Testing
Test the following major features:

### BST
- Insert patients
- Search for an existing patient
- Search for a non-existing patient
- Delete a leaf node
- Delete a node with one child
- Delete a node with two children
- Display patients in order

### Queue
- Enqueue patients
- Display queue
- Dequeue patient
- Verify FIFO behavior
- Dequeue from empty queue

### Stack
- Push treatment records
- Display records
- Pop records
- Verify LIFO behavior
- Pop from empty stack

### Linked List
- Add visit records
- Display all visits
- Search a visit
- Remove a visit
- Search a non-existing visit
- Remove from empty list

## Conclusion
This assignment helps students understand how core data structures work in a real hospital environment. The project is simple, easy to follow, and demonstrates the main ideas of BST, queue, stack, and linked list in Java.
