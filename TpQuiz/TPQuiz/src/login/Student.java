package login;

public class Student extends User {
	int admission_score;
	boolean graduate;
	int completed_courses;
	int corrected_courses;
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String firstname, String lastname, String function, String userMessage, int admission_score, boolean graduate, int completed_courses, int corrected_courses) {
		super(id, firstname, lastname, function, userMessage);
		this.admission_score = admission_score;
		this.graduate = graduate;
		this.completed_courses = completed_courses;
		this.corrected_courses = corrected_courses;
	}

	public int getAdmission_score() {
		return admission_score;
	}
	public void setAdmission_score(int admission_score) {
		this.admission_score = admission_score;
	}
	public boolean isGraduate() {
		return graduate;
	}
	public void setGraduate(boolean graduate) {
		this.graduate = graduate;
	}
	public int getCompleted_courses() {
		return completed_courses;
	}
	public void setCompleted_courses(int completed_courses) {
		this.completed_courses = completed_courses;
	}
	public int getCorrected_courses() {
		return corrected_courses;
	}
	public void setCorrected_courses(int corrected_courses) {
		this.corrected_courses = corrected_courses;
	}

}
