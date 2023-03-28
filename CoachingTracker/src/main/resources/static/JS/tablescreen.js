function newentry(){
    location.href = "/homescreen";
}



function common(roleid){
	if(roleid==2){
		loaddata();
	}
	else{
		agentData(userid);
	}
}


const api_url =
"http://localhost:4788/coaching/gettablescreen";

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
  <th id="head1">Date</th>
  <th id="head2"> Agent name</th>
  <th id="head3">Supervisor Name</th>
  <th id="head4">Reason</th>
  <th>status</th>
  <th>See more</th>
  
  </tr>`;

// Loop to access all rows
for (let r of data) {
  tab += `<tr>
 <td>${r.shiftdate}</td>
<td>${r.agent_name} </td>
<td>${r.supervisorname}</td>
<td>${r.reason}</td>
<td>${r.status}</td>
<td><i class="fa fa-eye"><a onclick="viewfunction(${r.entryid})" >view</a></i></td>
</tr>`;
}



document.getElementById("element").innerHTML = tab;
}

function viewfunction(entryid)
{
	location.href="finalTable?entryid="+entryid+"";
	
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
	$("#agent").append("<option>"+item +"</option>");
  console.log(response);
});
});

});
  
  
  
  
  function go() {
    
    const from_date = document.getElementById("from_date").value;
    const to_date = document.getElementById("to_date").value;
    const agent_name=document.getElementById("agent").value;
    console.log(from_date);
    console.log(to_date);
    console.log(agent_name);
    const payload = {
     from_date,
     to_date,
     agent_name
     
    };
  
    console.log(payload);
  
    var settings = {
      url: "http://localhost:4788/coaching/filter?from_date="+from_date+"&to_date="+to_date+"&agent_name="+agent_name+"",
      method: "POST",
      timeout: 0,
      headers: {
        "Content-Type": "application/json",         
      },
      data: JSON.stringify(payload),
    };
  
    $.ajax(settings).done(function (response) {
      console.log(response);
   
  show(response);
    });
    
    function show(response) {
let tab =
  `<tr>
  <th id="head1">Date</th>
  <th id="head2"> Agent name</th>
  <th id="head3">Supervisor Name</th>
  <th id="head4">Reason</th>
  <th>status</th>
  <th>See more</th>
  
  </tr>`;

// Loop to access all rows

for (var i=0;i<response.length;i++ ) {
  tab += `<tr>
 <td>${response[i].shiftdate}</td>
<td>${response[i].agent_name} </td>
<td>${response[i].supervisorname}</td>
<td>${response[i].reason}</td>
<td>${response[i].status}</td>
<td><i class="fa fa-eye"><a onclick="viewfunction(${response[i].entryid})" >view</a></i></td>
</tr>`;
}



document.getElementById("element").innerHTML = tab;
}

  }
function agentData(userid)
{
	 $.ajax({
                url: "localhost:4788/coaching/agentpage?userid="+userid+"",
                type: "GET",
                dataType: "json",
                success: function (response) {
                    $("#element").find("tbody").empty();
                    for (var i = 0; i < response.length; i++) {
				$("#element").find("tbody").
				append("<tr userid='"+response[i].userid+"'><td>"+response[i].shiftdate+"</td><td>"+response[i].supervisorname+"</td><td>"+response[i].reason+"</td><td>"+response[i].status+"</td><td>"+response[i].status+"</td></tr>")

			}
                    $("#element").html(table);
                }
            });
}

function loaddata(){
		$.ajax(settings).done(function(response) {
		console.log(response);
		for (i = 0; i < response.length; i++) {
			if (response[2] == "Login Success") {
				location.href = "/tablescreen?roleid="+response[0]+"&userid="+response[1]+"";
			}
			
		
		
		}

	});
}
 