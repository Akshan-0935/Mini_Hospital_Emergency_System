public class PatientBST {
    private PatientNode root;

    private static class PatientNode {
        private Patient patient;
        private PatientNode left;
        private PatientNode right;

        public PatientNode(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    public PatientBST() {
        root = null;
    }

    public void insertPatient(Patient patient) {
        root = insert(root, patient);
    }

    private PatientNode insert(PatientNode current, Patient patient) {
        if (current == null) {
            return new PatientNode(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insert(current.left, patient);
        } else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insert(current.right, patient);
        } else {
            System.out.println("Duplicate Patient ID: " + patient.getPatientId() + ". Patient already exists.");
        }

        return current;
    }

    public Patient searchPatient(int patientId) {
        return search(root, patientId);
    }

    private Patient search(PatientNode current, int patientId) {
        if (current == null) {
            return null;
        }

        if (patientId == current.patient.getPatientId()) {
            return current.patient;
        }

        if (patientId < current.patient.getPatientId()) {
            return search(current.left, patientId);
        }

        return search(current.right, patientId);
    }

    public void deletePatient(int patientId) {
        root = delete(root, patientId);
    }

    private PatientNode delete(PatientNode current, int patientId) {
        if (current == null) {
            return null;
        }

        if (patientId < current.patient.getPatientId()) {
            current.left = delete(current.left, patientId);
            return current;
        }

        if (patientId > current.patient.getPatientId()) {
            current.right = delete(current.right, patientId);
            return current;
        }

        if (current.left == null && current.right == null) {
            return null;
        }

        if (current.left == null) {
            return current.right;
        }

        if (current.right == null) {
            return current.left;
        }

        PatientNode smallestNode = findSmallestNode(current.right);
        current.patient = smallestNode.patient;
        current.right = delete(current.right, smallestNode.patient.getPatientId());
        return current;
    }

    private PatientNode findSmallestNode(PatientNode current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void inorderTraversal() {
        inorder(root);
    }

    private void inorder(PatientNode current) {
        if (current == null) {
            return;
        }

        inorder(current.left);
        System.out.println(current.patient);
        inorder(current.right);
    }

    public void displayPatients() {
        if (root == null) {
            System.out.println("Patient BST is empty.");
            return;
        }

        System.out.println("Patients in ascending Patient ID order:");
        inorderTraversal();
    }

    public boolean isEmpty() {
        return root == null;
    }
}
