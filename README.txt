This project is about "Movie booking system". What is "Movie booking system application"?
 It is a simple console application that helps the user to reserve a movie.
This application is connected with the database, so it stores information about movies, users and reservation. In my project, I have following classes:
1) Main class - As the name itself says, this class is the most important and special because here is the main part of the code; this is where the entire project is focused on.
2) Movie class - This class is created for initializing fields and adding information about Movie. In this class, I’ve created getter and setter functions to get and set the values; 
 1.The name is used to initialize the name of the movie; through this field the user and the program can enter and get names of the movies;
 2.The time is used to show the time of the movie; 
 3.The country and genre fields are created to store information about the movie’s country and genre
3) User class - This class is created for initializing fields and adding information about the user. In this class, I’ve created getter and setter functions to get and set the values; 
 1.The name is used to initialize the user’s name;
 2.The phone_number initialize the user’s phone number
4) Children_movie class - This class is the subclass of the Movie class; the reason of creating this class is children category. The user should choose the category of the film during the booking procedure, so for that reason the ChildrenMovie class is created.
5) Adult_movie class - This class was created with the same reason as it was with the ChildrenMovie class. The only difference is that this class is for the adult category.

Also, as I mentioned before, my project is connected with the database, so I've created a database with following tables:
1)The "user1" table stores information about users. The data that the user enters in the Console is redirected to this table and stored there.
The query of this table:
create table user1(
	user_id serial primary key,
	user_name varchar(25),
	user_number varchar(12)
);

2)The “movies” table stores all the information about the available movies. This table is needed to access the list of movies and select the desired movie from there. This table was previously filled with 25 rows with different movies, which are then displayed to the user.
Creation of this table:
create table movies(
	movie_id serial primary key,
	movie_name varchar(50),
	movie_country varchar(20),
	movie_category varchar(20),
	movie_genre varchar(20),
        movie_time varchar(50)
);
Inserting values into this table:
insert into movies(movie_name, movie_country, movie_category, movie_genre, movie_time) values
('Emily in Paris', 'USA','Adult','comedy, romance', '10:00'),
('Emily in Paris', 'USA','Adult','comedy, romance', '15:00'),
('Emily in Paris', 'USA','Adult','comedy, romance', '20:00'),
('Emily in Paris', 'USA','Adult','comedy, romance', '23:00'),
('Tom and Jerry', 'England', 'Children', 'comedy','09:00'),
('Tom and Jerry', 'England', 'Children', 'comedy','12:30'),
('Tom and Jerry', 'England', 'Children', 'comedy','16:45'),
('Tom and Jerry', 'England', 'Children', 'comedy','17:00'),
('Lion King', 'USA', 'Children', 'comedy', '10:00'),
('Lion King', 'USA', 'Children', 'comedy', '13:55'),
('Back to the Future', 'USA', 'Adult', 'fantasy', '18:35'),
('Back to the Future', 'USA', 'Adult', 'fantasy', '22:00'),
('Snatch', 'England', 'Adult', 'crime', '23:50'),
('Shrek', 'USA', 'Children', 'comedy', '12:00'),
('Shrek', 'USA', 'Children', 'comedy', '14:30'),
('Shrek', 'USA', 'Children', 'comedy', '17:45'),
('Edge of Tomorrow', 'USA', 'Adult', 'fantasy', '22:00'),
('Alien', 'England', 'Adult', 'horror', '21:00'),
('Alien', 'England', 'Adult', 'horror', '22:45'),
('The Originals', 'England', 'Adult', 'drama', '17:45'),
('The Originals', 'England', 'Adult', 'drama', '22:45'),
('Soul', 'USA', 'Children', 'comedy, fantasy', '10:45'),
('Soul', 'USA', 'Children', 'comedy, fantasy', '13:25'),
('Soul', 'USA', 'Children', 'comedy, fantasy', '17:05'),
('Soul', 'USA', 'Children', 'comedy, fantasy', '20:00');

3)The “reservation” table is needed to store information about the reservation, more precisely, information about which user has reserved which movie.
create table reservation(
	user_id int,
	movie_id int,
	foreign key(user_id) references user1(user_id),
	foreign key(movie_id) references movies(movie_id)
);

4)The “cinema” table is needed to store information about cinemas.
Creation of this table:
create table cinema(
	cinema_id serial primary key,
	cinema_name varchar(20)
);
Inserting values into this table:
insert into cinema(cinema_name) values 
('Arsenal'),('Kinoplex'), ('Chaplin'), ('Keruen'), ('Arman');

5)The “city” table is needed to store information about cities.
Creation of this table:
create table city(
	city_id serial primary key,
	city_name varchar(20)
);
Inserting values into this table:
insert into city(city_name) values
('Atyrau'), ('Almaty'), ('Astana'), ('Shymkent'), ('Semey');

6)The “cinema_city” table was created to link cities with movie theaters. This table shows which movie theater in which city the user wants to book.
Creation of this table:
create table cinema_city(
	city_id int,
	cinema_id int,
	foreign key(city_id) references city(city_id),
	foreign key(cinema_id) references cinema(cinema_id)
);
Inserting values into this table:
insert into cinema_city
values
(1,1),(1,2),(1,3),(1,4),(1,5),
(2,1),(2,2),(2,3),(2,4),(2,5),
(3,1),(3,2),(3,3),(3,4),(3,5),
(4,1),(4,2),(4,3),(4,4),(4,5),
(5,1),(5,2),(5,3),(5,4),(5,5);

Entity Relationship Diagram
Business rule:
1)	Movie – to book – reservation
2)	User – to book – reservation
3)	Cinema – has – cinema_city
4)	City – has – cinema_city
Movie(optional) many to many (optional) Reservation:
	One movie can be reserved several times;
	Multiple movies can be booked per reservation;
User(required) one to many (optional) Reservation:
	One user can make many reservations;
	The same reservation cannot be made by two different people;
Cinema(optional) many to one(required) Cinema_city
City(optional) many to one(required) Cinema_city
	One cinema_city can have multiple data with the same cinema, because the same cinema is also available in other cities.
	By the same logic, a one cinema_city can have multiple data with the same city, but with different cinemas.



