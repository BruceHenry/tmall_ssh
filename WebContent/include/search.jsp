<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<div class="searchOutDiv">
    <a href="${contextPath}">
        <img id="logo" src="img/site/logo.gif" class="logo">
    </a>
    <form action="foresearch" method="post" > 
        <div class="searchDiv">
            <input name="keyword" type="text" value="${param.keyword}" placeholder="搜索 天猫 商品/品牌/店铺 ">
            <button  type="submit" class="searchButton">搜索</button>
            <div class="searchBelow">
                <c:forEach items="${cs}" var="c" varStatus="st">
                    <c:if test="${st.count>=5 and st.count<=8}">
                        <span>
                            <a href="forecategory?category.id=${c.id}">
                                ${c.name}
                            </a>
                            <c:if test="${st.count!=8}">              
                                <span>|</span>              
                            </c:if>
                        </span>           
                    </c:if>
                </c:forEach>      
            </div>
        </div>
    </form>   
</div>