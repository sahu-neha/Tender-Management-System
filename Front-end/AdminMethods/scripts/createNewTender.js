// let input = document.querySelectorAll("#form form input");

// input.forEach((input) => {
// 	input.setAttribute("size", input.getAttribute("placeholder").length-8);
// });

let form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	e.preventDefault();
	let obj = {
		title: document.getElementById("title").value,
		description: document.getElementById("description").value,
		image: document.getElementById("image").value,
		creationDate: document.getElementById("creationDate").value,
		durationInDays: document.getElementById("durationInDays").value,
		tenderPrice: document.getElementById("tenderPrice").value,
	};

	console.log(obj);
	createTender(obj);
});

function createTender(obj) {
	fetch("http://localhost:8080/tenders", {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(obj),
	})
		.then((res) => {
			return res.json();
		})
		.then((data) => {
			console.log(data);
		});
}
