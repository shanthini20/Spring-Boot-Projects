function login() {
  var settings = {
    "url": "http://localhost:7755/book/login?username=" + $("#username").val() + "&password=" + $("#password").val() + " ",
    "method": "POST",
    "timeout": 0,
  };

  $.ajax(settings).done(function(response) {
    const userid = response;
    console.log(userid);

    if (userid === 1) {
      window.location.href = '/patienttable';
    } else if (userid !== 1) {
      console.log(userid);
      window.location.href = '/doctable?userid=' + userid;
    } else {
      alert("Invalid username or password");
    }
  });
}
