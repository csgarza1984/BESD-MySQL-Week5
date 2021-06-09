package entity;

public class Exercises {

	private int exerciseId;
	private String exerciseType;
	private String exerciseName;
	private String target;
	
	public Exercises(int exerciseId, String exerciseType, String exerciseName, String target) {
		this.setExerciseId(exerciseId);
		this.setExerciseType(exerciseType);
		this.setExerciseName(exerciseName);
		this.setTarget(target);
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	public String getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
}
