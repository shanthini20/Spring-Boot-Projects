



function post() {
	const sow_copy = document.getElementById("sow_copy");
	const po_copy = document.getElementById("po_copy");



	var formdata = new FormData();
	formdata.append("sow_copy", sow_copy.files[0]);
	formdata.append("po_copy", po_copy.files[0]);

	var requestOptions = {
		method: 'POST',
		body: formdata,
		redirect: 'follow'
	};

	fetch("http://localhost:7070/purchase/fileupload", requestOptions)
		.then(response => response.json())
		.then((result) => {
			console.log(result);
			var sow_url = result.sow_copy_url;
			var po_url = result.po_copy_url;
			console.log(sow_url)
			console.log(po_url)
		
	var sowfilename = sow_url.replace(/^.*[\\\/]/, '')
	var pofilename=po_url.replace(/^.*[\\\/]/, '')
	

	console.log(sowfilename)
	console.log(pofilename)
			
	const business_model = document.getElementById("businessmodel").value;
	const department = document.getElementById("department").value;
	const project_initiation = document.getElementById("projectinitiation").value;
	const pov_month = document.getElementById("povmonth").value;
	const pov = document.getElementById("pov").value;
	const order_quantity = document.getElementById("orderquantity").value;
	const invoiced_amount = document.getElementById("invoicedamount").value;
	const po_startdate = document.getElementById("postartdate").value;
	const country = document.getElementById("country").value;
	const client_purchasecontact = document.getElementById("clientpurchasecontact").value;
	const client_operationcontact = document.getElementById("clientoperationcontact").value;
	const kg_operationcontact = document.getElementById("kgoperationcontact").value;
	const bill_to_address = document.getElementById("billtoaddress").value;
	const po_receiveddate = document.getElementById("poreceiveddate").value;
	const date_of_closure = document.getElementById("dateofclosure").value;
	const po_number = document.getElementById("ponumber").value;
	const functionality = document.getElementById("functionality").value;
	const total_resources = document.getElementById("totalresources").value;
	const po_tenure = document.getElementById("potenure").value;
	const achieved_pov = document.getElementById("achievedpov").value;
	const achieved_order_qty = document.getElementById("achievedorderqty").value;
	const received_amount = document.getElementById("receivedamount").value;
	const po_enddate = document.getElementById("poenddate").value;
	const state= document.getElementById("state").value;
	const phone_no1= document.getElementById("phoneno1").value;
	const phone_no2= document.getElementById("phoneno2").value;
	const phone_no3= document.getElementById("phoneno3").value;
	const ship_to_address= document.getElementById("shiptoaddress").value;
	const dispositions= document.getElementById("dispositions").value;
	const project_name= document.getElementById("projectname").value;
	const status= document.getElementById("status").value;
	const business_location= document.getElementById("businesslocation").value;
	const sow_id= document.getElementById("sowid").value;
	const balance_pov= document.getElementById("balancepov").value;
	const balance_quantity= document.getElementById("balancequantity").value;
	const outstanding= document.getElementById("outstanding").value;
    const actual_po_enddate= document.getElementById("actualpoenddate").value;
    const city= document.getElementById("city").value;
    const email_id1= document.getElementById("emailid1").value;
    const email_id2= document.getElementById("emailid2").value;
    const email_id3= document.getElementById("emailid3").value;
    const comments= document.getElementById("comments").value;
    
    
	
	
	
	
	






	const payload = {

		business_model,
		department,
		project_initiation,
		pov_month,
		pov,
		order_quantity,
		invoiced_amount,
		po_startdate,
		country,
		client_purchasecontact,
		client_operationcontact,
		kg_operationcontact,
		bill_to_address,
		po_receiveddate,
		date_of_closure,
		po_number,
		functionality,
		total_resources,
		po_tenure,
		achieved_pov,
		achieved_order_qty,
		received_amount,
		po_enddate,
		state,
		phone_no1,
		phone_no2,
		phone_no3,
		ship_to_address,
		dispositions,
		project_name,
		status,
		business_location,
		sow_id,
		balance_pov,
		balance_quantity,
		outstanding,
		actual_po_enddate,
		city,
		email_id1,
		email_id2,
		email_id3,
		comments,
		sow_url,
		po_url,
		pofilename,
		sowfilename

	};
			console.log(payload);

	var settings = {
		url: "http://localhost:7070/purchase/neworder",
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
			alert("Save Successfully")

		}

	});


		}
		)

}













