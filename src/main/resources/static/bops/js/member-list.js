// Call the dataTables jQuery plugin
$(document).ready(function() {
    var appServer = $("#appServer").val();

    $('#dataTable').DataTable(
        $.extend(true,HCC_CONSTANT.DATA_TABLES.DEFAULT_OPTION,{
            serverSide: false,//不开启服务端模式
            //绑定数据
            columns: [
                {
                    data: "id",//Id
                    orderable : false,
                    width:"10%"
                },
                {
                    data: "username",//用户名
                    orderable : false,
                    width:"30%"
                },
                {
                    data: "password",//密码
                    orderable : false,
                    width:"60%"
                }
            ]
        })
    );
});