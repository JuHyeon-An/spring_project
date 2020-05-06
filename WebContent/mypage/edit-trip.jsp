<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<!-- Mobile Specific Meta -->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Favicon-->
		<link rel="shortcut icon" href="./img/fav.png">
		<!-- Author Meta -->
		<meta name="author" content="colorlib">
		<!-- Meta Description -->
		<meta name="description" content="">
		<!-- Meta Keyword -->
		<meta name="keywords" content="">
		<!-- meta character set -->
		<meta charset="UTF-8">
		<!-- Site Title -->
		<title>Travel</title>

		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
			<!--
			CSS
			============================================= -->
			<link rel="stylesheet" href="./css/linearicons.css">
			<link rel="stylesheet" href="./css/font-awesome.min.css">
			<link rel="stylesheet" href="./css/bootstrap.css">
			<link rel="stylesheet" href="./css/magnific-popup.css">
			<link rel="stylesheet" href="./css/jquery-ui.css">				
			<link rel="stylesheet" href="./css/nice-select.css">							
			<link rel="stylesheet" href="./css/animate.min.css">
			<link rel="stylesheet" href="./css/owl.carousel.css">				
			<link rel="stylesheet" href="./css/main.css">
			<link rel="stylesheet" href="./css/custom.css">
<title>Insert title here</title>
</head>
<body>

		<body>	
			<header id="header">
				<div class="header-top">
					<div class="container">
			  		<div class="row align-items-center">
			  			<div class="col-lg-6 col-sm-6 col-6 header-top-left">
			  				<ul>
			  					<li><a href="#">Visit Us</a></li>
			  					<li><a href="#">Buy Tickets</a></li>
			  				</ul>			
			  			</div>
			  			<div class="col-lg-6 col-sm-6 col-6 header-top-right">
							<div class="header-social">
								<a href="#"><i class="fa fa-facebook"></i></a>
								<a href="#"><i class="fa fa-twitter"></i></a>
								<a href="#"><i class="fa fa-dribbble"></i></a>
								<a href="#"><i class="fa fa-behance"></i></a>
							</div>
			  			</div>
			  		</div>			  					
					</div>
				</div>
				<div class="container main-menu">
					<div class="row align-items-center justify-content-between d-flex">
				      <div id="logo">
				        <a href="index.html"><img src="./img/logo.png" alt="" title="" /></a>
				      </div>
				      <nav id="nav-menu-container">
				        <ul class="nav-menu">
				          <li><a href="index.html">Home</a></li>
				          <li><a href="about.html">About</a></li>
				          <li><a href="packages.html">Packages</a></li>
				          <li><a href="hotels.html">Hotels</a></li>
				          <li><a href="insurance.html">Insurence</a></li>
				          <li class="menu-has-children"><a href="">Blog</a>
				            <ul>
				              <li><a href="blog-home.html">Blog Home</a></li>
				              <li><a href="blog-single.html">Blog Single</a></li>
				            </ul>
				          </li>	
				          <li class="menu-has-children"><a href="">Pages</a>
				            <ul>
				            	  <li><a href="elements.html">Elements</a></li>
						          <li class="menu-has-children"><a href="">Level 2 </a>
						            <ul>
						              <li><a href="#">Item One</a></li>
						              <li><a href="#">Item Two</a></li>
						            </ul>
						          </li>					                		
				            </ul>
				          </li>					          					          		          
				          <li><a href="contact.html">Contact</a></li>
				        </ul>
				      </nav><!-- #nav-menu-container -->					      		  
					</div>
				</div>
			</header><!-- #header -->
			  
			  
			  <section class="about-banner relative">
				<div class="overlay overlay-bg"></div>
				<div class="container">				
					<div class="row d-flex align-items-center justify-content-center">
						<div class="about-content col-lg-12">
							<h1 class="text-white">
								My Trip				
							</h1>	
							<p class="text-white link-nav"><a href="index.html">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="hotels.html"> My Trips</a></p>
						</div>	
					</div>
				</div>
			</section>

			<section class="post-content-area single-post-area">
				<div class="container">
					<form>
						<div class="text-center row">
							<div class="col-md-12">
							<input class="edit-trip-input" type="text" placeholder="여행이름을 입력하세요."/>
							<button class="btn-edit" type="button">✔</button>
						</div>
						</div>
					</form>
					<div class="row">
						<div class="col-lg-12">
							<div class="edit-plan row">
									<div class="col-lg-9">
										<div id="map" style="width:100%;height:350px;"></div>
									</div>
									<div class="col-lg-3">
										<h4 class="text-center mb-3">여행일정짜기</h4>
										<div><span>1️⃣</span>
										<span class="plan-container">
									 첨성대첨성대첨성대
								</span>
							</div>
							<div>
							<span>2️⃣ </span>
								<span class="plan-container">
									불국사첨성대
								</span>
							</div>	
							<div>
								<span>3️⃣ </span>
								<span class="plan-container">
									 석굴암첨성대첨성대
								</span>
							</div>
							<span>4️⃣ </span>
								<span class="plan-container">
									첨성대첨성대
								</span>
									</span>									
								</span>
								</div>
							</div>
							<div class="edit-trip">

								<input type="text" placeholder="여행지 검색"/>
								<input type="button" value="검색"/>
								<br/>
								<hr/>
								<div class="add-from-like">
								<h5 class="text-center mb-2">내 관심리스트에서 추가</h5>
								<div>여행지1 <input type="button" class="genric-btn info circle small" value="추가"/></div>
								<div>여행지2 <input type="button" class="genric-btn info circle small" value="추가"/></div>
								<div>여행지3 <input type="button" class="genric-btn info circle small" value="추가"/></div>
							</div>
							</div>
							<div class="comment-form">
								<h4>Leave a Comment</h4>
								<form>
									<div class="form-group form-inline">
									  <div class="form-group col-lg-6 col-md-12 name">
									    <input type="text" class="form-control" id="name" placeholder="Enter Name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Name'">
									  </div>
									  <div class="form-group col-lg-6 col-md-12 email">
									    <input type="email" class="form-control" id="email" placeholder="Enter email address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'">
									  </div>										
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="subject" placeholder="Subject" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Subject'">
									</div>
									<div class="form-group">
										<textarea class="form-control mb-10" rows="5" name="message" placeholder="Messege" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Messege'" required=""></textarea>
									</div>
									<a href="#" class="primary-btn text-uppercase">Post Comment</a>	
								</form>
							</div>
						</div>
						
					</div>
				</div>	
			</section>			

			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=52d0cd9eb539c564cdc52bb34a626875"></script>	
			<script src="./js/vendor/jquery-2.2.4.min.js"></script>
			<script src="./js/popper.min.js"></script>
			<script src="./js/vendor/bootstrap.min.js"></script>			
 			<script src="./js/jquery-ui.js"></script>					
  			<script src="./js/easing.min.js"></script>			
			<script src="./js/hoverIntent.js"></script>
			<script src="./js/superfish.min.js"></script>	
			<script src="./js/jquery.ajaxchimp.min.js"></script>
			<script src="./js/jquery.magnific-popup.min.js"></script>						
			<script src="./js/jquery.nice-select.min.js"></script>					
			<script src="./js/owl.carousel.min.js"></script>							
			<script src="./js/mail-script.js"></script>	
			<script src="./js/main.js"></script>
			<script src="./my_page.js"></script>

</body>
</html>