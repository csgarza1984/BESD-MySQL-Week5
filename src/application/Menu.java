package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.ExercisesDao;
import entity.Exercises;

public class Menu {

	private ExercisesDao exercisesDao = new ExercisesDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Exercises",
			"Add an Exercise",
			"Delete an Exercise",
			"Change an Exercise Type");
			
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayExercises();
				} else if (selection.equals("2")) {
					addExercise();
				} else if (selection.equals("3")) {
					deleteExercise();
				} else if (selection.equals("4")) {
					changeExerciseType();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			System.out.println("Press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayExercises() throws SQLException {
		List<Exercises> exercises = exercisesDao.getExercises();
		for (Exercises exercise : exercises) {
			System.out.println(exercise.getExerciseId() + ":  " 
					+ exercise.getExerciseType() + " / "
					+ exercise.getExerciseName() + " / "
					+ exercise.getTarget());
		}
	}
	
	private void addExercise() throws SQLException {
		System.out.print("Enter exercise type:  ");
		String exerciseType = scanner.nextLine();
		System.out.print("Enter exercise name:  ");
		String exerciseName = scanner.nextLine();
		System.out.print("Enter target:  ");
		String target = scanner.nextLine();
		exercisesDao.createNewExercise(exerciseType, exerciseName, target);
	}
	
	private void deleteExercise() throws SQLException {
		System.out.print("Enter exercise id to delete:  ");
		int id = Integer.parseInt(scanner.nextLine());
		exercisesDao.deleteExerciseById(id);
	}
	
	private void changeExerciseType() throws SQLException {
		System.out.print("Enter exercise id for type change:  ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter new exercise type:  ");
		String exerciseType = scanner.nextLine();
		exercisesDao.updateExerciseTypeById(exerciseType, id);
	}
}
