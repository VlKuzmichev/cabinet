DELETE FROM users;
DELETE FROM user_groups;
DELETE FROM user_departments;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO user_groups (name)
VALUES ('НС Чита'),
       ('РЦС Чита'),
       ('РЦС Могоча'),
       ('РЦС Белогорск');

INSERT INTO user_departments (name)
VALUES ('КИП Могоча'),
       ('Кабельный Могоча'),
       ('ЛАЗ Шилка');

INSERT INTO users (user_name, password, email, full_name, boss ,user_group_id, user_department_id)
VALUES ('User', '{noop}password', 'usersv@yandex.ru','Ivanov Ivan Ivanovich', true, 100000, 100004);


