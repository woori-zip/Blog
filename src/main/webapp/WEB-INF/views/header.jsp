<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title><c:out value="${title}"/></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<header>
    <nav>
        <div>
            <a href="${pageContext.request.contextPath}/index">Home</a>
            <a href="${pageContext.request.contextPath}/post/list">Board</a>
        </div>
    </nav>
</header>
<main class="main-container">
