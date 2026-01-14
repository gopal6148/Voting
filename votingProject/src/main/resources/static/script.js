const API_URL = "https://bert-festive-cash.ngrok-free.dev/api";
const BASE_URL = window.location.origin;
// LOAD candidates from backend
function loadCandidates() {
    fetch(BASE_URL + "/api/candidates")
        .then(response => response.json())
        .then(data => {
            let table = document.getElementById("candidateTable");
            table.innerHTML = "";
			
			// 1. Initialize a variable to count total votes
			            let totalVotesCount = 0;

           data.forEach((c, index) => {
			// 2. Add each candidate's votes to the total
			                totalVotesCount += c.votes;
                table.innerHTML += `
				<tr>
				  <td>1</td>
				  <td></td>
				  <td></td>
				  <td></td>
				  <td></td>
				  <td></td>
				  </tr>
                <tr class="selected">
                    <td>${c.id}</td>
                    <td>${c.name}</td>
					<td><img src="/uploads/vishal.jpeg" width="60px" height="60px"></td>
					<td><img src="/uploads/shivsena.png" width="60px" height="60px"></td>
                    <td><img src="/uploads/arrow.jfif" width="40px" height="40px"></td>
                    <td>
                        <button class="vote-btn" onclick="vote(${c.id})">बटन दाबा</button>
                    </td>
                </tr>
				<tr>
				   <td>3</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>4</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
				    <td>5</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>6</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
                `;
            });
			// 3. Update the HTML element with the calculated total
			            document.getElementById("totalVotes").innerText = totalVotesCount;
        });
}
function playVoteSound() {
    const sound = document.getElementById("voteSound");
    sound.currentTime = 0;
    sound.play();
}
// SEND vote to backend
function vote(candidateId) {
	if (localStorage.getItem("voted") === "true") {
	        alert(" तुम्ही आधीच मतदान केले आहे");
	        return;
	    }
	playVoteSound();
    fetch(BASE_URL + "/api/vote/" + candidateId, {
        method: "POST"
    })
    .then(response => response.json())
    .then(data => {
		
		localStorage.setItem("voted", "true");
        document.getElementById("totalVotes").innerText = data.totalVotes;
		alert("मतदान यशस्वी!");
    });
}

function shareWhatsApp() {
    const message =
	"🗳️ पुणे महानगरपालिका निवडणूक 2026 \n\n" +
	        "भाग ५ साठी उमेदवार – मंगेश \n" +
	        "मतदानासाठी निळे बटन दाबा!\n\n" +
        "🔗 Vote here: https://bert-festive-cash.ngrok-free.dev";

    const encodedMessage = encodeURIComponent(message);

    // Works on mobile + desktop
    const whatsappUrl = "https://wa.me/?text=" + encodedMessage;

    window.open(whatsappUrl, "_blank");
}


// Load on page open
loadCandidates();
