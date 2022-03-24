
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<section>
	<div class="gap2 gray-bg" style="height:90vh">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="row merged20" id="page-contents">
						<!-- nave list -->
						<div class="col-lg-9">
							<div class="central-meta">
							<c:forEach var="itemOwner" items="${OwnerList}">
								<c:set var="totalInvoicePrice" scope="session" value="${0}" />
									<h4 class="create-post">Sản phẩm của ${itemOwner.name}</h4>
									<div class="cart-sec">
									<table class="table table-responsive">
										<tr>
											<th>Tên Sản Phẩm</th>
											<th>Giá</th>
											<th>Số Lượng</th>
											<th>Thành Tiền</th>
										</tr>

										
											<c:forEach var="itemProduct" items="${Cart}">
												<c:if test="${itemOwner.id == itemProduct.value.productDTO.user_id}">
												<tr>
													<td><a
														href="<c:url value="/user/deletecart/${itemProduct.value.productDTO.id}"/>"
														title="" class="delete-cart"><i class="ti-close"></i></a>
														<div class="cart-avatar">

															<img style="width:100px;height:100px" src="${itemProduct.value.productDTO.image}" alt="">
														</div>
														<div class="cart-meta">
															<span>${itemProduct.value.productDTO.product_name}</span>
														</div></td>
													<td><span class="cart-prices"> 
																<span class="woocommerce-Price-amount amount"><span
																	class="woocommerce-Price-currencySymbol"></span>${itemProduct.value.productDTO.formatCurrency} ₫</span>
															</ins>
													</span></td>
													<td>
														<div class="cart-list-quantity">
															<div class="c-input-number">
																<span> <input type="number" class="manual-adjust" id = "quantity-${itemProduct.value.productDTO.id}" value="${itemProduct.value.quantity}" />
																</span> <button style="border-radius: 30px;
																						background: #fa6342;
																						border:none;
																						margin-left:10px;
																						color: #fff;
																						font-size: 13px;
																						font-weight: 500;
																						padding: 10px 26px;
																						display: inline-block;
																						transition: all 0.2s linear 0s;
																						box-shadow: 4px 7px 12px 0 rgb(250 99 66 / 20%);" id="${itemProduct.value.productDTO.id}" onClick="EditQuantityCart(this.id)" data-id="${itemProduct.value.productDTO.id}" type="button">Cập nhập</button>
															</div>
														</div>
													</td>
													<td><span class="total-price">${itemProduct.value.formatCurrency} ₫</span></td>
													<c:set var="totalInvoicePrice" scope="session" value="${totalInvoicePrice + itemProduct.value.totalPrice}" />
												</tr>
												</c:if>
											</c:forEach>
									
										<c:if test="${Cart == null}">
											<h1> Không có sản phẩm trong giỏ hàng</h1>
										</c:if>

									</table>
									</div>
									<div class="row">
									<div class="col-lg-6">
										<div class="amount-area">

											<div class="total-area">
												<ul>
													<li><span>Tổng tiền:</span> <i> <fmt:formatNumber type="number" groupingUsed="true" value="${totalInvoicePrice}" /> đ</i></li>
													<li class="order-total"><span>Tổng tiền mua:</span> <i><fmt:formatNumber type="number" groupingUsed="true" value="${totalInvoicePrice}" /> đ</i>
													</li>
												</ul>
											</div>
										</div>
									</div>
									<div class="col-lg-6">
										<form method="post" class="coupon-code">
											<input type="text" placeholder="Nhập mã khuyến mãi">
											<button>
												<i class="fa fa-paper-plane-o"></i>
											</button>
										</form>
										<div class="proceed">
											 <a
												href="<c:url value="/user/checkout/${itemOwner.id}"/>" type="submit" title="" class="main-btn">Đặt mua</a>
										</div>
									</div>
								</div>
									
							</c:forEach>
								
								
								
							</div>
						</div>
						<div class="col-lg-3">
							<aside class="sidebar static right">
								<!-- recent post-->
								
								<!-- ad banner -->
							</aside>
						</div>
						<!-- sidebar -->
					</div>
				</div>
			</div>
		</div>
	</div>
</section>