create table if not exists person
(
    id integer generated by default as identity primary key,
    username varchar not null unique,
    password varchar not null,
    role varchar not null
);