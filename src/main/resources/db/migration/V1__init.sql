CREATE TABLE teacher (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    description TEXT,
    teacher_id BIGINT,
    CONSTRAINT fk_course_teacher FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);

CREATE TABLE student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE enrollment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT,
    course_id BIGINT,
    CONSTRAINT fk_enrollment_student FOREIGN KEY (student_id) REFERENCES student(id),
    CONSTRAINT fk_enrollment_course FOREIGN KEY (course_id) REFERENCES course(id)
);
