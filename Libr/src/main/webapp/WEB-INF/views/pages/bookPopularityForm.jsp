<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
 <form method="post" action="${pageContext.request.contextPath}/books/popularity/result">
 <h2>Enter period</h2>
  <label for="startDate">From:</label>
  <input type="date" id="startDate" name="startDate" required>
  <br/>
  <label for="endDate">To:</label>
  <input type="date" id="endDate" name="endDate" required>
  <input type="submit">
</form>