<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>

<!-- Linking external CSS file -->
<link rel="stylesheet" href="css/registration.css">

</head>
<body>
	<div>
		<h2 style="text-align: center;">Registration Page</h2>

		<!-- Display success message if all validations pass -->
		<%
		if (request.getAttribute("successMessage") != null) {
		%>
		<p
			style="color: green; text-align: center; font-weight: bold; font-size: 16px;">
			<%=request.getAttribute("successMessage")%>
		</p>
		<%
		}
		%>
		<!-- form action ="RegistrationServlet" method="post"> -->
		<form action="<%=request.getContextPath()%>/RegistrationServlet"
			method="post">
			<table style="width: 80%">
				<!-- Username field -->
				<tr>
					<td>UserName</td>
					<td><input type="text" name="userName" value="${userName}"
						required /> <span style="color: red">${userNameError}</span></td>
				</tr>
				<!-- Password field -->
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"  required/> <span
						style="color: red">${passwordError}</span></td>
				</tr>
				<!-- Retype password field -->
				<tr>
					<td>ReType Password</td>
					<td><input type="password" name="retypePassword" /> <span
						style="color: red">${retypePasswordError}</span></td>
				</tr>
				<!-- Mobile number field -->
				<tr>
					<td>Mobile Number</td>
					<td><input type="text" name="mobileNumber"  required/> <span
						style="color: red">${mobileError}</span></td>
				</tr>
				<!-- Email field -->
				<tr>
					<td>Email Id</td>
					<td><input type="email" name="emailID" value="${emailID }" required />
						<span style="color: red">${emailError}</span></td>
				</tr>
				<tr>
					<td>Enter Captcha Image</td>
					<td><input type="text" name="captcha"></td>
				</tr>
			</table>
			<!-- Submit button -->
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>