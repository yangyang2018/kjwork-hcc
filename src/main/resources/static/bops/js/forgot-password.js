$(function () {

    var  appServer = $("#appServer").val();
    //注册点击事件
  $("#btnReset").on("click",function () {
      var name=$("#name").val();
      $.ajax({
          url: appServer+"/front/ajax/resetPassword.do",
          // contentType: 'application/json', //默认 application/x-www-form-urlencoded
          dataType: "json",
          type:"post",
          data:{"name":name},
          success:function(res){
              if(res.success){
                  alert("重置成功");
              }else {
                  alert(res.errorInfo);
              }

          },
          error:function(){
              alert("网络错误！");
          }
      });
  })
})