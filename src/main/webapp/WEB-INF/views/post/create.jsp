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
                <select id="tagSelect" name="tag">
                    <c:forEach var="tag" items="${tags}">
                        <option value="${tag.name}">${tag.name}</option>
                    </c:forEach>
                </select>
                <input type="text" id="newTag" name="newTag" placeholder="New Tag" style="display: none;">
                <button type="button" id="newTagButton" onclick="toggleTagInput()">New Tag</button>
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
<script>
    function toggleTagInput() {
        const tagSelect = document.getElementById('tagSelect');
        const newTagInput = document.getElementById('newTag');
        const newTagButton = document.getElementById('newTagButton');

        if (newTagInput.style.display === 'none') {
            newTagInput.style.display = 'inline';
            tagSelect.disabled = true;
            newTagButton.textContent = 'Cancel';
        } else {
            newTagInput.style.display = 'none';
            tagSelect.disabled = false;
            newTagButton.textContent = 'New Tag';
        }
    }
</script>
<%@ include file="../footer.jsp" %>
