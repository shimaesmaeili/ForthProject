$(document).ready(function() {
    $('#search').click(function(e) {
        e.preventDefault();
        $.ajax({
            url : '/get-real-customer',
            data : {
                customerId : $('#customerId').val()
            },
            success : function(responseText) {
                $('#firstName').val(responseText.customer.firstName);
                $('#lastName').val(responseText.customer.lastName);
                $('#customerInfo').show();

                $('#loansInfo').show();
                var $element = $("#loans");
                $element.empty(); // remove old options
                $element.append($("<option></option>")
                    .attr("value", '').text(''));
                $.each(responseText.loans, function(key, value) {
                    $element.append($("<option></option>")
                        .attr("value", value.id).text(value.name));
                });

                $('#userId').val(responseText.customer.id);
            }
        });
    });
});