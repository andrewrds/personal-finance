<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.dingwallsmith.finance.provider.Provider" %>

<html lang="en">
<head>
    <title>Providers</title>
    <jsp:directive.include file="commonHeaders.jsp" />
</head>
    <body>
        <div id="header">
            <h1>Providers</h1>
        </div>

        <table>
            <c:forEach items="${providerList}" var="provider">
                <tr>
                    <td><a href="/account/list?providerId=${provider.id}"><c:out value="${provider.name}" /></a></td>
                    <td><a href="javascript:deleteProvider(${provider.id})">delete</a></td>
                </tr>
            </c:forEach>
        </table>
        
        <form id="createProvider" onsubmit="createProvider()" action="">
            <div>
                <label for="inputName">Name</label>
                <input id="inputName"
                       maxlength="${Provider.NAME_MAX_LENGTH}"/>
                       
                 <input type="submit" value="Create"/>
            </div>
        </form>
    </body>
</html>
