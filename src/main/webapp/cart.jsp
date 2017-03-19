<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Cart | E-Shopper</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="images/ico/apple-touch-icon-57-precomposed.png">
</head>
<!--/head-->
<script type="text/javascript">
	function cartFunction(event) {

		alert('delete me--' + $(event).attr('id'))
		$.ajax({

			type : 'POST',

			url : 'servlet/CartController',

			data : $('#formid' + $(event).attr('id')).serialize(),

			success : function(response) {

				$('#cartItemsCountId').html(function(i, val) {
					if (val == 0) {
						return +val
					} else {
						return +val - 1
					}
				});
				
				window.location.reload();

			}

		});

	}
</script>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<jsp:useBean id="cart" scope="session"
		class="com.smartshop.cart.CartBean" />
	<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
	<%! int count=0; %>


	<section id="cart_items">
	<div class="container">
		<div class="breadcrumbs">
			<ol class="breadcrumb">
				<li><a href="#">Home</a></li>
				<li class="active">Shopping Cart</li>
			</ol>
		</div>
		<div class="table-responsive cart_info">
			<table class="table table-condensed">
				<thead>
					<tr class="cart_menu">
						<td class="image">Title</td>
						<td class="description"></td>
						<td class="price">Description</td>
						<!-- <td class="quantity">Quantity</td> -->
						<td class="quantity">Availability</td>
						<td class="total">Buy Now</td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${cart.lineItemCount==0}">
						<tr>
							<td colspan="4"><font size="2"
								face="Verdana, Arial, Helvetica, sans-serif">Your Cart is
									currently empty -<br />
						</tr>
					</c:if>
					<c:forEach var="cartItem" items="${cart.cartItems}"
						varStatus="counter">
						<form name="item" id="formid${counter.index}">
							<tr>
								<td class="cart_description">
									<h4>
										<a href=""><c:out value="${cartItem.title}" /></a>
									</h4> <!-- <p>Web ID: 1089772</p> -->
								</td>
								<td class="cart_product"><a href=""><img
										style="width: 180px; height: 200px"
										src="<c:out
								value="${cartItem.imgUrl}" />" alt=""></a>
								</td>

								<td class="cart_price">
									<p>
										<c:out value="${cartItem.modelDescription}" />
									</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<%-- <a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
									
									
									<a class="cart_quantity_down" href=""> - </a> --%>
										<input type='hidden' name='itemIndex' value="${counter.index}" />
										<input type="hidden" name="action" value="Delete">
										<h4>
											<a href=""><c:out value="${cartItem.availability}" /></a>
										</h4>
									</div>
								</td>
								<td class="cart_total">
								<c:set var="anotherTest"	value="${cartItem.siteName}" scope="request" />
										 <%String buyVar;%><% buyVar=(String)request.getAttribute("anotherTest"); %>



									<%if(buyVar.equals("flipkart")){%>
									<p class="cart_total_price">
										<a target="_blank" href="${cartItem.productUrl}"
											class="btn btn-success">Buy Now From  <img
											style="width: 100px; height: 20px"
											src="http://www.flipkart.com/images/flipkart_india.png"
											alt="loading image" /></a>
									</p> <%}else{ %><p class="cart_total_price">
										<a target="_blank" href="${cartItem.productUrl}"
											class="btn btn-success">Buy Now From <img style="width:100px;height:20px" src="snapdeal_logo.png" alt="loading image"/></a>
									</p> <%} %></td>
								<td class="cart_delete"><a style="background: #FE980F"
									class="cart_quantity_delete" id="${counter.index}"
									onClick="cartFunction(this)"><i class="fa fa-times"></i></a></td>
							</tr>
						</form>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</section>
	<!--/#cart_items-->







	<!-- 	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>What would you like to do next?</h3>
				<p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
						<ul class="user_option">
							<li>
								<input type="checkbox">
								<label>Use Coupon Code</label>
							</li>
							<li>
								<input type="checkbox">
								<label>Use Gift Voucher</label>
							</li>
							<li>
								<input type="checkbox">
								<label>Estimate Shipping & Taxes</label>
							</li>
						</ul>
						<ul class="user_info">
							<li class="single_field">
								<label>Country:</label>
								<select>
									<option>United States</option>
									<option>Bangladesh</option>
									<option>UK</option>
									<option>India</option>
									<option>Pakistan</option>
									<option>Ucrane</option>
									<option>Canada</option>
									<option>Dubai</option>
								</select>
								
							</li>
							<li class="single_field">
								<label>Region / State:</label>
								<select>
									<option>Select</option>
									<option>Dhaka</option>
									<option>London</option>
									<option>Dillih</option>
									<option>Lahore</option>
									<option>Alaska</option>
									<option>Canada</option>
									<option>Dubai</option>
								</select>
							
							</li>
							<li class="single_field zip-field">
								<label>Zip Code:</label>
								<input type="text">
							</li>
						</ul>
						<a class="btn btn-default update" href="">Get Quotes</a>
						<a class="btn btn-default check_out" href="">Continue</a>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Cart Sub Total <span>$59</span></li>
							<li>Eco Tax <span>$2</span></li>
							<li>Shipping Cost <span>Free</span></li>
							<li>Total <span>$61</span></li>
						</ul>
							<a class="btn btn-default update" href="">Update</a>
							<a class="btn btn-default check_out" href="">Check Out</a>
					</div>
				</div>
			</div>
		</div>
	</section>/#do_action -->
	<div id="footer">
		<jsp:include page="Footer.jsp" />
	</div>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/main.js"></script>
</body>
</html>