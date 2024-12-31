<<<<<<< HEAD
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function validateLogin() {
            const username = document.getElementById("username").value.trim();
            const password = document.getElementById("password").value.trim();

            if (username === "" || password === "") {
                alert("All fields are required!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h1 class="text-center">Login</h1>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <!-- Login Form -->
                <form onsubmit="return validateLogin()" method="post" action="loginServlet">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" id="username" name="username" class="form-control" placeholder="Enter username" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Enter password" required>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Login</button>
                </form>

                <!-- Redirection to Registration -->
                <div class="text-center mt-3">
                    <p>Don't have an account?</p>
                    <a href="register.jsp" class="btn btn-secondary">Register Here</a>
                </div>
            </div>
        </div>
    </div>

    <!-- JavaScript for Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
||||||| empty tree
=======
<html>
<body>
<h2>Hello World!</h2>
</body>
</html>
>>>>>>> b03bf580a37766ec2b42f677892fe7b6a7174fab
