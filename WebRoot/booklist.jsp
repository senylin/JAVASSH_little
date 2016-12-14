<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage=""%>
<%@ include file="header.jsp" %>
  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">Book</strong> / <small>Table</small></div>
	    <div class="am-fr">
	      <a href="book_addUI.action"><button type="button" class="am-btn am-btn-primary am-btn-xs">增加图书信息</button></a>
	    </div>
      </div>

      <hr>

      <div class="am-g">
        <div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
              <th class="table-title">ID</th><th class="table-title">书名</th><th class="table-type">学号</th><th class="table-author am-hide-sm-only">状态</th>
              <th class="table-type">操作时间</th><th class="table-set">操作</th>
              </tr>
              </thead>
              <tbody>
           <s:iterator value="#request.list" id="us">
              <tr>
                <td><s:property value="#us.id"/></td>
                <td><s:property value="#us.name"/></td>
                <td><s:property value="#us.studentid"/></td>
                <td><s:property value="#us.status"/></td>
                <td><s:property value="#us.time"/></td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> <s:a href="book_updateP.action?book.id=%{#us.id}">update</s:a></button>
                      <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> <s:a href="book_delete.action?book.id=%{#us.id}">delete</s:a></button>
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
