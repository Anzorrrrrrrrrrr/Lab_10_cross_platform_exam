@import com.example.project.exam.model.Student
@import com.example.project.exam.model.Course
@import java.lang.Iterable

@param Iterable<Student> students
@param Iterable<Course> courses

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Enrollment</title>
</head>
<body>
<h1>Create Enrollment</h1>
<form action="/enrollments/create" method="post">
    <label>Student:
        <select name="studentId">
            @for (Student student : students)
                <option value="${student.id}">${student.name}</option>
            @endfor
        </select>
    </label><br>

    <label>Course:
        <select name="courseId">
            @for (Course course : courses)
                <option value="${course.id}">${course.title}</option>
            @endfor
        </select>
    </label><br>

    <button type="submit">Enroll</button>
</form>
</body>
</html>
