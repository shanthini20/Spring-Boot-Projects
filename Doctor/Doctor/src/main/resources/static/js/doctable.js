const queryParams = new URLSearchParams(window.location.search);
const userid = queryParams.get('userid');
got(userid);

function got(userid) {
	fetch("http://localhost:7755/book/patientdata?userid=" + userid).then((data) => {
		return data.json(); //converted to object
	}).then((objectData) => {
		let tableData = "";
		objectData.map((values) => {
			tableData += `  <tr>
        <td>${values.patientid}</td>
        <td>${values.patientname}</td>
        <td>${values.age}</td>
        <td>${values.gender}</td>
        <td>${values.phoneno}</td>
        <td>${values.doctorname}</td> 
        <td>${values.apptime}</td> 
        <td>${values.status}</td> 
         <td><button id="ev" class="btn btn-success" onclick="editfunction(${values.patientid})">View</button></td>
        <td><button id="ec" class="btn btn-success" onclick="cancel(${values.patientid})">Cancel</button></td> 
      </tr>`;
		});
		document.getElementById("element").innerHTML = tableData;
	}).catch((err) => {
		console.log(err);
	})
}



function cancelall(userid) {
	var settings = {
		"url": "http://localhost:7755/book/cancelall?status=Cancelled&userid=" +userid+ "",
		"method": "PUT",
		"timeout": 0,
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		if (response == "cancel") {
			alert(" All Appointment Cancelled");
		}
		
	});
}





function cancel(patientid) {
	var settings = {
		"url": "http://localhost:7755/book/approve?status=Cancelled&patientid=" +patientid+ "",
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





function editfunction(patientid) {
	location.href = "doctorview?patientid=" + patientid + "";
	//location.href="/editscreen";
}





function go(userid) {

	const from_date = document.getElementById("from_date").value;
	const to_date = document.getElementById("to_date").value;

	console.log(from_date);
	console.log(to_date);

	const payload = {
		from_date,
		to_date,


	};

	console.log(payload);

	var settings = {
		url: "http://localhost:7755/book/filteruser?userid=" + userid + "&from_date=" + from_date + "&to_date=" + to_date + "",
		method: "POST",
		timeout: 0,
		headers: {
			"Content-Type": "application/json",
		},
		data: JSON.stringify(payload),
	};

	$.ajax(settings).done(function(response) {
		console.log(response);

		show(response);
	});

	function show(response) {
		let tab = "";

		for (var i = 0; i < response.length; i++) {
			tab += `<tr>
 <td>${response[i].patientid}</td>
<td>${response[i].patientname} </td>
<td>${response[i].age}</td>
<td>${response[i].gender}</td>
<td>${response[i].phoneno}</td>
 <td>${response[i].doctorname}</td>
 <td>${response[i].apptime}</td> 
 <td>${response[i].status}</td>   
<td><button id="ev" class="btn btn-success" onclick="editfunction(${response[i].patientid})">View</button></td>
<td><button  id="ec" class="btn btn-success" onclick="editfunction(${response[i].patientid})">Cancel</button></td>

</tr>`;
		}

		document.getElementById("element").innerHTML = tab;
	}


}





function search() {

	const search = document.getElementById("search").value;

	var data = "";


	var settings = {
		url: "http://localhost:7755/book/search?name=" + search + "",
		method: "GET",
		timeout: 0,
		headers: {
			"Content-Type": "application/json",
		},
		data: JSON.stringify(data),
	};

	$.ajax(settings).done(function(response) {
		console.log(response);

		show(response);
	});

	function show(response) {
		let tab = "";

		for (var i = 0; i < response.length; i++) {
			tab += `<tr>
 <td>${response[i].patientid}</td>
<td>${response[i].patientname} </td>
<td>${response[i].age}</td>
<td>${response[i].gender}</td>
<td>${response[i].phoneno}</td>
 <td>${response[i].doctorname}</td>
        <td>${response[i].apptime}</td>
        <td>${response[i].status}</td>
       
        <td><button class="btn btn-success" id="ev" onclick="editfunction(${response[i].patientid})">View</button></td>
        <td><button class="btn btn-success" id="ec" onclick="editfunction(${response[i].patientid})">Cancel</button></td>



</tr>`;
		}

		document.getElementById("element").innerHTML = tab;
	}

}


