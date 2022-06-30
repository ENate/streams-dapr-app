function updateMultiply() {
$.ajax({
    url: "http://localhost:8080/multiplications/random"
}).then(function(data) {
    // cleans the form
    $("#attept-form").find(" input[name='result-attempt']" )
    .val(" ");
    $("#attept-form").find(" input[name='result-alias']" )
    .val(" ");
    // Gets a randomm challenge from API and loads data
    $('.multiply-a').empty().append(data.factorA);
    $('.multiply-b').empty().append(data.factorB);
});
}
$(document).ready(function() {
    updateMultiply();
    $("#attempt-form").submit(function( event ) {
        // Do not submit the form normally
        event.preventDefault();

        // Get some vales from elements on the page
        var a = $('.multiply-a').text();
        var b = $('.multiply-b').text();
        var $form = $( this ),
            attempt = $form.find( " input[name='result-attempt']").val(),
            userAlias = $form.find( " input[name='user-alias']").val();
    var data = { user: { alias: userAlias}, multiply: 
    {factorA: a, factorB: b}, resultAttempt: attempt};

    // Send the data using post
    $.ajax({
        url: '/results',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(result) {
            if (result.correct) {
                $('.result-message').empty().append("The result is correct! Congratula");
            }
            else {
                $('.result-message').empty().append("The result is correct! Congratula");
            }

        }
    });
    updateMultiply();
    });
});