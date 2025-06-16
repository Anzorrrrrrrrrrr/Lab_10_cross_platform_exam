@import com.example.project.exam.model.Enrollment
@import java.util.List

@param List<Enrollment> enrollments

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enrollment List</title>
    <style>
        table {
            width: 90%;
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
<h1>All Enrollments</h1>
<a href="/enrollments/create">Add Enrollment</a>

@if (enrollments.isEmpty())
    <p>No enrollments found in the database.</p>
@else
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Student Name</th>
            <th>Course Title</th>
        </tr>
        </thead>
        <tbody>
        @for (Enrollment enrollment : enrollments)
            <tr>
                <td>${enrollment.id}</td>
                <td>${enrollment.student != null ? enrollment.student.name : "Unknown"}</td>
                <td>${enrollment.course != null ? enrollment.course.title : "Unknown"}</td>
            </tr>
        @endfor
        </tbody>
    </table>
@endif

</body>
</html>
