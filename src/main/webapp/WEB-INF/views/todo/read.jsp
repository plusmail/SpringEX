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
    <div class="input-group mb-3">
        <span class="input-group-text">번호</span>
        <input type="text" name="tno"
               class="form-control" value="${dto.tno}" readonly>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">제목</span>
        <input type="text" class="form-control" name="title"
               value="${dto.title}" readonly>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">종료날짜</span>
        <input type="text" class="form-control" name="dueDate"
               value="${dto.dueDate}" readonly>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">작성자</span>
        <input type="text" class="form-control" name="writer"
               value="${dto.writer}" readonly>
    </div>
    <div class="form-check">
        <label for="finished" class="form-check-label">완료여부</label>
        <input type="checkbox" class="form-check-input" name="finished"
        ${dto.finished?"checked":""} disabled>
    </div>

    <div class="my-4">
        <div class="float-end">
            <button class="btn btn-primary" type="button">수정</button>
            <button class="btn btn-secondary" type="button">목록보기</button>
        </div>
    </div>

</div>
<script>
    document.querySelector(".btn-primary").addEventListener("click",
        (e) => {
            self.location = "/todo/modify?tno=${dto.tno}&${pageRequestDTO.link}"

        }, false)
    document.querySelector(".btn-secondary").addEventListener("click",
        (e) => {
            self.location = "/todo/list?${pageRequestDTO.link}";
        }, false)
</script>

</body>
</html>
