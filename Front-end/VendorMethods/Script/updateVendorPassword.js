const form = document.querySelector("#updateVendorPasswordForm");
const resultDiv = document.querySelector("#result");

form.addEventListener("submit", (event) => {
  event.preventDefault(); // Prevent form submission from refreshing the page

  const username = form.username.value;
  const password = form.password.value;
  const newPassword = form.newPassword.value;

  const url = `http://localhost:8080/${username}/${password}/${newPassword}`;
  fetch(url, {
    method: "PUT",
  })
    .then((response) => {
      if (response.ok) {
        return response.text();
      } else {
        throw response;
      }
    })
    .then((message) => {
      
      resultDiv.textContent = message;
resultDiv.classList.add("show");
resultDiv.style.color = "green";

    })
    .catch((error) => {
      error.json().then((json) => {
        resultDiv.textContent = json.message;
        resultDiv.classList.add("show");
        resultDiv.style.color = "red";
      });
    });
});
