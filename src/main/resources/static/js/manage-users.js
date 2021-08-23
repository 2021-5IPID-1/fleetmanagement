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
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');

            var currentId = $(this).attr("id");
            var href = $("#update-user").attr("data-href");
            var newHref = href.replace("#id", currentId);

            $("#update-user").attr('href', newHref);
        }
    } );

});