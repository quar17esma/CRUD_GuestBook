<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

        .button {
            width: 100px;
        }

    </style>

    <title>Show All Guests</title>
</head>
<body>

<table>

    <thead>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Birthday Date</th>
        <th>Phone #</th>
        <th>E-mail</th>
        <th>Country</th>
        <th>City</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${guests}" var="guest">
        <tr>

            <td><c:out value="${guest.firstName}"/></td>
            <td><c:out value="${guest.lastName}"/></td>
            <td><c:out value="${guest.birthday}"/></td>
            <td><c:out value="${guest.phoneNumber}"/></td>
            <td><c:out value="${guest.email}"/></td>
            <td><c:out value="${guest.country}"/></td>
            <td><c:out value="${guest.city}"/></td>
            <td>
                <form>
                    <input class="button" type="button" value="Edit"
                           onclick="location.href='GuestController.do?action=edit&guestId=<c:out value="${guest.guestId}"/>'"/>
                </form>
            </td>
            <td>
                <form>
                    <input class="button" type="button" value="Delete"
                           onclick="location.href='GuestController.do?action=delete&guestId=<c:out value="${guest.guestId}"/>'"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<form>
    <input class="button" type="button"  value="Add Record"
           onclick="location.href='GuestController.do?action=add'" />
</form>

</body>
</html>
