<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review</title>
<style type="text/css">
    table { border: 0; }
    table td { padding: 5px; }
</style>
</head>
<body>
<div class="gap no-gap signin whitish medium-opacity" style="padding:3rem 0px;color:black">
		<div class="bg-image"
		style="background-image:url(<c:url value ="/assets/images/resources/theme-bg.jpg"/>)"></div>
    <h1 style="text-align:center;color:black;position:relative;">Kiểm tra thông tin trước khi thanh toán!</h1>
    <form action="/HutechSocialNetwork/user/execute_payment" method="post">
    
    <div class="container">
    	<div class="row" style="align-items: center;">
    		<div class="col-md-12">
    			<table style="width:100%;text-align:center;font-size:20px;background: #fff;">
    				<tbody style="border-width:1px;">
	    				<tr style="border-width:1px;">
				            <td style="border-width:1px;font-size:25px" colspan="2"><b>Transaction Details:</b>
				            	<input type="hidden" name="paymentId" value="${param.paymentId}" />
				                <input type="hidden" name="PayerID" value="${param.PayerID}" /></td>
				        </tr>
				        <tr style="border-width:1px;">
				            <td style="border-width:1px;width:50%;font-weight:bolder">Description:</td>
				            <td style="border-width:1px;width:50%;">${transaction.description}</td>
				        </tr>
				        <tr style="border-width:1px;">
				            <td style="border-width:1px;width:50%;font-weight:bolder">Subtotal:</td>
				            <td style="border-width:1px;width:50%;">${transaction.amount.details.subtotal} USD</td>
				        </tr>
				        <tr style="border-width:1px;">
				            <td style="border-width:1px;width:50%;font-weight:bolder">Shipping:</td>
				            <td style="border-width:1px;width:50%;">${transaction.amount.details.shipping} USD</td>
				        </tr>
				        <tr style="border-width:1px;">
				            <td style="border-width:1px;width:50%;font-weight:bolder">Tax:</td>
				            <td style="border-width:1px;width:50%;">0.00 USD</td>
				        </tr>
				        <tr style="border-width:1px;">
				            <td style="border-width:1px;width:50%;font-weight:bolder">Total:</td>
				            <td style="border-width:1px;width:50%;">${transaction.amount.total} USD</td>
				        </tr>
			        </tbody>
    			</table>
    		</div>
    		<div class="col-md-12" style="margin-top:20px">
    			<table style="width:100%;text-align:center;font-size:20px;background: #fff;">
    				<tbody style="border-width:1px;">
	    				<tr style="border-width:1px;">
				            <td style="border-width:1px;font-size:25px" colspan="2"><b>Payer Information:</b></td>
					        </tr>
					        <tr style="border-width:1px;">
					            <td style="border-width:1px;width:50%;font-weight:bolder">First Name:</td>
					            <td style="border-width:1px;width:50%;">${payer.firstName}</td>
					        </tr>
					        <tr style="border-width:1px;">
					            <td style="border-width:1px;width:50%;font-weight:bolder">Last Name:</td>
					            <td style="border-width:1px;width:50%;">${payer.lastName}</td>
					        </tr style="border-width:1px;">
					        <tr>
					            <td style="border-width:1px;width:50%;font-weight:bolder">Email:</td>
					            <td style="border-width:1px;width:50%;">${payer.email}</td>
				        </tr>
			        </tbody>
    			</table>
    		</div>
    		<div class="col-md-12" style="margin-top:20px">
    			<table style="width:100%;text-align:center;font-size:20px;background: #fff;">
    				<tbody style="border-width:1px;">
	    				<tr style="border-width:1px;">
				            <td style="border-width:1px;font-size:25px" colspan="2"><b>Shipping Address:</b></td>
				        </tr>
				        <tr style="border-width:1px;">
				            <td style="border-width:1px;width:50%;font-weight:bolder">Recipient Name:</td>
				            <td style="border-width:1px;width:50%;">${shippingAddress.recipientName}</td>
				        </tr>
				        <tr style="border-width:1px;">
				            <td style="border-width:1px;width:50%;font-weight:bolder">Line 1:</td>
				            <td style="border-width:1px;width:50%;">${shippingAddress.line1}</td>
				        </tr>
				        <tr style="border-width:1px;">
				            <td style="border-width:1px;width:50%;font-weight:bolder">City:</td>
				            <td style="border-width:1px;width:50%;">${shippingAddress.city}</td>
				        </tr>
				        <tr style="border-width:1px;">
				            <td style="border-width:1px;width:50%;font-weight:bolder">State:</td>
				            <td style="border-width:1px;width:50%;">${shippingAddress.state}</td>
				        </tr>
				        <tr style="border-width:1px;">
				            <td style="border-width:1px;width:50%;font-weight:bolder">Country Code:</td>
				            <td style="border-width:1px;width:50%;">${shippingAddress.countryCode}</td>
				        </tr>
				        <tr style="border-width:1px;">
				            <td style="border-width:1px;width:50%;font-weight:bolder">Postal Code:</td>
				            <td style="border-width:1px;width:50%;">${shippingAddress.postalCode}</td>
				        </tr>
			        </tbody>
    			</table>
    		</div>
    		<div style="text-align:center" class="col-md-12">
    			<input style=" background: #fa6342;
    border: medium none;
    border-radius: 30px;
    color: #fff;
    padding:10px 15px;
    font-size:20px;
    margin-top:10px" type="submit" id="${idOwner}" onClick="sendNotification(this.id)" value="Thanh toán" />
    		</div>
    	</div>
    </div>
    
    </form>
</div>
</body>
</html>