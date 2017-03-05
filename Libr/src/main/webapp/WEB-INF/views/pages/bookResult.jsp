<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div >


	<c:if test="${not empty res}">
		<p>Number of instances is : ${fn:length(res)}</p>
			<table >
				<thead>
				<tr ><th>id</th><th>book name</th><th>Instance info link</th><th>is available</th></tr>
				</thead>					
				<c:forEach items="${res}" var="current">
					<tr>
						<td><c:out value="${current.bi.id}"/>
						</td>
						<td><c:out value="${current.bi.book.name}"/>
						</td>
						<td><a href="${pageContext.request.contextPath}/inst/info/${current.bi.id}">info</a>
						</td>
						<td><c:out value="${current.isAvailable}"/>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty res}">
		<c:out value="no books found for that name"/>
		<a href="${pageContext.request.contextPath}/books/byName/form">Try again</a>
		
		</c:if>

	<br />

</div>