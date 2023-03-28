
function editfunction(vendor_id) {
	location.href = "editscreen?vendor_id=" + vendor_id + "";
	//location.href="/editscreen";
}



function got() {

	fetch("http://localhost:9090/api/csv/tutorials").then((data) => {

		//console.log(data);
		return data.json();//converted to object

	}).then((objectData) => {
		console.log(objectData[0].priority);
		let tableData = "";
		objectData.map((values) => {
			tableData += `  <tr>
        <td>${values.priority}</td>
        <td>${values.reason}</td>
        <td>${values.vendor_id}</td>
        <td>${values.vendor_name}</td>
        <td>${values.scan_id}</td>
        <td>${values.cluster}</td>
        <td>${values.country}</td>
        <td>${values.document_no}</td>
        <td>${values.company_code}</td>
        <td>${values.type}</td>
        <td>${values.total_amnt}</td>
        <td>${values.currency}</td>
        <td>${values.po_no}</td>
        <td>${values.scan_date}</td>
        <td>${values.existing_status}</td>
        <td><button onclick="editfunction(${values.vendor_id})">Edit</button></td>
        
       
      </tr>`;
		});
		document.getElementById("table_body").innerHTML = tableData;
	}).catch((err) => {

		console.log(err);
	})
}

function search() {

	const search = document.getElementById("search").value;

	var data = "";


	var settings = {
		url: "http://localhost:9090/api/csv/get?vendor_name=" + search + "",
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
 <td>${response[i].priority}</td>
<td>${response[i].reason} </td>
<td>${response[i].vendor_id}</td>
<td>${response[i].vendor_name}</td>
<td>${response[i].scan_id}</td>
 <td>${response[i].cluster}</td>
        <td>${response[i].country}</td>
        <td>${response[i].document_no}</td>
        <td>${response[i].company_code}</td>
        <td>${response[i].type}</td>
        <td>${response[i].total_amnt}</td>
        <td>${response[i].currency}</td>
        <td>${response[i].po_no}</td>
        <td>${response[i].scan_date}</td>
        <td>${response[i].existing_status}</td>
        <td><button onclick="editfunction(${response[i].vendor_id})">Edit</button></td>



</tr>`;
		}

		document.getElementById("table_body").innerHTML = tab;
	}

}