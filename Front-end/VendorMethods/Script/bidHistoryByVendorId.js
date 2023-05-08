function getBidHistory() {
  const vendorId = document.getElementById("vendorId").value;
  const jyani = new XMLHttpRequest();
  jyani.open("GET", `http://localhost:8080/vendors/bidHistory/${vendorId}`);
  jyani.onload = () => {
    const bidHistory = JSON.parse(jyani.responseText);
    const bidHistoryTable = document.getElementById("bidHistoryTable");

    // Clear the table before adding new search results
    bidHistoryTable.innerHTML = "";

    const headerRow = bidHistoryTable.createTHead().insertRow();
    headerRow.insertCell(0).textContent = "Bid ID";
    headerRow.insertCell(1).textContent = "Tender ID";
    headerRow.insertCell(2).textContent = "Bid Amount";
    headerRow.insertCell(3).textContent = "Duration (days)";
    headerRow.insertCell(4).textContent = "Bid Status";
    headerRow.insertCell(5).textContent = "Tender Image";
    for (const bid of bidHistory) {
      const row = bidHistoryTable.insertRow();
      row.insertCell(0).textContent = bid.id;
      row.insertCell(1).textContent = bid.tender.tenderId;
      row.insertCell(2).textContent = bid.bidAmount;
      row.insertCell(3).textContent = bid.durationInDays;
      row.insertCell(4).textContent = bid.bidStatus;
      const imageCell = row.insertCell(5);
      const img = document.createElement("img");
      img.src = bid.tender.image;
      imageCell.appendChild(img);
    }
  };
  jyani.send();
}
function redirectToPlaceBid() {
    window.location.href = "placeBid.html";
  }