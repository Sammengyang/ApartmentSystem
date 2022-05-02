var totalRecord; // 总记录数
$(function (){

    // 分页获取房屋信息
    to_page(1); // 页面加载完成发送请求获取


});
// 获取第几页的数据
function to_page(page){
    $.ajax({
        url:"/houses",
        data:"page="+page,
        type:"get",
        success:function (result){
            // 1.解析房屋信息数据
            build_house(result.extend.pageInfo.list);
            // 2.解析分页信息
            build_page_info(result);
            // 3. 解析导航条
            build_page_nav(result);
        }
    });
}

// 解析房屋信息
function build_house(list){
     // 清空数据
    $("#houseInfo").empty();
    // 获取json数据
    var houses = list;
    $.each(houses,function (index,item){
        var housediv = $("<div></div>").addClass("house_one").appendTo($("#houseInfo"));
        // 解析图片
        var houseimg = $("<div></div>").addClass("col-md-2 house_img")
        if (item.himage=="" || item.himage==null){
            houseimg.append($("<img>").attr("src","\\static\\image\\default.png").addClass("imgs").css("width","100%").attr("id","img"+item.hid));
        }else {
            houseimg.append($("<img>").attr("src","\\photo\\"+item.himage).addClass("imgs").css("width","100%").attr("id","img"+item.hid));
        }
        housediv.append(houseimg);
        // $("<img>").attr("src","").addClass("img-rounded").appendTo(houseimg);
        // // 解析信息
        var houseInfo = $("<div></div>").addClass("col-md-6 house_info");
        housediv.append(houseInfo);
        var districtdiv = $("<div></div>").text(item.hdistrict+"   "+item.hdir).addClass("house_name")
            .append($("<button style='float: right'></button>").addClass("btn btn-info house_edit_btn").append("修改房源信息").attr("houseId",item.hid));
        var allAddress = $("<div></div>").text(item.hfulladdress).addClass("house_address");
        var hfurniture = item.hfurniture=="无"?"简装":"精装";
        var hdir = item.hdir=="南"?"南  北":"东  西";
        var info = $("<div></div>")
            .text(item.harea+' | '
                +hdir+' | '
                +hfurniture+' | '
                +item.hfloor).addClass("house_con");
        var rentstatus = item.hrentstatus=="0"?"已出租":(item.hrentstatus=="1"?"招租":"暂停出租");
        var rent = $("<div></div>")
            .append($("<span></span>").append(rentstatus))
            .addClass("house_rent")
            .append($("<span></span>").append(item.hprice+"/ 月").addClass("house_price"));
        houseInfo.append(districtdiv).append(allAddress).append(info).append(rent);


    });
}
// 解析分页信息
function build_page_info(result){
    // 清除数据
    $("#page_info").empty();
    $("#page_info").append(
        "当前第 "+result.extend.pageInfo.pageNum
        +" 页"+" 总共 "+result.extend.pageInfo.pages+" 页"
        +" 共计 "+result.extend.pageInfo.total+" 条")
    totalRecord = result.extend.pageInfo.total;
}
// 解析导航条
function build_page_nav(result){
    // 清空数据
    $("#page_nav").empty();
    // ul
    var ulTag = $("<ul></ul>").addClass("pagination pagination-lg");
    // 首页上\一页
    var firstLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
    var preLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
    ulTag.append(firstLi).append(preLi);
    // 数字导航
    $.each(result.extend.pageInfo.navigatepageNums,function (index,item){
       var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
       if (result.extend.pageInfo.pageNum==item){
           numLi.addClass("active")// 当前页码高亮
       }
        numLi.click(function (){ //点击去那一页
            to_page(item);
        });
       ulTag.append(numLi);
    });
    // 下一页、尾页
    var nextLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
    var endLi = $("<li></li>").append($("<a></a>").append("尾页").attr("href","#"));
    ulTag.append(nextLi).append(endLi);
    ulTag.appendTo($("#page_nav"));

    // 添加翻页时间
    firstLi.click(function (){
       to_page(1);
    });
    endLi.click(function (){
        to_page(totalRecord);
    });
    preLi.click(function (){
        to_page(result.extend.pageInfo.pageNum-1)
    });
    nextLi.click(function (){
        to_page(result.extend.pageInfo.pageNum+1)
    });
}
// 添加房源
$("#house_add_modal_btn").click(function (){
    // 清除表单数据
    $("#house_add_modal form")[0].reset();
    // 展示模态框
    $("#house_add_modal").modal({
        backdrop:"static"
    });
});
// 提交添加
$("#house_add_btn").click(function (){
    var fromdata = new FormData();
    // 添加选取的文件
    fromdata.append("file",$("#house_image")[0].files[0]);
    alert(fromdata.get("file").size);
    // 把form表单序列化  转化为json key值为 equipmentTypeForm
    fromdata.append('house',JSON.stringify($('#add_house_form').serialize()));
    // 检测表格数据
    check_add_form();
    if ($("#house_add_btn").attr("check_btn")=="success"){
        // 提交表单数据
        $.ajax({
            url:"/house",
            type: "POST",
            data:fromdata,
            dataType:"json",
            cache:false,
            async:false,
            processData: false,
            contentType: false,// 必须添加
            success:function (result){
                if (result.code==100){
                    // 关闭模态框
                    $("#house_add_modal").modal("hide");
                    // 跳转到首页
                    to_page(1);
                }else{
                    alert("添加异常");
                }
            }
        });
    }
});
var check_count;
// 检测表单数据
function check_add_form(){
    check_count=0;
    var haddress = $("#haddress_add_input").val();
    haddress==""?show_input("#haddress_add_input","error"):show_input("#haddress_add_input","success");
    var hdistrict = $("#hdistrict_add_input").val();
    hdistrict==""?show_input("#hdistrict_add_input","error"):show_input("#hdistrict_add_input","success");
    var hon = $("#hon_add_input").val();
    hon==""?show_input("#hon_add_input","error"):show_input("#hon_add_input","success");
    var hroomNum = $("#hroomNum_add_input").val();
    hroomNum==""?show_input("#hroomNum_add_input","error"):show_input("#hroomNum_add_input","success");
    var harea = $("#harea_add_input").val();
    harea==""?show_input("#harea_add_input","error"):show_input("#harea_add_input","success");
    var hdir = $("#hdir_add_input").val();
    hdir==""?show_input("#hdir_add_input","error"):show_input("#hdir_add_input","success");
    var hfurniture = $("#hfurniture_add_input").val();
    hfurniture==""?show_input("#hfurniture_add_input","error"):show_input("#hfurniture_add_input","success");
    var hdeco = $("#hdeco_add_sclect").val();
    hdeco==""?show_input("#hdeco_add_sclect","error"):show_input("#hdeco_add_sclect","success");
    var hair = $("#hair_add_input").val();
    hair==""?show_input("#hair_add_input","error"):show_input("#hair_add_input","success");
    var hprice = $("#hprice_add_input").val();
    hprice==""?show_input("#hprice_add_input","error"):show_input("#hprice_add_input","success");
    var hrentStatus = $("#hrentStatus_add_input").val();
    hrentStatus==""?show_input("#hrentStatus_add_input","error"):show_input("#hrentStatus_add_input","success");
    var hfullAddress = $("#hfullAddress_add_input").val();
    hfullAddress==""?show_input("#hfullAddress_add_input","error"):show_input("#hfullAddress_add_input","success");
    if (check_count==12){
        $("#house_add_btn").attr("check_btn","success");
        var photo = document.getElementById("house_image").files[0];
        var photo = $("#house_image")[0].files[0];
        if (typeof (photo)=="undefined" ){//|| photo.size()<=0
            alert("请选上传图片");
            $("#house_add_btn").attr("check_btn","error");
        }else {
            $("#house_add_btn").attr("check_btn","success");
        }
    }else{
        $("#house_add_btn").attr("check_btn","error");
    }
}
// 根据检测结果改变输入框效果
function show_input(ele,status){
    // 清除当前元素状态
    $(ele).parent().remove("has-success has-error");
    if (status=="success"){
        check_count+=1;
        $(ele).parent().addClass("has-success");
    }else {
        $(ele).parent().addClass("has-error");
    }
}
// 修改房源信息
// 修改房源信息
$(document).on("click",".house_edit_btn",function (){
    // 发送ajax请求
    // 展示模态框
    $("#house_edit_modal").modal({
        backdrop:"static"
    });
    var hid = $(this).attr("houseid");
    $("#house_edit_btn").attr("houseid",hid);
    // 获取当前房源信息复现在模态框中
    $.ajax({
        url:"/house/"+hid,
        type:"get",
        success:function (result){
            if (result.code==100){
                // 清空form表但数据
                $("#edit_house_form input").empty();
                // 将房源信息复现在模态框
                show_houseInfo_modal(result);
            }
        }
    })
});
// 将房源信息复现在模态框
function show_houseInfo_modal(result){
    var house = result.extend.house;
    $("#haddress_edit_input").val(house.haddress);
    $("#hdistrict_edit_input").val(house.hdistrict);
    $("#hon_edit_input").val(house.hno);
    $("#hroomNum_edit_input").val(house.hroomnum);
    $("#harea_edit_input").val(house.harea);
    $("#hdir_edit_input").val(house.hdir);
    $("#hfurniture_edit_input").val(house.hfurniture);
    $("#hdeco_edit_sclect").val([house.hdeco]);
    $("#hair_edit_input").val([house.hair]);
    $("#hprice_edit_input").val(house.hprice);
    $("#hrentStatus_edit_input").val([house.hrentstatus]);
    $("#hfullAddress_edit_input").val(house.hfulladdress);
    if (house.himage=="" || house.himage ==null){
        $("#edit_image").attr("src","\\static\\image\\default.png");
    }else{
        $("#edit_image").attr("src","\\photo\\"+house.himage);
    }
}
// 保存修改
$("#house_edit_btn").click(function (){
    var data = new FormData();
    // 添加选取的文件
    alert($("#house_edit_img").attr("name"));
    data.append("file",$("#house_edit_img")[0].files[0]);
    alert(data.get("file").size);
    // 把form表单序列化  转化为json数据
    data.append("house",JSON.stringify($("#edit_house_form").serialize()));
    // 发送 put请求
    var hid = $(this).attr("houseid");
    // 发送ajax请求更新house信息
    $.ajax({
        url:"/house/"+hid,
        type:"POST",
        data:data,
        cache: false,
        async:false,
        processData: false,
        contentType: false,
        success:function (result){
            // 关闭模态框
            $("#house_edit_modal").modal("hide");
            if (result.code==100){
                var ele = "#img"+hid;
                $(ele).attr("src","\\photo\\"+result.extend.house.himage);
            }else {
                alert(result.msg);
            }
        }
    });
});
// 搜索
$("#serch_btn").click(function (){
    // 序列化form表单数据
    var serch = $("#serch_house").serialize();
    // 发送ajax请求
    $.ajax({
        url:"/house",
        type:"get",
        data:serch,
        success:function (result){
            // 解析房源信息
            build_house(result.extend.houses);
        }

    });
});





