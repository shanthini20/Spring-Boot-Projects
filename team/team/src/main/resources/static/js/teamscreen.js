function newteam() {

	const teamname = document.getElementById("newteam").value;

	const payload = {

		teamname
	};

	console.log(payload);

	var settings = {
		url: "http://localhost:8877/team/newteam",
		method: "POST",
		timeout: 0,
		headers: {
			"Content-Type": "application/json",
		},
		data: JSON.stringify(payload),
	};

	$.ajax(settings).done(function(response) {
		console.log(response);


	});
}




var userid;
var teamid;
var memid;



$(document).ready(function() {
	var settings = {
		"url": "http://localhost:8877/team/getteam",
		"method": "GET",
		"timeout": 0
	};

	$.ajax(settings).done(function(response) {
		$("#getteam").append("<option value='' disabled selected>Select Team</option>");
		$.each(response, function(index, item) {
			$("#getteam").append("<option tid=" + item.teamid + ">" + item.teamname + "</option>")
		});

		$("#getteam").on("click", function() {
			var selectedOption = $(this).find(':selected');
			teamid = selectedOption.attr('tid');
			console.log(teamid);
			addTeamMembers(teamid);
			deleteTeamMembers(teamid);


		});

	});

});



var userIds = [];
function addTeamMembers(teamid) {
	document.getElementById("ul1").innerHTML = "";

	$(document).ready(function() {
		var settings = {
			"url": "http://localhost:8877/team/specmem?teamid=" + teamid,
			"method": "GET",
			"timeout": 0
		};

		$.ajax(settings).done(function(response) {
			$.each(response, function(index, item) {
				$("#ul1").append("<li data-userid='" + item.userid + "'><input type='checkbox' class='member-checkbox'>" + item.firstname + " " + item.lastname + "</li>");
			});


			$("#add").prop("disabled", true);


			$("#select-all-checkbox-1").on("click", function() {
				$("#ul1 .member-checkbox").prop("checked", $(this).is(":checked"));
				if ($("#ul1 .member-checkbox:checked").length > 0) {
					$("#add").prop("disabled", false);
				} else {
					$("#add").prop("disabled", true);
				}
			});


			$("#ul1").on("change", ".member-checkbox", function() {
				if ($("#ul1 .member-checkbox:checked").length > 0) {
					$("#add").prop("disabled", false);
				} else {
					$("#add").prop("disabled", true);
				}
			});

			$("#add").on("click", function() {
				var useridValues = [];

				var checkboxes = document.querySelectorAll("#ul1 .member-checkbox");
				for (var i = 0; i < checkboxes.length; i++) {
					if (checkboxes[i].checked) {
						var userid = checkboxes[i].parentNode.getAttribute("data-userid");
						useridValues.push(userid);
					} else {
						var index = userIds.indexOf(userid);
						if (index !== -1) {
							userIds.splice(index, 1);
						}
					}
				}
				console.log(useridValues);
				userIds = useridValues;


				move();
				document.getElementById("ul1").innerHTML = "";

			});

		});
	});
}


function move() {
	$("#add").prop("disabled", false);
	const payload = {
		teamid,
		userIds

	};

	console.log(payload);

	var settings = {
		url: "http://localhost:8877/team/insertmem",
		method: "POST",
		timeout: 0,
		headers: {
			"Content-Type": "application/json",
		},
		data: JSON.stringify(payload),
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		addTeamMembers(teamid);
		deleteTeamMembers(teamid);
		userIds = [];


	});
}




var memIds = [];
function deleteTeamMembers(teamid) {
	memIds = [null];
	document.getElementById("ul2").innerHTML = "";

	$(document).ready(function() {
		var settings = {
			"url": "http://localhost:8877/team/teammembers?teamid=" + teamid,
			"method": "GET",
			"timeout": 0
		};

		$.ajax(settings).done(function(response) {
			$.each(response, function(index, item) {
				$("#ul2").append("<li data-userid='" + item.memid + "'><input type='checkbox' class='member-checkbox'>" + item.firstname + " " + item.lastname + "</li>");
			});


			$("#del").prop("disabled", true);

			$("#select-all-checkbox-2").on("click", function() {
				$("#ul2 .member-checkbox").prop("checked", $(this).is(":checked"));
				if ($("#ul2 .member-checkbox:checked").length > 0) {
					$("#del").prop("disabled", false);
				} else {
					$("#add").prop("disabled", true);
				}
			});


			$("#ul2").on("change", ".member-checkbox", function() {
				if ($("#ul2 .member-checkbox:checked").length > 0) {
					$("#del").prop("disabled", false);
				} else {
					$("#del").prop("disabled", true);
				}
			});

			$("#select-all-checkbox-2").on("click", function() {
				$("#ul2 .member-checkbox").prop("checked", $(this).is(":checked"));
			});

			$("#ul2").on("click", ".member-checkbox", function() {
				$("#select-all-checkbox-2").prop("checked", $("#ul2 .member-checkbox:checked").length == $("#ul2.member-checkbox").length);
			});

			$("#del").on("click", function() {
				var memidValues = [];

				var checkboxes = document.querySelectorAll("#ul2 .member-checkbox");
				for (var i = 0; i < checkboxes.length; i++) {
					if (checkboxes[i].checked) {
						var memid = checkboxes[i].parentNode.getAttribute("data-userid");
						memidValues.push(memid);
					}
				}
				console.log(memidValues);
				memIds = memidValues;
				remove(memIds);
				document.getElementById("ul2").innerHTML = "";

			});

		});
	});
}





function remove(memIds) {
	$("#del").prop("disabled", false);
	const payload = {

		memIds

	};

	console.log(payload);

	var settings = {
		url: "http://localhost:8877/team/memdelete",
		method: "DELETE",
		timeout: 0,
		headers: {
			"Content-Type": "application/json",
		},
		data: JSON.stringify(payload),
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		addTeamMembers(teamid);
		deleteTeamMembers(teamid);
		memIds = [null];






	});
}




