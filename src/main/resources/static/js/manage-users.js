$(document).ready( function () {
    var table = $('#manage-users').DataTable({
        "ajax": "/ws/admin/users",
        "processing": true,
        "serverSide": true,
        "pageLength": 10,
        "searching": false,
        "info" : true,
        "ordering": false,
        "columns": [
            { "data": "id"},
            { "data": "firstname" },
            { "data": "lastname" },
            { "data": "username" },
            { "data": "emailaddress" },
            { "data": "roles" }
        ]
    })
});