$(document).ready(function() {
    $('#f').on('change', function() { //Begin upload image 
        var file = this.files[0];
        clearDataImage();
        if (file.type.indexOf('image') !== -1) {
            $('#nameLogo').val(file.name);
            var reader = new FileReader();
            reader.onload = function(e) {
                var image = new Image();
                image.src = e.target.result;
                var width = 10, height = 100;
                image.onload = function() {
                    width = this.width;
                    height = this.height;
                    $('#imgheight').val(height);
                    $('#imgwidth').val(width);
                    $('<img width="' + width + '" height="' + height + '" id="imgUpload"/>').attr({'src': e.target.result}).appendTo($('#previewLogo'));
                    $('<a class="btn btn-default" id="btnRemove" onclick="if (!confirm(\'Eliminar imagen ' + file.name + '?\')) return false;clearDataImage();"><span class="fa fa-trash-o"></span></a>').appendTo($('#spDelete'));
                };
            };
            reader.readAsDataURL(file);
        } else {
            clearDataImage();
            $('<div class="alert alert-danger" role="alert">\n\
                <button type="button" class="close" data-dismiss="alert">\n\
                    <span aria-hidden="true">&times;</span></button>\n\
                <b>Solo imagenes,</b> intenta subir ' + file.type + '</div>').appendTo($('#previewLogo'));
        }
    }); //End upload image

    //Modify height img
    $('#imgheight').on('input', function() {
        $('#imgUpload').attr('height', $('#imgheight').val());
    });
    //Modify width img
    $('#imgwidth').on('input', function() {
        $('#imgUpload').attr('width', $('#imgwidth').val());
    });
});
function clearDataImage() { //Begin delete image
    $('#previewLogo').empty();
    $('#nameLogo').val('');
    $('#spDelete').empty();
    $('#imgheight').val('');
    $('#imgwidth').val('');
//    $('#fileLogo').val('');
}//End delete image


var error = '<span class="col-lg-8 col-lg-offset-3"><div class="alert alert-danger alert-dismissible" role="alert"> <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button> <strong>Aviso!</strong> Ocurrio un error, vuelve a intentarlo.</div></span>';
var deleted = '<span class="col-lg-8 col-lg-offset-3"><div class="alert alert-danger alert-dismissible" role="alert"> <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button> <strong>Aviso!</strong> Elemento eliminado.</div></span>';
var success = '<span class="col-lg-8 col-lg-offset-3"><div class="alert alert-success alert-dismissible" role="alert"> <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button> <strong>Aviso!</strong> Datos guardados.</div></span>';
var newVersion = '<span id="newVersionAlert" class="col-lg-8 col-lg-offset-3"><div class="alert alert-success alert-dismissible" role="alert"> <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button> <strong>Aviso!</strong> Version publicada.</div></span>';
var guardando = '<span class="col-lg-8 col-lg-offset-3"><h3><span class="fa fa-gear fa-spin"></span> Guardando...</h3></span>';
var winVar;
var updateTitle;
var deletedElemt;
//post html jquery
function postHtmlDoc(url, tagid) {
    //console.log('the url : ' + url);
    var text = '<h3><span class="fa fa-gear fa-spin"></span> Cargando...</h3>';
    $.ajax({
        url: url,
        type: 'POST',
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        beforeSend: function() {
            $('#' + tagid).html(text);
        },
        success: function(data, event) {
            //console.log('data : ' + data);
            $('#' + tagid).html(data);
        },
        error: function(e) {
            $('#' + tagid).html(error);
        }
    });
}
function documenterPost(url, tagid, idelement) {
    var text = '<h3><span class="fa fa-gear fa-spin"></span> Ejecutando...</h3>';
    $.ajax({
        url: url,
        type: 'POST',
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        beforeSend: function() {
            $('#' + tagid).html(text);
        },
        success: function(data, event) {
            $('#' + tagid).html(deleted);
            $('#' + idelement).remove();
            window.clearTimeout(deletedElemt);
            deletedElemt = window.setTimeout(function() {
                $('#' + tagid).empty();
            }, 1000);

            window.clearTimeout(winVar);
            winVar = window.setTimeout(function() {
                location.hash = '#';
            }, 1000);
        },
        error: function(e) {
            $('#' + tagid).html(error);
        }
    });
}

