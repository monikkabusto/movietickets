insert into t_movie (castmembers, director, duration, genre, movie_title, rating, sales, year) values ('Gal Gadot.Chris Pine.Robin Wright', 'Patty Jenkins', 141, 'Action.Adventure.Fantasy.Sci-Fi.War', 'Wonder Woman', 'PG-13', 0, 2017);
insert into t_movie (castmembers, director, duration, genre, movie_title, rating, sales, year) values ('Taron Egerton.Colin Firth.Mark Strong.Channing Tatum', 'Matthew Vaughn', 141, 'Action.Adventure.Comedy', 'Kingsman: The Golden Circle', 'R', 0, 2017);
insert into t_movie (castmembers, director, duration, genre, movie_title, rating, sales, year) values ('Mark Wahlberg.Anthony Hopkins.Josh Duhame', 'Michael Bay', 149, 'Action.Adventure.Sci-Fi', 'Transformers: The Last Knight', 'PG-13', 0, 2017);
insert into t_movie (castmembers, director, duration, genre, movie_title, rating, sales, year) values ('Jackie Chan.Dave Franco.Fred Armisen', 'Charlie Bean.Paul Fisher', 101, 'Animation.Action.Adventure.Comedy.Family', 'The LEGO Ninjago', 'Rated PG', 0, 2017);
insert into t_movie (castmembers, director, duration, genre, movie_title, rating, sales, year) values ('Abra.Dido de la Paz.Loonie', 'Treb Monteras II', 110, 'Drama', 'Respeto', 'Rated-13', 0, 2017);

insert into t_cinema (maxx, maxy, venue) values (10, 15, 'Cine Adarna');
insert into t_cinema (maxx, maxy, venue) values (20, 30, 'Cine Adarna');
insert into t_cinema (maxx, maxy, venue) values (19, 17, 'Cine Adarna');

insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 12:31',1,1, 200);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 12:31',2,2, 220);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 12:31',3,3, 230);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 14:32',1,4, 240);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 14:08',2,5, 180);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 15:12',3,1, 200);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 17:13',1,2, 220);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 17:30',2,3, 230);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 17:13',3,4, 240);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 19:23',1,5, 180);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 20:11',2,1, 200);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 19:54',3,2, 220);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 22:12',1,3, 230);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 22:12',2,4, 240);
insert into t_nowshowing (date_and_time, cinema_id, movie_id, price ) values ('2017-09-29 22:04',3,5, 180);	

insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (1, 1, true, 'A:1', 1);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (1, 2, true, 'B:1', 1);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (1, 3, true, 'C:1', 1);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (2, 1, true, 'A:2', 1);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (2, 2, true, 'B:2', 1);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (2, 3, true, 'C:2', 1);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (3, 1, true, 'A:3', 1);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (3, 2, true, 'B:3', 1);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (3, 3, true, 'C:3', 1);

insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (1, 1, true, 'A:1' ,2);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (1, 2, true, 'B:1', 2);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (1, 3, true, 'C:1', 2);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (2, 1, true, 'A:2', 2);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (2, 2, true, 'B:2', 2);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (2, 3, true, 'C:2', 2);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (3, 1, true, 'A:3', 3);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (3, 2, true, 'B:3', 3);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (3, 3, true, 'C:3', 3);

insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (1, 1, true, 'A:1',3);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (1, 2, true, 'B:1', 3);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (1, 3, true, 'C:1', 3);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (2, 1, true, 'A:2', 3);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (2, 2, true, 'B:2', 3);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (2, 3, true, 'C:2', 3);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (3, 1, true, 'A:3', 3);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (3, 2, true, 'B:3', 3);
insert into t_seats(posx, posy, seat, seat_name, cinema_id ) values (3, 3, true, 'C:3', 3);