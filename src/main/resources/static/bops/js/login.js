$(function () {
    var  appServer = $("#appServer").val();
    //注册点击事件
    $("#btnLogin").on("click",function () {
      var username=$("#exampleInputEmail").val();
      var password=$("#exampleInputPassword").val();
      //md5加密
      var pwd = $.md5(password);
      $.ajax({
          url: appServer+"bops/ajax/login.action",
          contentType: 'application/json',
          dataType: "json",
          type:"post",
          data:JSON.stringify({"username":username,"password":pwd}),
          success:function(res){
              if(res.success){
                  window.location.href=appServer+"bops/index.action";
              }else {
                  alert(res.resultInfo);
              }
          },
          error:function(){
              alert("请求异常！");
          }
      });
    })
})