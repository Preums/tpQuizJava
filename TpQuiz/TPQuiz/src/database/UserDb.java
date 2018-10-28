package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import login.Student;
import login.User;

public class UserDb {
	
	public ArrayList<User> getStudentList() {
		
		ArrayList<User> listing = new ArrayList<User>();
		try {
			DataSource connect = new DataSource();
			Connection con = connect.dataSourceConnexion();
			
			String sqlRequest = "SELECT id_user, firstname, lastname, function From users WHERE function = 'student'";
			PreparedStatement preparedSelect = con.prepareStatement(sqlRequest);
			ResultSet preparedResult = preparedSelect.executeQuery();
			while(preparedResult.next()) {
				User user = new User();
				user.setId(Integer.parseInt(preparedResult.getString(1)));
				user.setFirstname(preparedResult.getString(2));
				user.setLastname(preparedResult.getString(3));
				user.setFunction(preparedResult.getString(4));
				listing.add(user);
			}

			con.close();
			
		} catch (Exception e) {
			System.out.println("connexion unavailable, the error message is:\n"+e);
		}
		return listing;
	}
	
	public User getEmployee(int id) {
		User seletedUser = new User();
		try {
			DataSource connect = new DataSource();
			Connection con = connect.dataSourceConnexion();
			
			String sqlRequest = "SELECT id_user, firstname, lastname, email, function From users WHERE id_user =?";
			PreparedStatement preparedSelect = con.prepareStatement(sqlRequest);
			preparedSelect.setInt(1, id);
			ResultSet preparedResult = preparedSelect.executeQuery();
			preparedResult.next();
				seletedUser.setId(Integer.parseInt(preparedResult.getString(1)));
				seletedUser.setFirstname(preparedResult.getString(2));
				seletedUser.setLastname(preparedResult.getString(3));
				seletedUser.setEmail(preparedResult.getString(4));
				seletedUser.setFunction(preparedResult.getString(5));

			con.close();
			
		} catch (Exception e) {
			System.out.println("connexion unavailable, the error message is:\n"+e);
		}
		return seletedUser;
	}
	
	public Student getStudent(int id) {
		Student seletedUser = new Student();
		try {
			DataSource connect = new DataSource();
			Connection con = connect.dataSourceConnexion();
			
			String sqlRequest = "SELECT users.id_user, users.firstname, users.lastname, "
					+ "users.email, users.function, students.admission_score, "
					+ "students.graduate, students.completed_courses, students.corrected_courses "
					+ "From users INNER JOIN students USING(id_user) WHERE id_user =?";
			PreparedStatement preparedSelect = con.prepareStatement(sqlRequest);
			preparedSelect.setInt(1, id);
			ResultSet preparedResult = preparedSelect.executeQuery();
			preparedResult.next();
				seletedUser.setId(Integer.parseInt(preparedResult.getString(1)));
				seletedUser.setFirstname(preparedResult.getString(2));
				seletedUser.setLastname(preparedResult.getString(3));
				seletedUser.setEmail(preparedResult.getString(4));
				seletedUser.setFunction(preparedResult.getString(5));
				seletedUser.setAdmission_score(preparedResult.getInt(6));
				seletedUser.setGraduate(preparedResult.getBoolean(7));
				seletedUser.setCompleted_courses(preparedResult.getInt(8));
				seletedUser.setCorrected_courses(preparedResult.getInt(9));

			con.close();
			
		} catch (Exception e) {
			System.out.println("connexion unavailable, the error message is:\n"+e);
		}
		return seletedUser;
	}
	
