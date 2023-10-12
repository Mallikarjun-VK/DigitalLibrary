
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Faculty home</title>
    <link rel="stylesheet" href="./facultyHome.css">
</head>
<body>
    <section >
        <div class="div1">
            <form action="/home">
                <button>Log out</button>
            </form>
            
        </div>    
        <div class="div2">   
        <div class="div3">
            <form action="/book">
                <button>Add books</button><h3 class="green">${addedBook}</h3>
            </form>
            <form action="/seeLog">
                <button>See book log</button>
            </form>
        </div>   
           
        <div class="div3">
            <form action="/serchBook">
                <input type="text" name="bookName" placeholder="Enter book name">
                <button>Search book</button><h3 class="red">${noRecordF1}</h3>
            </form>
        </div>
        <div class="div3">    
            <form action="/getBookById">
                <input type="text" name="id" placeholder="Enter book primary id">
                <button>get a book</button><h3 class="red">${noRecordF2}</h3><h3 class="green"> ${Issued}</h3>
            </form>
        </div>
        <div class="div3">   
            <form action="/returnBookById">
                <input type="text" name="id" placeholder="Enter book primary id">
                <button>Return a book</button><h3 class="red">${noRecordF3}</h3><h3 class="green"> ${return2}</h3>
            </form>
            
        </div>    
    </div> 
    <textarea>${listBooks} ${Log}</textarea>
</section>
</body>
</html>