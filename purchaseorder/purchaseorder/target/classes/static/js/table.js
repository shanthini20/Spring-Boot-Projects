
var pofilename;
function got(){

fetch("http://localhost:7070/purchase/data").then((data)=>{
	
	//console.log(data);
	return data.json();//converted to object
	
}).then((objectData)=>{
	
	let tableData="";
	objectData.map((values)=>{
		
		tableData+=`  <tr>
		
        <td>${values.po_number}</td>
        <td>${values.project_name}</td>
        <td>${values.order_quantity}</td>
        <td>${values.functionality}</td>
       <td><button id="downloadBtn" onclick="downpo('${values.pofilename}');">Download</button></td>
        <td><button id="downloadBtn" onclick="downso('${values.sowfilename}');">Download</button></td>
        <td>${values.pov}</td>
        <td>${values.pov_month}</td>
        <td>${values.invoiced_amount}</td>
         <td>${values.email_id1}</td>
        <td>${values.phone_no1}</td>
         <td>${values.city}</td>
        <td>${values.state}</td>
         <td>${values.country}</td>
        
       
      </tr>`;
	});
	document.getElementById("table_body").innerHTML=tableData;
}).catch((err)=>{
	
	console.log(err);
})
}



function downpo(pofilename){

  var settings = {
    "url": `http://localhost:7070/purchase/downloadFile/${pofilename}`,
    "method": "GET",
    "timeout": 0,
    "responseType": "blob" // set the response type to blob
  };

  $.ajax(settings).done(function (response) {
    var blob = new Blob([response], {type: 'application/octet-stream'}); 
    var url = URL.createObjectURL(blob); 
    var a = document.createElement('a'); 
    a.href = url; 
    a.download = 'PoCopy';
    a.click(); 
  });

}


function downso(sowfilename){

  var settings = {
    "url": `http://localhost:7070/purchase/downloadfile/${sowfilename}`,
    "method": "GET",
    "timeout": 0,
    "responseType": "blob" 
  };

  $.ajax(settings).done(function (response) {
    var blob = new Blob([response], {type: 'application/octet-stream'}); 
    var url = URL.createObjectURL(blob); 
    var a = document.createElement('a'); 
    a.href = url; 
    a.download = 'SowCopy';
    a.click(); 
  });

}





function newpage()
{
	location.href ="/index";
}
