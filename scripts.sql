CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table team
(
  id        uuid default uuid_generate_v4() not null,
  team_name varchar(10),
  technics  integer,
  constraint team_pk
    primary key (id)
);

create table worker
(
  id         uuid default uuid_generate_v4() not null,
  full_name  varchar(30),
  birth_date date,
  team_id    uuid,
  constraint worker_pk
    primary key (id),
  constraint worker_team_id_fk
    foreign key (team_id) references team
);

create table farm
(
  id      uuid default uuid_generate_v4() not null,
  name    varchar(20),
  owner   varchar(30),
  coord_x double precision,
  coord_y double precision,
  constraint farm_pk
    primary key (id)
);

create table field
(
  id          uuid default uuid_generate_v4() not null,
  field_name  varchar(10),
  square      integer,
  sowing_date date,
  farm_id     uuid,
  constraint field_pkey
    primary key (id),
  constraint field_farm_id_fk
    foreign key (farm_id) references farm
);

create table job
(
  id          uuid default uuid_generate_v4() not null,
  start_date  date,
  finish_date date,
  field_id    uuid,
  team_id     uuid,
  constraint job_pk
    primary key (id),
  constraint job_field_fk
    foreign key (field_id) references field,
  constraint job_team_id_fk
    foreign key (team_id) references team
);

insert into farm (name, owner, coord_x, coord_y)
values ('Колхоз Кирова', 'Иванов Иван Иванович', 43.54325, 43.54634),
       ('Белый яр', 'Егоров Петр Олегович', 36.78954, 58.45245),
       ('Черногорье', 'Милов Александр Дмитриевич', 50.46326, 51.15475);


insert into team (team_name, technics)
values ('Бригада 1', 2),
       ('Бригада 2', 5),
       ('Бригада 3', 10),
       ('Бригада 4', 3),
       ('Бригада 5', 5);

insert into worker (full_name, birth_date, team_id)
values ('Петров Александр Васильевич', '1975-05-22', 'cd1f26ef-758f-4aa5-8f84-fa986faef949'),
       ('Делов Иван Дмитриевич', '1970-02-24', 'cd1f26ef-758f-4aa5-8f84-fa986faef949'),
       ('Листьев Кирилл Алексеевич', '1980-09-10', '5105cd8e-196e-4d49-a46d-e802a2009bb5'),
       ('Детров Валериан Демидович', '1974-07-04', '5105cd8e-196e-4d49-a46d-e802a2009bb5'),
       ('Малинов Аркадий Леонидович', '1980-07-03', '902db3e1-de35-40f8-a6d9-2f7b4dca211c'),
       ('Снежков Борис Вадимович', '1975-02-23', '902db3e1-de35-40f8-a6d9-2f7b4dca211c'),
       ('Кульков Авраам Абрамович', '1972-09-06', '18ae9af7-28f5-4cd5-aa06-35827609f578'),
       ('Достроев Савелий Алексеевич', '1974-02-01', '8e5b4f8f-9793-4928-9d19-7a270e6d1854'),
       ('Растраев Иван Леонидович', '1972-09-05', '8e5b4f8f-9793-4928-9d19-7a270e6d1854'),
       ('Королев Василий Демидович', '1984-12-08', '8e5b4f8f-9793-4928-9d19-7a270e6d1854');

insert into field (field_name, square, sowing_date, farm_id)
values ('Кукуруза', 35, '01.05.2018', 'ac0456ad-bd59-4666-b83e-3eba2985ff4a'),
       ('Пшеница', 30, '02.05.2018', 'f1a80625-e69b-4242-a2e4-b5a7b8337347'),
       ('Овес', 36, '30.04.2018', 'ab6e086a-ad61-49e2-98ab-9b0c02c11fe2'),
       ('Кукуруза', 23, '05.05.2018', 'ab6e086a-ad61-49e2-98ab-9b0c02c11fe2'),
       ('Мак', 25, '03.05.2018', 'f1a80625-e69b-4242-a2e4-b5a7b8337347');

INSERT INTO job ("start_date", "finish_date", "field_id", "team_id")
VALUES ('2018-06-06', '2018-06-16', '6fcd02a7-87d0-4edb-a695-2d70792a6869',
        'cd1f26ef-758f-4aa5-8f84-fa986faef949'),
       ('2018-06-01', '2018-06-05', 'dd2fe7a7-6fb8-4cd0-8605-3204b6858766',
        '5105cd8e-196e-4d49-a46d-e802a2009bb5'),
       ('2018-06-05', '2018-06-20', '3ee7052e-d4a0-40d6-86ef-9cae40ff907e',
        '902db3e1-de35-40f8-a6d9-2f7b4dca211c'),
       ('2018-06-02', '2018-06-11', '56d0e4d3-0f6e-4625-8d03-3fbf8fa9ce8c',
        '18ae9af7-28f5-4cd5-aa06-35827609f578'),
       ('2018-06-01', '2018-06-05', '3ee7052e-d4a0-40d6-86ef-9cae40ff907e',
        '5105cd8e-196e-4d49-a46d-e802a2009bb5');


