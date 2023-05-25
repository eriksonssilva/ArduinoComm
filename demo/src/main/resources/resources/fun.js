var xmlHttp = new XMLHttpRequest();

let toggle = document.getElementById('interruptor')
let on;


function post() {

if (toggle.checked) {

    on = true;

} else {

on = false;

}

  var data = new FormData();
  data.append('command', on);

  let functionsUrl = 'http://192.168.1.16:8080';

  xmlHttp.onreadystatechange = function () {


  };


  xmlHttp.open("POST", functionsUrl);
  xmlHttp.send(data);

}
