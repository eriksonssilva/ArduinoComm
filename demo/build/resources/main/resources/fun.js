var xmlHttp = new XMLHttpRequest();

let red = document.getElementById('red');
let green = document.getElementById('green');
let blue = document.getElementById('blue');
let on;


function post(command) {


  var data = new FormData();
  data.append('command', command);

  let functionsUrl = 'http://192.168.1.16:8080';

  xmlHttp.onreadystatechange = function () {


  };


  xmlHttp.open("POST", functionsUrl);
  xmlHttp.send(data);

}
