DELETE
FROM users;
DELETE
FROM user_groups;
DELETE
FROM user_departments;
DELETE
FROM todos;

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

INSERT INTO users (user_name, password, email, full_name, boss, user_group_id, user_department_id)
VALUES ('user', '$2a$12$umiAUHsIK9xFm6BYTtoHq.6esFnXeEilc23rij/aWI9nVPMwEauOS', 'usersv@yandex.ru', 'Ivanov Ivan Ivanovich', true, 100000, 100004);

INSERT INTO todos (date_time, name, description, checked, user_id)
VALUES ('2021-12-28 00:00:00', 'Провести учения по пожарной безопасности',
        'Согласно распоряжения главного инженера провести учения по пожарной безопасности с использованием спецодежды и огнетушителя',
        false, 100007),
       ('2021-12-22 00:00:00', 'Проверить состояние опоры по улице Ленина',
        NULL,
        false, 100007);

INSERT INTO sub_todos (date_time, name, description, checked, todo_id)
VALUES ('2021-12-28 10:00:00', 'Подготовить огнетушитель для учений',
        NULL,
        false, 100008),
       ('2021-12-28 10:00:00', 'Заполнить журнал инструктажа',
        '123',
        false, 100008),
       ('2021-12-28 10:00:00', 'Провести инструктаж всех участвующих эл. механиков',
        '123',
        false, 100008);

