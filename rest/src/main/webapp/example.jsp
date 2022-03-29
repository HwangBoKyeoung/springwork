<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-md-6 grid-margin stretch-card">
      <div class="card">
         <div class="card-body">
            <h4 class="card-title">상세페이지</h4>
            <form class="forms-sample" action="adminUpdate.do" method="post">
               <div class="form-group">
                  <label for="exampleInputUsername1">ID</label> <input type="text"
                     class="form-control" id="MId" name="MId" readonly="readonly" value="${mana.MId }">
               </div>
               <div class="form-group">
                  <label for="exampleInputEmail1">Password</label> <input
                     type="password" class="form-control" id="pwd" name="pwd" value="${mana.pwd }" readonly="readonly">
               </div>
               <div class="form-group">
                  <label for="exampleInputUsername1">Name</label> <input type="text"
                     class="form-control" id="name" name="name" value="${mana.name }" readonly="readonly">
               </div>
               <div class="form-group">
                  <label for="exampleInputUsername1">Depart</label> <input
                     type="text" class="form-control" id="depart" value="${mana.depart }" name="depart">
               </div>
               <div class="form-group">
                  <label for="exampleInputUsername1">Phone</label> <input
                     type="text" class="form-control" id="phone" name="phone"
                     placeholder="Mobile number" value="${mana.phone }" readonly="readonly">
               </div>
               <div class="form-group">
                  <label for="exampleInputMobile">AuthCode</label>
                  <div class="input-group-prepend">
                     <select name="authCd" id="selectedval" data-auth="${mana.authCd }" class="col-md-6">
                        <option value="영화" <c:if test="${mana.authCd=='공연'}"> selected</c:if>> 영화담당자</option>
                        <option value="공연" <c:if test="${mana.authCd=='공연'}"> selected</c:if>> 공연담당자</option>
                        <option value="굿즈" <c:if test="${mana.authCd=='굿즈'}"> selected</c:if>> 굿즈담당자 </option>
                     </select>
                  </div>
               </div>
                  <button type="submit" class="btn btn-gradient-primary me-2">UPDATE</button>
                  <button class="btn btn-light" onclick="location.href='admin.do'">Cancel</button>
            </form>
         </div>
      </div>
   </div>
   <!-- <script type="text/javascript">
      /* console.log($("#selected option:selected").val()); */
      let dts = $("#selectedval").data("auth");
      /* console.log(dts); */
      console.log(${mana.authCd});

      console.log(vals);
      var index = $("#selectedval option").index($("#selectedval option:selected"));
      /* $("#selectedval").attr("selected", vals); */
         
      $('#selectedval option[value=' + ${mana.authCd} + ']').prop('selected', 'selected').change();
      /* $("#selectedval").change(function(){
         $("#selectedval").val($(this.val()));
      }) */
   </script> -->

</body>
</html>