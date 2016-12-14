<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage=""%>
<%@ include file="header.jsp" %>
<!-- content start -->
<div class="admin-content">
  <div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
      <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">更新</strong> /
        <small>finance</small>
      </div>
    </div>

    <hr>

    <div class="am-tabs am-margin" data-am-tabs>
      <ul class="am-tabs-nav am-nav am-nav-tabs">
        <li class="am-active"><a href="#tab1">Finance</a></li>
      </ul>

      <div class="am-tabs-bd">
       
        <div class="am-tab-panel am-fade am-in am-active" id="tab1">
          <form class="am-form" method="post" action="finance_update.action">
        	 <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                	ID
              </div>
              <div class="am-u-sm-8 am-u-md-4">
                <input type="text" name="finance.id" class="am-input-sm" value="<%=request.getParameter("finance.id") %>" readonly>
              </div>
              <div class="am-hide-sm-only am-u-md-6">*******</div>
            </div>
        	
        	
             <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                	学生学号
              </div>
              <div class="am-u-sm-8 am-u-md-4">
                <input type="text" name="finance.studentid" class="am-input-sm">
              </div>
              <div class="am-hide-sm-only am-u-md-6">*******</div>
            </div>

            <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                	交付情况
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                <input type="text" name="finance.status" class="am-input-sm">
              </div>
            </div>

            <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                	学费
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                <input type="text" name="finance.tuitionfee" class="am-input-sm">
              </div>
            </div>
            
            <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                	宿费
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                <input type="text" name="finance.roomfee" class="am-input-sm">
              </div>
            </div>
         
            <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                	班费
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                <input type="text" name="finance.classesfee" class="am-input-sm">
              </div>
            </div> 

            
  			<input type="submit" name="" value="提交修改" class="am-btn am-btn-primary am-btn-xs">
          </form>
        </div>

      </div>
    </div>

    <div class="am-margin">
      <button type="button" class="am-btn am-btn-primary am-btn-xs">放弃修改</button>
    </div>
  </div>

  <footer class="admin-content-footer">
    <hr>
 
  </footer>
</div>
<!-- content end -->
<%@ include file="footer.jsp" %>
