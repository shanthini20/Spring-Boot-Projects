fetch("http://localhost:8877/user/singlerow?userid=" + CommonJS.GetQueryStringValue("userid") + "").then((response)=>{
	
	//console.log(data);
	return response.json();//converted to object
	
}).then((objectData)=>{
	console.log(objectData[0].profilepicname);
	var profilepicname=objectData[0].profilepicname;
	let tableData="";
	objectData.map((values)=>{
		document.getElementById("firstname").value=values.firstname
		document.getElementById("lastname").value=values.lastname
	document.getElementById("age").value=values.age
	document.getElementById("dob").value=values.dob
	document.getElementById("doj").value=values.doj
	
	
	
	load(profilepicname);
	
	
	});
	//document.getElementById("form_body").innerHTML=tableData;
}).catch((err)=>{
	
	console.log(err);
})














function load(profilepicname){
  
  
fetch(`http://localhost:8877/user/images/${profilepicname}`)
  .then(response => response.blob())
  .then(blob => {
	
    const url = URL.createObjectURL(blob);
    const img = document.createElement('img');
   img.src = url;
   img.height = 300;
   img.width=300;
    var container = document.getElementById("new")
     container.appendChild(img)
    
  
  });


  }
  
  
  
  
function edit() {
	const profilepic = document.getElementById("profilepic");
	


	var formdata = new FormData();
	formdata.append("profilepic", profilepic.files[0]);
	

	var requestOptions = {
		method: 'POST',
		body: formdata,
		redirect: 'follow'
	};

	fetch("http://localhost:8877/user/profile", requestOptions)
		.then(response => response.json())
		.then((result) => {
			console.log(result);
			var profilepic = result.profilepic;
			
			console.log(profilepic)
			
	var profilepicname = profilepic.replace(/^.*[\\\/]/, '');
	
	

	console.log(profilepicname)

			
	const firstname = document.getElementById("firstname").value;
	const lastname = document.getElementById("lastname").value;
	const age = document.getElementById("age").value;
	const dob = document.getElementById("dob").value;
	const doj = document.getElementById("doj").value;
	
	 
	const payload = {

		firstname,
		lastname,
		age,
		dob,
		doj,
		profilepic,
		profilepicname
	};
			console.log(payload);
		document.getElementById("new").innerHTML = "";
         load(profilepicname);
        
	var settings = {
		url: "http://localhost:8877/user/update?userid="+ CommonJS.GetQueryStringValue("userid") +"",
		method: "POST",
		timeout: 0,
		headers: {
			"Content-Type": "application/json",
		},
		data: JSON.stringify(payload),
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		if (response == "updated") {
			alert("Updated Successfully")

		}

	});


		}
		)

}

