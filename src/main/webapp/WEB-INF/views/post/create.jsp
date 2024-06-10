<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.jsp" %>

<h2>Create a New Post</h2>
<form action="${pageContext.request.contextPath}/post/create" method="post">
    <table>
        <tr>
            <td><label for="title">Title:</label></td>
            <td><input type="text" id="title" name="title" required></td>
        </tr>
        <tr>
            <td><label for="tag">Tag:</label></td>
            <td>
                <select id="tag" name="tag">
                    <c:forEach var="tag" items="${tags}">
                        <option value="${tag}">${tag}</option>
                    </c:forEach>
                </select>
                <input type="text" id="newTag" name="newTag" style="display:none;" placeholder="Enter new tag">
                <button type="button" onclick="showNewTagInput()">New Tag</button>
            </td>
        </tr>
        <tr>
            <td><label for="content">Content:</label></td>
            <td><textarea id="content" name="content" rows="10" cols="30" required></textarea></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">Create Post</button></td>
        </tr>
    </table>
</form>

<%@ include file="../footer.jsp" %>
