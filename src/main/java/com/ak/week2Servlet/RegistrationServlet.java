package com.ak.week2Servlet;

import com.ak.week2.dao.RegistrationDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.regex.Pattern;

import com.ak.week2.RegistrationClass;

//Servlet handles form submission and validation
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Read form parameters from JSP
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String retypePassword = request.getParameter("retypePassword");
		String mobileNumber = request.getParameter("mobileNumber");
		String emailID = request.getParameter("emailID");

		boolean hasError = false;

		// Username validation
		if (userName == null || userName.isBlank() || userName.length() > 10) {
			request.setAttribute("userNameError", "Username cannot be blank and must not exceed 10 characters");
			hasError = true;
		}

		// Password validation
		if (password == null || password.isBlank() || !Pattern.matches("^[a-zA-Z0-9_$]{1,10}$", password)) {
			request.setAttribute("passwordError", "Password should not be blank");
			hasError = true;
		}

		// Retype password validation
		if (retypePassword == null || !retypePassword.equals(password)) {
			request.setAttribute("retypePasswordError", "Passwords do not match");
			hasError = true;
		}

		// Mobile validation
		if (mobileNumber == null || !Pattern.matches("^\\d{10}$", mobileNumber)) {
			request.setAttribute("mobileError", "Mobile number must be 10 digits, Mobile number can not be blank");
			hasError = true;
		}

		// Email validation
		if (emailID == null || emailID.isBlank() || !Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", emailID)) {
			request.setAttribute("emailError", "Enter valid Email ID. Field can not be blank");
			hasError = true;
		}

		// Populate Model
		RegistrationClass reg = new RegistrationClass();
		reg.setUserName(userName);
		reg.setPassword(password);
		reg.setRetypePassword(retypePassword);
		reg.setMobileNumber(mobileNumber);
		reg.setEmailID(emailID);

		// Preserve values for JSP
		request.setAttribute("userName", userName);
		request.setAttribute("mobileNumber", mobileNumber);
		request.setAttribute("emailID", emailID);

		// If there are validation errors, forward back to form
		if (hasError) {
			request.getRequestDispatcher("/RegistrationWebForm.jsp").forward(request, response);
		} else {
			try {
				RegistrationDao dao = new RegistrationDao();
				int result = dao.registerUser(reg);

				if (result > 0) {
					request.setAttribute("successMessage", "Registration Successful & Data Saved in DB!");
				} else {
					request.setAttribute("successMessage", "Registration Failed!");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("/RegistrationWebForm.jsp").forward(request, response);
		}
	}
}