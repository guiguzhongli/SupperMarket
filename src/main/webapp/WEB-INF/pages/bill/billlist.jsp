<%--
  Created by IntelliJ IDEA.
  User: 977
  Date: 2022/5/23
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>订单管理页面</span>
    </div>
    <div class="search">
        <form method="post" action="${pageContext.request.contextPath }/bill/billlist">
            <input name="method" value="query" class="input-text" type="hidden">
            <span>商品名称：</span>
            <input name="queryname" class="input-text"	type="text" value="${queryproductName }">
            <span>供应商：</span>
            <select name="queryisPayment">
                <c:if test="${providerList != null }">
                    <option value="0">--请选择--</option>
                    <c:forEach var="provider" items="${providerList}">
                        <option <c:if test="${provider.id == queryisPayment }">selected="selected"</c:if>
                                value="${provider.id}">${provider.proName}</option>
                    </c:forEach>
                </c:if>
            </select>

            <input type="hidden" name="pageIndex" value="1"/>
            <input	value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath}/bill/billadd" >添加订单</a>
        </form>
    </div>
    <!--用户-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">订单编码</th>
            <th width="20%">商品名称</th>
            <th width="20%">商品类型</th>
            <th width="10%">创建时间</th>
            <th width="10%">商品单价</th>
            <th width="10%">商品厂商</th>
            <th width="20%">操作</th>


        </tr>
        <c:forEach var="bill" items="${pageResult.list }" varStatus="status">
            <tr>
                <td>
                    <span>${bill.billCode}</span>
                </td>
                <td>
                    <span>${bill.productName}</span>
                </td>
                <td>
                    <span>${bill.productDesc}</span>
                </td>
                <td>
                    <span>${bill.creationDate}</span>
                </td>
                <td>
                    <span>${bill.productCount}</span>
                </td>
                <td>
                    <span>${bill.provider.proName}</span>
                </td>
                <td>
                    <span><a class="viewUser" href="javascript:;" billid=${bill.id } username=${bill.productName }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
                    <span><a class="modifyUser" href="javascript:;" billid=${bill.id } username=${bill.productName }><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
                    <span><a class="deleteUser" href="javascript:;" billid=${bill.id } username=${bill.productName }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="totalPageCount" value="${pageResult.pages}"/>
    <c:import url="../rollpage.jsp">
        <c:param name="totalCount" value="${pageResult.pages}"/>
        <c:param name="currentPageNo" value="${pageResult.pageNum}"/>
        <c:param name="totalPageCount" value="${pageResult.pages}"/>
    </c:import>
</div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/pages/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/billlist.js"></script>