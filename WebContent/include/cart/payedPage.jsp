<!-- 模仿天猫整站j2ee 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<div class="payedDiv">
	<div class="payedTextDiv">
		<img src="img/site/paySuccess.png">
		<span>鎮ㄥ凡鎴愬姛浠樻</span> 
		
	</div>
	<div class="payedAddressInfo">
		<ul>
			<li>鏀惰揣鍦板潃锛?${order.address} ${order.receiver} ${order.mobile }</li>
			<li>瀹炰粯娆撅細<span class="payedInfoPrice">
			锟?<fmt:formatNumber type="number" value="${param.total}" minFractionDigits="2"/>
			</li>
			<li>棰勮08鏈?08鏃ラ?佽揪	</li>
		</ul>
				
		<div class="paedCheckLinkDiv">
			鎮ㄥ彲浠?
			<a class="payedCheckLink" href="forebought">鏌ョ湅宸蹭拱鍒扮殑瀹濊礉</a>
			<a class="payedCheckLink" href="forebought">鏌ョ湅浜ゆ槗璇︽儏 </a>
		</div>
			
	</div>
	
	<div class="payedSeperateLine">
	</div>
	
	<div class="warningDiv">
		<img src="img/site/warning.png">
		<b>瀹夊叏鎻愰啋锛?</b>涓嬪崟鍚庯紝<span class="redColor boldWord">鐢≦Q缁欐偍鍙戦?侀摼鎺ュ姙鐞嗛??娆剧殑閮芥槸楠楀瓙锛?</span>澶╃尗涓嶅瓨鍦ㄧ郴缁熷崌绾э紝璁㈠崟寮傚父绛夐棶棰橈紝璋ㄩ槻鍋囧啋瀹㈡湇鐢佃瘽璇堥獥锛?
	</div>

	

</div>