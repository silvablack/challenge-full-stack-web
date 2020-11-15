-- SCHEMA/TABLE CREATION

create schema base;

create table base.institution
	(
		id bigserial not null constraint institution_pk primary key,
		description varchar(50) not null,
		active boolean not null
	);

alter table base.institution owner to miguel;
create unique index institution_id_uindex
    on base.institution (id);

create table base.course
	(
		id bigserial not null constraint course_pk primary key,
		description varchar(50) not null,
		    institution_id             integer   not null
        constraint base_institution_id_fk
            references base.institution,
		active boolean not null
	);

alter table base.course owner to miguel;
create unique index course_id_uindex
    on base.course (id);

create table base.student
	(
		registration bigserial not null constraint student_pk primary key,
		name varchar(50) not null,
		cpf  varchar(11) not null
        	constraint cpf_student_unique unique,
		email varchar(50) not null,
		register_date  date   not null,
		deactivation_date  date null,
		active boolean not null
	);

alter table base.student owner to miguel;
create unique index student_id_uindex
    on base.student (registration);

create table base.registry_course
(
    id bigserial not null
        constraint registry_course_pk
            primary key,
    registration integer not null
        constraint registration_student_fk
            references base.student,
    course_id integer not null
        constraint course_id_fk
            references base.course,
    active boolean not null
);

alter table base.registry_course
    owner to miguel;

create unique index registry_course_id_uindex
    on base.registry_course (id);

-- INITIALIZE DATA

insert into base.institution
(id, description, active)
values (1, 'EdTech', true);

insert into base.course
(description, institution_id, active)
values ('Programação Web', 1, true);