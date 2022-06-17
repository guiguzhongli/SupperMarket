<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>供应商管理页面 >> 供应商添加页面</span>
    </div>
    <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/bill/billaddsave">
            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label for="billCode">订单编码：</label>
                <input type="text" name="billCode" id="billCode" value="">
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="productName">商品名称：</label>
                <input type="text" name="productName" id="productName" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="productDesc">商品类型：</label>
                <input type="password" name="productDesc" id="productDesc" value="">
                <font color="red"></font>
            </div>
<%--            <div>--%>
<%--                <label for="ruserPassword">供应商联系人：</label>--%>
<%--                <input type="password" name="proContact" id="ruserPassword" value="">--%>
<%--                <font color="red"></font>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label >创建者：</label>--%>
<%--                <select name="gender" id="gender">--%>
<%--                    <option value="1" selected="selected">男</option>--%>
<%--                    <option value="2">女</option>--%>
<%--                </select>--%>
<%--            </div>--%>
            <div>
                <label for="creationDate">创建时间：</label>
                <input type="date" Class="Wdate" id="creationDate" name="creationDate"
                       onclick="WdatePicker();">
                <font color="red"></font>
            </div>
            <div>
                <label for="productCount">商品单价：</label>
                <input type="text" name="productCount" id="productCount" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="providerId">商品厂商：</label>
                <input type="text" name="providerId" id="providerId" value="">
                <font color="red"></font>
            </div>
<%--            <div>--%>
<%--                <label for="address">联系电话：</label>--%>
<%--                <input name="proPhone" id="phone"  value="">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label >创建者：</label>--%>
<%--                <!-- 列出所有的角色分类 -->--%>
<%--                <!-- <select name="userRole" id="userRole"></select> -->--%>
<%--                <select name="createdBy" id="userRole">--%>
<%--                    <option value="1">系统管理员</option>--%>
<%--                    <option value="2">经理</option>--%>
<%--                    <option value="3" selected="selected">普通用户</option>--%>
<%--                </select>--%>
<%--                <font color="red"></font>--%>
<%--            </div>--%>
            <div class="providerAddBtn">
                <input type="submit" name="add" id="add" value="保存" >
                <input type="button" id="back" name="back" value="返回" >
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/WEB-INF/pages/common/foot.jsp" %>
<%--<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/billadd.js"></script>--%>
