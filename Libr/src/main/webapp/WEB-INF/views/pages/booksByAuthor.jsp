<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<div   >

    <c:if test="${not empty books}">

        <table width="500">

            <thead>
            <tr><th>List of books where ${author.getName()} is author</th></tr>
            </thead>

             <c:forEach items="${books}" var="current">
                 <tr>
                     <td>
                         <c:out value="${current.getName()}"/>
                     </td>
                 </tr>
             </c:forEach>
        </table>
    </c:if>
</div>
