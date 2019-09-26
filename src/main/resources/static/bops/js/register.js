$(function () {

    var  appServer = $("#appServer").val();
    //注册点击事件
  $("#btnRegister").on("click",function () {
      var firstname=$("#firstname").val();
      var lastname=$("#lastname").val();
      var name=$("#name").val();
      var password=$("#password").val();
      var rePassword=$("#rePassword").val();
      if(password != rePassword){
          alert("两次输入密码不一致")
          return;
      }
      $.ajax({
          url: appServer+"/front/ajax/register.do",
          contentType: 'application/json',
          dataType: "json",
          type:"post",
          data:JSON.stringify({"firstname":firstname,"lastname":lastname,"name":name,"password":password}),
          success:function(res){
              if(res.success){
                  alert("注册成功");
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