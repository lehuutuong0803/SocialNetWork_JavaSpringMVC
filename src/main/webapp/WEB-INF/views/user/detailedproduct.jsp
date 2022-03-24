<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<section>
		<div class="gap2 no-bottom">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="prod-detail">
							<div class="row">
								<div class="col-lg-6">
									<div class="central-meta">
										<div class="prod-avatar">
											<ul class="slider-for-gold">
												 <li><img src="${detailedproduct.image }" alt=""></li>
												 
											</ul>
											<ul class="slider-nav-gold">
												 <li><img src="${detailedproduct.image }" alt=""></li>
												 
											</ul>
										</div>	
									</div>	
								</div>
								<div class="col-lg-6">
    								<div class="central-meta">
    								
										<div class="full-postmeta">
											<ol class="pit-rate">
												<li class="rated"><i class="fa fa-star"></i></li>
												<li class="rated"><i class="fa fa-star"></i></li>
												<li class="rated"><i class="fa fa-star"></i></li>
												<li class="rated"><i class="fa fa-star"></i></li>
												<li class=""><i class="fa fa-star"></i></li>
												<li><span>4.7/5</span></li>
											</ol>
											<div class="share">
												<span>share</span>
												<a class="facebook-color" href="#" title=""><i class="fa fa-facebook-square"></i></a>
												<a class="twitter-color" href="#" title=""><i class="fa fa-twitter-square"></i></a>
												<a class="google-color" href="#" title=""><i class="fa fa-google-plus-square"></i></a>
											</div>
											
											
											<h4><span>${detailedproduct.product_name }</span></h4>
											<p>
												${detailedproduct.note } 
											</p>
											
											<form class="qty-select">
												<input class="qty" type="text" name="value" value="1">
											</form>
											<span class="prices style4">
												<ins>
													<span class="woocommerce-Price-amount amount">
														<span class="woocommerce-Price-currencySymbol">$</span>${detailedproduct.formatCurrency}
													</span>
												</ins>
												                                            
											</span>

											<button type="submit" id="${detailedproduct.id}" onClick="addCart(this.id)" href="#" class="main-btn" title="">Thêm vào giỏ hàng</button>
										</div>
										
									</div>
    							</div>
							</div>
							
							<div class="central-meta">
								<span class="title2">Related Products</span>
								<div class="row">
									<div class="col-lg-3 col-md-6">
										<div class="dig-pro">
											<figure>
												<img src="images/resources/dig-product1.jpg" alt="">
												<div class="user-avatr">
													<img alt="" src="images/resources/admin.jpg">
													<div>
														<span>Posted by</span>
														<ins>Jack Carter</ins>
													</div>	
												</div>
											</figure>
											<div class="digi-meta">
												<h4><a href="product-detail.html" title="">EMail Marketing 2020</a></h4>
												<p>Full E-Marketing for your digital product with cheap budget. </p>
												<div class="rate">
													<ol class="pit-rate">
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class=""><i class="fa fa-star"></i></li>
													</ol>
													<span class="qeemat"><del>60</del>$40</span>
												</div>
											</div>
										</div>
									</div>
									<div class="col-lg-3 col-md-6">
										<div class="dig-pro">
											<figure>
												<img src="images/resources/dig-product2.jpg" alt="">
												<div class="user-avatr">
													<img alt="" src="images/resources/user25.jpg">
													<div>
														<span>Posted by</span>
														<ins>Amy Watson</ins>
													</div>
												</div>
											</figure>
											<div class="digi-meta">
												<h4><a href="product-detail.html" title="">Android studio app</a></h4>
												<p>Make your own android app absolutely free by click here. </p>
												<div class="rate">
													<ol class="pit-rate">
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class=""><i class="fa fa-star"></i></li>
													</ol>
													<span class="qeemat"><del>40</del>$20</span>
												</div>
											</div>												
										</div>
									</div>
									<div class="col-lg-3 col-md-6">
										<div class="dig-pro">
											<figure>
												<img src="images/resources/dig-product4.jpg" alt="">
												<div class="user-avatr">
													<img alt="" src="images/resources/user15.jpg">
													<div>
														<span>Posted by</span>
														<ins>Bob Frank</ins>
													</div>
												</div>
											</figure>
											<div class="digi-meta">
												<h4><a href="product-detail.html" title="">Android studio app</a></h4>
												<p>Make your own android app absolutely free by click here. </p>
												<div class="rate">
													<ol class="pit-rate">
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class=""><i class="fa fa-star"></i></li>
													</ol>
													<span class="qeemat"><del>90</del>$70</span>
												</div>
											</div>												
										</div>
									</div>
									<div class="col-lg-3 col-md-6">
										<div class="dig-pro">
											<figure>
												<img src="images/resources/dig-product6.jpg" alt="">
												<div class="user-avatr">
													<img alt="" src="images/resources/user14.jpg">
													<div>
														<span>Posted by</span>
														<ins>Kiley Red</ins>
													</div>
												</div>
											</figure>
											<div class="digi-meta">
												<h4><a href="product-detail.html" title="">Android studio app</a></h4>
												<p>Make your own android app absolutely free by click here. </p>
												<div class="rate">
													<ol class="pit-rate">
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class="rated"><i class="fa fa-star"></i></li>
														<li class=""><i class="fa fa-star"></i></li>
													</ol>
													<span class="qeemat"><del>90</del>$70</span>
												</div>
											</div>												
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>	
					 </div>
			</div>
		</div>	
	</section>