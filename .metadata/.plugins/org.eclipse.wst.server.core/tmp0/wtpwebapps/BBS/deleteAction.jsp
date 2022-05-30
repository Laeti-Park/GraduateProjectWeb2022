<!--
김영원: 전체적인 코딩
서동학: category 나누기
-->


<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="bbs.BbsDAO"%>
<%@ page import="bbs.Bbs"%>
<%@ page import="bbs.NoticeDAO"%>
<%@ page import="bbs.Notice"%>
<%@ page import="bbs.StudyboardDAO"%>
<%@ page import="bbs.Studyboard"%>
<%@ page import="java.io.PrintWriter"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
   String category = request.getParameter("category");
   String userID = null;
   
   // if user logged-in
   if (session.getAttribute("userID") != null) {
      userID = (String) session.getAttribute("userID");
   }
   // if user not logged-in
   if (userID == null) {
      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("alert('로그인을 하세요.');");
      script.println("history.back();");
      script.println("</script>");
   }

   int bbsID = 0;
   // get bbsID (PK)
   if (request.getParameter("bbsID") != null) {
      bbsID = Integer.parseInt(request.getParameter("bbsID"));
   }
   // if there isn't bbsID
   if (bbsID == 0) {
      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("alert('유효하지 않은 글입니다.')");
      script.println("location.href = '" + category + ".jsp'");
      script.println("</script>");
   }
   
   
   Bbs bbs = new BbsDAO().getBbs(bbsID);
   Notice notice = new NoticeDAO().getNotice(bbsID);
   Studyboard studyboard = new StudyboardDAO().getStudyboard(bbsID);
   
   // if deleteAction isn't my post
   if (!userID.equals(bbs.getUserID()) && !userID.equals(studyboard.getUserID()) && !userID.equals(notice.getUserID())) {
      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("alert('권한이 없습니다.')");
      script.println("location.href = '" + category + ".jsp'");
      script.println("</script>");
   // if deleteAction is my post
   // delete by category
   } else {
      BbsDAO bbsDAO = new BbsDAO();
      NoticeDAO noticeDAO = new NoticeDAO();
      StudyboardDAO studyboardDAO = new StudyboardDAO();
      int result = 0;
      if (category.equals("notice")) {
         result = bbsDAO.delete(bbsID);
      }
      if (category.equals("noticeAdmin")) {
         result = noticeDAO.delete(bbsID);
      }
      if (category.equals("studyboard")) {
         result = studyboardDAO.delete(bbsID);
      }

      if (result == -1) {
         PrintWriter script = response.getWriter();
         script.println("<script>");
         script.println("alert('글삭제에 실패했습니다.')");
         script.println("history.back()");
         script.println("</script>");
      } else {
         PrintWriter script = response.getWriter();
         script.println("<script>");
         script.println("location.href = '" + category + ".jsp'");
         script.println("</script>");
      }
   }
   %>
</body>
</html>