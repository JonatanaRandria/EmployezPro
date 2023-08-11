create table if not exists "EmployeePosition"
(
    id          varchar
        constraint position_pk primary key default uuid_generate_v4(),
    name        varchar not null unique
);