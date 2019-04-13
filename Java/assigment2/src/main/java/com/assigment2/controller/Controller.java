package com.assigment2.controller;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import com.assigment2.database.config.HibernateUtil;
import com.assigment2.model.entities.Student;
import com.assigment2.model.repositories.DatabaseAccesException;
import com.assigment2.model.repositories.StudentRepository;
import com.assigment2.model.services.StudentService;

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
//	// private TeacherRepository teacherRepo = new
//	// TeacherRepository(HibernateUtil.getSessionFactory());
//	private UserRepository userRepo = new UserRepository(HibernateUtil.getSessionFactory());
//	// private EnrollementRepository enrolementRepo = new
//	// EnrollementRepository(dbConnectionWrapper);
//	// private CoursRepository coursRepo = new CoursRepository(dbConnectionWrapper);
//	private UserService userService = new UserService(userRepo);
	private StudentService studentService = new StudentService(studentRepo);
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
	private void enroleButton(ActionEvent event) throws ExecutionException {
//		String selectedCours = comboBox.getValue();
//		Cours cours = studentService.getSelectedCours(selectedCours);
//		Enrollment enrollement = new Enrollment();
//		enrollement.setStudent_id(((Student) currentStudent).getIdStudent());
//		enrollement.setCours_id(cours.getIdCours());
//		enrollement.setGrade(INITIAL_GRADE);
//		studentService.addEnrollement(enrollement);
//		refreshButton.fire();
//		showInfoMessage("Enrollement with success!");
	}

	@FXML
	private void register(ActionEvent event) {
//		Student newUser = null;
//		if (!(StringUtils.isEmptyOrWhitespaceOnly(nameRegister.getText())
//				|| StringUtils.isEmptyOrWhitespaceOnly(addressRegister.getText())
//				|| StringUtils.isEmptyOrWhitespaceOnly(pncRegister.getText())
//				|| StringUtils.isEmptyOrWhitespaceOnly(icnRegister.getText())
//				|| StringUtils.isEmptyOrWhitespaceOnly((groupRegister.getText()))
//				|| StringUtils.isEmptyOrWhitespaceOnly(userNameRegister.getText())
//				|| StringUtils.isEmptyOrWhitespaceOnly(passwordRegister.getText())
//				|| StringUtils.isEmptyOrWhitespaceOnly(cPasswordRegister.getText()))) {
//			newUser = new Student();
//			newUser.setName(nameRegister.getText());
//			newUser.setAddress(addressRegister.getText());
//			newUser.setPNC(pncRegister.getText());
//			newUser.setICN(icnRegister.getText());
//			newUser.setGroup(groupRegister.getText());
//			newUser.setUserName(userNameRegister.getText());
//			newUser.setPassword(passwordRegister.getText());
//			Validator validator = new Validator();
//
//			if (validator.validatePassword(passwordRegister.getText(), cPasswordRegister.getText())) {
//				try {
//					currentStudent = studentService.addUser(newUser);
//					Stage stage = (Stage) registerButtonRegister.getScene().getWindow();
//					stage.close();
//					studentPage();
//				} catch (ExecutionException e) {
//					showInfoMessage(e.getMessage());
//				} catch (IOException e) {
//					showInfoMessage(e.getMessage());
//				}
//			} else {
//				registerMessage.setText("Confirmed password is incorrect!");
//			}
//		} else {
//			showInfoMessage("Pease fill all the fields!");
//		}

	}

	@FXML
	private void refresh(ActionEvent event) {
//		Student student;
//		try {
//			student = (Student) studentService.getStudentWithId(((Student) currentStudent).getIdStudent());
//			fillStudentFields(student);
//			studentCoursesTable(((Student) currentStudent).getIdStudent(), tabelView);
//			comboBox();
//		} catch (ExecutionException e) {
//			showInfoMessage(e.getMessage());
//		}

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

//		table.getColumns().clear();
//		table.getColumns().addAll(coursColumn, teacherColumn, examColumn, gradeColumn);
//		ObservableList<CoursEnrollementEntity> obs = FXCollections.observableArrayList();
//		List<CoursEnrollementEntity> stuentEnrollments = null;
//		try {
//			stuentEnrollments = studentService.getStudentEnrollements(idStudent);
//		} catch (ExecutionException e) {
//			showInfoMessage(e.getMessage());
//		}
//		for (CoursEnrollementEntity studentEnroll : stuentEnrollments) {
//			obs.add(studentEnroll);
//		}
//
//		coursColumn.setCellValueFactory(new PropertyValueFactory<CoursEnrollementEntity, String>("cours"));
//		teacherColumn.setCellValueFactory(new PropertyValueFactory<CoursEnrollementEntity, String>("teacher"));
//		examColumn.setCellValueFactory(new PropertyValueFactory<CoursEnrollementEntity, String>("examDate"));
//		gradeColumn.setCellValueFactory(new PropertyValueFactory<CoursEnrollementEntity, String>("grade"));
//
//		table.setItems(obs);
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
//		ArrayList<Cours> courses = new ArrayList<>();
//		courses = studentService.getPossibleOptionsForCoursForStudent(((Student) currentStudent).getIdStudent());
//		ObservableList<String> data = FXCollections.observableArrayList();
//		for (Cours cours : courses) {
//			data.add(cours.getCoursName());
//		}
//		comboBox.setItems(data);
	}

	private void fillStudentFields(Student user) {
//		this.nameField.setText(user.getName());
//		this.addressField.setText(user.getAddress());
//		this.pncField.setText(user.getPNC());
//		this.icnField.setText(user.getICN());
//		this.idField.setText("" + user.getIdStudent());
//		this.groupField.setText(user.getGroup());
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
