<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div >
	
	<h2>Info for BookInstance with id = <c:out value="${biObj.id}" /></h2>
	<p>Book name : <c:out value="${biObj.book.name}" /> </p>
	
		<table>
			<thead>
				<tr>
					<th>timesPicked</th>
					<th>avgReadTime</th>
					<th>isAvailable</th>
				</tr>
			</thead>
			<tr>
				<td><c:out value="${timesPicked}" /></td>
				
				<td>
				<c:if test="${timesPicked eq 0}">
				<c:out value="not picked yet" />
				</c:if>
				<c:if test="${timesPicked ne 0}">
				<c:if test="${avgReadTime eq 0}">
				<c:out value="not returned yet" />
				</c:if>
				<c:if test="${avgReadTime ne 0}">
				<c:out value="${avgReadTime} days" />
				</c:if>
				</c:if></td>
				<td><c:out value="${isAvailable}" /></td>
			</tr>
		</table>

	<br />

</div>