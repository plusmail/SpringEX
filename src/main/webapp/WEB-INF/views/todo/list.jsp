<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css">
<script src="/bootstrap/js/bootstrap.bundle.min.js"></script>

<html>
<head>
    <title>Todo List페이지</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>

<h1>Todo List 페이지</h1>
<div class="row">
    <div class="col">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a href="#" class="navbar-brand">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a href="#" class="nav-link active" aria-current="page">Home</a>
                        <a href="#" class="nav-link">기능들</a>
                        <a href="#" class="nav-link">가격</a>
                        <a href="#" class="nav-link">사용할 수 있나?</a>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</div>
<div class="card-body">
    <h5 class="card-title">내가 해야할일 목록</h5>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">종료일자</th>
            <th scope="col">완료여부</th>
        </tr>
        </thead>
        <tbody>
        ${responeDTO.page}:
        ${responeDTO.size}:
        ${responeDTO.total}:
        ${responeDTO.start}:
        ${responeDTO.end}:
        ${responeDTO.prev}:
        ${responeDTO.next}
        <c:forEach items="${responeDTO.dtoList}" var="dto">
            <tr>
                <th scope="row">${dto.tno}</th>
                <td><a href="/todo/read?tno=${dto.tno}" class="text-decoration-none">${dto.title}</a></td>
                <td>${dto.writer}</td>
                <td>${dto.dueDate}</td>
                <td>${dto.finished}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>



</div>
</body>
</html>
