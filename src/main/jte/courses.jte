@import com.example.project.exam.model.Course
@import java.util.List

@param List<Course> courses

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course List</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>All Courses</h1>

@if (courses.isEmpty())
    <p>No courses found in the database.</p>
@else
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        @for (Course course : courses)
            <tr>
                <td>${course.id}</td>
                <td>${course.title}</td>
                <td>${course.description}</td>
            </tr>
        @endfor
        </tbody>
    </table>
@endif

</body>
</html>
