function doMenu(id, action) {
    if (action === "select") {
        select(id);
    } else if (action === "edit") {
        edit(id);
    }
}

function select(id) {
    $.ajax({
        type: "get",
        url: "/battalion/findMenu",
        dataType: 'json',
        async: false,
        data: {
            id: id
        },
        success: function (result) {
            if (result.code === 200) {
                data = result.data;
                $("#menuName").val(data.menuName);
                $("#menuParent").val(data.menuCenter.centerName);
                $("#menuDescription").val(data.menuDescription);
                $("#menuOrder").val(data.menuOrder);
            }
        }
    })
}

function edit(id) {
    $.ajax({
        type: "get",
        url: "/battalion/editMenu",
        dataType: 'json',
        async: false,
        data: {
            id: id
        },
        success: function (result) {
            if (result.code === 200) {
                data = result.data;
                $("#menuId-edit").val(data.menu.menuId);
                $("#menuName-edit").val(data.menu.menuName);
                $("#menuOrder-edit").val(data.menu.menuOrder);
                //$("#menuParent-edit").val(data.menuCenter.centerName);
                $("#selectMenu").empty();
                $("#selectMenu").val()
                for (var i in data.menuCenter) {
                    if (data.menuCenter[i].centerId === data.menu.menuOrder) {
                        $("#selectMenu").append(
                            /* $("#selectMenu").val(data.menuCenter[i].centerName)*/
                            '<option value =' + data.menuCenter[i].centerId + '>' + data.menuCenter[i].centerName + '</option>'
                        )
                    } else {
                        $("#selectMenu").append(
                            '<option value =' + data.menuCenter[i].centerId + '>' + data.menuCenter[i].centerName + '</option>'
                        )
                    }

                }
                $("#menuDescription-edit").val(data.menu.menuDescription)
            }
        }
    })
}

function save() {
    $.ajax({
        type: "post",
        url: "/battalion/saveMenu",
        dataType: 'json',
        async: true,
        data: {
            menuId: $("#menuId-edit").val(),
            menuName: $("#menuName-edit").val(),
            menuOrder: $("#menuOrder-edit").val(),
            menuCenter: $('#selectMenu option:selected').val(),
            menuDescription: $("#menuDescription-edit").val()
        },
        success: function (result) {
            if (result.code === 200) {
                layer.msg('保存成功');
                window.location.reload();
            }
        }
    })
}

function editRole(roleId) {
    $.ajax({
        type: "post",
        url: "/battalion/editRole",
        dataType: 'json',
        async: true,
        data: {
            id: roleId
        },
        success: function (result) {
            if (result.code === 200) {
                data = result.data;
                $("#roleName-edit").val(data.roleName);
                $("#roleDescription-edit").val(data.roleDescription);
                $("#roleId").val(data.roleId);
            }
        }
    })

}

function saveRole() {
    $.ajax({
        type: "post",
        url: "/battalion/saveRole",
        dataType: 'json',
        async: true,
        data: {
            roleId: $("#roleId").val(),
            roleName: $("#roleName-edit").val(),
            roleDescription: $("#roleDescription-edit").val()
        },
        success: function (result) {
            if (result.code === 200) {
                layer.msg('保存成功');
                window.location.reload();
            }
        }
    })
}

function editJob(jobId) {
    $.ajax({
        type: "post",
        url: "/battalion/editJob",
        dataType: 'json',
        async: true,
        data: {
            id: jobId
        },
        success: function (result) {
            if (result.code === 200) {
                data = result.data;
                $("#jobId-edit").val(data.jobId);
                $("#jobName-edit").val(data.jobName);
                $("#jobDescription-edit").val(data.jobDescription);
            }
        }
    })
}

