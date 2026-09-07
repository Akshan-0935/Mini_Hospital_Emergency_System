public class TreatmentRecord {
    private int treatmentId;
    private int patientId;
    private String patientName;
    private String doctorName;
    private String diagnosis;
    private String treatment;
    private String date;

    public TreatmentRecord(int treatmentId, int patientId, String patientName, String doctorName,
                          String diagnosis, String treatment, String date) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.date = date;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Treatment ID: " + treatmentId +
               " | Patient ID: " + patientId +
               " | Patient Name: " + patientName +
               " | Doctor: " + doctorName +
               " | Diagnosis: " + diagnosis +
               " | Treatment: " + treatment +
               " | Date: " + date;
    }
}
