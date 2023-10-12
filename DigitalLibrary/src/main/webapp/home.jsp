<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library</title>
    <link rel="stylesheet" href="./home.css">
</head>
<body>
  <div class="div1">
    <section class="s1">
        <div class="div2"><centre>
            <h1>Faculty login</h1>
            <h3 class="h31">${facultyReg}</h3><h3 class="h32">${value2}</h3>
            <form action="/facultyLogIn">
                <input class="in1" type="text" name="facultyid" placeholder="Enter your college id "><br>
                <input type="password" name="password" placeholder="Enter your password "><br>
                <button>Log in</button><br>
                <a class="atag" href="registerFaculty.jsp">Register Faculty</a>
            </form></centre>
        </div>
        <div class="div3">
            <h1>Student login</h1>
            <h3 class="h31" >${StudentReg}</h3><h3 class="h32">${value3}</h3>
            <form action="/studentLogIn">
                <input type="text" name="registerno" placeholder="Enter your VTU register id "><br>
                <input type="password" name="password" placeholder="Enter your password "><br>
                <button>Log in</button><br>
                <a class="atag" href="registerStudent.jsp">Register Student</a>
            </form>
        </section>
    </div>
</div> 
</body>
</html>