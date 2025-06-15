
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="/api/register" method="post">
    <label>Username: <input type="text" name="username" required></label><br>
    <label>Password: <input type="password" name="password" required></label><br>
    <label>Role:
        <select name="role">
            <option value="USER">USER</option>
            <option value="ADMIN">ADMIN</option>
        </select>
    </label><br>

    <button type="submit">Register</button>
</form>
</body>
</html>