	public ArrayList<User> getEmployeesList() {
		
		ArrayList<User> listing = new ArrayList<User>();
		try {
			DataSource connect = new DataSource();
			Connection con = connect.dataSourceConnexion();
			
			String sqlRequest = "SELECT id_user, firstname, lastname, function From users WHERE function = 'teacher' OR function ='admin'";
			PreparedStatement preparedSelect = con.prepareStatement(sqlRequest);
			ResultSet preparedResult = preparedSelect.executeQuery();
			while(preparedResult.next()) {
				User user = new User();
				user.setId(Integer.parseInt(preparedResult.getString(1)));
				user.setFirstname(preparedResult.getString(2));
				user.setLastname(preparedResult.getString(3));
				user.setFunction(preparedResult.getString(4));
				listing.add(user);
			}

			con.close();
			
		} catch (Exception e) {
			System.out.println("connexion unavailable, the error message is:\n"+e);
		}
		return listing;
	}
	public void SetStudent(
			String firstname,
			String lastname,
			String email,
			String password,
			float admission_score
			) {

		try {
			DataSource connect = new DataSource();
			Connection con = connect.dataSourceConnexion();
			
			String sqlRequest = "INSERT INTO users(firstname, lastname, email, password, function) VALUES (?,?,?,?,'student')";
			PreparedStatement preparedSelect = con.prepareStatement(sqlRequest);
			preparedSelect.setString(1, firstname);
			preparedSelect.setString(2, lastname);
			preparedSelect.setString(3, email);
			preparedSelect.setString(4, password);
			preparedSelect.executeUpdate();
	
			sqlRequest = "SELECT id_user FROM users where email=?";
			preparedSelect = con.prepareStatement(sqlRequest);
			preparedSelect.setString(1, email);
			ResultSet preparedResult = preparedSelect.executeQuery();
			preparedResult.next();
			Long idToUpdate = preparedResult.getLong(1);
			
			
			sqlRequest = "INSERT INTO students (id_user, admission_score) VALUES (?,?)";
			preparedSelect = con.prepareStatement(sqlRequest);
			preparedSelect.setLong(1, idToUpdate);
			preparedSelect.setFloat(2, admission_score);
			preparedSelect.executeUpdate();

			con.close();
			
		} catch (Exception e) {
			System.out.println("connexion unavailable, the error message is:\n"+e);
		}
	}
	
	public void SetUser(
			String firstname,
			String lastname,
			String email,
			String password,
			String function
			) {

		try {
			DataSource connect = new DataSource();
			Connection con = connect.dataSourceConnexion();
			
			String sqlRequest = "INSERT INTO users(firstname, lastname, email, password, function) VALUES (?,?,?,?,?)";
			PreparedStatement preparedSelect = con.prepareStatement(sqlRequest);

			preparedSelect.setString(1, firstname);
			preparedSelect.setString(2, lastname);
			preparedSelect.setString(3, email);
			preparedSelect.setString(4, password);
			preparedSelect.setString(5, function);
			preparedSelect.executeUpdate();

			con.close();
			
		} catch (Exception e) {
			System.out.println("connexion unavailable, the error message is:\n"+e);
		}
	}
	
	public void deleteUser(String id_user) {
		try {
			DataSource connect = new DataSource();
			Connection con = connect.dataSourceConnexion();
			
			String sqlRequest = "DELETE FROM users WHERE id_user=?";
			PreparedStatement preparedSelect = con.prepareStatement(sqlRequest);
			preparedSelect.setString(1, id_user);
			preparedSelect.executeUpdate();

			con.close();
			
		} catch (Exception e) {
			System.out.println("connexion unavailable, the error message is:\n"+e);
		}
	}

	public void updateStudent(String id_user, String firstname, String lastname, String email, String function, String admission_score,
			String completed_courses, String corrected_courses, int graduate) {
		try {
			DataSource connect = new DataSource();
			Connection con = connect.dataSourceConnexion();
			
			String sqlRequest = "UPDATE users SET firstname=?,lastname=?,email=?,function=? WHERE id_user=?";
			PreparedStatement preparedSelect = con.prepareStatement(sqlRequest);
			preparedSelect.setString(1, firstname);
			preparedSelect.setString(2, lastname);
			preparedSelect.setString(3, email);
			preparedSelect.setString(4, function);
			preparedSelect.setString(5, id_user);
			preparedSelect.executeUpdate();
			
			sqlRequest = "UPDATE students SET admission_score=?,completed_courses=?,corrected_courses=?,graduate=? WHERE id_user=?";
			preparedSelect = con.prepareStatement(sqlRequest);
			preparedSelect.setString(1, admission_score);
			preparedSelect.setString(2, completed_courses);
			preparedSelect.setString(3, corrected_courses);
			preparedSelect.setInt(4, graduate);
			preparedSelect.setString(5, id_user);
			preparedSelect.executeUpdate();

			con.close();
			
		} catch (Exception e) {
			System.out.println("connexion unavailable, the error message is:\n"+e);
		}
	}

	public void updateUser(String id_user, String firstname, String lastname, String email, String function) {
		try {
			DataSource connect = new DataSource();
			Connection con = connect.dataSourceConnexion();
			
			String sqlRequest = "UPDATE users SET firstname=?,lastname=?,email=?,function=? WHERE id_user=?";
			PreparedStatement preparedSelect = con.prepareStatement(sqlRequest);
			preparedSelect.setString(1, firstname);
			preparedSelect.setString(2, lastname);
			preparedSelect.setString(3, email);
			preparedSelect.setString(4, function);
			preparedSelect.setString(5, id_user);
			preparedSelect.executeUpdate();

			con.close();
			
		} catch (Exception e) {
			System.out.println("connexion unavailable, the error message is:\n"+e);
		}
	}
}
