<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/html4/lose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>upload page</title>
    </head>
    <body>
        <div class="upload">
            <form action="upload" enctype="multipart/form-data" method="post">
                <input type="file" name="file"/><br/>
                <input type="submit" value="上传">
            </form>
        </div>
    </body>
</html>