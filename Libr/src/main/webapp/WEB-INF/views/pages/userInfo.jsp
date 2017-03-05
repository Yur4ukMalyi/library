<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>

	<h2>
		<c:out value="${userObj.name}" />
	</h2>
	<br />
	<p>
		Time since registration:
		<c:out value="${timeSinceRegistration}" />
		days
	</p>

	<br />

	<c:if test="${not empty bookOnHands}">
		<c:out value="Books not returned" />
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
			<c:forEach items="${bookOnHands}" var="current">
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
	<c:if test="${ empty bookTaken}">
		<c:out value="No books to return" />
	</c:if>

	<c:if test="${not empty bookTaken}">
		<c:out value="Books taken" />
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
			<c:forEach items="${bookTaken}" var="current">
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
	<c:if test="${ empty bookTaken}">
		<c:out value="No books taken" />
	</c:if>

</div>