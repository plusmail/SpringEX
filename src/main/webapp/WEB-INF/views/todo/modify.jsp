<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css">
<script src="/bootstrap/js/bootstrap.bundle.min.js"></script>

<html>
<head>
    <title>Todo 상세보기</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
<div class="card-body">
    <form action="/todo/modify" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text">번호</span>
            <input type="text" name="tno"
                   class="form-control" value="${dto.tno}" readonly>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">제목</span>
            <input type="text" class="form-control" name="title"
                   value="${dto.title}">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">종료날짜</span>
            <input type="date" class="form-control" name="dueDate"
                   value="${dto.dueDate}">
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">작성자</span>
            <input type="text" class="form-control" name="writer"
                   value="${dto.writer}">
        </div>
        <div class="form-check">
            <label for="finished" class="form-check-label">완료여부</label>
            <input type="checkbox" class="form-check-input" name="finished"
            ${dto.finished?"checked":""} >
        </div>

        <div class="my-4">
            <div class="float-end">
                <button class="btn btn-danger" type="button">삭제</button>
                <button class="btn btn-primary" type="button">수정</button>
                <button class="btn btn-secondary" type="button">목록보기</button>
            </div>
        </div>

        <input type="hidden" name="page" value="${pageRequestDTO.page}">
        <input type="hidden" name="size" value="${pageRequestDTO.size}">


    </form>

</div>
<script>
    document.querySelector(".btn-primary").addEventListener("click",
        (e) => {
            e.preventDefault()
            e.stopPropagation()
            formObj.action = "/todo/modify?${pageRequestDTO.link}"
            formObj.method = "post"
            formObj.submit()

        }, false)
    document.querySelector(".btn-secondary").addEventListener("click",
        (e) => {
            self.location = "/todo/list?${pageRequestDTO.link}";
        })

    const formObj = document.querySelector("form");

    document.querySelector(".btn-danger").addEventListener("click",
        (e) => {
            e.preventDefault()
            e.stopPropagation()
            formObj.action = "/todo/remove?${pageRequestDTO.link}"
            formObj.method = "post"
            formObj.submit();
        }, false);

</script>

<script>
    const serverValidResult = {}
    <c:forEach items="${errors}" var="error">
    serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
    </c:forEach>

    console.log(serverValidResult)
    let errorMessages = "";
    for (const field in serverValidResult) {
        console.log(field)
        errorMessages += field + ":" + serverValidResult[field] + "\n";
    }
    if (errorMessages) {
        alert("검증 에러들 : \n" + errorMessages)
    }


    <%--function  setTodayDate(){--%>
    <%--    const today = new Date();--%>
    <%--    const yyyy = today.getFullYear();--%>
    <%--    const mm = String(today.getMonth() +1).padStart(2,'0');--%>
    <%--    const dd= String(today.getDate()).padStart(2, '0');--%>
    <%--    document.getElementById('dueDate').value= `${yyyy}-${mm}-${dd}`;--%>
    <%--}--%>

</script>

</body>
</html>
