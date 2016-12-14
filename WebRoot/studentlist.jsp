<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage=""%>
<%@ include file="header.jsp" %>
  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">Student</strong> / <small>Table</small></div>
    <div class="am-fr">
      <a href="student_addUI.action"><button type="button" class="am-btn am-btn-primary am-btn-xs">增加学生信息</button></a>
    </div>
      </div>

      <hr>

      <div class="am-g">
        <div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
              <th class="table-title">学号</th><th class="table-type">姓名</th><th class="table-author am-hide-sm-only">班级号</th><th class="table-set">专业号</th><th class="table-set">寝室号</th><th class="table-set">操作</th>
              </tr>
              </thead>
              <tbody>
           <s:iterator value="#request.slist" id="us">
              <tr>
                <td><s:property value="#us.studentid"/></td>
                <td><s:property value="#us.name"/></td>
                <td><s:property value="#us.classid"/></td>
                <td><s:property value="#us.majorid"/></td>
                <td><s:property value="#us.roomid"/></td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> <s:a href="student_updateP.action?student.studentid=%{#us.studentid}">update</s:a></button>
                      <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> <s:a href="student_delete.action?student.studentid=%{#us.studentid}">delete</s:a></button>
                    </div>
                  </div>
                </td>
              </tr>
           </s:iterator>


              </tbody>
            </table>
 
            <hr />

          </form>
        </div>

      </div>
    </div>

    <footer class="admin-content-footer">
      <hr>
      <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
    </footer>

  </div>
  <!-- content end -->
<%@ include file="footer.jsp" %>