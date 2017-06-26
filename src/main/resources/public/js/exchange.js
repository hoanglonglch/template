$(document).ready(function() {
	var url = window.location.href;
	let urlExchange = "http://localhost:8080/exchangeApi";
	let username = $("#username").val();
	 $.ajax({
         type: "GET"
         , url: urlExchange
         , data: {
             username: username
         }
         , success: function (data) {
        	 console.log(data);
         }
     });
});