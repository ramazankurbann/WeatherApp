//document.querySelector('#getAll').addEventListener('click', getAll);

function getCityWeather(city){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var myArr = JSON.parse(this.responseText);
            //myFunction(myArr);
            console.log(myArr);
        }
    };
    xhttp.open('GET', 'http://localhost:8080/dailyweather/getCity/'+city);
    xhttp.send();
}

function loadHtml(id, filename){
    console.log(`div id: ${id}, filename: ${filename}`);

    var element = document.getElementById(id);

    if (filename){
        xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function (){
            if(this.readyState == 4){
                if(this.status == 200) {element.innerHTML = this.responseText;}
                if (this.status == 404) {element.innerHTML = "<h1>Page not Found.</h1>";}
            }
        }

        xhttp.open("GET",filename, true);
        xhttp.send();
    }
}

function createWeatherCard(){

    var div = document.createElement("div");
    div.style.width = "100px";
    div.style.height = "100px";
    div.style.background = "red";
    div.style.color = "white";
    div.innerHTML = "Hello";

    document.getElementById("main").appendChild(div);
}
