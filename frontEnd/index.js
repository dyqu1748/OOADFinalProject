function showPlayNumberInput(){
    // Fade in the player number screen
    $("#titleScreen").fadeOut("fast");
    $("#playerNum").fadeIn("slow");
}

function showPlayInfoInput(){
    //Generate a table based on the number of players entered
    var numPlayers = document.getElementById("numPlayers").value;
    for (var i= 0; i < numPlayers; i++){
        var newPlayerRow = document.getElementById("playerInfoTable").insertRow();
        var newPlayerName = newPlayerRow.insertCell();
        var pName = "player" + i;
        //Each player will have to enter their name, select a car color, and select a gender
        newPlayerName.innerHTML = "<tr><td><input type ='text' name='" + pName + "' required></td>"
        newPlayerName = newPlayerRow.insertCell();
        newPlayerName.innerHTML = "<td><select name='colorChoice' id = 'colorChoice" + i + "' required><option hidden disabled selected value> -- select an color -- </option><option value='red'>Red</option><option value='green'>Green</option><option value='blue'>Blue</option><option value='yellow'>Yellow</option></select></td>";
        newPlayerName = newPlayerRow.insertCell();
        newPlayerName.innerHTML = "<td><select name ='genderChoice' id='genderChoice" + i + "' required><option hidden disabled selected value> -- select an gender -- </option><option value= 'male'>Male</option><option value = 'female'>Female</option></select></td></tr>";
    }
    //Fade out player number screen and fade in player info screen
    $("#playerNum").fadeOut("fast");
    $("#playerInfo").fadeIn("Slow");
    //Function to check that each player has a unique color selected. Runs every time a color dropdown value is changed
    $("select[name='colorChoice']").change(function () {

        if ($('select option[value="' + $(this).val() + '"]:selected').length > 1)
        {
            alert('This color has already been taken. Please choose another color.');
            //Reset value to the original null value
            $(this).prop("selectedIndex", 0);
        }
    });
    return false;
}