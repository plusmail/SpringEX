<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>병원관리 관리자 페이지</title>
    <tiles:insertAttribute name="admin-common" />
</head>
<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">
    <tiles:insertAttribute name="admin-sidebar" />
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <tiles:insertAttribute name="admin-body" />
        </div>
        <!-- End of Main Content -->
        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <tiles:insertAttribute name="admin-footer" />
        </footer>
        <!-- End of Footer -->
    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->
<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>
<!-- Logout Modal-->
<tiles:insertAttribute name="admin-logout-modal" />
<!-- Bootstrap core JavaScript-->
<tiles:insertAttribute name="admin-bootstrap" />
</body>
</html>