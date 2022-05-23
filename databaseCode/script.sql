CREATE DATABASE proekt;

CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          good TEXT NOT NULL,
                          price REAL NOT NULL,
                          category_name TEXT NOT NULL
);

CREATE TABLE clients (
                         id_client SERIAL,
                         first_name VARCHAR(50) NOT NULL,
                         middle_name VARCHAR(50) NULL,
                         last_name VARCHAR(50) NOT NULL,
                         address TEXT NOT NULL,
                         company_name TEXT,
                         CONSTRAINT pk_clients_id_client PRIMARY KEY(id_client)
);

CREATE TABLE employees (
                           id_employee SERIAL,
                           inn VARCHAR(12) NOT NULL,
                           date_of_birth DATE NOT NULL,
                           first_name VARCHAR(50) NOT NULL,
                           middle_name VARCHAR(50) NULL,
                           last_name VARCHAR(50) NOT NULL,
                           phone VARCHAR(50) NOT NULL,
                           email VARCHAR(50) NOT NULL,
                           driver_license_category VARCHAR(50) NULL,
                           CONSTRAINT pk_employees_id_employee PRIMARY KEY(id_employee)
);

CREATE TABLE employees_positions (
                                     id_position INT,
                                     name TEXT NOT NULL,
                                     salary REAL NOT NULL,
                                     CONSTRAINT pk_employees_positions_id_position PRIMARY KEY(id_position)
);

CREATE TABLE employees_employees_positions (
                                               id_employee INT,
                                               id_position INT,
                                               CONSTRAINT fk_EEP_employees FOREIGN KEY(id_employee) REFERENCES employees(id_employee)
                                                   ON DELETE CASCADE ,
                                               CONSTRAINT fk_EEP_employees_positions FOREIGN KEY(id_position) REFERENCES employees_positions(id_position)
                                                   ON DELETE CASCADE ,
                                               CONSTRAINT pk_EEP PRIMARY KEY(id_employee, id_position)
);

INSERT INTO employees (inn, date_of_birth, first_name, middle_name, last_name, phone, email, driver_license_category)
VALUES
    ('896475006138','2020-05-21','Rhiannon','J','Donovan','79361326557','at.nisi@aol.ca','A'),
    ('788224636851','2019-02-02','Kay','J','Alford','79172878708','nulla@aol.ca','B'),
    ('569676231844','2022-09-23','Dana','J','O''brien','79054042437','posuere.cubilia@google.ca','B'),
    ('735362307487','2022-02-06','Aquila','','Oneal','79830860018','eget.venenatis@protonmail.org','B'),
    ('053523671775','2022-03-13','Benedict','J','Curry','79019834546','placerat.cras@google.net','D'),
    ('278265272334','2021-08-13','Paki','','Shannon','79152763645','dolor.dolor@outlook.org','B'),
    ('126127746131','2017-05-28','Elmo','J','Graham','79119614023','diam.pellentesque@google.edu','D'),
    ('705665775661','2022-06-10','Selma','','Berger','79630267267','curabitur.vel.lectus@yahoo.ca','CE'),
    ('288111135354','2017-09-20','Bevis','J','Stokes','79362727121','dui.in.sodales@yahoo.ca','BCE'),
    ('384534995711','2019-12-03','Alyssa','J','Roberson','79396614888','est.nunc.ullamcorper@yahoo.org','ABCE'),
    ('240319269931','2020-07-15','Timon','J','Fox','79862788726','magna@protonmail.com', NULL),
    ('333264321437','2018-12-20','Fay','J','Potter','79483726654','integer@yahoo.com', NULL),
    ('044311757628','2019-12-02','Irma','J','Daniels','79246324762','eu.erat@yahoo.ca', NULL),
    ('244517721576','2018-06-10','Kiona','J','Snyder','79004451533','ultrices.a@icloud.couk', NULL),
    ('215436921728','2019-12-05','Serina','','Mcdowell','79170753151','tellus.nunc.lectus@outlook.ca', NULL),
    ('070326528275','2020-08-13','Aretha','J','Best','79720266015','libero.lacus@yahoo.edu', NULL),
    ('664643683749','2018-08-06','Callie','','Peck','79848964189','nisi.nibh.lacinia@hotmail.org', NULL),
    ('097647838828','2022-08-15','Ann','J','Hodges','79179221154','accumsan.interdum@hotmail.org', NULL),
    ('960632242469','2023-04-03','Brooke','J','Wong','79681531645','etiam.laoreet@icloud.edu', NULL),
    ('851843500628','2019-05-29','Hayden','','Cervantes','79820235415','lobortis.augue.scelerisque@hotmail.org', NULL);

INSERT INTO employees_positions (id_position, name, salary)
VALUES
    (100100, 'ДИРЕКТОР', 1000000),
    (100200, 'ЗАМ. ДИРЕКТОРА', 700000),
    (300100, 'ГЛАВНЫЙ ТРАКТОРИСТ', 50000),
    (300200, 'ЗАМ. ГЛАВНОГО ТРАКТОРИСТА', 25000),
    (300300, 'ТРАКТОРИСТ', 15000),
    (400100, 'МЕХАННИК', 20000);

insert into employees_employees_positions (id_position, id_employee)
VALUES
    (100100, 9),
    (100200, 9),
    (300100, 11),
    (300200, 12),
    (300300, 13),
    (300300, 14),
    (300300, 15),
    (400100, 11);

SELECT employees.first_name, employees.last_name, ep.name FROM employees
                                                                   JOIN employees_employees_positions eep ON employees.id_employee = eep.id_employee
                                                                   JOIN employees_positions ep ON ep.id_position = eep.id_position;