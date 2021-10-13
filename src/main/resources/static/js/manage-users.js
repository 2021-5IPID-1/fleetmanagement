$(document).ready( function () {
    var table = $('#manage-users').DataTable({
        "ajax": "/ws/admin/users",
        "processing": true,
        "serverSide": true,
        "pageLength": 10,
        "searching": false,
        "info" : true,
        "ordering": false,
        "rowId": "id",
        "columns": [
            { "data": "id"},
            { "data": "firstname" },
            { "data": "lastname" },
            { "data": "username" },
            { "data": "emailaddress" },
            { "data": "roles" }
        ]
    })

    $('#manage-users tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
            $("#update-user").attr('href', "#");
            $("#update-user").addClass('disabled');
            $("#delete-user").addClass('disabled');
            $("#delete-user").attr('disabled', 'disabled');
            $('#delete-user').removeAttr('data-id');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');

            var currentId = $(this).attr("id");
            var href = $("#update-user").attr("data-href");
            var newHref = href.replace("#id", currentId);

            $('#delete-user').attr('data-id', currentId);

            $("#update-user").attr('href', newHref);
            $("#update-user").removeClass('disabled');
            $("#delete-user").removeClass('disabled');
            $("#delete-user").removeAttr('disabled');
        }
    } );

    $("#delete-user").on('click', function(){
        var currentId = $(this).attr('data-id');
        $.ajax({
            url: '/ws/admin/users/' + currentId,
            type: 'DELETE',
            success: function(result) {
                console.log('success');
            }
        })
    })

});