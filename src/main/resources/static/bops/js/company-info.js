$(function () {
    var  appServer = $("#appServer").val();

    //编辑点击事件
    $("#btn-edit").on("click",function () {
        $("#name").prop("disabled",false);
        $("#profile").prop("disabled",false);
    })

    //取消编辑事件
    $("#btn-cancel").on("click",function () {
        window.location.reload();
    })


    //注册点击事件
    $("#btn-save").on("click",function () {
      var id=$("#id").val();
      var name=$("#name").val();
      var profile=$("#profile").val();
      $.ajax({
          url: appServer+"bops/ajax/company/info/save.action",
          contentType: 'application/json',
          dataType: "json",
          type:"post",
          data:JSON.stringify({"id":id,"name":name,"profile":profile}),
          success:function(res){
              if(res.success){
                  window.location.reload();
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