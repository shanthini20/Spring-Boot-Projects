

fetch("http://localhost:7755/book/singlerow?patientid=" + CommonJS.GetQueryStringValue("patientid") + "").then((response) => {

	//console.log(data);
	return response.json();//converted to object

}).then((objectData) => {
	let tableData = "";
	objectData.map((values) => {
		document.getElementById("name").value = values.patientname
		document.getElementById("age").value = values.age
		document.querySelector('input[name="gender"][value="' + values.gender + '"]').checked = true;

		document.getElementById("phone").value = values.phoneno
		document.getElementById("address").value = values.address
		document.getElementById("enquiry").value = values.enquiry
		document.getElementById("appointment_date").value = values.appdate
		document.getElementById("appointment_time").value = values.apptime
		
		
		

	});

}).catch((err) => {

	console.log(err);
})





function approve() {
	var settings = {
		"url": "http://localhost:7755/book/approve?status=Approved&patientid=" + CommonJS.GetQueryStringValue("patientid") + "",
		"method": "PUT",
		"timeout": 0,
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		if (response == "updated") {
			alert("Approved");
		}
		else if (Comments == "") {
			alert("fill the Comments");
		}

	});
}


function cancel() {
	var settings = {
		"url": "http://localhost:7755/book/approve?status=Cancelled&patientid=" +CommonJS.GetQueryStringValue("patientid") + "",
		"method": "PUT",
		"timeout": 0,
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		if (response == "updated") {
			alert("Appointment Cancelled");
		}
		else if (Comments == "") {
			alert("fill the Comments");
		}

	});
}

