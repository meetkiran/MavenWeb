 
 
 <jsp:useBean id="cart" scope="session" class="com.smartshop.cart.CartBean" />
 
 <%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	String userName = (String) session.getAttribute("username");
	System.out.println("sess"+userName);
	%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>


<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +91 80 87 88 4819</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> kiranbirajdar58@gmail.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.jsp"><img src="images/home/logo.png" alt="" /></a>
						</div>
						<div class="btn-group pull-right">
							<!-- <div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									USA
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Canada</a></li>
									<li><a href="#">UK</a></li>
								</ul>
							</div> 
							
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									DOLLAR
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Canadian Dollar</a></li>
									<li><a href="#">Pound</a></li>
								</ul>
							</div>-->
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								
								<li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>
								<li><a href="checkout.jsp"><i class="fa fa-crosshairs"></i> Checkout</a></li>
								<li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i> Cart <span id="cartItemsCountId"><%=cart.getLineItemCount()%></span></a></li>
								
								
								<c:choose>
  <c:when test="${sessionScope.username != null}">
   <li><a href="/LogoutController"><i class="fa fa-lock"></i> Logout</a></li>
    
  </c:when>
 
  <c:otherwise>
   <li><a href="login.jsp"><i class="fa fa-lock"></i> Login</a></li>
  </c:otherwise>
</c:choose>
								
								
								
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index.jsp" class="active">Home</a></li>
								<li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                       
                                        <li><a href="timeslot.jsp">Products</a></li>
                                        <li><a href="addProductDetails.jsp">Products</a></li>
										<li><a href="product-details.jsp">Product Details</a></li> 
										
                                    </ul>
                                </li>
                                
                                <li class="dropdown"><a href="#">Category<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                       
                                        <li><a href="Category_mobileController">Snapdeal Mobiles</a></li>
										<li><a href="product-details.jsp">Product Details</a></li> 
										
                                    </ul>
                                </li> 
								<li class="dropdown"><a href="#">Deal Of th Day<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="FlipkartController">Flipkart</a></li>
										<li><a href="SnapdealController">Snapdeal</a></li>
                                    </ul>
                                </li> 
								<li class="dropdown"><a href="#"><i class="fa fa-user"></i> Account<i class="fa fa-angle-down"></i></a>
									 <ul role="menu" class="sub-menu">
                                       
                                        <li><a href="#">Accounts</a></li>
										<li><a href="#">Orders</a></li> 
										
                                    </ul>
								
								</li>
								<li><a href="contact-us.jsp">Contact</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							
				<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
	