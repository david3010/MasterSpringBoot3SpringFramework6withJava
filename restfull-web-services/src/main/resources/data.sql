insert into user_details(id, birth_date, name) values (1001, CURRENT_DATE(), 'David Gallegos');
insert into user_details(id, birth_date, name) values (1002, CURRENT_DATE(), 'Isai Gallegos');
insert into user_details(id, birth_date, name) values (1003, CURRENT_DATE(), 'Nalle Gallegos');

insert into post(id, user_id, description) values (1001,1001, 'I want to learn aws');
insert into post(id, user_id, description) values (1002,1002, 'I want to learn devops');
insert into post(id, user_id, description) values (1003,1002, 'I want to learn java');