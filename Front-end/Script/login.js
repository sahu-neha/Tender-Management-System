let form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	e.preventDefault();
	let obj = {
		username: document.getElementById("username").value,
		password: document.getElementById("password").value,
	};

	if (obj.username == "" || obj.password == "") {
		alert("Please fill in all fields");
		return;
	}
	if (obj.username == "admin" || obj.password == "admin") {
		window.location.href = "admin.html";
		return;
	}

	console.log(obj);
	login(obj);
});

function login(obj) {
	let url = "http://localhost:8080/login/{username}/{password}";
	fetch(url, {
		method: "POST",
		body: JSON.stringify(obj),
		headers: {
			"Content-type": "application/json",
		},
	})
		.then((res) => res.json())
		.then((data) => {
			if (data.id) {
				window.location.href = "index.html";
			} else {
				alert("Login failed");
			}
		});
}
