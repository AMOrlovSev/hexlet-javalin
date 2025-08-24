DROP TABLE IF EXISTS courses;

CREATE TABLE courses (
    id bigint GENERATED ALWAYS AS IDENTITY,
    name varchar(255),
    description varchar(255)
    );

INSERT INTO courses (name, description) VALUES
('name1', 'description1'),
('name2', 'description2'),
('name3', 'description3'),
('name4', 'description4'),
('name5', 'description5');
