<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | E-Shopper</title>
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
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->


<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	String userName = (String) session.getAttribute("username");
	%>
	
<body>
	<jsp:include page="header.jsp" />

<section id="slider"><!--slider-->
		<div class="container">



 	 		  
 
 
 <form action="TimeslotController" method="post">
 
 
 <table class="table table-bordered ">
 <thead> 
 	<tr> 
 		<th></th>
 		 <th > Morning<jsp:useBean id="now" class="java.util.Date"  />
<fmt:formatDate value="${now}" pattern="dd-MM-yyyy" /></th>
 		 <th> Afternoon </th>
 		 <th> Evening </th>
 		 <th> Night</th> 
 	</tr> </thead>
 	 <tbody>  
 	 		 <tr> <th class=text-nowrap scope=row>Container width</th> <td>



  <input type="radio"   value="2017-02-11 11:00:00" name="appointment_time" id="slot_77658_2017-02-11110000" class="ui-helper-hidden-accessible">
  <label class="book-slot ui-button ui-widget ui-state-default ui-corner-all ui-button-disabled ui-state-disabled ui-button-text-only" for="slot_77658_2017-02-11110000" role="button" aria-disabled="true"><span class="ui-button-text">11:00:AM</span></label>
  
 <td>
   							<input type="radio"   value="2017-02-11 12:00:00" name="appointment_time" id="slot_77658_2017-02-11120000" class="ui-helper-hidden-accessible">
                            <label class="book-slot ui-button ui-widget ui-state-default ui-corner-all ui-button-disabled ui-state-disabled ui-button-text-only" for="slot_77658_2017-02-11120000" role="button" aria-disabled="true"><span class="ui-button-text">12:00:PM</span></label>
                            <input type="hidden" value="${now}" name="test"/>
                            <input type="radio"   value="2017-02-11 13:00:00" name="appointment_time" id="slot_77658_2017-02-11130000" class="ui-helper-hidden-accessible">
                            <label class="book-slot ui-button ui-widget ui-state-default ui-corner-all ui-button-disabled ui-state-disabled ui-button-text-only" for="slot_77658_2017-02-11130000" role="button" aria-disabled="true"><span class="ui-button-text">1:00:PM</span></label>
                            
                          
                            
                            
                            <input type="radio"   value="2017-02-11 14:00:00" name="appointment_time" id="slot_77658_2017-02-11140000" class="ui-helper-hidden-accessible">
                            <label class="book-slot ui-button ui-widget ui-state-default ui-corner-all ui-button-disabled ui-state-disabled ui-button-text-only" for="slot_77658_2017-02-11140000" role="button" aria-disabled="true"><span class="ui-button-text">2:00:PM</span></label>
                            
                            
                            <input type="radio"   value="2017-02-11 15:00:00" name="appointment_time" id="slot_77658_2017-02-11150000" class="ui-helper-hidden-accessible">
                            <label class="book-slot ui-button ui-widget ui-state-default ui-corner-all ui-button-disabled ui-state-disabled ui-button-text-only" for="slot_77658_2017-02-11150000" role="button" aria-disabled="true"><span class="ui-button-text">3:00:PM</span></label>
</td>

 <td>
                            
                            
                            
                            <input type="radio"   value="2017-02-11 16:00:00" name="appointment_time" id="slot_77658_2017-02-11160000" class="ui-helper-hidden-accessible">
                            <label class="book-slot ui-button ui-widget ui-state-default ui-corner-all ui-button-disabled ui-state-disabled ui-button-text-only" for="slot_77658_2017-02-11160000" role="button" aria-disabled="true"><span class="ui-button-text">4:00:PM</span></label>
                            
                            
                            
                            <input type="radio"   value="2017-02-11 17:00:00" name="appointment_time" id="slot_77658_2017-02-11170000" class="ui-helper-hidden-accessible">
                            <label class="book-slot ui-button ui-widget ui-state-default ui-corner-all ui-button-disabled ui-state-disabled ui-button-text-only" for="slot_77658_2017-02-11170000" role="button" aria-disabled="true"><span class="ui-button-text">5:00:PM</span></label>
                      
                            <input type="radio"   value="2017-02-11 18:00:00" name="appointment_time" id="slot_77658_2017-02-11180000" class="ui-helper-hidden-accessible">
                            <label class="book-slot ui-button ui-widget ui-state-default ui-corner-all ui-button-disabled ui-state-disabled ui-button-text-only" for="slot_77658_2017-02-11180000" role="button" aria-disabled="true"><span class="ui-button-text">6:00:PM</span></label>
                            
                            
                            <input type="radio"   value="2017-02-11 19:00:00" name="appointment_time" id="slot_77658_2017-02-11190000" class="ui-helper-hidden-accessible">
                            <label class="book-slot ui-button ui-widget ui-state-default ui-corner-all ui-button-disabled ui-state-disabled ui-button-text-only" for="slot_77658_2017-02-11190000" role="button" aria-disabled="true"><span class="ui-button-text">7:00:PM</span></label>
                            </td>
 
                            
                     <td>       
                            <input type="radio"   value="2017-02-11 20:00:00" name="appointment_time" id="slot_77658_2017-02-11200000" class="ui-helper-hidden-accessible">
                            <label class="book-slot ui-button ui-widget ui-state-default ui-corner-all ui-button-disabled ui-state-disabled ui-button-text-only" for="slot_77658_2017-02-11200000" role="button" aria-disabled="true"><span class="ui-button-text">8:00:PM</span></label>
                            
                            
                            
                           
                      
