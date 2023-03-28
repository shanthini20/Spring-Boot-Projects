
function editfunction(userid)
{
	location.href="editscreen?userid="+userid+"";
	//location.href="/editscreen";
}





function got(){

fetch("http://localhost:8877/user/data").then((data)=>{
	
	//console.log(data);
	return data.json();//converted to object
	
}).then((objectData)=>{
	
	let tableData="";
	objectData.map((values)=>{
		tableData+=`  <tr>
        <td>${values.userid}</td>
        <td>${values.firstname}</td>
        <td>${values.lastname}</td>
        <td>${values.age}</td>
        <td>${values.dob}</td>
        <td>${values.doj}</td> 
        <td><button onclick="editfunction(${values.userid})">Edit</button></td> 
        <td><button onclick="sendMail()">Send Email</button></td>  
      </tr>`;
	});
	document.getElementById("table_body").innerHTML=tableData;
}).catch((err)=>{
	
	console.log(err);
})
}

function sendMail() {
  var params = {
    from_name: 'Shanthini',
    to_name:'Sakthi',
    message: 'Happy Birthday'
  };

  const serviceID = "service_4v15u1f";
  const templateID = "template_ccfx9hs";

    emailjs.send(serviceID, templateID, params)
    .then(res=>{
        
        console.log(res);
        alert("Your message sent successfully!!")

    })
    .catch(err=>console.log(err));

}





function newpage()
{
	location.href ="/first";
}











