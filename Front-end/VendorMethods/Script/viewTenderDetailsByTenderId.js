function retrieveTender() {
    const id = document.getElementById("tenderId").value;
    const url = `http://localhost:8080/availableTenders/${id}`;
    const jyani = new XMLHttpRequest();
    jyani.open("GET", url, true);
    jyani.onload = function () {
      if (jyani.status === 302) {
        const tender = JSON.parse(jyani.responseText);
        const tenderTable = document.getElementById("tenderBody");
        tenderTable.innerHTML = "";
        const row = tenderTable.insertRow(0);
        const tenderIdCell = row.insertCell(0);
        const titleCell = row.insertCell(1);
        const descriptionCell = row.insertCell(2);
        const creationDateCell = row.insertCell(3);
        const durationInDaysCell = row.insertCell(4);
        const tenderPriceCell = row.insertCell(5);
        const imageCell = row.insertCell(6);
        tenderIdCell.innerHTML = tender.tenderId;
        titleCell.innerHTML = tender.title;
        descriptionCell.innerHTML = tender.description;
        creationDateCell.innerHTML = tender.creationDate;
        durationInDaysCell.innerHTML = tender.durationInDays;
        tenderPriceCell.innerHTML = tender.tenderPrice;
        const img = document.createElement("img");
        img.src = tender.image;
        img.alt = "Tender Image";
        img.width = "200";
        imageCell.appendChild(img);
      } else {
        alert("Error retrieving tender data");
      }
    };
    jyani.send();
  }
  function redirectToPlaceBid() {
    window.location.href = "placeBid.html";
  }