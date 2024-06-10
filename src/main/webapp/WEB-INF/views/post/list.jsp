<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/js/timeFormatting.js"></script>
<%@ include file="../header.jsp" %>
<h2>Board</h2>

<form method="get" action="${pageContext.request.contextPath}/post/list">
    <select name="tag" id="tagSelect" onchange="this.form.submit()">
        <option value="">전체</option>
        <c:forEach var="tag" items="${tags}">
            <option value="${tag.name}" ${tag.name == selectedTag ? 'selected' : ''}>${tag.name}</option>
        </c:forEach>
    </select>
</form>

<form>
    <table border="1">
        <tr>
            <th>no.</th>
            <th>tag</th>
            <th>title</th>
            <th>author</th>
            <th>createdAt</th>
        </tr>
        <c:forEach var="post" items="${posts}">
            <tr>
                <td>${post.id}</td>
                <td>${post.tag}</td>
                <td>${post.title}</td>
                <td>${post.author}</td>
                <td>
                    <script>
                        document.write(formatDate('${post.createdAt}'));
                    </script>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
<button onclick="location.href='${pageContext.request.contextPath}/post/create'">New Post</button>
<%@ include file="../footer.jsp" %>
