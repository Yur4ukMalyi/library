<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div>


	<c:if test="${not empty instances}">
		<p>Number of instances is : ${fn:length(instances)}</p>
			<table >
				<thead>
				<tr ><th>id</th><th>book name</th><th>Instance info link</th></tr>
				</thead>					
				<c:forEach items="${instances}" var="current">
					<tr>
						<td><c:out value="${current.id}"/>
						</td>
						<td><c:out value="${current.book.name}"/>
						</td>
						<td><a href="${pageContext.request.contextPath}/inst/info/${current.id}">info</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	<br />

</div>