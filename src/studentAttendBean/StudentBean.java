package studentAttendBean;

import java.io.Serializable;

public class StudentBean implements Serializable {
	private int student_id;
	private int student_classId;
	private int student_attendId;
	private String student_name;
	private String student_attend;

	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getStudent_classId() {
		return student_classId;
	}
	public void setStudent_classId(int student_classId) {
		this.student_classId = student_classId;
	}
	public int getStudent_attendId() {
		return student_attendId;
	}
	public void setStudent_attendId(int student_attendId) {
		this.student_attendId = student_attendId;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_attend() {
		return student_attend;
	}
	public void setStudent_attend(String student_attend) {
		this.student_attend = student_attend;
	}


}
