INSERT INTO teacher (name, email) VALUES
('Ivan Petrenko', 'ivan.petrenko@example.com'),
('Olga Shevchenko', 'olga.shevchenko@example.com');

INSERT INTO course (title, description, teacher_id) VALUES
('Java Basics', 'Introduction to Java programming', 1),
('Web Development', 'HTML, CSS, JavaScript basics', 2);

INSERT INTO student (name, email) VALUES
('Andriy Kovalenko', 'andriy@example.com'),
('Kateryna Lytvyn', 'kateryna@example.com');

INSERT INTO enrollment (student_id, course_id) VALUES
(1, 1),
(2, 2);
