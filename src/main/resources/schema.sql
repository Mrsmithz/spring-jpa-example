USE test;

DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id         int auto_increment primary key,
    email      varchar(255) not null unique,
    role       varchar(255) default 'STUDENT',
    created_at timestamp    default current_timestamp,
    updated_at timestamp    default current_timestamp on update current_timestamp
);

DROP TABLE IF EXISTS courses;

CREATE TABLE courses
(
    id         int auto_increment primary key,
    title      varchar(255) not null,
    owner_id   int          not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    foreign key (owner_id) references users (id)
);

DROP TABLE IF EXISTS user_course_mapping;

CREATE TABLE user_course_mapping
(
    user_id    int not null,
    course_id  int not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,

    primary key (user_id, course_id),
    foreign key (user_id) references users (id),
    foreign key (course_id) references courses (id)
)