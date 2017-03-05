<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:if test="${age ne 0}">
		<p>Average user age for author ${name}: ${age} years</p>
</c:if>
<c:if test="${age eq 0}">
		<p>Can't find author with  name  ${name}  </p>
		 <a href="${pageContext.request.contextPath}/users/byAuthorName">Try again</a>
		
</c:if>