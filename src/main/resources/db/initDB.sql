DROP TABLE IF EXISTS orders_users;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS sub_todos;
DROP TABLE IF EXISTS todos;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_groups;
DROP TABLE IF EXISTS user_departments;

DROP SEQUENCE IF EXISTS order_seq;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;
CREATE SEQUENCE order_seq START WITH 100;

-- в поручении поле ознакомлены(список users)
-- пользователи ознакамливаются вручную
CREATE TABLE orders
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    number      INTEGER   NOT NULL  DEFAULT nextval('order_seq'),
    date_time   TIMESTAMP NOT NULL, -- время создания
    name        VARCHAR   NOT NULL, -- заголовок поручения
    description TEXT      NOT NULL  -- текст поручения
);
CREATE UNIQUE INDEX orders_unique_number_idx ON orders (number);

-- Задания
CREATE TABLE todos
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    date_time   TIMESTAMP NOT NULL, -- время создания
    end_date    TIMESTAMP NOT NULL, -- deadline
    name        VARCHAR   NOT NULL, -- заголовок задания
    description VARCHAR   NOT NULL, -- текст задания
    checked     BOOLEAN   NOT NULL  -- отметка о выполнении
);

-- Подзадания в заданиях
CREATE TABLE sub_todos
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    date_time   TIMESTAMP NOT NULL, -- время создания
    end_date    TIMESTAMP NOT NULL, -- deadline
    name        VARCHAR   NOT NULL, -- заголовок подзадания
    description VARCHAR   NOT NULL, -- текст подзадания
    checked     BOOLEAN   NOT NULL, -- отметак о выполнении
    todo_id     INTEGER   NOT NULL, -- связь с таблицей todos(1 ко М)
    FOREIGN KEY (todo_id) REFERENCES todos (id) ON DELETE CASCADE
);


-- Подразделения (РЦС 1,2,3, НС)
CREATE TABLE user_groups
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR NOT NULL -- наименование подразделения
);
-- Подразделения с одинаковым именем нет
CREATE UNIQUE INDEX user_groups_unique_name_idx ON user_groups (name);

-- Отделы / цеха
CREATE TABLE user_departments
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name      VARCHAR NOT NULL, -- краткое наименование подразделения
    full_name VARCHAR NULL      -- полное наименование подразделения
);
-- Отдела с одинаковым кратким и полным наименованием нет
CREATE UNIQUE INDEX user_departments_unique_name_idx ON user_departments (name);
CREATE UNIQUE INDEX user_departments_unique_full_name_idx ON user_departments (full_name);

-- Пользователи(авторизация в системе)
CREATE TABLE users
(
    id                 INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_name          VARCHAR NOT NULL, -- логин
    password           VARCHAR NOT NULL, -- пароль
    email              VARCHAR NOT NULL, -- адрес эл. почты
    full_name          VARCHAR NOT NULL, -- ФИО
    boss               BOOLEAN DEFAULT false NOT NULL, -- право издавать поручения BOOLEAN
    user_group_id      INTEGER NOT NULL, -- поле таблицы user_groups
    user_department_id INTEGER NOT NULL, -- поле таблицы user_groups
    FOREIGN KEY (user_group_id) REFERENCES user_groups (id) ON DELETE CASCADE,
    FOREIGN KEY (user_department_id) REFERENCES user_departments (id) ON DELETE CASCADE
);
-- Пользователей с одинаковым логином нет
CREATE UNIQUE INDEX users_unique_user_name_idx ON users (user_name);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE orders_users
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    order_id INTEGER NOT NULL, -- связь с таблицей orders
    user_id  INTEGER NOT NULL, -- связь с таблицей users
    FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
-- Ограничение только одно конкретное поручение у конкретного пользователя
CREATE UNIQUE INDEX orders_users_unique_order_id_user_id_idx ON orders_users (order_id, user_id);
