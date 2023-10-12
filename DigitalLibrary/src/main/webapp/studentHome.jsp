<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stdunet homepage</title>
    <link rel="stylesheet" href="./studentHome.css">
</head>
<body>
    <section>
        <div class="div1">
            <form action="/home">
                <button>Log out</button>
            </form>
        </div>      
        <div class="div3">  
        <div class="div2">    
            <form action="/serchBookStudent">
                <input type="text" name="bookName" placeholder="Enter book name">
                <button>Search book</button><h3 class="red">${noRecordS1} </h3>
            </form>
        </div>
        <div class="div2">    
            <form action="/getBookByIdStudent">
                <input type="text" name="id" placeholder="Enter book primary id">
                <button>Get a book</button><h3 class="red" >${noRecordS2}</h3><h3 class="green"> ${Issued}</h3>
            </form>
        </div>
        <div class="div2">
            <form action="/returnBookByIdStudent">
                <input  type="text" name="id" placeholder="Enter book primary id">
                <button >Return a book</button><h3 class="red">${noRecordS3}</h3> <h3 class="green">${return1}</h3>
            </form>
        </div>    
        </div>
        <textarea > ${listBookSt}</textarea>
</section>

</body>
</html>