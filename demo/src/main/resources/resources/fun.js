let commandArray = ["G2", "G3", "G4"];
let labels = ["blueLabel", "greenLabel", "redLabel"];

function post(command) {

    var xmlHttp = new XMLHttpRequest();
    var data = new FormData();
    data.append('command', command);

    let functionsUrl = 'http://192.168.1.16:8080';

    xmlHttp.open("POST", functionsUrl);
    xmlHttp.send(data);

}

function get(command) {

    var xmlHttp = new XMLHttpRequest();
    var data = new FormData();
    data.append('command', command);

    var setLabel = "";

    let functionsUrl = 'http://192.168.1.16:8080/?command=' + command;

    xmlHttp.onreadystatechange = function () {

    if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
    setLabel = xmlHttp.response;

    for (let i=0; i < commandArray.length; i++)  {

        if(command == commandArray[i]) {

                document.getElementById(labels[i]).innerHTML = setLabel;

        }
    }
}};


  xmlHttp.open("GET", functionsUrl);
  xmlHttp.send();


}