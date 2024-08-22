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

<div class="row content">
    <div class="col">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">검색</h5>
                <form action="/admin/todo/list" method="get">
                    <input type="hidden" name="size" value="${pageRequestDTO.size}">
                    <div class="mb-3">
                        <input type="checkbox"
                               name="finished" ${pageRequestDTO.finished? "checked":""}> 완료여부
                    </div>
                    <div class="mb-3">
                        <input type="checkbox" name="types" value="t"
                        ${pageRequestDTO.checkType("t")?"checked":""}
                        >제목
                        <input type="checkbox" name="types" value="w"
                        ${pageRequestDTO.checkType("w")?"checked" :""}
                        >작성자
                        <input type="text" name="keyword" class="form-control"
                        value="${pageRequestDTO.keyword}"
                        >
                    </div>
                    <div class="input-group mb-3 dueDateDiv">
                        <input type="date" name="from" class="form-control"
                        value="${pageRequestDTO.from}"
                        >
                        <input type="date" name="to" class="form-control"
                        value="${pageRequestDTO.to}">
                    </div>
                    <div class="input-group mb-3">
                        <div class="float-end">
                            <button class="btn btn-primary" type="submit">검색</button>
                            <button class="btn btn-info" type="reset">초기화</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
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
        <c:forEach items="${responeDTO.dtoList}" var="dto">
            <tr>
                <th scope="row">${dto.tno}</th>
                <td><a href="/admin/todo/read?tno=${dto.tno}&${pageRequestDTO.link}"
                       class="text-decoration-none">${dto.title}</a></td>
                <td>${dto.writer}</td>
                <td>${dto.dueDate}</td>
                <td>${dto.finished}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="float-end">

        <ul class="pagination flex-wrap  pagination-sm">
            <c:if test="${responeDTO.prev}">
                <li class="page-item">
                    <a href="" class="page-link"
                       data-num="${responeDTO.start-1}"
                    >이전</a>
                </li>
            </c:if>


            <c:forEach begin="${responeDTO.start}"
                       end="${responeDTO.end}"
                       var="num">
                <li class="page-item  ${responeDTO.page == num ? "active" : ""} ">
                    <a href="#" class="page-link"
                       data-num="${num}"
                    >${num}</a>
                </li>
            </c:forEach>

            <c:if test="${responeDTO.next}">
                <li class="page-item">
                    <a href="" class="page-link"
                       data-num="${responeDTO.end +1}"
                    >다음</a>
                </li>
            </c:if>
        </ul>
    </div>


</div>
<script>
    document.querySelector(".pagination").addEventListener("click",
        e => {
            e.preventDefault();
            e.stopPropagation();
            const target = e.target;
            if(target.tagName !== "A"){
                return
            }

            const num =target.getAttribute("data-num");
            const formObj = document.querySelector("form");
            formObj.innerHTML += `<input type='hidden' name='page' value='\${num}'>`
            formObj.submit();
        },false)

</script>
</body>
</html>