//Guarda cambios en plantilla de documentación
function submitForm(formid, tagid, tagmodal) {
    var cont = validateInputsForm(formid);
//    console.log('the cont on submitForm : ' + cont);
    if (cont === 0) {
        $.ajax({
            url: $('#' + formid).attr('action'),
            cache: false,
            data: $('#' + formid).serialize(),
            type: 'POST',
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend: function() {
                $('#' + tagid).html(guardando);
            },
            success: function(data) {
                if (tagmodal !== '') {
                    $('#' + tagmodal).modal('hide');
                }
                $('#container').empty();
                $('#container').append(data);
            },
            error: function(e) {
                $('#' + tagid).html(error);
            }
        });
    }
}//Guarda cambios en plantilla de documentación
function submitUrl(url, tagid) {
    $.ajax({
        url: url,
        cache: false,
        type: 'POST',
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        beforeSend: function() {
        },
        success: function(data) {
            $('#' + tagid).html(data);
        },
        error: function(e) {
        }
    });
}
//Guardar o editar sección de documentación
function submitFormSection(formid, tagid, tagmodal, btnid) {
    var cont = validateInputsForm(formid);
    if (cont === 0) {
        $.ajax({
            url: $('#' + formid).attr('action'),
            cache: false,
            data: $('#' + formid).serialize(),
            type: 'POST',
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend: function() {
                $('#'+ btnid).toggleClass('disabled');
                $('#' + tagid).html(guardando);
            },
            success: function(data) {
                $('#' + tagmodal).empty();
                $('#' + tagmodal).append(data);
//                $('#'+tagmodal).modal('hide');
            },
            error: function(e) {
                $('#' + tagid).html(error);
            }
        });
    }
}

function deleteDocumentSection(url, tagid) {
    var text = '<h3><span class="fa fa-gear fa-spin"></span> Ejecutando...</h3>';
    $.ajax({
        url: url,
        type: 'POST',
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        beforeSend: function() {
//            console.log('ejecutando ...' + tagid);
            $('#' + tagid).html(text);
        },
        success: function(data, event) {
//            console.log('eliminado...' + tagid);
            $('#' + tagid).html(deleted);
            $('#' + tagid).remove();
        },
        error: function(e) {
//            console.log('error en eliminar...');
            $('#' + tagid).html(error);
        }
    });
}
function validateInputsForm(formid) {
    var $inputs = $('#' + formid + ' :input');
    var cont = 0;
    $inputs.each(function() {
        if (this.required) {
            var diverror = $('#div' + this.id);
            var sph = $('#sph' + this.id);
//            console.log('id : ' + this.id);
            //console.log('value is checked : ' + $(this).is(':checked'));
            if ($(this).val().length === 0) {
                diverror.addClass('has-error');
                sph.empty();
                sph.append('Dato obligatorio');
                cont++;
            } else {
                sph.empty();
                diverror.removeClass('has-error');
            }
        }
    });
    return  cont;
}

function showAlert(tagid) {
    $('#' + tagid).show(800).html(success);
    closeAlert(tagid);
}
function closeAlert(tagid) {
    window.clearTimeout(winVar);
    winVar = window.setTimeout(function() {
        $('#' + tagid).hide(800);
    }, 1800);
}

function appendChildHtml(tagidparent, prefixtag, tagidchild, htmlelement, clsactive) {
    if ($('#' + prefixtag + tagidchild).length) {
        $('#' + prefixtag + tagidchild).empty();
        var tr = $('#' + prefixtag + tagidchild);
        tr.addClass(clsactive);
        tr.append(htmlelement);
    } else {
        $('#' + tagidparent).append('<tr class="' + clsactive + '" id="' + prefixtag + tagidchild + '">' + htmlelement + '</tr>');
    }

}


function appendTemplate(element, uridt, url, title) {
    var child = '<a id="litc' + uridt + '" href="#' + uridt + '" class="list-group-item" onclick="postHtmlDoc(\'' + url + '\', \'container\');"><i class="fa fa-file fa-fw"></i> ' + title + '</a>';
    $('#' + element).append(child);
}
function updateTitleTemplate(title, element) {
//    var child = ' <b><i class="fa fa-refresh fa-spin fa-fw"></i>' + title + '</a></b>';
    var child = ' <b><i class="fa fa-refresh fa-spin fa-fw"></i> Actualizando...</a></b>';
    $('#litc' + element).empty();
    $('#litc' + element).append(child);
    window.clearTimeout(updateTitle);
    updateTitle = window.setTimeout(function() {
        child = '<i class="fa fa-file fa-fw"></i> ' + title + '</a>';
        $('#litc' + element).empty();
        $('#litc' + element).append(child);
    }, 1000);
}
function clearElement(element) {
    $('#' + element).empty();
}

function showWaitDialog(title, loadmsg, idmodal) {
    var msg = "Loading, please wait...";
    if (loadmsg && loadmsg !== "")
        msg = loadmsg;

    $("#" + idmodal).html('<div class="modal-dialog"><div class="modal-content"><div class="modal-header">\n\
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">' + title
            + '</h4></div><div class="modal-body"><div id="modal-content" class="text-center"><span class="fa fa-cog fa-lg fa-spin">\n\
        </span> ' + msg + '</div></div></div></div>');

    $("#" + idmodal).modal('show');
}

