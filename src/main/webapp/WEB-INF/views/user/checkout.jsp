<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<section>
		<div class="gap2 gray-bg">
			<div class="container">
				<div class="row">
					<div class="col-lg-8" style="margin:auto">
						<div class="row merged20" id="page-contents">
							<div class="central-meta" style="padding: 20px;">
									<h4 class="create-post">Thanh toán</h4>
									<div class="checkout-meta">
									<c:set var="totalInvoicePrice" scope="session" value="${0}" />
									<form:form method="post" action="/HutechSocialNetwork/user/checkout"  modelAttribute="invoice" >
										<div class="col-lg-12 col-sm-12">
												<label>Địa chỉ*</label>
													<form:input class="form-control" style="margin-bottom:15px;" type="text" placeholder="Nhập địa chỉ giao hàng" path="address"/>
													<label>Ghi chú*</label>
													<form:textarea class="form-control" rows="4" placeholder="Ghi chú của bạn"  path="note"></form:textarea>
												</div>
												
										
										<ul class="cart-prod">
										<c:forEach var="itemProduct" items="${Invoice_user}">
											<li>
												<span>${itemProduct.value.productDTO.product_name}</span>
												<ins>Regular License</ins>
												<p>
													<span></span>
													${itemProduct.value.productDTO.formatCurrency} ₫ x${itemProduct.value.quantity}
												</p>
											</li>
											<c:set var="totalInvoicePrice" scope="session" value="${totalInvoicePrice + itemProduct.value.totalPrice}" />
										</c:forEach>
											

										</ul>
										<div class="total-line">
											<ul>
											
												<li><ins>Tổng tiền:</ins> <span ><i></i ><fmt:formatNumber type="number" groupingUsed="true" value="${totalInvoicePrice}" /> ₫</span></li>
												
												<li><b>Tổng tiền mua: </b><em><fmt:formatNumber type="number" groupingUsed="true" value="${totalInvoicePrice}" /> ₫</em></li>
											</ul>
										</div>
										<div class="payment-method">
												<div>
													<label>Phương thức thanh toán</label>
													<div class="form-radio">
													<div class="radio" style="text-align:center">
														<button  id="${idOwner}" onClick="sendNotification(this.id)" style="margin: auto;
																	    width: 222px;
																	    display: block;
																	    margin-top: 20px;
																	    height: 40px;
																	    font-size: 25px;
																	    font-weight: bolder;" 
													    type="submit" class="main-btn">SHIP COD</button>
													  </div>
													  </form:form>
													  
													  <form method="post" action="/HutechSocialNetwork/authorize_payment">
														  <div class="radio" style="text-align:center">
														  <button style="background-color:#fff"  type="submit" title="">
												            <img class="paypal_img" src="../..//assets/images/paypal_checkout.gif" style="height:100px" />
														  </button>
														  </div>
													  </form>
													  
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