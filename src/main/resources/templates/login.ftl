<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
        <form action="/post" method="post">
            <input type="text" name="username">
            <input type="text" name="password">
            <input type="submit">
        </form>
        //文件上传
        <form action="/upload" method="post" enctype="multipart/form-data" >
            <input type="file" name="file">
           <input type="submit">
        </form>
</body>
</html>