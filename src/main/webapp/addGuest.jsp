<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Guest</title>

    <style>
        .field {
            clear: both;
            text-align: right;
            line-height: 25px;
        }

        label {
            float: left;
            padding-right: 10px;
        }

        .button {
            width: 100px;
        }

        .main {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100%;
        }
    </style>
</head>
<body>
<div class="main">
    <form name="guestForm" action="GuestController.do" method="post">

        <div class="field">
            <label for="firstName">Name:</label>
            <input id="firstName" type="text" value="${guest.firstName}" name="firstName" placeholder="Name" required="required" autofocus="autofocus">
        </div>

        <div class="field">
            <label for="lastName">Surname:</label>
            <input id="lastName" type="text" value="${guest.lastName}" name="lastName" placeholder="Surname" required="required">
        </div>

        <div class="field">
            <label for="birthday">Birthday Date:</label>
            <input id="birthday" type="date" value="${guest.birthday}" name="birthday" placeholder="YYYY-MM-DD" required="required"
                   pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" title="Date format YYYY-MM-DD">
        </div>

        <div class="field">
            <label for="phoneNumber">Phone #:</label>
            <input id="phoneNumber" type="tel" value="${guest.phoneNumber}" name="phoneNumber" placeholder="+38(XXX)XXX-XX-XX" required="required"
                   pattern="[\+]38[\(]\d{3}[\)]\d{3}[\-]\d{2}[\-]\d{2}"
                   title="Phone number format +38(XXX)XXX-XX-XX">
        </div>

        <div class="field">
            <label for="email">E-mail:</label>
            <input id="email" type="email" value="${guest.email}" name="email" placeholder="e-mail" required="required">
        </div>

        <div class="field">
            <label for="country">Country:</label>
            <input id="country" type="text" value="${guest.country}" name="country" placeholder="Country" required="required">
        </div>

        <div class="field">
            <label for="city">City:</label>
            <input id="city" type="text" value="${guest.city}" name="city" placeholder="City" required="required">
        </div>

        <br>
        <input class="button" type="submit" value="Submit">
        <input class="button" type="reset" value="Reset">
        <input class="button" type="button" value="Return"
               onclick="location.href='GuestController.do?action=listGuests'"/>
    </form>
</div>

</body>
</html>
