<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title><c:out value="${title}"/></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<main class="main-container">
<form action="${pageContext.request.contextPath}/users/signUp" method="post">
    <h1>Sign Up</h1>
        <table>
            <tr>
                <td><label for="id">ID:</label></td>
                <td><input type="text" id="id" name="id" required></td>
            </tr>
            <tr>
                <td><label for="password">Password:</label></td>
                <td><input type="password" id="password" name="password" required></td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td><input type="email" id="email" name="email" required></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <button type="submit">Sign Up</button>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="color: red; text-align: center;">
                    <c:if test="${not empty error}">
                        <span>${error}</span>
                    </c:if>
                </td>
            </tr>
        </table>
    </form>
<%@ include file="../footer.jsp" %>
