insert into users (username, email, password) values 
	('jojo', 'codeyasam', '$2a$10$KRtic9o7kMHp20/OgC96aODJoVRKQqLMPahmzXh.es5zo3xG38QYq'),
	('codeyasam', 'jojo', '$2a$10$KRtic9o7kMHp20/OgC96aODJoVRKQqLMPahmzXh.es5zo3xG38QYq');

insert into roles (role) values
	('ROLE_USER'), ('ROLE_ADMIN'), ('ROLE_ACTUATOR');

insert into users_roles (user_id, role_id) values 
	(1, 1), (1,2), (1,3), (2,1);