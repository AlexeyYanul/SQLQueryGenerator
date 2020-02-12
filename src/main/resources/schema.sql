CREATE TABLE technologies
(
    id bigint NOT NULL,
    name character varying(40) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE resume
(
    id bigint NOT NULL,
    name character varying(40) NOT NULL,
    surname character varying(40) NOT NULL,
    patronomic character varying(40) NOT NULL,
    gender character varying(20) NOT NULL,
    birth timestamp without time zone NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE contacts
(
    id bigint NOT NULL ,
    name character varying NOT NULL,
    resume_id bigint NOT NULL,
    CONSTRAINT contacts_pkey PRIMARY KEY (id),
    CONSTRAINT contacts_resume_id FOREIGN KEY (resume_id)
        REFERENCES resume (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE resume_technologies
(
    id bigint NOT NULL,
    resume_id bigint NOT NULL,
    technology_id bigint NOT NULL,
    CONSTRAINT resume_technologies_pkey PRIMARY KEY (id),
    CONSTRAINT resume_tecnologies_resume_id FOREIGN KEY (resume_id)
        REFERENCES resume (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT resume_tecnologies_technology_id FOREIGN KEY (technology_id)
        REFERENCES technologies (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);



INSERT INTO technologies(id, name) VALUES (1, 'Git');
INSERT INTO technologies(id, name) VALUES (2, 'Spring Boot');
INSERT INTO technologies(id, name) VALUES (3, 'HTML');
INSERT INTO technologies(id, name) VALUES (4, 'JavaEE');
INSERT INTO technologies(id, name) VALUES (5, 'Java Core');
INSERT INTO technologies(id, name) VALUES (6, 'Maven');
INSERT INTO technologies(id, name) VALUES (7, 'Rest');
INSERT INTO technologies(id, name) VALUES (8, 'Spring');

INSERT INTO resume(id, name, surname, patronomic, gender, birth)
	VALUES (1, 'Петр', 'Петров', 'Петрович', 'мужчина', '12.12.1986');
INSERT INTO resume(id, name, surname, patronomic, gender, birth)
	VALUES (2, 'Иван', 'Иванов', 'Иванович', 'мужчина', '04.04.1997');
INSERT INTO resume(id, name, surname, patronomic, gender, birth)
	VALUES (3, 'Мария', 'Морская', 'Васильевна', 'женщина', '07.11.1999');

INSERT INTO contacts (id, name, resume_id) VALUES (1, '+375(29)123-45-67', 1);
INSERT INTO contacts (id, name, resume_id) VALUES (2, 'http://github.com/petya', 1);
INSERT INTO contacts (id, name, resume_id) VALUES (3, 'petrovich@gmail.com', 1);
INSERT INTO contacts (id, name, resume_id) VALUES (4, '+375(29)87-65-43', 2);
INSERT INTO contacts (id, name, resume_id) VALUES (5, 'http://github.com/vanya', 2);
INSERT INTO contacts (id, name, resume_id) VALUES (6, 'skype:ivanko', 2);
INSERT INTO contacts (id, name, resume_id) VALUES (7, '+375(29)999-99-99', 3);
INSERT INTO contacts (id, name, resume_id) VALUES (8, 'https://www.linkedin.com/in/mariya/', 3);

INSERT INTO resume_technologies(id, resume_id, technology_id)
	VALUES (1, 1, 1);
INSERT INTO resume_technologies(id, resume_id, technology_id)
	VALUES (2, 1, 2);
INSERT INTO resume_technologies(id, resume_id, technology_id)
	VALUES (3, 1, 3);
INSERT INTO resume_technologies(id, resume_id, technology_id)
	VALUES (4, 2, 1);
INSERT INTO resume_technologies(id, resume_id, technology_id)
	VALUES (5, 2, 4);
INSERT INTO resume_technologies(id, resume_id, technology_id)
	VALUES (6, 2, 5);
INSERT INTO resume_technologies(id, resume_id, technology_id)
	VALUES (7, 3, 6);
INSERT INTO resume_technologies(id, resume_id, technology_id)
	VALUES (8, 3, 7);
INSERT INTO resume_technologies(id, resume_id, technology_id)
	VALUES (9, 3, 8);
