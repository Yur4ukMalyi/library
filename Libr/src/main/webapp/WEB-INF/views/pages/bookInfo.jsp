<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div >
	
	<h2><c:out value="${bookObj.name}" /></h2>

		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>is available</th>
					<th>Times picked</th>
					<th>avg reading time</th>
					<th>avg reader age</th>
				</tr>
			</thead>
			<tr>
				<td><c:out value="${book}" /></td>
				<td><c:out value="${isAvailable}" /></td>
				<td><c:out value="${timesPicked}" /></td>
				<td>
				<c:if test="${avgReadingTime eq 0}">
				<c:out value="not returned yet" />
				</c:if>
				<c:if test="${avgReadingTime ne 0}">
				<c:out value="${avgReadingTime}" />
				</c:if>
				</td>
				<td>
				<c:if test="${avgAge eq 0}">
				<c:out value="not picked yet" />
				</c:if>
				<c:if test="${avgAge ne 0}">
				<c:out value="${avgAge}" />
				</c:if>
			</tr>
		</table>

	<br />

</div>