function showModal(url, title, loadmsg, errormsg, idmodal) {//modalDialog
    var emsg = "Sorry, there was an error processing the request...";
    if (errormsg && errormsg !== "")
        emsg = errormsg;

    showWaitDialog(title, loadmsg, idmodal);
//    console.log('idmodal : ' + idmodal);
    var jqxhr = $.get(url, function(data) {
        $("#" + idmodal).html(data);
    })
            .fail(function() {
                $("#" + idmodal).find("#modal-content").html(" " + emsg);
            });
}


/*         ------------------ Section Element ----------------------*/
function saveSE(formid, tagid, modal, hideAlert) {
    var cont = validateInputsForm(formid);
    var hide = hideAlert || false;
//    console.log('cont : ' + cont);
    if (cont === 0) {
        $("#" + formid).submit(function(e) {
            var formObj = $(this);
            var formURL = formObj.attr("action");
            var formData = new FormData(this);
            $.ajax({
                url: formURL,
                type: 'POST',
                data: formData,
                mimeType: "multipart/form-data",
                contentType: false,
                cache: false,
                processData: false,
                success: function(data) {
                    $('#' + modal).modal('hide');
                    $('#' + tagid).empty();
                    if (!hide) {
                        $('#' + tagid).append(newVersion);
                    }
                    $('#' + tagid).append(data);
                    winVar = window.setTimeout(function() {
                    $('#newVersionAlert').remove();
                    }, 1500);
//                    console.log('the uridoc response : ' + data);
                },
                error: function(error) {
//                    console.log('error : ' + error);
                }
            });
            e.preventDefault(); //Prevent Default action.
        });
        $("#" + formid).submit(); //Submit the form
    }
}
function saveRelated(formid, tagid, modal, msg1, msg2) {
    var msg = '<div role="alert" class="alert alert-danger alert-dismissible fade in"> <button data-dismiss="alert" class="close" type="button"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button><strong>' + msg1 + '!</strong> ' + msg2 + '</div>';
    var cont = 0;
    var $inputs = $('#' + formid + ' :input');
    $inputs.each(function() {
        if (this.required) {
            if ($(this).is(':checked')) {
                cont++;
//                console.log('seleccionar alguna opción....');
            } else {
//                console.log('ok.......');
            }
        }
    });
//    console.log('cont : ' + cont);
    if (cont > 0) {
        $.ajax({
            url: $('#' + formid).attr('action'),
            cache: false,
            data: $('#' + formid).serialize(),
            type: 'POST',
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend: function() {
                //$('#' + tagid).html(guardando);
            },
            success: function(data) {
                $('#' + modal).modal('hide');
                $('#modalDialog').modal('hide');
                $('#' + tagid).empty();
                $('#' + tagid).append(data);
            },
            error: function(e) {
                $('#' + tagid).html(error);
            }
        });
    } else {
        $('#divrelated').empty();
        $('#divrelated').append(msg);
    }
}


function saveText(url, data, urise, tagid, trid) {
    $.ajax({
        url: url,
        cache: false,
        data: {data: data, urise: urise},
        type: 'POST',
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        beforeSend: function() {
            $('#' + tagid).html(guardando);
        },
        success: function(data) {
//            $('#modalDialog').modal('hide');
//            console.log('tag id to update : ' + tagid);
            $('#modalDialog').modal('hide');
            $('#' + trid).empty();
            $('#' + trid).append(data);

            $('#' + tagid).empty();
            $('#' + tagid).append(success);
            window.clearTimeout(winVar);
            winVar = window.setTimeout(function() {
                $('#' + tagid).empty();
            }, 1500);
        },
        error: function(e) {
            $('#' + tagid).html(error);
        }
    });
}

function toggleShow(elementId, idinput, show) {
    var el = document.getElementById(elementId);
    var el1 = document.getElementById(idinput);
    if (el !== null) {
        if (show) {
            $(el1).attr('required', 'true');
            el.style.display = "block";

        } else {
            $(el1).removeAttr("required");
            el.style.display = "none";
        }
    }
}
function updateColorFill(color, id, surifill, url) {
    var btnColorFill = $('#btnColorFill' + id);
    if (color !== 'defaultFill') {
        btnColorFill.attr('style', 'color: #' + color + ';');
        btnColorFill.removeClass("fa-ban");
        btnColorFill.addClass("fa-square");
    } else {
        btnColorFill.attr('style', 'color: #333;');
        btnColorFill.removeClass("fa-square");
        btnColorFill.addClass("fa-ban");
    }
    var params = {
        "fill": color,
        "urise": surifill
    };
    $.ajax({
        data: params,
        url: url,
        type: 'POST',
        beforeSend: function() {
            //console.log('procesando......');
        },
        success: function(response) {
            //console.log('se ejecutó');
        }
    });
}

function renderURL(url){
//    console.log('on url : ' + url);
    window.location = url;
}