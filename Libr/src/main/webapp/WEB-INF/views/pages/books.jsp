<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div  >
		<c:if test="${not empty books}">
		
			<table >
				<thead>
				<tr ><th>Name</th><th>Author name</th><th>Publish date</th><th>statistic link</th><th>instances link</th></tr>
				</thead>					
				<c:forEach items="${books}" var="current">
					<tr>
						<td><c:out value="${current.name}"/>
						</td>
						<td><c:out value="${current.author.name}"/>
						</td>
						<td><c:out value="${current.publishDate}"/>
						</td>
						<td><a href="${pageContext.request.contextPath}/books/info/${current.id}">info</a>
						</td>
						<td><a href="${pageContext.request.contextPath}/inst/${current.id}">instances</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br/>
		<a href="${pageContext.request.contextPath}/books/byName/form">statistic by book name</a>
		<br/>
		<a href="${pageContext.request.contextPath}/books/indep">get only books published after independence</a>
		<br/>
		<a href="${pageContext.request.contextPath}/books/popularityForm">find most and least popular Book for period</a>
		
	</div>