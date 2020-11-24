function showPlayNumberInput(){
    $("#titleScreen").fadeOut("fast");
    $("#playerNum").fadeIn("slow");
}

function showPlayInfoInput(){
    var numPlayers = document.getElementById("numPlayers").value;
    for (var i= 0; i < numPlayers; i++){
        var newPlayerRow = document.getElementById("playerInfoTable").insertRow();
        var newPlayerName = newPlayerRow.insertCell();
        var pName = "player" + i;
        newPlayerName.innerHTML = "<tr><td><input type ='text' name='" + pName + "' required></td></tr>"
    }
    $("#playerNum").fadeOut("fast");
    $("#playerInfo").fadeIn("Slow");
    return false;
}
