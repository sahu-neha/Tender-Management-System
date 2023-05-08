const placeBid = async () => {
    const tenderId = document.getElementById("tenderId").value;
    const vendorId = document.getElementById("vendorId").value;
    const bidAmount = document.getElementById("bidAmount").value;
    const durationInDays = document.getElementById("durationInDays").value;
  
    const bid = {
      bidAmount,
      durationInDays,
    };
  
    try {
      const response = await fetch(`http://localhost:8080/tenders/${tenderId}/${vendorId}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(bid),
      });
  
      if (!response.ok) {
        alert(`Failed to place bid: ${response.status}`);
      }else{
        alert("Bid Placed Sucessfully. Bid Amount is "+bidAmount+"₹ and Your Tender Id is "+tenderId);
        const result = await response.json();
      document.getElementById("result").textContent = `Bid placed successfully. Bid ID: ${result.id}`;
      }
  
      
    } catch (error) {
      alert(error);
      document.getElementById("result").textContent = `Error placing bid: ${error.message}`;
    }
  };
  
  const form = document.getElementById("placeBidForm");
  form.addEventListener("submit", (event) => {
    event.preventDefault();
    placeBid();
  });
  