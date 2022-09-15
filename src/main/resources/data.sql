insert into admin(username, password, first_name, last_name,phone_number,email,status) values ('admin','1234','Boris','Knezevic','061234567','boris.knezevic@mail.ru',true);

insert into trainer(username, password, first_name, last_name,phone_number,email,status) values ('trainer1','1234','Marko','Markovic','061234567','marko.markovic@mail.ru',true);

insert into member(username, password, first_name, last_name,phone_number,email,status) values ('member1','1234','Pera','Peric','061234567','pera.peric@mail.ru',true);
insert into member(username, password, first_name, last_name,phone_number,email,status) values ('member2','1234','Jovana','Jovanovic','061234567','jovana.jovanovic@mail.ru',true);
insert into member(username, password, first_name, last_name,phone_number,email,status) values ('member3','1234','Sima','Simic','061234567','sima.simic@mail.ru',true);

insert into training_type(name,description,trainer_id)
values ('Trening stage', 'Ovo je traning stage.',1);

insert into fitness_center(name, address, phone_number, email)
values ('FT1','Cara Dusana 1389','036251458','ft1@mail.ru');


insert into hall (mark, capacity, fitness_center_id) values ('H1',20,1);
insert into hall (mark, capacity, fitness_center_id) values ('H2',20,1);


insert into training(name, description, duration, training_type_id)
values ('POWER100','Ovo je trening snage. Tralalala.', 100,1);