<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Receipt</title>
<style type="text/css">
    table { border: 0; }
    table td { padding: 5px; }
</style>
</head>
<body>
<div class="gap no-gap signin whitish medium-opacity" style="padding:3rem 0px;color:black;height:84vh">
		<div class="bg-image"
		style="background-image:url(<c:url value ="/assets/images/resources/theme-bg.jpg"/>)"></div>
    <h1 style="text-align:center;color:black;position:relative;">Thanh toán thành công. Cảm ơn bạn đã mua sản phẩm</h1>
    <br/>
    <h2 style="text-align:center;color:black;position:relative;">Chi tiết thanh toán:</h2>
    <div class="container" style="margin-top:3rem">
    	<div class="row">
    		<div class="col-md-12">
    			<table style="width:100%;text-align:center;font-size:20px;background: #fff;">
	    			<tr style="border-width:1px;">
			            <td style="border-width:1px;width:50%;font-weight:bolder"><b>Merchant:</b></td>
			            <td style="border-width:1px;width:50%;">Company ABC Ltd.</td>
			        </tr>
			        <tr style="border-width:1px;">
			            <td style="border-width:1px;width:50%;font-weight:bolder"><b>Payer:</b></td>
			            <td style="border-width:1px;width:50%;">${payer.firstName} ${payer.lastName}</td>      
			        </tr>
			        <tr style="border-width:1px;">
			            <td style="border-width:1px;width:50%;font-weight:bolder"><b>Description:</b></td>
			            <td style="border-width:1px;width:50%;">${transaction.description}</td>
			        </tr>
			        <tr style="border-width:1px;">
			            <td style="border-width:1px;width:50%;font-weight:bolder"><b>Subtotal:</b></td>
			            <td style="border-width:1px;width:50%;">${transaction.amount.details.subtotal} USD</td>
			        </tr>
			        <tr style="border-width:1px;">
			            <td style="border-width:1px;width:50%;font-weight:bolder"><b>Shipping:</b></td>
			            <td style="border-width:1px;width:50%;">${transaction.amount.details.shipping} USD</td>
			        </tr>
			        <tr style="border-width:1px;">
			            <td style="border-width:1px;width:50%;font-weight:bolder"><b>Tax:</b></td>
			            <td style="border-width:1px;width:50%;">${transaction.amount.details.tax} USD</td>
			        </tr>
			        <tr style="border-width:1px;">
			            <td style="border-width:1px;width:50%;font-weight:bolder"><b>Total:</b></td>
			            <td style="border-width:1px;width:50%;">${transaction.amount.total} USD</td>
			        </tr>       
    			</table>
    		</div>
    	</div>
    </div>
    <table>
                     
    </table>
</div>
</body>