create table t_cinema (id  bigserial not null, maxx int4 not null, maxy int4 not null, venue varchar(255), primary key (id))
create table t_movie (id  bigserial not null, castmembers varchar(255), director varchar(255), duration int4, genre varchar(255), movie_title varchar(255) not null, rating varchar(255), sales int4 not null, year int4, primary key (id))
create table t_nowshowing (id  bigserial not null, price numeric(19, 2), schedule bytea, cinema_id int8, movie_id int8, primary key (id))
create table t_seats (id  bigserial not null, posx int4 not null, posy int4 not null, seat boolean not null, cinema_id int8, primary key (id))
create table t_ticket (id  bigserial not null, posx int4 not null, posy int4 not null, seat_label varchar(255), now_showing_id int8, primary key (id))
alter table t_nowshowing add constraint FK51i5wb7ap09a6yo95bggxs4oi foreign key (cinema_id) references t_cinema
alter table t_nowshowing add constraint FKhbximprf39lt75wdg4c8ucdpr foreign key (movie_id) references t_movie
alter table t_seats add constraint FKf7l418adqpuorhph3vt6o98t5 foreign key (cinema_id) references t_cinema
alter table t_ticket add constraint FKm5mki4u99kvhxueowpecl1w7e foreign key (now_showing_id) references t_nowshowing
