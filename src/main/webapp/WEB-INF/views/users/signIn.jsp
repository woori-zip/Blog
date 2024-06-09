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
    <h1>Sign In</h1>
    <form action="${pageContext.request.contextPath}/users/signIn" method="POST">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" id="id" name="id" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" id="password" name="password" required></td>
            </tr>
            <tr>
                <td colspan="2"><a href="/users/signUp">Sign Up</a></td>
            </tr>
            <tr>
                <td colspan="2" style="color: red; text-align: center;">
                    <c:if test="${not empty error}">
                        <span>${error}</span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <button type="submit">Sign In</button>
                </td>
            </tr>
        </table>
    </form>
<%@ include file="../footer.jsp" %>
