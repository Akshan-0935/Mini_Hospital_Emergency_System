public class TreatmentStack {
    private TreatmentNode top;

    private static class TreatmentNode {
        private TreatmentRecord record;
        private TreatmentNode next;

        public TreatmentNode(TreatmentRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    public TreatmentStack() {
        top = null;
    }

    public void push(TreatmentRecord record) {
        TreatmentNode newNode = new TreatmentNode(record);
        newNode.next = top;
        top = newNode;
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        TreatmentRecord record = top.record;
        top = top.next;
        return record;
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return;
        }

        System.out.println("Treatment history (latest first):");
        TreatmentNode current = top;

        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}
