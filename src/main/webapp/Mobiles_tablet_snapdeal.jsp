<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
	import="com.snapdeal.data.*,java.util.ArrayList,org.json.simple.JSONObject"%>
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
 <jsp:useBean id="cart" scope="session" class="com.smartshop.cart.CartBean" />
 <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%! int count=0; %>
<body>

<!-- <form action="servlet/CartController" method="post"><input type="submit" ></input></form> -->

	<jsp:include page="header.jsp" />
	
	<script type="text/javascript">

function cartFunction(event){
	
		
	$.ajax({

        type : 'POST',

          url : 'servlet/CartController',

          data : $('#formid'+$(event).attr('id')).serialize(),

           success : function(response) {
        	   
        	   $('#cartItemsCountId	').html(function(i, val) { 
        		   $(event).html("<i	class='fa fa-shopping-cart'></i>Go to Cart" );	
        		   return +val+1 });

        	   

        }

    });
	
}
	
	
   


</script>



		
		
		
		
	<section id="advertisement">
	<div class="container">
		<!-- <img src="images/shop/advertisement.jpg" alt="" /> -->
		<div data-WRID="WRID-148456126409212140" data-widgetType="searchBar" data-class="affiliateAdsByFlipkart" height="45" width="640" ></div><script async src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script>
	</div>
	<div class="dropdown">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort by
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="#">High:Price</a></li>
    <li><a href="#">Low:Price</a></li>
    <li><a href="#">Brand:Brand</a></li>
  </ul>
</div>	
	</section>

	<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="left-sidebar">

					<div class="panel-group category-products" id="accordian">
						<!--category-productsr-->

					</div>
					<!--/category-productsr-->

					<div class="shipping text-center">
						<!--shipping-->
					<!--  <img src="images/home/shipping.jpg" alt="" />  -->
					<div data-WRID="WRID-148456200618716695" data-widgetType="staticBanner" data-responsive="yes" data-class="affiliateAdsByFlipkart" height="250" width="300"></div><script async src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script>
							</div>
					<!--/shipping-->

				</div>
			</div>

			<div class="col-sm-9 padding-right">
				<div class="features_items">
					<!--features_items-->
					<h2 class="title text-center">Mobiles and Tablets  !!  
					
					
				
				</h2>

					

					<!--flipcart data-->


					<% 
						SortJSON getData = new SortJSON();
					ArrayList<JSONObject> obj = getData.sendData();
						//iterating over values only
						System.out.println(obj.size());
						for (JSONObject objlist : obj) {
					%>
					<form  id="formid<%=count%>" name="formname">
					<div class="col-sm-4">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="<%=objlist.get("imageLink")%>" alt=""
										style="width: 200px; height: 200px" />
										
										<input name="productDescId" disabled value='<%=objlist.get("title")%>' style="border: 0;font-weight: bold;background-color: #FFFFFF;input:focus{outline: none;}"></input>
									 
									  <input type="hidden" name="title" value="<%=objlist.get("title")%>">
									   <input type="hidden" name="description" value="<%=objlist.get("description")%>">
									    <input type="hidden" name="availability" value="<%=objlist.get("availability") %>">
									     <input type="hidden" name="productUrl" value="<%=objlist.get("link")%>">
									     <input type="hidden" name="imageUrl" value="<%=objlist.get("imageLink")%>">
									     <input type="hidden" name="siteName" value="flipkart">
										
								</div>
								<div class="product-overlay">
									<div class="overlay-content">
										<!-- <h2>INR.499</h2> -->
											<p><%=objlist.get("description")%></p>
											<p>INR.<%=objlist.get("mrp")%></p>
										<input type="hidden" name="action" value="add">					
										<a onClick="cartFunction(this)" id="<%=count%>"  name="formAnchor" class="btn btn-default add-to-cart" ><i
											class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
								</div>
							</div>
							</form>
							<div class="choose">
								<ul class="nav nav-pills nav-justified">
									<li><a href="" ><i class="fa fa-plus-square"></i>Add to
											wishlist</a></li>
									<li><a href="" ><i class="fa fa-plus-square" ></i>Add to
											compare</a></li>
								</ul>
							</div>
						</div>
					</div>

					<%
					++count;}
					%>




					<ul class="pagination">
						<li class="active"><a href="">1</a></li>
						<li><a href="">2</a></li>
						<li><a href="">3</a></li>
						<li><a href="">&raquo;</a></li>
					</ul>
				</div>
				<!--features_items-->



			</div>
		</div>
	</div>
	</section>
	<%-- <center>
					<h3>Deals Of The Day !</h3>
					<%HttpURLConnectionExample getData=new HttpURLConnectionExample();
					Map<Integer,ProductInfo>obj=getData.sendGet();
					//iterating over values only
					for (ProductInfo product : obj.values()) {
					    
					%>
					

	<div class="col-xs-12"></div>
	
	
	
	
  
    <ul class="nav nav-pills navbar-form row">
      <div class="col-xs-4 col-md-offset-2">
        <li class="list-group-item navbar-form"><%=product.getDescription()%></li>
        <li class="list-group-item navbar-form"><%=product.getTitle()%></li>
        <li class="list-group-item navbar-form">Available:<%=product.getInStock() %></li>
        <li class="list-group-item navbar-form"><a target="_blank" href="<%=product.getProductUrl()%>" class="btn btn-success">BUY NOW FROM<img style="width:100px;height:20px" src="http://www.flipkart.com/images/flipkart_india.png" alt="loading image"/></a></li>
      </div>
      <div class="col-md-offset-6">
        <ul class="nav nav-pills navbar-form">
          <li style="float:left" class="list-group-item navbar-form"><a target="_blank" href="">      <img style="width:200px;height:300px" src="<%=product.getImgurl()%>" alt="loading image"/></a></li>
        </ul>
      </div>
      
    </ul>
  <%} %>
  <hr/>
</center> --%>


<%-- 
		<c:forEach var="cartItem" items="${cart.cartItems}"
			varStatus="counter">
			
				
					<font size="2"
						face="Verdana, Arial, Helvetica, sans-serif"><b><c:out
									value="${cartItem.strDescription}" /></b><br /> <c:out
								value="${cartItem.modelDescription}" /></font>
					<font size="2"
						face="Verdana, Arial, Helvetica, sans-serif"><input
							 name='itemIndex'
							value='<c:out value="${counter.count}"/>'><input
							type='text' name="quantity"
							value='<c:out value="${cartItem.quantity}"/>' size='2'>  <br /> </font>
					<font size="2"
						face="Verdana, Arial, Helvetica, sans-serif">$<c:out
								value="${cartItem.unitCost}" /></font>
					<font size="2"
						face="Verdana, Arial, Helvetica, sans-serif">$<c:out
								value="${cartItem.totalCost}" /></font>
				
		
		</c:forEach> --%>
	<jsp:include page="Footer.jsp" />

	<script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/main.js"></script>
</body>
</html>