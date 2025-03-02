package HMSystem;

import java.sql.Time;
import java.util.Scanner;

public class Appointment {
	 
    private int id;
    private int patientId;
    private int doctorId;
    private String appointmentDate, reason;
    
    public Appointment()
    {}
    
	public Appointment(int patientId, int doctorId, String appointmentDate, String reason) {

		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.reason = reason;
	}
    
	public Appointment(int id, int patientId, int doctorId, String appointmentDate, String reason) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId + ", appointmentDate="
				+ appointmentDate + ", reason=" + reason + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}