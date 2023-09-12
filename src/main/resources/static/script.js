function getAllCrad() {
  var requestOptions = {
    method: 'GET',
    redirect: 'follow'
  };

  fetch("http://localhost:8080/boards/1/cards", requestOptions)
    .then(response => response.json())
    .then(parsedResponse => {
      parsedResponse.forEach(element => {

        let cardSection = element.section;
        let boardDiv;

        if(cardSection === "to_do"){
          boardDiv = document.getElementById("To_Do");
        }
        else if(cardSection === "in_progress"){
          boardDiv = document.getElementById("In_Progress");
        }
        else{
          boardDiv = document.getElementById("Done");
        }

        let cardDiv = document.createElement("div");
        cardDiv.className = "card";
        cardDiv.id = element.id;

        let idDiv = document.createElement("h2");
        idDiv.className = "id";
        idDiv.textContent = element.id;

        let titleDiv = document.createElement("h3");
        titleDiv.className = "title";
        titleDiv.textContent = element.title;

        let descDiv = document.createElement("p");
        descDiv.className = "description";
        descDiv.textContent = element.description;

        cardDiv.appendChild(idDiv);
        cardDiv.appendChild(titleDiv);
        cardDiv.appendChild(descDiv);

        boardDiv.appendChild(cardDiv);
      });
  })
    .catch(error => console.log('error', error));
}

window.onload = getAllCrad;