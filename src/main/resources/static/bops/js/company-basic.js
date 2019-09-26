$(function () {
    var  appServer = $("#appServer").val();

    //编辑点击事件
    $("#btn-edit").on("click",function () {
        $("#simplesDic").prop("disabled",false);
        $("#phoneDic").prop("disabled",false);
        $("#emailDic").prop("disabled",false);
        $("#websiteDic").prop("disabled",false);
        $("#addressDic").prop("disabled",false);
    })

    //取消编辑事件
    $("#btn-cancel").on("click",function () {
        window.location.reload();
    })


    //注册点击事件
    $("#btn-save").on("click",function () {
      var simplesDicValue=$("#simplesDic").val();
        var simplesDicGroupNo=$("#simplesDic").attr("groupno");
      var simplesDicDicNo=$("#simplesDic").attr("dicno");
      var phoneDicValue=$("#phoneDic").val();
      var phoneDicGroupNo=$("#phoneDic").attr("groupno");
      var phoneDicDicNo=$("#phoneDic").attr("dicno");
      var emailDicValue=$("#emailDic").val();
      var emailDicGroupNo=$("#emailDic").attr("groupno");
      var emailDicDicNo=$("#emailDic").attr("dicno");
      var websiteDicValue=$("#websiteDic").val();
      var websiteDicGroupNo=$("#websiteDic").attr("groupno");
      var websiteDicDicNo=$("#websiteDic").attr("dicno");
      var addressDicValue=$("#addressDic").val();
      var addressDicGroupNo=$("#addressDic").attr("groupno");
      var addressDicDicNo=$("#addressDic").attr("dicno");

      var company={};
      company.simplesDic ={};
      company.simplesDic.remark=simplesDicValue;
      company.simplesDic.dicNo=simplesDicDicNo;
      company.simplesDic.groupNo=simplesDicGroupNo;

      company.phoneDic ={};
      company.phoneDic.remark=phoneDicValue;
      company.phoneDic.dicNo=phoneDicDicNo;
      company.phoneDic.groupNo=phoneDicGroupNo;

      company.emailDic ={};
      company.emailDic.remark=emailDicValue;
      company.emailDic.dicNo=emailDicDicNo;
      company.emailDic.groupNo=emailDicGroupNo;

      company.websiteDic ={};
      company.websiteDic.remark=websiteDicValue;
      company.websiteDic.dicNo=websiteDicDicNo;
      company.websiteDic.groupNo=websiteDicGroupNo;

      company.addressDic ={};
      company.addressDic.remark=addressDicValue;
      company.addressDic.dicNo=addressDicDicNo;
      company.addressDic.groupNo=addressDicGroupNo;
      $.ajax({
          url: appServer+"bops/ajax/company/basic/save.action",
          contentType: 'application/json',
          dataType: "json",
          type:"post",
          data:JSON.stringify(company),
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