</td>
 
 
 
  </tr> 
 	 		 <tr> <th class=text-nowrap scope=row>Class prefix</th> <td><code>.col-xs-</code></td> <td><code>.col-sm-</code></td> <td><code>.col-md-</code></td> <td><code>.col-lg-</code></td> </tr>
 	 		 <tr> <th class=text-nowrap scope=row>Column width</th> <td class=text-muted>Auto</td> <td>~62px</td> <td>~81px</td> <td>~97px</td> </tr>
 	 		  
 	 		  <tr><td class=text-nowrap scope=row> <td colspan=4><input type="submit"   value="Submit" name="book_appointment" id="booking_btn_id" class="ui-helper-hidden-accessible"></td></th></tr></tbody> 
 	 		  
</table>
 
 <table class="table table-bordered">
 	<thead>
 		<tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
 	</thead>
 	<tbody>
 		<tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
      <tr>
        <td></td>
        <td colspan="2">Dooley</td>
      </tr>
 	</tbody>
 </table>
 </form>	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 <style>.donate-now {
     list-style-type:none;
     margin:25px 0 0 0;
     padding:0;
}

.donate-now li {
     float:left;
     margin:0 5px 0 0;
    width:100px;
    height:40px;
    position:relative;
}

.donate-now label, .donate-now input {
    display:block;
    position:absolute;
    top:0;
    left:0;
    right:0;
    bottom:0;
}

.donate-now input[type="radio"] {
    opacity:0.01;
    z-index:100;
}

.donate-now input[type="radio"]:checked + label,
.Checked + label {
    
    text-decoration: line-through;
    disabled:disabled;
    border-color #ffffff;
}

.donate-now label {
     padding:5px;
     border:1px solid #CCC; 
     cursor:pointer;
    z-index:90;
}

.donate-now label:hover {
     background:#DDD;
}</style>	 		  
<ul class="donate-now">
<li>
    <input type="radio" id="a25" name="amount" />
    <label for="a25">$25</label>
</li>
<li>
    <input type="radio" id="a50" name="amount" />
    <label for="a50">$50</label>
</li>
<li>
    <input type="radio" id="a75" name="amount" checked="checked" />
    <label for="a75">$75</label>
</li>
<li>
    <input type="radio" id="a100" name="amount" />
    <label for="a100">$100</label>
</li>
<li>
    <input type="radio" id="other" name="amount" />
    <label for="other">other:</label>
</li>
<li>
    <input type="text" id="otherAmount" name="numAmount" />
</li>
</ul>











 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 	 		  
 <div id="slots-group-77658" class="slots-group" style="display: table;">
                    <div class="day-row">
                        <div class="day-label">
                            
                            <div class="rel-day">TODAY</div>
                            
                            <div class="week-day">Sat</div>
                            <div class="date">11 Feb</div>
                        </div>
                        <div class="slot-header inside-group">
                            <div class="morning">MORNING</div>
                            <div class="afternoon">AFTERNOON</div>
                            <div class="evening">EVENING</div>
                            <div class="night">NIGHT</div>
                        </div>
                        
                        
                        
                            
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        <div class="day-slot-column">
                            
                        </div>
                        
                        <div class="day-slot-column">
                            
                            
                        
                            
                        </div>
                        
                        <div class="day-slot-column">
                            
                            
                           
                            
                            
                                  
                        </div>
                        
                    </div>
                </div>	 		  
</div>
</section>

</body>
</html>