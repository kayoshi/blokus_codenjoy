var canvas = document.getElementById("canvas"),
c = canvas.getContext("2d");

var roomNumber = "";
function enterRoom() {
  roomNumber = document.getElementById("roomNumber").value;
  start();
}

function start() {
  
  var request = new XMLHttpRequest()
  // request.open('GET', 'http://heap.kz/' + `${roomNumber}` + '.json', true)
  // request.open('GET', 'http://heap.kz/roomOne.json', true)
  request.open('GET', 'http://192.168.43.224:8080/getdrawed', true)
  request.onload = function() {
    var drawed = JSON.parse(this.response).drawed
    drawBox(drawed);
  }
  request.send();
  //console.log("here");
}


function drawBox(inputArray) {
  
  var boxes = inputArray.length,
      boxSize = Math.floor(600 / boxes);

  var gradient=c.createLinearGradient(0,0,170,0);
  gradient.addColorStop("0","#00892D");
  gradient.addColorStop("0.3","#025DBA");
  gradient.addColorStop("0.5","#ECBC00");
  gradient.addColorStop("1","#AD0101");

  c.beginPath();
  c.fillStyle = "white";
  c.lineWidth = 2;
  c.strokeStyle = "black";
  for (var row = 0; row < boxes; row++) {
    for (var column = 0; column < boxes; column++) {
      var x = column * boxSize;
      var y = row * boxSize;
      c.rect(x, y, boxSize, boxSize);
      c.fill();
      c.stroke();
    }
  }
  c.strokeStyle=gradient;
  c.lineWidth=10;
  c.strokeRect(0,0,600,600);
  c.closePath();

  for (var i = 0; i < inputArray.length; i++) {
    for(var j = 0; j < inputArray.length; j++) {
      if(inputArray[i][j] !== 0) {
        drawTire(boxSize, inputArray[i][j], i, j)
      }
    };
  };
  
  setTimeout(start(), 5000);
}

function drawTire(boxSize, player, xcoord, ycoord) {
  if(player == 1) {
    c.fillStyle = "#AD0101";
  } else if(player == 2) {
    c.fillStyle = "#00892D"
  }
  c.fillRect(
    xcoord * boxSize,
    ycoord * boxSize,
    boxSize, 
    boxSize
  );
}