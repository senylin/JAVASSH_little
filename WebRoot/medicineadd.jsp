<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage=""%>
<%@ include file="header.jsp" %>
<!-- content start -->
<div class="admin-content">
  <div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
      <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">添加</strong> /
        <small>medicine</small>
      </div>
    </div>

    <hr>

    <div class="am-tabs am-margin" data-am-tabs>
      <ul class="am-tabs-nav am-nav am-nav-tabs">
        <li class="am-active"><a href="#tab1">Medicine</a></li>
      </ul>

      <div class="am-tabs-bd">
       
        <div class="am-tab-panel am-fade am-in am-active" id="tab1">
          <form class="am-form" method="post" action="medicine_add.action">
 <!--        	 <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                	ID
              </div>
              <div class="am-u-sm-8 am-u-md-4">
                <input type="text" name="medicine.id" class="am-input-sm" >
              </div>
              <div class="am-hide-sm-only am-u-md-6">*******</div>
            </div> -->
        	
        	
            <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                	学生学号
              </div>
              <div class="am-u-sm-8 am-u-md-4">
                <input type="text" name="medicine.studentid" class="am-input-sm">
              </div>
              <div class="am-hide-sm-only am-u-md-6">*******</div>
            </div>

            <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                	医疗情况
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                <input type="text" name="medicine.status" class="am-input-sm">
              </div>
            </div>

            <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                	医疗记录
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                <input type="text" name="medicine.describ" class="am-input-sm">
              </div>
            </div>
            
            <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                	使用药物
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                <input type="text" name="medicine.drugs" class="am-input-sm">
              </div>
            </div>
         
            <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                	时间
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                <input type="text" name="medicine.time" class="am-input-sm">
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
