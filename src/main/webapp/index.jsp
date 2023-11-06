<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.db.HibernateUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<title>Spenndle - Expense Tracker: Your Financial Compass</title>
<%@include file="components/all_cdn.jsp"%>
</head>

<body>
	<%@include file="components/navbar.jsp"%>
	<div id="carouselExampleInterval" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="10000">
				<img src="img/IMG_1.jpg" class="d-block w-100" alt="..."
					height="680px">
			</div>
			<div class="carousel-item" data-bs-interval="2000">
				<img src="img/IMG_2.jpg" class="d-block w-100" alt="..."
					height="680px">
			</div>
			<div class="carousel-item">
				<img src="img/IMG_3.jpg" class="d-block w-100" alt="..."
					height="680px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleInterval" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
</body>

</html>