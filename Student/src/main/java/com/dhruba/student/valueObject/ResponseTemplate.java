package com.dhruba.student.valueObject;
import com.dhruba.student.entity.Student;
public class ResponseTemplate {

private Student student;
private College college;
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public College getCollege() {
	return college;
}
public void setCollege(College college) {
	this.college = college;
}
public ResponseTemplate(Student student, College college) {
	super();
	this.student = student;
	this.college = college;
}
public ResponseTemplate() {
	super();
}
@Override
public String toString() {
	return "ResponseTemplate [student=" + student + ", college=" + college + "]";
}


}








