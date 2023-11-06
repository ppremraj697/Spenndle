<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><i
			class="fa-solid fa-money-check" style="color: #ffffff;"></i>Spenndle</a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<c:if test="${empty loginUser}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp"><i
							class="fa-solid fa-house" style="color: #ffffff;"></i>Home</a></li>
				</c:if>

				<c:if test="${not empty loginUser}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home.jsp"><i
							class="fa-solid fa-house" style="color: #ffffff;"></i>Home</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="addExpense.jsp"><i class="fa-solid fa-plus"
							style="color: #ffffff;"></i>Add Expense</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="viewExpense.jsp" tabindex="-1"><i
							class="fa-solid fa-list" style="color: #ffffff;"></i>View Expense</a></li>
				</c:if>
			</ul>

			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<c:if test="${not empty loginUser}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">About us</a></li>
					<li class="nav-item"><a class="nav-link active" href="#"><i
							class="fa-solid fa-circle-user" style="color: #ffffff;">${loginUser.fullName}</i></a></li>
					<li class="nav-item"><a class="nav-link active"
						href="../logout" tabindex="-1"><i
							class="fa-solid fa-user-plus" style="color: #ffffff;"></i>Logout</a></li>
				</c:if>

				<c:if test="${empty loginUser}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">About us</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="login.jsp"><i class="fa-solid fa-right-to-bracket"
							style="color: #ffffff;"></i>Login</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="register.jsp" tabindex="-1"><i
							class="fa-solid fa-user-plus" style="color: #ffffff;"></i>Register</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>