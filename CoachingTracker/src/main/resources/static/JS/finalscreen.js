

// api url
const api_url =
	"http://localhost:4788/coaching/getfinalrec?entryid=" + CommonJS.GetQueryStringValue("entryid") + "";

// Defining async function
async function getapi(api_url) {

	// Storing response
	const response = await fetch(api_url);

	// Storing data in form of JSON
	var data = await response.json();
	console.log(data);
	if (response) {
		hideloader();
	}
	show(data);
}
// Calling that async function
getapi(api_url);

// Function to hide the loader
function hideloader() {
}
// Function to define innerHTML for HTML table
function show(data) {
	let tab =
		`<tr>
  <th id="head1">shiftdate</th>
  <th id="head2"> supervisorname</th>
  <th id="head3">reason</th>
  <th id="head4">hour</th>
  <th>Minutes</th>
  <th>Status</th>
  <th>Notes</th>
  
  </tr>`;

	// Loop to access all rows
	var dataArr = new Array();
	dataArr.push(data)
	for (let r of dataArr) {
		tab += `<tr>
  <td>${r.shiftdate}</td>
  <td>${r.supervisorname}</td>
  <td>${r.reason}</td>
   <td>${r.hour}</td>
    <td>${r.minute}</td>
    <td>${r.status}</td>
  <td>${r.notes}</td>

</tr>`;
	}

	document.getElementById("final").innerHTML = tab;
}







function save() {
	var settings = {
		"url": "http://localhost:4788/coaching/agentcomments?agent_comments=" + $("#w3review").val() + "&entryid=" + CommonJS.GetQueryStringValue("entryid") + "&status=Acknowledge",
		"method": "PUT",
		"timeout": 0,
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		if (response == "updated") {
			alert("Comments Saved");
		}
		else if (Comments == "") {
			alert("fill the Comments");
		}

	});
}