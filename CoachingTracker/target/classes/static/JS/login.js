function post() {

	const username = document.getElementById("usrname").value;
	const password = document.getElementById("pwd").value;

	console.log(username);
	console.log(password);

	const payload = {
		username,
		password

	};

	console.log(payload);

	var settings = {
		url: "http://localhost:4788/coaching/login",
		method: "POST",
		timeout: 0,
		headers: {
			"Content-Type": "application/json",
		},
		data: JSON.stringify(payload),
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		for (i = 0; i < response.length; i++) {
			if (response[2] == "Login Success") {
				location.href = "/tablescreen?roleid="+response[0]+"&userid="+response[1]+"";
			}
			/*else if (response[0] == 1) {
				agentData(userid);
			}
			
			else if (payload.username == "" && payload.password == "") {
				alert("Username and Password should not be empty")
			}
			else if (payload.username == "") {
				alert("Username should not be empty")
			}
			else if (payload.password == "") {
				alert("Password should not be empty")
			}
			else
				alert("Kindly verify your user id or password and try again.")
				*/
		}

	});
}













/*$(document).ready(function(){

var settings = {
"url": "http://localhost:4788/coaching/role",
"method": "GET",
"timeout": 0,
};

$.ajax(settings).done(function (response) {
  $.each(response,function(index,item)
  {
  $("#userd").append("<option>"+item +"</option>");
console.log(response);
});
});

});*/


