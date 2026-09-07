public class VisitHistory {
    private VisitNode head;

    private static class VisitNode {
        private Visit visit;
        private VisitNode next;

        public VisitNode(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    public VisitHistory() {
        head = null;
    }

    public void addVisit(Visit visit) {
        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
            return;
        }

        VisitNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public boolean removeVisit(int visitId) {
        if (head == null) {
            return false;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            return true;
        }

        VisitNode current = head;
        while (current.next != null && current.next.visit.getVisitId() != visitId) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        return true;
    }

    public Visit searchVisit(int visitId) {
        VisitNode current = head;

        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }

        return null;
    }

    public void displayVisits() {
        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        System.out.println("Previous visits:");
        VisitNode current = head;

        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
