<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	
	<h2>UserStatistic</h2>

		<table>
			<thead>
				<tr>
					<th>avg Age</th>
					<th>avg TimeSinceRegistration</th>
					<th>avg RequestByPeriod</th>
				</tr>
			</thead>
			<tr>
				<td><c:out value="${statistic.avgAge}" /></td>
				<td><c:out value="${statistic.avgTimeSinceRegistration}" /></td>
				<td>
				<c:if test="${statistic.avgRequestByPeriod eq 0}">
				<c:out value="no any for that period" />
				</c:if>
				<c:if test="${statistic.avgRequestByPeriod ne 0}">
				<c:out value="${statistic.avgRequestByPeriod}" />
				</c:if>
				</td>
			</tr>
		</table>

	<br />

</div>