public class EmergencyQueue {
    private QueueNode front;
    private QueueNode rear;

    private static class QueueNode {
        private Patient patient;
        private QueueNode next;

        public QueueNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    public EmergencyQueue() {
        front = null;
        rear = null;
    }

    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = front.patient;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return patient;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("Emergency patients waiting:");
        QueueNode current = front;

        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}
