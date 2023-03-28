
const firstnameInput = document.getElementById("firstname");
const firstnameError = document.getElementById("firstname-error");
firstnameInput.addEventListener("input", function() {
	const firstname = this.value.trim();
	if (!/^[A-Za-z]*$/.test(firstname)) {
		this.setCustomValidity("First name should contain only alphabets");
		firstnameError.innerHTML = "First name should contain only alphabets";
	} else {
		this.setCustomValidity("");
		firstnameError.innerHTML = "";
	}
});


const lastnameInput = document.getElementById("lastname");
const lastnameError = document.getElementById("lastname-error");
lastnameInput.addEventListener("input", function() {
	const lastname = this.value.trim();
	if (!/^[A-Za-z]*$/.test(lastname)) {
		this.setCustomValidity("First name should contain only alphabets");
		lastnameError.innerHTML = "First name should contain only alphabets";
	} else {
		this.setCustomValidity("");
		lastnameError.innerHTML = "";
	}
});

const ageField = document.getElementById("age");
const errorMessage = document.getElementById("error-message");

ageField.addEventListener("input", function() {
	let inputValue = ageField.value;
	if (/[^0-9]/.test(inputValue)) {
		errorMessage.innerText = "Age Should Contains Only numeric values";
		ageField.classList.add("error");
	} else {
		errorMessage.innerText = "";
		ageField.classList.remove("error");

		inputValue = inputValue.replace(/[^0-9]/g, "");
		ageField.value = inputValue;
	}
});
const dobInput = document.getElementById("dob");
const errorElement = document.getElementById("dob-error");

dobInput.addEventListener("input", validateDateOfBirth);

function validateDateOfBirth() {
	const dobValue = dobInput.value;
	const dobDate = new Date(dobValue);
	const nowDate = new Date();

	if (dobDate.getTime() >= nowDate.getTime()) {
		errorElement.textContent = "Date of birth cannot be the present date or a future date.";
		dobInput.focus();
	} else {
		errorElement.textContent = "";
	}
}

var ageMatches=true;


function validateAge() {
  var currentDate = new Date();
  var age = parseInt(document.getElementById("age").value);
  var dob = new Date(document.getElementById("dob").value);
  var dobYear = dob.getFullYear();
  var dobMonth = dob.getMonth() + 1;
  var dobDate = dob.getDate();
  var calculatedAge = currentDate.getFullYear() - dobYear;
  
  if (currentDate.getMonth() < dobMonth || (currentDate.getMonth() == dobMonth && currentDate.getDate() < dobDate)) {
    calculatedAge--;
  }
  
  if (calculatedAge !== age) {
    document.getElementById("error").innerHTML = "Age and date of birth do not match.";
     ageMatches = false;
  } else {
    document.getElementById("error").innerHTML = "";
     ageMatches = true;
  }
}

document.getElementById("age").addEventListener("input", validateAge);
document.getElementById("dob").addEventListener("input", validateAge);





function post() {
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
			var profilepicname = profilepic.replace(/^.*[\\\/]/, '')
			console.log(profilepicname)

			const firstname = document.getElementById("firstname").value;
			if (!/^[A-Za-z]*$/.test(firstname)) {
				alert("First name should contain only alphabets");
				return;
			}
			const lastname = document.getElementById("lastname").value;
			if (!/^[A-Za-z]*$/.test(lastname)) {
				alert("First name should contain only alphabets");
				return;
			}

			const age = document.getElementById("age").value;
			if (!/^[0-9]+$/.test(age)) {
				alert("Age should contain only numeric values");
				return;
			}

			const currentDate = new Date();
			const dob = new Date(document.getElementById("dob").value);

			if (dob >= currentDate) {
				alert("Date of birth cannot be a present or future date.");
				return;
			}
           else if(ageMatches==false)
           {
	          alert("Date of birth and age doesn't match .please provide valid data");
	          return;
           }


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
			load(profilepicname);

			var settings = {
				url: "http://localhost:8877/user/userdata",
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
		});
}



function load(profilepicname) {


	fetch(`http://localhost:8877/user/images/${profilepicname}`)
		.then(response => response.blob())
		.then(blob => {
			const url = URL.createObjectURL(blob);
			const img = document.createElement('img');
			img.src = url;
			img.height = 200;
			img.width = 300;
			var container = document.getElementById("your-container")
			container.appendChild(img)

		});


}

