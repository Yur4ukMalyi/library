<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div >
	<c:if test="${not empty authors}">

		<table width="400">
			<thead>
				<tr>
					<th>Name</th>
					<th>Author</th>
					<th>Co-author</th>
				</tr>
			</thead>

			<c:forEach items="${authors}" var="current">
				<tr>
					<td><c:out value="${current.name}" /></td>
					<td><a
						href="${pageContext.request.contextPath}/authors/author/${current.id}">link</a>
					</td>
					<td><a
						href="${pageContext.request.contextPath}/authors/coauthor/${current.id}">link</a>
					</td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
	<a href="${pageContext.request.contextPath}/users/byAuthorName">get
		avg user age by author name</a>
</div>




