// populate career choice with the proper job choices depending on whether the player has a degree.
function careerChoices(){
    if (){
        var careers = ["Doctor","Lawyer","Programmer","Scientist"];        
    }
    else{
        var careers = ["Cashier","FastFoodWorker","MailMan","ConstructionWorker"];
    }
    var choices = document.getElementById("careerChoices");
    for (car of careers){
        choices.innerHTML += "<form><input type='text' id='careerName' name='careerName' value='"+ car +"' style='display: none;'><input type='submit' value='" + car + "'></form><br><br>"
    }
}