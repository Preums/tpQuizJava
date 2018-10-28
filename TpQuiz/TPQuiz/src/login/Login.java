package login;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

	public static User checkIdent(String email,String password) {
		User user = new User();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tp_quiz", "Preums", "password");
			String sqlRequest = "SELECT id_user, firstname, lastname, function, password From users WHERE email = ?";
			PreparedStatement preparedSelect = con.prepareStatement(sqlRequest);
			preparedSelect.setString(1,email);
			ResultSet preparedResult = preparedSelect.executeQuery();
			if(preparedResult != null) {
				preparedResult.next();
				user.setId(preparedResult.getInt(1));
				user.setFirstname(preparedResult.getString(2));
				user.setLastname(preparedResult.getString(3));
				user.setFunction(preparedResult.getString(4));
				user.setUserMessage("Bienvenue "+preparedResult.getString(2));} else {
				user.setUserMessage("Identification invalide");
			}
			con.close();	
		} catch (Exception e) {
			System.out.println("connexion unavailable, the error message is:\n"+e);
			user.setUserMessage("Identification invalide");
		}
		return user;
	}

}
