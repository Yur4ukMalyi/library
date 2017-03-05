<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div >
	

<c:if test="${ mostPopular ne null}">
		<table>
			<thead>
				<tr>
					<th>popularity</th>
					<th>id</th>
					<th>name</th>
					<th>author name</th>
					<th>Times picked</th>
				</tr>
			</thead>
			<tr>
				<td>Most popular</td>
				<td><c:out value="${mostPopular.book.id}" /></td>
				<td><c:out value="${mostPopular.book.name}" /></td>
				<td><c:out value="${mostPopular.book.author.name}" /></td>
				<td><c:out value="${mostPopular.timesPicked}" /></td>
				
			</tr>
			<tr>
				<td>Least popular</td>
				<td><c:out value="${leastPopular.book.id}" /></td>
				<td><c:out value="${leastPopular.book.name}" /></td>
				<td><c:out value="${leastPopular.book.author.name}" /></td>
				<td><c:out value="${leastPopular.timesPicked}" /></td>
				
			</tr>
		</table>
		</c:if>
<c:if test="${ mostPopular eq null}">
<c:out value="no books found for that period" />
<a href="${pageContext.request.contextPath}/books/popularityForm">TRY AGAIN</a>
</c:if>
	<br />

</div>