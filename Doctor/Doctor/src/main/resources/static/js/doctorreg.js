function newdoc() {
	const docname = document.getElementById("cname").value;
	const docage = document.getElementById("cage").value;
	const qualification = document.getElementById("qualification").value;
	const registerno = document.getElementById("reg").value;
	const docaddress = document.getElementById("caddress").value;
	const cliniccity = document.getElementById("ccity").value;
	const clinicstate = document.getElementById("cstate").value;
	const clinicarea = document.getElementById("carea").value;






	const payload = {

		docname,
		docage,
		qualification,
		registerno,
		docaddress,
		cliniccity,
		clinicstate,
		clinicarea,

	};

	console.log(payload);

	var settings = {
		url: "http://localhost:7755/book/doctordata",
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
