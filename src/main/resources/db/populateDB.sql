DELETE FROM users;
DELETE FROM employees;
DELETE FROM doc_types;
DELETE FROM doc_units;
DELETE FROM units;
DELETE FROM services;
DELETE FROM documents;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO services (name)
VALUES ('Картридж'),
       ('Доставка грузовым автотранспортом'),
       ('Лампа светодиодная');

INSERT INTO units (name)
VALUES ('шт'),
       ('кг'),
       ('упак');

INSERT INTO doc_types (name)
VALUES ('Накладная'),
       ('Счет фактура'),
       ('УПД');

INSERT INTO doc_units (service_id, unit_id)
VALUES (100000, 100003),
       (100002, 100003);

INSERT INTO employees (org_id, full_name)
VALUES (94234527, 'Иванов Иван Иванович'),
       (94234134, 'Петров Петр Петрович'),
       (94234215, 'Измаилов Артур Венедиктович');

INSERT INTO documents (date_time, value, sum, doc_type_id, doc_unit_id, employee_id)
VALUES ('2021-05-30 09:00:00', 'Магазин Энергия', 13000, 100006, 100010, 100012),
       ('2021-07-10 08:00:00', 'Материалы отопление', 174523, 100007, 100009, 100011),
       ('2021-07-11 07:00:00', 'Материалы отопление2', 774523, 100007, 100009, 100011),
       ('2021-07-12 08:00:00', 'Материалы отопление3', 474523, 100007, 100009, 100011),
       ('2021-08-13 06:00:00', 'Материалы отопление4', 124523, 100007, 100009, 100011);
