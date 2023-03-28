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
		document.getElementById("docname").value = values.doctorname
		document.getElementById("appointment_time").value = values.apptime
		document.getElementById("area").value = values.doc_area
		document.getElementById("state").value = values.doc_state
		document.getElementById("city").value = values.doc_city
		
		

	});

}).catch((err) => {

	console.log(err);
})


function editpatient() {
       const patientname= document.getElementById("name").value;
		const age=document.getElementById("age").value;
		 const gender = document.querySelector('input[name="gender"]:checked').value;
		 const phoneno=document.getElementById("phone").value;
		const address=document.getElementById("address").value 
		const enquiry=document.getElementById("enquiry").value;
		const appdate=document.getElementById("appointment_date").value ;
		const doctorname=document.getElementById("docname").value ;
		const apptime=document.getElementById("appointment_time").value;
		const doc_area=document.getElementById("area").value;
		const doc_state=document.getElementById("state").value;
		const doc_city =document.getElementById("city").value ;
		

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
		doc_area
	};

	console.log(payload);

	var settings = {
		url: "http://localhost:7755/book/update?patientid="+ CommonJS.GetQueryStringValue("patientid") +"",
		method: "POST",
		timeout: 0,
		headers: {
			"Content-Type": "application/json",
		},
		data: JSON.stringify(payload),
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		if(response=="updated")
		{
			alert("updated");
		}
		
		


	});
}



var docid;

$(document).ready(function() {
	var settings = {
		"url": "http://localhost:7755/book/doctordetails",
		"method": "GET",
		"timeout": 0
	};

	$.ajax(settings).done(function(response) {
		$("#docname").append("<option value='' disabled selected>Select Doctor</option>");
		$.each(response, function(index, item) {
			$("#docname").append("<option docid=" + item.docid + ">" + item.docname + "</option>")
		});

		$("#docname").on("click", function() {
			var selectedOption = $(this).find(':selected');
			docid = selectedOption.attr('docid');
			console.log(docid);
			


		});

	});

});







function Home2()
{
	location.href ="/patienttable";
}

