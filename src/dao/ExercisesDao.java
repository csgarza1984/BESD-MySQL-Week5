package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Exercises;

public class ExercisesDao {
	
	private Connection connection;
	private final String GET_EXERCISES_QUERY = "SELECT * FROM exercises";
	private final String CREATE_NEW_EXERCISE_QUERY = "INSERT INTO exercises(exercise_type, name, target) VALUES(?, ?, ?)";
	private final String DELETE_EXERCISE_BY_ID_QUERY = "DELETE FROM exercises WHERE exercise_id_pk = ?";
	private final String CHANGE_EXERCISE_TYPE_BY_ID_QUERY = "UPDATE exercises SET exercise_type = ? WHERE exercise_id_pk = ?";
	
	
	public ExercisesDao() {
		connection = DBConnection.getConnection();
	}

	public List<Exercises> getExercises() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_EXERCISES_QUERY).executeQuery();
		List<Exercises> exercises = new ArrayList<Exercises>();
		
		while (rs.next()) {
			exercises.add(populateExercises(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		
		return exercises;
	}
	
	public void createNewExercise(String exerciseType, String exerciseName, String target) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_EXERCISE_QUERY);
		ps.setString(1, exerciseType);
		ps.setString(2, exerciseName);
		ps.setString(3, target);
		ps.executeUpdate();
	}
	
	public void deleteExerciseById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_EXERCISE_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateExerciseTypeById(String exerciseType, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CHANGE_EXERCISE_TYPE_BY_ID_QUERY);
		ps.setString(1, exerciseType);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	private Exercises populateExercises(int id, String ex_type, String name, String target) {
		return new Exercises(id, ex_type, name, target);
	}
}
