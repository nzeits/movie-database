BEGIN TRANSACTION;

DROP TABLE IF EXISTS movie;

CREATE TABLE movie (
    movie_id serial,
    title varchar(200) NOT NULL,
	my_rating decimal(3,2) NOT NULL,
	date_watched date NOT NULL,
	CONSTRAINT PK_movie PRIMARY KEY(movie_id),
	CONSTRAINT CHK_my_rating CHECK (my_rating BETWEEN 1 AND 5)
);

INSERT INTO movie (title, my_rating, date_watched) VALUES ('The Avengers', 4, '01/25/2022');
INSERT INTO movie (title, my_rating, date_watched) VALUES ('Avengers: Age of Ultron', 3, '02/05/2022');
INSERT INTO movie (title, my_rating, date_watched) VALUES ('Avengers: Infinity War', 4.25, '02/12/2022');
INSERT INTO movie (title, my_rating, date_watched) VALUES ('Avengers: Endgame', 5, '3/21/2022');

COMMIT;