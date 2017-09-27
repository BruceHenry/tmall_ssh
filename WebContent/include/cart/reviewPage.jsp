<!-- 模仿天猫整站j2ee 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<div class="reviewDiv">
	<div class="reviewProductInfoDiv">
		<div class="reviewProductInfoImg"><img width="400px" height="400px" src="img/productSingle/${product.firstProductImage.id}.jpg"></div>
		<div class="reviewProductInfoRightDiv">
			<div class="reviewProductInfoRightText">
				${product.name}
			</div>
			<table class="reviewProductInfoTable">
				<tr>
					<td width="75px">浠锋牸:</td>
					<td><span class="reviewProductInfoTablePrice">锟?<fmt:formatNumber type="number" value="${product.originalPrice}" minFractionDigits="2"/></span> 鍏? </td>
				</tr>
				<tr>
					<td>閰嶉??</td>
					<td>蹇??:  0.00</td>
				</tr>
				<tr>
					<td>鏈堥攢閲?:</td>
					<td><span class="reviewProductInfoTableSellNumber">${product.saleCount}</span> 浠?</td>
				</tr>
			</table>
			
			<div class="reviewProductInfoRightBelowDiv">
				<span class="reviewProductInfoRightBelowImg"><img1 src="img/site/reviewLight.png"></span>
				<span class="reviewProductInfoRightBelowText" >鐜板湪鏌ョ湅鐨勬槸 鎮ㄦ墍璐拱鍟嗗搧鐨勪俊鎭?
浜?<fmt:formatDate value="${order.createDate}" pattern="yyyy骞碝M鏈坉d"/>涓嬪崟璐拱浜嗘鍟嗗搧 </span>
			
			</div>
		</div>
		<div style="clear:both"></div>
	</div>
	<div class="reviewStasticsDiv">
		<div class="reviewStasticsLeft">
				<div class="reviewStasticsLeftTop"></div>
				<div class="reviewStasticsLeftContent">绱璇勪环 <span class="reviewStasticsNumber"> ${product.reviewCount}</span></div>
				<div class="reviewStasticsLeftFoot"></div>
		</div>
		<div class="reviewStasticsRight">
			<div class="reviewStasticsRightEmpty"></div>
			<div class="reviewStasticsFoot"></div>
		</div>
	</div>		
	
	<c:if test="${param.showonly==true}">
	<div class="reviewDivlistReviews">
		<c:forEach items="${reviews}" var="r">
			<div class="reviewDivlistReviewsEach">
				<div class="reviewDate"><fmt:formatDate value="${r.createDate}" pattern="yyyy-MM-dd"/></div>
				<div class="reviewContent">${r.content}</div>
				<div class="reviewUserInfo pull-right">${r.user.anonymousName}<span class="reviewUserInfoAnonymous">(鍖垮悕)</span></div>
			</div>
		</c:forEach>
	</div>
	</c:if>
	
	<c:if test="${param.showonly!=true}">
		<div class="makeReviewDiv">
		<form method="post" action="foredoreview">
			<div class="makeReviewText">鍏朵粬涔板锛岄渶瑕佷綘鐨勫缓璁摝锛?</div>
			<table class="makeReviewTable">
				<tr>
					<td class="makeReviewTableFirstTD">璇勪环鍟嗗搧</td>
					<td><textarea name="review.content"></textarea></td>
				</tr>
			</table>
			<div class="makeReviewButtonDiv">
				<input type="hidden" name="order.id" value="${order.id}">
				<input type="hidden" name="product.id" value="${product.id}">
				<button type="submit">鎻愪氦璇勪环</button>
			</div>
		</form>
		</div>	
	</c:if>

</div>