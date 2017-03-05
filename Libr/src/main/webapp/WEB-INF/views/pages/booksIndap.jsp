<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div>
	<c:if test="${not empty books}">

		<p>Number of books is : ${fn:length(books)}</p>

		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Author name</th>
					<th>Publish date</th>
					<th>statistic link</th>
					<th>instances link</th>
				</tr>
			</thead>
			<c:forEach items="${books}" var="current">
				<tr>
					<td><c:out value="${current.name}" /></td>
					<td><c:out value="${current.author.name}" /></td>
					<td><c:out value="${current.publishDate}" /></td>
					<td><a
						href="${pageContext.request.contextPath}/books/info/${current.id}">info</a>
					</td>
					<td><a
						href="${pageContext.request.contextPath}/inst/${current.id}">instances</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty books}">No books published after independence found
		</c:if>
	<br /> <a href="${pageContext.request.contextPath}/books/byName/form">statistic
		by book name</a>

</div>