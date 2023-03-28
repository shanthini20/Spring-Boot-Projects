
/*// api url
const api_url =
	"http://localhost:9090/api/csv/singlerow?vendor_id=" + CommonJS.GetQueryStringValue("vendor_id") + "";

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
	let tab ="";
		

	// Loop to access all rows
	var dataArr = new Array();
	dataArr.push(data)
	for (let r of dataArr) {
		tab += ` <div>${values.priority}</div>
        <div>${values.reason}</div>
        <div>${values.vendor_id}</div>
        <div>${values.vendor_name}</div>
        <div>${values.scan_id}</div>
        <div>${values.cluster}</div>
        <div>${values.country}</div>
        <div>${values.document_no}</div>
        <div>${values.company_code}</div>
        <div>${values.type}</div>
        <div>${values.total_amnt}</div>
        <div>${values.currency}</div>
        <div>${values.po_no}</div>
        <div>${values.scan_date}</div>
        <div>${values.existing_status}</div>

`;
	}

	document.getElementById("form_body").innerHTML = tab;
}
*/


fetch("http://localhost:9090/api/csv/singlerow?vendor_id=" + CommonJS.GetQueryStringValue("vendor_id") + "").then((response)=>{
	
	//console.log(data);
	return response.json();//converted to object
	
}).then((objectData)=>{
	console.log(objectData[0].priority);
	let tableData="";
	objectData.map((values)=>{
		document.getElementById("priority").value=values.priority
		document.getElementById("reason").value=values.reason
	document.getElementById("vendor_id").value=values.vendor_id
	document.getElementById("vendor_name").value=values.vendor_name
	document.getElementById("scan_id").value=values.scan_id
	document.getElementById("cluster").value=values.cluster
	document.getElementById("country").value=values.country
	document.getElementById("document_no").value=values.document_no
	document.getElementById("company_code").value=values.company_code
	document.getElementById("type").value=values.type
	document.getElementById("total_amnt").value=values.total_amnt
	document.getElementById("currency").value=values.currency
	document.getElementById("po_no").value=values.po_no
	document.getElementById("scan_date").value=values.scan_date
	document.getElementById("existing_status").value=values.existing_status
	
	
	});
	//document.getElementById("form_body").innerHTML=tableData;
}).catch((err)=>{
	
	console.log(err);
})


function save() {
	var settings = {
		"url": "http://localhost:9090/api/csv/lastsave?priority="+ $("#priority").val() +"&reason="+ $("#reason").val() +" &vendor_id="+CommonJS.GetQueryStringValue("vendor_id")+"&vendor_name="+ $("#vendor_name").val() +"&cluster="+ $("#cluster").val() +"&country="+ $("#country").val() +"&document_no="+ $("#document_no").val() +" &company_code="+ $("#company_code").val() +" &type="+ $("#type").val() +"&total_amnt="+ $("#total_amnt").val() +"&currency="+ $("#currency").val() +"&po_no="+ $("#po_no").val() +"&scan_date="+ $("#scan_date").val() +"&existing_status=Acknowlege&existing_comments="+ $("#existing_comments").val() +"",
		"method": "PUT",
		"timeout": 0,
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		if (response == "updated") {
			alert("Comments Saved");
			got();
		
		}
		else if (Comments=="") {
			alert("fill the Comments");
		}

	});
}


function getfile() {
	var settings = {
		"url": "http://localhost:9090/api/csv/download/dataexcel.csv",
		"method": "GET",
		"timeout": 0
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		
	});
}

function downloadCSV(csv, filename) {
    var csvFile;
    var downloadLink;

    // CSV file
    csvFile = new Blob([csv], {type: "text/csv"});

    // Download link
    downloadLink = document.createElement("a");

    // File name
    downloadLink.download = filename;

    // Create a link to the file
    downloadLink.href = window.URL.createObjectURL(csvFile);

    // Hide download link
    downloadLink.style.display = "none";

    // Add the link to DOM
    document.body.appendChild(downloadLink);

    // Click download link
    downloadLink.click();
}




function exportTableToCSV(filename) {
    var csv = [];var data=[];
     var formData = new FormData(document.querySelector("#form_body"));
    
      for(var pair of formData.entries()){
         csv.push(pair[1]);  
    }
   
       
    // Download CSV file
    downloadCSV(csv.join(","), filename);
}
document.getElementById("getfile");



/*function show(){
    console.clear();

    var formData = new FormData(document.querySelector("#form_body"));
    
    for(var pair of formData.entries()){
        console.log(pair[1]);
    }
    
    event.preventDefault();    
} 
document.getElementById("getfile");


*/














/*function ExportToExcel(type, fn, dl) {
            var elt = document.getElementById('form_body');
            var wb = XLSX.utils.table_to_book(elt, { sheet: "sheet1" });
            return dl ?
                XLSX.write(wb, { bookType: type, bookSST: true, type: 'base64' }) :
                XLSX.writeFile(wb, fn || ('Formdata.' + (type || 'xlsx')));
        }
*/
