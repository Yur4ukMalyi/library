<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div  >
		<c:if test="${not empty debtors}">
		
			<table >
				<thead>
				<tr ><th>Name</th><th>Birth Date</th><th>Registration Date</th></tr>
				</thead>					
				<c:forEach items="${debtors}" var="current">
					<tr>
						<td><c:out value="${current.name}"/>
						</td>
						<td><c:out value="${current.birthDate}"/>
						</td>
						<td><c:out value="${current.registrationDate}"/>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br/>
		
		
	</div>