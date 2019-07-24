(function () {
	'use strict';

	var submitContact = function () {
		var appServerUrl = $("#appServerUrl").val();
		var firstname = $("#firstname").val();
		var lastname = $("#lastname").val();
		var phone = $("#phone").val();
		var email = $("#email").val();
		var subject = $("#subject").val();
		var message = $("#message").val();
		var msg = {};
        msg.firstname = firstname;
        msg.lastname = lastname;
        msg.phone = phone;
        msg.email = email;
        msg.subject = subject;
        msg.message = message;
		$.ajax({
			type:"POST",
			url:appServerUrl+"front/ajax/submit/message.action",
            contentType: 'application/json',
			data:JSON.stringify(msg),
			dataType:"json",
			success:function (result) {
				console.log(result);
				alert(result.resultInfo);
            },
			error:function () {
				alert("请求异常");
            }
        });
    };



	 var init = function () {
	 	$("#submitContact").on("click",submitContact)
     };

	
	$(function(){
		init();
	});
}());