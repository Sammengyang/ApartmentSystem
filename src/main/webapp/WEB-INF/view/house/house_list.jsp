<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/4/28
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="icon" href="/static/image/favicon.ico">
    <script rel="stylesheet" src="/static/js/jquery-3.6.0.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/static/bootstrap3.4.1/css/bootstrap.min.css" crossorigin="anonymous">
    <link href="/static/bootstrap3.4.1/css/bootstrap-theme.min.css">
    <script src="/static/bootstrap3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div id="menu">
        <ol class="breadcrumb" style="font-size: 20px">
            <li><a href="#">默认排序</a></li>
            <li><a href="#">最新发布</a></li>
            <li><a href="#">房屋价格</a></li>
            <li><a href="#">房屋面积</a></li>
<%--            <button type="button" id="house_edit_modal_btn" class="btn btn-info" style="float: right"></button>--%>
            <button type="button" id="house_add_modal_btn" class="btn btn-info" style="float: right;margin-right: 20px">添加房源</button>
            <div class="col-lg-3">
                <div class="input-group">
                    <form id="serch_house">
                        <input type="text" class="form-control" placeholder="Search for...">
                    </form>
                    <span class="input-group-btn">
                        <button class="btn btn-default" id="serch_btn" type="button">搜索</button>
                    </span>
                </div>
            </div>
        </ol>
    </div>
    <div id="serch_count">

    </div>
    <div class="row" id="houseInfo">
<%--        <div class="house_one">--%>
<%--            <div class="col-md-2 house_img">--%>
<%--                <img src="" alt="" class="img-rounded">--%>
<%--                图片--%>
<%--            </div>--%>
<%--            <div class="col-md-6 house_info">--%>
<%--                信息--%>
<%--            </div>--%>
<%--        </div>--%>

    </div>
    <div class="row">
<%--        分页信息--%>
        <div class="col-md-6" id="page_info">

        </div>
<%--    导航条--%>
        <div class="col-md-6" id="page_nav">
<%--            <ul class="pagination pagination-lg">--%>
<%--                <li>--%>
<%--                    <a href="#" aria-label="Previous">--%>
<%--                        <span aria-hidden="true">&laquo;</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li><a href="#">1</a></li>--%>
<%--                <li><a href="#">2</a></li>--%>
<%--                <li><a href="#">3</a></li>--%>
<%--                <li><a href="#">4</a></li>--%>
<%--                <li><a href="#">5</a></li>--%>
<%--                <li>--%>
<%--                    <a href="#" aria-label="Next">--%>
<%--                        <span aria-hidden="true">&raquo;</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--            </ul>--%>
        </div>
    </div>


<%-- 添加房源--%>
    <div  id="house_add_modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">房源添加</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="add_house_form" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">地区</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="haddress_add_input" name="haddress"  placeholder="填写地区">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">小区名字</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hdistrict_add_input" name="hdistrict" placeholder="小区名字">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">单元号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hon_add_input" name="hno" placeholder="单元号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">房间号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hroomNum_add_input" name="hroomnum" placeholder="房间号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">面积（平米）</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="harea_add_input" name="harea" placeholder="面积">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">朝向</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hdir_add_input" name="hdir" placeholder="朝向">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">配套设施</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hfurniture_add_input" name="hfurniture" placeholder="配套设施">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">装修</label>
                            <div class="col-sm-4">
                                <select class="form-control" name="hdeco" id="hdeco_add_sclect">
                                    <option value="1">精装</option>
                                    <option value="2">简装</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">是否双气</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="hair" id="hair_add_input">
                                    <option value="2">是</option>
                                    <option value="1">否</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">出租价格(元/月)</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hprice_add_input" name="hprice">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">出租状态</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="hrentstatus" id="hrentStatus_add_input">
                                    <option value="0">已出租</option>
                                    <option value="1">待出租</option>
                                    <option value="2">停止出租</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">完整地址信息</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hfullAddress_add_input" name="hfulladdress">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">房屋图片</label>
                            <div class="col-sm-10">
                                <input type="file" name="image" id="house_image">
                            </div>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="house_add_btn">Save</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%-- 编辑房源--%>
    <div class="modal fade" id="house_edit_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="editModal">修改信息</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="edit_house_form" method="post">
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">地区</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="haddress_edit_input" name="haddress"  placeholder="填写地区">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">小区名字</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hdistrict_edit_input" name="hdistrict" placeholder="小区名字">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">单元号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hon_edit_input" name="hno" placeholder="单元号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">房间号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hroomNum_edit_input" name="hroomnum" placeholder="房间号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">面积（平米）</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="harea_edit_input" name="harea" placeholder="面积">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">朝向</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hdir_edit_input" name="hdir" placeholder="朝向">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">配套设施</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hfurniture_edit_input" name="hfurniture" placeholder="配套设施">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">装修</label>
                            <div class="col-sm-4">
                                <select class="form-control" name="hdeco" id="hdeco_edit_sclect">
                                    <option value="1">精装</option>
                                    <option value="2">简装</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">是否双气</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="hair" id="hair_edit_input">
                                    <option value="2">是</option>
                                    <option value="1">否</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">出租价格(元/月)</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hprice_edit_input" name="hprice">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">出租状态</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="hrentstatus" id="hrentStatus_edit_input">
                                    <option value="0">已出租</option>
                                    <option value="1">待出租</option>
                                    <option value="2">停止出租</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">完整地址信息</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="hfullAddress_edit_input" name="hfulladdress">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">房屋图片</label>
                            <div class="col-sm-10">
                                <img src="">
                                <input type="file" name="himage" placeholder="">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="house_edit_btn">Update</button>
                </div>
            </div>
        </div>
    </div>
</body>
    <script src="/static/js/house.js"></script>
    <link rel="stylesheet" href="/static/css/house.css">
</html>
