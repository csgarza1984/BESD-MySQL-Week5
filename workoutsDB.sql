CREATE database IF NOT EXISTS workouts;

use workouts;

DROP TABLE IF EXISTS exercises;

CREATE TABLE exercises (
	exercise_id_pk int NOT NULL auto_increment,
	exercise_type varchar(20) NOT NULL,
	name varchar(50) NOT NULL,
	target varchar(40) NOT NULL,
	PRIMARY key(exercise_id_pk)
);

