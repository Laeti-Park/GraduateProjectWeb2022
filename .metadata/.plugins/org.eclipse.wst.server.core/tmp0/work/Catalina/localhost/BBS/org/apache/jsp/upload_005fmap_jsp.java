/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.52
 * Generated at: 2022-05-13 04:39:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import file.FileDTO;
import file.FileDAO;
import java.io.PrintWriter;

public final class upload_005fmap_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.io.PrintWriter");
    _jspx_imports_classes.add("file.FileDTO");
    _jspx_imports_classes.add("file.FileDAO");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!--\r\n");
      out.write("김영원: CSS\r\n");
      out.write("서동학: 전체적인 코딩\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>업로드/다운로드</title>\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("   margin: 0px;\r\n");
      out.write("   background-color: #f9f9f9;\r\n");
      out.write("   padding: 10px 0px 0px 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("   color: blue;\r\n");
      out.write("   text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   ");

   String userID = null;
   if (session.getAttribute("userID") != null) {
      userID = (String) session.getAttribute("userID");
   }
   String itemID = null;
   itemID = request.getParameter("itemID");
   String mapID = null;
   mapID = request.getParameter("mapID");
   
   // 본인이 아니면 다운로드페이지로 이동
   if (!mapID.equals(userID) || userID == null) {
      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("location.href = 'fileDownload.jsp?itemID=" + itemID + "&mapID=" + mapID + "'");
      script.println("</script>");
   }
   
      out.write("\r\n");
      out.write("   <span>총 업로드 가능 용량은 100mb입니다.</span>\r\n");
      out.write("   <hr>\r\n");
      out.write("   <button type=\"button\" name=\"add_btn\" id=\"add_btn\" style=\"margin-bottom: 10px;\" onclick=\"addButton()\">추가하기</button>\r\n");
      out.write("   <form action=\"uploadAction.jsp?id=");
      out.print(itemID);
      out.write("\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("      <input type=\"file\" name=\"file1\" id=\"file1\" style=\"margin-bottom: 10px;\"> <br> \r\n");
      out.write("      <input type=\"file\" name=\"file2\" id=\"file2\" style=\"margin-bottom: 10px; display: none;\">\r\n");
      out.write("      <input type=\"file\" name=\"file3\" id=\"file3\" style=\"margin-bottom: 10px; display: none;\"> \r\n");
      out.write("      <input type=\"file\" name=\"file4\" id=\"file4\" style=\"margin-bottom: 10px; display: none;\"> \r\n");
      out.write("      <input type=\"file\" name=\"file5\" id=\"file5\" style=\"margin-bottom: 10px; display: none;\"> \r\n");
      out.write("      <input type=\"submit\" value=\"업로드\">\r\n");
      out.write("   </form>\r\n");
      out.write("   <br>\r\n");
      out.write("   <a href=\"fileDownload.jsp?itemID=");
      out.print(itemID);
      out.write("&mapID=");
      out.print(mapID);
      out.write("\">파일 관리</a>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("   var n = 1;\r\n");
      out.write("   // 화면에서 추가하기 버튼을 누르면 파일을 하나더 업로드할 수 있게 변경\r\n");
      out.write("   function addButton() {\r\n");
      out.write("      var filenum = \"file\";\r\n");
      out.write("      if (n >= 5) {\r\n");
      out.write("         document.getElementById(\"add_btn\").disabled = true;\r\n");
      out.write("      } else {\r\n");
      out.write("         n++;\r\n");
      out.write("         if (n >= 5) {\r\n");
      out.write("            document.getElementById(\"add_btn\").disabled = true;\r\n");
      out.write("         }\r\n");
      out.write("         filenum = filenum + n;\r\n");
      out.write("         console.log(filenum);\r\n");
      out.write("         document.getElementById(filenum).style.display = \"block\";\r\n");
      out.write("      }\r\n");
      out.write("   }\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
