

function Home1() {
	location.href = "/patienttable";
}

var docid;
var userid;

$(document).ready(function() {
	var settings = {
		"url": "http://localhost:7755/book/doctordetails",
		"method": "GET",
		"timeout": 0
	};

	$.ajax(settings).done(function(response) {
		$("#docname").append("<option value='' disabled selected>Select Doctor</option>");
		$.each(response, function(index, item) {
			$("#docname").append("<option docid=" + item.docid + " userid=" + item.userid + ">" + item.docname + "</option>");

		});

		$("#docname").on("click", function() {
			var selectedOption = $(this).find(':selected');
			docid = selectedOption.attr('docid');
			console.log(docid);
			city(docid);
			state(docid);
			area(docid);
			
			 userid = selectedOption.attr('userid');
             console.log(userid);
             
           

		});

	});

});


function newop(userid) {
	const patientname = document.getElementById("name").value;
	const age = document.getElementById("age").value;
	const gender = document.querySelector('input[name="gender"]:checked').value;
	const phoneno = document.getElementById("phone").value;
	const address = document.getElementById("address").value
	const enquiry = document.getElementById("enquiry").value;
	const appdate = document.getElementById("appointment_date").value;
	const doctorname = document.getElementById("docname").value;
	const apptime = document.getElementById("appointment_time").value;
	const doc_area = document.getElementById("area").value;
	const doc_state = document.getElementById("state").value;
	const doc_city = document.getElementById("city").value;
	const status = "pending";



	const payload = {

		patientname,
		age,
		gender,
		phoneno,
		address,
		enquiry,
		appdate,
		apptime,
		doctorname,
		doc_state,
		doc_city,
		doc_area,
		status

	};

	console.log(payload);

	var settings = {
		url: "http://localhost:7755/book/patientdata1?userid=" + userid + "",
		method: "POST",
		timeout: 0,
		headers: {
			"Content-Type": "application/json",
		},
		data: JSON.stringify(payload),
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		if (response == "save") {
			alert("Appointment Saved")
		}
		else {
			alert("The selected time booked")
		}


	});
}










function city(docid) {

	$(document).ready(function() {
		var settings = {
			"url": "http://localhost:7755/book/clinicdata?docid=" + docid + "",
			"method": "GET",
			"timeout": 0
		};

		$.ajax(settings).done(function(response) {
			$("#city").append("<option value='' disabled selected>Select City</option>");
			$.each(response, function(index, item) {
				$("#city").append("<option>" + item.city1 + "</option>")
				$("#city").append("<option>" + item.city2 + "</option>")
				$("#city").append("<option>" + item.city3 + "</option>")
				$("#city").append("<option>" + item.city4 + "</option>")
			});


		});

		document.getElementById("city").innerHTML = "";
	});
}



function state(docid) {

	$(document).ready(function() {
		var settings = {
			"url": "http://localhost:7755/book/clinicdata?docid=" + docid + "",
			"method": "GET",
			"timeout": 0
		};

		$.ajax(settings).done(function(response) {
			$("#state").append("<option value='' disabled selected>Select State</option>");
			$.each(response, function(index, item) {
				$("#state").append("<option>" + item.state1 + "</option>")
				$("#state").append("<option>" + item.state2 + "</option>")
				$("#state").append("<option>" + item.state3 + "</option>")

			});


		});

		document.getElementById("state").innerHTML = "";
	});
}




function area(docid) {

	$(document).ready(function() {
		var settings = {
			"url": "http://localhost:7755/book/clinicdata?docid=" + docid + "",
			"method": "GET",
			"timeout": 0
		};

		$.ajax(settings).done(function(response) {
			$("#area").append("<option value='' disabled selected>Select Area</option>");
			$.each(response, function(index, item) {
				$("#area").append("<option>" + item.area1 + "</option>")
				$("#area").append("<option>" + item.area2 + "</option>")
				$("#area").append("<option>" + item.area3 + "</option>")
				$("#area").append("<option>" + item.area4 + "</option>")
				$("#area").append("<option>" + item.area5 + "</option>")
				$("#area").append("<option>" + item.area11 + "</option>")
				$("#area").append("<option>" + item.area22 + "</option>")
				$("#area").append("<option>" + item.area33 + "</option>")
				$("#area").append("<option>" + item.area44 + "</option>")
				$("#area").append("<option>" + item.area55 + "</option>")
				$("#area").append("<option>" + item.area111 + "</option>")
				$("#area").append("<option>" + item.area222 + "</option>")
				$("#area").append("<option>" + item.area333 + "</option>")
				$("#area").append("<option>" + item.area444 + "</option>")
				$("#area").append("<option>" + item.area555 + "</option>")
				$("#area").append("<option>" + item.area1111 + "</option>")
				$("#area").append("<option>" + item.area2222 + "</option>")
				$("#area").append("<option>" + item.area3333 + "</option>")
				$("#area").append("<option>" + item.area4444 + "</option>")
				$("#area").append("<option>" + item.area5555 + "</option>")

			});


		});

		document.getElementById("area").innerHTML = "";
	});
}

