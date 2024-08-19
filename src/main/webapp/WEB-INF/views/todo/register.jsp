<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css">
<script src="/bootstrap/js/bootstrap.bundle.min.js"></script>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="card-body">

    <form action="/todo/register" method="post">
        <div class="input-group mb-3">
             <span class="input-group-text">제목 :</span>
            <input type="text" name="title" class="form-control" placeholder="제목넣어세요">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">날자 :</span>
            <input type="date" name="dueDate" class="form-control" value="2024-08-14">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">작성자 :</span>
            <input type="text" name="writer" class="form-control" >
        </div>
        <div class="my-4">
            <div class="float-end">
                <button type="submit" class="btn btn-primary">등록</button>
                <button type="reset" class="btn btn-secondary">취소</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
