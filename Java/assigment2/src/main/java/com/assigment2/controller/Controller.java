package com.assigment2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import com.assigment2.database.config.HibernateUtil;
import com.assigment2.model.entities.Course;
import com.assigment2.model.entities.Enrollement;
import com.assigment2.model.entities.Student;
import com.assigment2.model.entities.User;
import com.assigment2.model.repositories.CourseRepository;
import com.assigment2.model.repositories.DatabaseAccesException;
import com.assigment2.model.repositories.EnrollementRepository;
import com.assigment2.model.repositories.StudentRepository;
import com.assigment2.model.repositories.TeacherRepository;
import com.assigment2.model.repositories.UserRepository;
import com.assigment2.model.services.CoursEnrollementEntity;
import com.assigment2.model.services.CourseService;
import com.assigment2.model.services.EnrollementService;
import com.assigment2.model.services.StudentService;
import com.assigment2.model.services.UserService;
import com.mysql.cj.util.StringUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {

	private static final String ADMIN_USER = "admin";
	private static final String ADMIN_PASSWORD = "admin";
	private static final String SCHEMA = "university_db";
	private static final float INITIAL_GRADE = -1.0f;
	private String checkUser;
	private String checkPassword;
	private static Student currentStudent;

	private StudentRepository studentRepo = new StudentRepository(HibernateUtil.getSessionFactory());
	private TeacherRepository teacherRepo = new TeacherRepository(HibernateUtil.getSessionFactory());
	private UserRepository userRepo = new UserRepository(HibernateUtil.getSessionFactory());
	private EnrollementRepository enrolementRepo = new EnrollementRepository(HibernateUtil.getSessionFactory());
	private CourseRepository courseRepo = new CourseRepository(HibernateUtil.getSessionFactory());

	private UserService userService = new UserService(userRepo);
	private StudentService studentService = new StudentService(studentRepo);
	private EnrollementService enrollmentService = new EnrollementService(enrolementRepo);
	private CourseService courseService = new CourseService(courseRepo);
	private Alert alert = new Alert(AlertType.INFORMATION);

	// Courses columns for students enrollments
	private TableColumn coursColumn = new TableColumn("Cours");
	private TableColumn gradeColumn = new TableColumn("Grade");
	private TableColumn teacherColumn = new TableColumn("Teacher");
	private TableColumn examColumn = new TableColumn("Exam Date");

	// Courses columns for students enrollments
	private TableColumn studentIdColumn = new TableColumn("    Student ID   ");
	private TableColumn studentNameColumn = new TableColumn("   Student Name  ");
	private TableColumn studentGroupColumn = new TableColumn("   Student Group  ");

	@FXML
	private Button loginButton;

	@FXML
	private Button registerButton;

	@FXML
	private Button registerButtonRegister;

	@FXML
	private Button refreshButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Label messageField;

	@FXML
	private TextField password;

	@FXML
	private TextField userName;

	@FXML
	private TextField addressField;

	@FXML
	private TextField groupField;

	@FXML
	private TextField idField;

	@FXML
	private TextField pncField;

	@FXML
	private TextField nameField;

	@FXML
	private TextField icnField;

	@FXML
	private TableView tabelView;

	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private TextField pncRegister;

	@FXML
	private Label registerMessage;

	@FXML
	private TextField icnRegister;

	@FXML
	private TextField nameRegister;

	@FXML
	private TextField groupRegister;

	@FXML
	private TextField addressRegister;

	@FXML
	private TextField passwordRegister;

	@FXML
	private TextField userNameRegister;

	@FXML
	private TextField cPasswordRegister;

	@FXML
	private TableView enrollementsTable;

	@FXML
	private TextField newGradeField;

	@FXML
	private TextField newGroupField;

	@FXML
	private Button enrollButtonAdmin;

	@FXML
	private Button unrollButtonTeacher;

	@FXML
	private TableView<Student> studentsTable;

	@FXML
	private void unenrollStudent(ActionEvent event) {
//		try {
//			if (Objects.nonNull(getSelectedCours())) {
//				Cours selectedCours = studentService.getSelectedCours(getSelectedCours().getCours());
//				Enrollment enrollment = new EnrollementBuilder().setIdStudent(getSelectedStudent().getIdStudent())
//						.setIdCours(selectedCours.getIdCours()).build();
//				studentService.unenrollStudent(enrollment);
//				showInfoMessage("Unenrollment with success!");
//			} else {
//				showInfoMessage("Please select a cours from right table!");
//			}
//		} catch (
//
//		ExecutionException e) {
//			showInfoMessage(e.getMessage());
//		}
	}

	@FXML
	private void getGrade(ActionEvent event) {
//		CoursEnrollementEntity selectedGrade = getSelectedCours();
//		if (Objects.nonNull(selectedGrade)) {
//			newGradeField.setText(selectedGrade.getGrade());
//		} else {
//			showInfoMessage("Please select a Cours first from right table!");
//		}
	}

	@FXML
	private void getGroup(ActionEvent event) {
		if (Objects.nonNull(getSelectedStudent())) {
			newGroupField.setText(getSelectedStudent().getGroupF());
		} else {
			showInfoMessage("Please select a student first from left table!");
		}
	}

	@FXML
	private void updateStudentInfoByTeacher(ActionEvent event) {

//		try {
//			if (Objects.isNull(getSelectedCours())) {
//				studentService.updateStudentGroup(getSelectedStudent().getIdStudent(), newGroupField.getText());
//				showInfoMessage("Group updated with success!");
//			} else {
//				Cours selectedCours = studentService.getSelectedCours(getSelectedCours().getCours());
//				if (StringUtils.isEmptyOrWhitespaceOnly(newGroupField.getText())) {
//					studentService.updateGrade(getSelectedStudent().getIdStudent(), selectedCours.getIdCours(),
//							Float.parseFloat(newGradeField.getText()));
//					showInfoMessage("Grade updated with success!");
//				} else if (StringUtils.isEmptyOrWhitespaceOnly(newGradeField.getText())) {
//					studentService.updateStudentGroup(getSelectedStudent().getIdStudent(), newGroupField.getText());
//					showInfoMessage("Group updated with success!");
//				} else {
//					studentService.updateGrade(getSelectedStudent().getIdStudent(), selectedCours.getIdCours(),
//							Float.parseFloat(newGradeField.getText()));
//					studentService.updateStudentGroup(getSelectedStudent().getIdStudent(), newGroupField.getText());
//					showInfoMessage("Group and grade updated with success!");
//				}
//			}
//		} catch (NumberFormatException |
//
//				ExecutionException e) {
//			showInfoMessage(e.getMessage());
//		}

	}

	@FXML
	private void deleteStudentByTeacher(ActionEvent event) {
//		try {
//			studentService.deleteAcount(getSelectedStudent());
//			showInfoMessage("Student acount deleted with success!");
//		} catch (ExecutionException e) {
//			showInfoMessage(e.getMessage());
//		}
	}

	@FXML
	private void getStudentEnrollements(ActionEvent event) {
//		Student student = getSelectedStudent();
//		if (Objects.nonNull(student)) {
//			System.out.println(student.getIdStudent());
//			try {
//
//				enrollementsTable.setEditable(true);
//				gradeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//				studentGroupColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//
//				studentCoursesTable(student.getIdStudent(), enrollementsTable);
//			} catch (ExecutionException e) {
//				showInfoMessage(e.getMessage());
//			}
//		} else {
//			showInfoMessage("Please select a student from table!");
//		}
	}

	@FXML
	private void refreshTeacherPage(ActionEvent event) {
//		try {
//			studentsTableTeacherPage();
//			enrollementsTable.getColumns().clear();
//		} catch (ExecutionException e) {
//			showInfoMessage(e.getMessage());
//		}
	}

	@FXML
	private void enroleButton(ActionEvent event) {
		try {
			String selectedCoursName = comboBox.getValue();
			Course selectedCourse = courseService.getCourseByName(selectedCoursName);
			Enrollement enrollement = new Enrollement();
			enrollement.setStudent(studentService.getByID(currentStudent.getId()));
			enrollement.setCourse(selectedCourse);
			enrollement.setGrade(INITIAL_GRADE);
			enrollmentService.save(enrollement);
		} catch (DatabaseAccesException e) {
			showInfoMessage(e.getMessage());
		}
		// refreshButton.fire();
		showInfoMessage("Enrollement with success!");
	}

	@FXML
	private void register(ActionEvent event) {
		User user = null;
		Student student = null;
		Validator validator = null;
		if (!(StringUtils.isEmptyOrWhitespaceOnly(nameRegister.getText())
				|| StringUtils.isEmptyOrWhitespaceOnly(addressRegister.getText())
				|| StringUtils.isEmptyOrWhitespaceOnly(pncRegister.getText())
				|| StringUtils.isEmptyOrWhitespaceOnly(icnRegister.getText())
				|| StringUtils.isEmptyOrWhitespaceOnly((groupRegister.getText()))
				|| StringUtils.isEmptyOrWhitespaceOnly(userNameRegister.getText())
				|| StringUtils.isEmptyOrWhitespaceOnly(passwordRegister.getText())
				|| StringUtils.isEmptyOrWhitespaceOnly(cPasswordRegister.getText()))) {

			user = new User();
			student = new Student();
			validator = new Validator();
			if (validator.validatePassword(passwordRegister.getText(), cPasswordRegister.getText())) {
				try {
					user.setName(nameRegister.getText());
					user.setAddress(addressRegister.getText());
					user.setPNC(pncRegister.getText());
					user.setICN(icnRegister.getText());
					userService.save(user);

					student.setUserName(userNameRegister.getText());
					student.setPassword(passwordRegister.getText());
					student.setGroupF(groupRegister.getText());
					student.setUser(user);

					currentStudent = studentService.save(student);
					Stage stage = (Stage) registerButtonRegister.getScene().getWindow();
					stage.close();
					studentPage();

				} catch (DatabaseAccesException e) {
					showInfoMessage(e.getMessage());
				} catch (IOException e) {
					showInfoMessage(e.getMessage());
				}
			} else {
				registerMessage.setText("Confirmed password is incorrect!");
			}
		} else {
			showInfoMessage("Pease fill all the fields!");
		}

	}

	@FXML
	private void refresh(ActionEvent event) {
		Student student;
		try {
			student = studentService.getByID(currentStudent.getId());
			fillStudentFields(student);
			studentCoursesTable(studentService.getByID(currentStudent.getId()).getId(), tabelView);
			System.err.println(studentService.getByID(currentStudent.getId()).getEnrollement().toString());
			//comboBox();
		} catch (ExecutionException | DatabaseAccesException e) {
			showInfoMessage(e.getMessage());
		}

	}

	@FXML
	private void updateStudentButtonClicked(ActionEvent event) {
//		try {
//			Student studentToBeUpdated = updateCurrentUserInfo();
//			if (Objects.nonNull(studentToBeUpdated)) {
//				studentService.updateStudent(studentToBeUpdated);
//				refreshButton.fire();
//				showInfoMessage("Update with succes!");
//			} else {
//
//				showInfoMessage("Please fill all the fields!");
//			}
//		} catch (ExecutionException e) {
//			showInfoMessage(e.getMessage());
//		}
	}

	@FXML
	private void loginButtonClicked(ActionEvent event) {
//		
//		Stage stage = (Stage) loginButton.getScene().getWindow();
//		stage.close();
//		try {
//			studentPage();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		checkUser = userName.getText().toString();
		checkPassword = password.getText().toString();
		try {
			if (checkUser.equalsIgnoreCase(ADMIN_USER)) {
				if (checkPassword.equalsIgnoreCase(ADMIN_PASSWORD)) {
					Stage stage = (Stage) loginButton.getScene().getWindow();
					stage.close();
					adminPage();
				}
			} else {
				currentStudent = studentService.login(checkUser, checkPassword);

				if (Objects.nonNull(currentStudent)) {
					Stage stage = (Stage) loginButton.getScene().getWindow();
					stage.close();
					studentPage();
				} else if (Objects.isNull(currentStudent)) {
					messageField.setText("Username or password invalid!!");
				}
			}
		} catch (DatabaseAccesException | IOException e) {
			showInfoMessage(e.getMessage());
		}

	}

	@FXML
	private void deleteAcount(ActionEvent event) {
//		try {
//			studentService.deleteAcount(currentStudent);
//			Stage stage = (Stage) deleteButton.getScene().getWindow();
//			stage.close();
//		} catch (ExecutionException e) {
//			showInfoMessage(e.getMessage());
//		}
	}

	@FXML
	private void registerFromLoginButtonClicked(ActionEvent event) {
		try {
			Stage stage = (Stage) registerButton.getScene().getWindow();
			stage.close();
			registerPage();
		} catch (IOException e) {
			showInfoMessage(e.getMessage());
		}
	}

	private Student updateCurrentUserInfo() {
//		Student updatedStudent = null;
//		if (!(StringUtils.isEmptyOrWhitespaceOnly(groupField.getText())
//				|| StringUtils.isEmptyOrWhitespaceOnly(nameField.getText())
//				|| StringUtils.isEmptyOrWhitespaceOnly(addressField.getText())
//				|| StringUtils.isEmptyOrWhitespaceOnly(pncField.getText())
//				|| StringUtils.isEmptyOrWhitespaceOnly((icnField.getText())))) {
//
//			updatedStudent = new StudentBuilder().setGroup(groupField.getText()).build();
//			updatedStudent.setIdStudent(((Student) currentStudent).getIdStudent());
//			updatedStudent._setIdUser(((Student) currentStudent)._getIdUser());
//			updatedStudent.setUserName(((Student) currentStudent).getUserName());
//			updatedStudent.setPassword(((Student) currentStudent).getPassword());
//			updatedStudent.setIdUser(currentStudent.getIdUser());
//			updatedStudent.setName(nameField.getText());
//			updatedStudent.setAddress(addressField.getText());
//			updatedStudent.setPNC(pncField.getText());
//			updatedStudent.setICN(icnField.getText());
//		}
//		return updatedStudent;
		return null;

	}

	private void studentCoursesTable(Long idStudent, TableView table) throws ExecutionException {

		table.getColumns().clear();
		table.getColumns().addAll(coursColumn, teacherColumn, examColumn, gradeColumn);
		ObservableList<CoursEnrollementEntity> obs = FXCollections.observableArrayList();
		List<Enrollement> stuentEnrollments = null;
		try {
			stuentEnrollments = enrollmentService.getStudentEnrollements(idStudent);
		} catch (DatabaseAccesException e) {
			showInfoMessage(e.getMessage());
		}
		for (Enrollement studentEnroll : stuentEnrollments) {
			obs.add(new CoursEnrollementEntity(studentEnroll.getCourse().getCourseName(),
					studentEnroll.getCourse().getTeacher().getUser().getName(),
					studentEnroll.getCourse().getExamDate().toString(), studentEnroll.getGrade() + ""));
		}

		coursColumn.setCellValueFactory(new PropertyValueFactory<CoursEnrollementEntity, String>("cours"));
		teacherColumn.setCellValueFactory(new PropertyValueFactory<CoursEnrollementEntity, String>("teacher"));
		examColumn.setCellValueFactory(new PropertyValueFactory<CoursEnrollementEntity, String>("examDate"));
		gradeColumn.setCellValueFactory(new PropertyValueFactory<CoursEnrollementEntity, String>("grade"));

		table.setItems(obs);
	}

	private void studentsTableTeacherPage() throws ExecutionException {

//		studentsTable.getColumns().clear();
//		studentsTable.getColumns().addAll(studentIdColumn, studentNameColumn, studentGroupColumn);
//		ObservableList<Student> obs = FXCollections.observableArrayList();
//		List<Student> students = null;
//		try {
//			students = studentService.getAllStudents();
//		} catch (ExecutionException e) {
//			showInfoMessage(e.getMessage());
//		}
//		for (Student student : students) {
//			obs.add(student);
//		}
//
//		studentIdColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("idStudent"));
//		studentNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
//		studentGroupColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("group"));
//
//		studentsTable.setItems(obs);
	}

	private void comboBox() throws ExecutionException {
		try {
			List<Course> courses = new ArrayList<>();
			// For updating currentUserInfo, I will reUplode student info from database
			//System.err.println(currentStudent.getEnrollement());
			Student uploadedStudent = studentService.getByID(currentStudent.getId());
			//System.err.println(uploadedStudent.getEnrollement());
			List<Enrollement> enrollementsOfCurrentStudent = uploadedStudent.getEnrollement();

			List<Course> takenCourses = new ArrayList<Course>();
			if (Objects.nonNull(enrollementsOfCurrentStudent)) {
				for (Enrollement enrollement : enrollementsOfCurrentStudent) {
					takenCourses.add(enrollement.getCourse());
				}
			}
			courses = courseService.getPossibleOptionsForCoursForStudent(takenCourses);
			ObservableList<String> data = FXCollections.observableArrayList();
			for (Course cours : courses) {
				data.add(cours.getCourseName());
			}
			comboBox.setItems(data);
		} catch (DatabaseAccesException e) {
			showInfoMessage(e.getMessage());
		}

	}

	private void fillStudentFields(Student student) {
		this.nameField.setText(student.getUser().getName());
		this.addressField.setText(student.getUser().getAddress());
		this.pncField.setText(student.getUser().getPNC());
		this.icnField.setText(student.getUser().getICN());
		this.idField.setText("" + student.getId());
		this.groupField.setText(student.getGroupF());
	}

	private void registerPage() throws IOException {
		Stage registertStage = new Stage();
		registertStage.setTitle("Register:");
		Pane pane = FXMLLoader.load(getClass().getResource("/com/assigment2/view/register.fxml"));
		registertStage.setScene(new Scene(pane, 540, 480));
		registertStage.show();
	}

	private void studentPage() throws IOException {
		Stage studentStage = new Stage();
		studentStage.setTitle("Student:");
		Pane pane = FXMLLoader.load(getClass().getResource("/com/assigment2/view/student.fxml"));
		studentStage.setScene(new Scene(pane, 1011, 540));
		studentStage.show();
	}

	private void adminPage() throws IOException {
		Stage adminStage = new Stage();
		adminStage.setTitle("Admin:");
		Pane pane = FXMLLoader.load(getClass().getResource("/com/assigment2/view/admin.fxml"));
		adminStage.setScene(new Scene(pane, 1250, 780));
		adminStage.show();
	}

	private void showInfoMessage(String message) {
		alert.close();
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	private Student getSelectedStudent() {
		return (Student) studentsTable.getSelectionModel().getSelectedItem();
	}

//	private CoursEnrollementEntity getSelectedCours() {
//		return (CoursEnrollementEntity) enrollementsTable.getSelectionModel().getSelectedItem();
//	}

}
