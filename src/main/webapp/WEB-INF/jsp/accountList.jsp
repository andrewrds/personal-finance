<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.dingwallsmith.finance.provider.Provider" %>

<html lang="en">
<head>
    <title><c:out value="${provider.name}" />Accounts</title>
    <jsp:directive.include file="commonHeaders.jsp" />
</head>
    <body>
        <div id="header">
            <h1><c:out value="${provider.name}" /> Accounts</h1>
        </div>

        <table>
            <c:forEach items="${accountList}" var="account">
                <tr>
                    <td><c:out value="${account.name}" /></td>
                    <td><a href="javascript:deleteAccount(${account.id})">delete</a></td>
                </tr>
            </c:forEach>
        </table>
        
        <form id="createAccount" onsubmit="createAccount()" action="">
            <div>
                <input id="providerId" type="hidden" value="${provider.id}" />
            
                <label for="inputName">Name</label>
                <input id="inputName"
                       maxlength="${Account.NAME_MAX_LENGTH}"/>
                       
                 <input type="submit" value="Create"/>
            </div>
        </form>
    </body>
</html>
