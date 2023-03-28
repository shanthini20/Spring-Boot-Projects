function post() {

	const shiftdate = document.getElementById("sdate").value;
	const supervisorname = document.getElementById("sname").value;
	const reason = document.getElementById("reason").value;
	const hour = document.getElementById("hour").value;
	const agent_name = document.getElementById("agentname").value;
	const notes = document.getElementById("notes").value;
	const minute = document.getElementById("minute").value;
	const status="pending";
	console.log(shiftdate);
	console.log(supervisorname);
	console.log(reason);
	console.log(hour);
	console.log(agent_name);
	console.log(notes);
	console.log(minute);
	console.log(status);
	const payload = {
		shiftdate,
		supervisorname,
		reason,
		hour,
		agent_name,
		notes,
		minute,
		status
	};
	validation(payload);

	console.log(payload);
	
}

function validation(payload){
		if (payload.hour=="" || payload.supervisorname==""||payload.notes==""|| payload.reason=="" || payload.shiftdate=="" || payload.minute=="" || payload.agent_name == "") {
			alert("Fill the Missing field")
			
		}
		else{
			var settings = {
		url: "http://localhost:4788/coaching/entrydateinsert",
		method: "POST",
		timeout: 0,
		headers: {
			"Content-Type": "application/json",
		},
		data: JSON.stringify(payload),
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		if (response.entryid == 0) {
			alert("Save Successfully")
			location.href = "/tablescreen";
		}
		 
	});
		}
	}
	
	
	
	function close()
	{
		history.back();
	}
	
	
	
	
$(document).ready(function(){

  var settings = {
  "url": "http://localhost:4788/coaching/agentname",
  "method": "GET",
  "timeout": 0,
};

$.ajax(settings).done(function (response) {
	$.each(response,function(index,item)
	{
	$("#agentname").append("<option>"+item +"</option>");
  console.log(response);
});
});

});
  
