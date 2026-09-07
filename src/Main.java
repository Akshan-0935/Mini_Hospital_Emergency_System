import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();

        loadSampleData(patientBST, emergencyQueue, treatmentStack);

        while (true) {
            System.out.println("\n========================================");
            System.out.println("MINI HOSPITAL EMERGENCY MANAGEMENT");
            System.out.println("========================================");
            System.out.println("1. Register New Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients");
            System.out.println("5. Add Patient to Emergency Queue");
            System.out.println("6. Treat Next Emergency Patient");
            System.out.println("7. Display Emergency Queue");
            System.out.println("8. Add Treatment Record");
            System.out.println("9. Remove Latest Treatment");
            System.out.println("10. Display Treatment History");
            System.out.println("11. Add Patient Visit");
            System.out.println("12. Remove Patient Visit");
            System.out.println("13. Search Patient Visit");
            System.out.println("14. Display Patient Visit History");
            System.out.println("15. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = readInt(input);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    registerPatient(input, patientBST);
                    break;
                case 2:
                    searchPatient(input, patientBST);
                    break;
                case 3:
                    deletePatient(input, patientBST);
                    break;
                case 4:
                    patientBST.displayPatients();
                    break;
                case 5:
                    addPatientToQueue(input, patientBST, emergencyQueue);
                    break;
                case 6:
                    treatNextEmergencyPatient(emergencyQueue, treatmentStack);
                    break;
                case 7:
                    emergencyQueue.displayQueue();
                    break;
                case 8:
                    addTreatmentRecord(input, treatmentStack, patientBST);
                    break;
                case 9:
                    removeLatestTreatment(treatmentStack);
                    break;
                case 10:
                    treatmentStack.displayStack();
                    break;
                case 11:
                    addPatientVisit(input, patientBST);
                    break;
                case 12:
                    removePatientVisit(input, patientBST);
                    break;
                case 13:
                    searchPatientVisit(input, patientBST);
                    break;
                case 14:
                    displayPatientVisitHistory(input, patientBST);
                    break;
                case 15:
                    System.out.println("Thank you for using the Mini Hospital Emergency Management System.");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void loadSampleData(PatientBST patientBST, EmergencyQueue emergencyQueue, TreatmentStack treatmentStack) {
        Patient p1 = new Patient(1001, "John Silva", 35, "0712345678", "Fever");
        Patient p2 = new Patient(1002, "Nimal Perera", 52, "0723456789", "Chest Pain");
        Patient p3 = new Patient(1003, "Kamal Fernando", 28, "0771234567", "Fracture");
        Patient p4 = new Patient(1004, "Sara Perera", 45, "0759876543", "Diabetes");

        patientBST.insertPatient(p1);
        patientBST.insertPatient(p2);
        patientBST.insertPatient(p3);
        patientBST.insertPatient(p4);

        p1.addVisit(new Visit(201, "2026-01-10", "Dr. Lim", "Fever", "Paracetamol"));
        p1.addVisit(new Visit(202, "2026-03-12", "Dr. Tan", "Flu", "Rest and Medicine"));
        p2.addVisit(new Visit(203, "2026-02-02", "Dr. Silva", "Chest Pain", "ECG and Observation"));

        emergencyQueue.enqueue(p1);
        emergencyQueue.enqueue(p2);

        treatmentStack.push(new TreatmentRecord(301, 1004, "Sara Perera", "Dr. Gamage",
                "Diabetes", "Insulin", "2026-03-20"));
        treatmentStack.push(new TreatmentRecord(302, 1003, "Kamal Fernando", "Dr. Jayasuriya",
                "Fracture", "Cast Application", "2026-04-01"));

        System.out.println("Sample data loaded successfully.");
    }

    private static void registerPatient(Scanner input, PatientBST patientBST) {
        System.out.print("Enter Patient ID: ");
        int patientId = readInt(input);

        
        System.out.print("Enter Patient Name: ");
        String patientName = input.nextLine();

        System.out.print("Enter Age: ");
        int age = readInt(input);

        System.out.print("Enter Contact Number: ");
        String contactNumber = input.nextLine();

        System.out.print("Enter Medical Condition: ");
        String medicalCondition = input.nextLine();

        Patient patient = new Patient(patientId, patientName, age, contactNumber, medicalCondition);
        patientBST.insertPatient(patient);
        System.out.println("Patient registered successfully.");
    }

    private static void searchPatient(Scanner input, PatientBST patientBST) {
        System.out.print("Enter Patient ID to search: ");
        int patientId = readInt(input);

        Patient patient = patientBST.searchPatient(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            System.out.println("Patient found: " + patient);
        }
    }

    private static void deletePatient(Scanner input, PatientBST patientBST) {
        System.out.print("Enter Patient ID to delete: ");
        int patientId = readInt(input);

        Patient patient = patientBST.searchPatient(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        patientBST.deletePatient(patientId);
        System.out.println("Patient deleted successfully: " + patient.getPatientName());
    }

    private static void addPatientToQueue(Scanner input, PatientBST patientBST, EmergencyQueue emergencyQueue) {
        System.out.print("Enter Patient ID to add to emergency queue: ");
        int patientId = readInt(input);

        Patient patient = patientBST.searchPatient(patientId);
        if (patient == null) {
            System.out.println("Patient does not exist in the BST.");
            return;
        }

        emergencyQueue.enqueue(patient);
        System.out.println("Patient added to emergency queue: " + patient.getPatientName());
    }

    private static void treatNextEmergencyPatient(EmergencyQueue emergencyQueue, TreatmentStack treatmentStack) {
        Patient patient = emergencyQueue.dequeue();
        if (patient == null) {
            return;
        }

        System.out.println("Treating patient: " + patient.getPatientName());
        System.out.println("Medical condition: " + patient.getMedicalCondition());

        System.out.print("Enter doctor name: ");
        Scanner input = new Scanner(System.in);
        String doctorName = input.nextLine();

        System.out.print("Enter diagnosis: ");
        String diagnosis = input.nextLine();

        System.out.print("Enter treatment given: ");
        String treatment = input.nextLine();

        TreatmentRecord record = new TreatmentRecord(
                (int) (System.currentTimeMillis() % 100000),
                patient.getPatientId(),
                patient.getPatientName(),
                doctorName,
                diagnosis,
                treatment,
                "2026-05-20"
        );

        treatmentStack.push(record);
        System.out.println("Treatment added to stack.");
    }

    private static void addTreatmentRecord(Scanner input, TreatmentStack treatmentStack, PatientBST patientBST) {
        System.out.print("Enter Patient ID: ");
        int patientId = readInt(input);

        Patient patient = patientBST.searchPatient(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Doctor Name: ");
        String doctorName = input.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = input.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = input.nextLine();

        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = input.nextLine();

        TreatmentRecord record = new TreatmentRecord(
                (int) (System.currentTimeMillis() % 100000),
                patientId,
                patient.getPatientName(),
                doctorName,
                diagnosis,
                treatment,
                date
        );

        treatmentStack.push(record);
        System.out.println("Treatment record added successfully.");
    }

    private static void removeLatestTreatment(TreatmentStack treatmentStack) {
        TreatmentRecord record = treatmentStack.pop();
        if (record != null) {
            System.out.println("Removed treatment record: " + record);
        }
    }

    private static void addPatientVisit(Scanner input, PatientBST patientBST) {
        System.out.print("Enter Patient ID: ");
        int patientId = readInt(input);

        Patient patient = patientBST.searchPatient(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID: ");
        int visitId = readInt(input);

        System.out.print("Enter Visit Date: ");
        String visitDate = input.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctorName = input.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = input.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = input.nextLine();

        patient.addVisit(new Visit(visitId, visitDate, doctorName, diagnosis, treatment));
        System.out.println("Visit added successfully.");
    }

    private static void removePatientVisit(Scanner input, PatientBST patientBST) {
        System.out.print("Enter Patient ID: ");
        int patientId = readInt(input);

        Patient patient = patientBST.searchPatient(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID to remove: ");
        int visitId = readInt(input);

        if (patient.removeVisit(visitId)) {
            System.out.println("Visit removed successfully.");
        } else {
            System.out.println("Visit not found.");
        }
    }

    private static void searchPatientVisit(Scanner input, PatientBST patientBST) {
        System.out.print("Enter Patient ID: ");
        int patientId = readInt(input);

        Patient patient = patientBST.searchPatient(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID to search: ");
        int visitId = readInt(input);

        Visit visit = patient.searchVisit(visitId);
        if (visit == null) {
            System.out.println("Visit not found.");
        } else {
            System.out.println("Visit found: " + visit);
        }
    }

    private static void displayPatientVisitHistory(Scanner input, PatientBST patientBST) {
        System.out.print("Enter Patient ID: ");
        int patientId = readInt(input);

        Patient patient = patientBST.searchPatient(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        patient.displayVisits();
    }

    private static int readInt(Scanner input) {
        while (true) {
            try {
                String value = input.nextLine().trim();
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Please enter a valid number.");
            }
        }
    }
}
