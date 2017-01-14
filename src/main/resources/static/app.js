var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/character", {}, JSON.stringify({
        "name": $("#name").val(),
        "species": "Human",
        "career": "Bounty Hunter",
        "specializationTrees": "Doctor",
        "avatar": "http://empire-legends.herokuapp.com/public/gfx/pash.png",
        "currentXP": 0,
        "totalXP": 0,
        "soak": 0,
        "currentWounds": 0,
        "totalWounds": 0,
        "currentStrain": 0,
        "totalStrain": 0,
        "defense": 0,
        "brawn": 3,
        "agility": 3,
        "intellect": 3,
        "cunning": 3,
        "willpower": 3,
        "presence": 3,
        "gender": "",
        "age": 18,
        "height": "",
        "eyes": "",
        "hair": "",
        "other": "",
        "credits": 0,
        "equipments": "",
        "skills": [{"name": "SKILLNAME", "career": false, "rank": 0}],
        "weapons": [{
            "name": "WEAPON",
            "skill": "WEAPONSKILL",
            "special": "WEAPONSPECIAL",
            "range": "",
            "damages": 2,
            "critique": 0,
            "HP": 0,
            "mods": "WEAPONMODS"
        }],
        "talents": [{"name": "TALENTNAME", "summary": "TALENTSUMMARY"}],
        "achievements": "21-",
        "selectedAchievement": 0,
        "world": "",
        "encumbrance": "",
        "force": 0,
        "$$hashKey": "006",
        "background": "BACKGROUND",
        "obligations": "OBLIGATIONS",
        "motivations": "MOTIVATIONS"
    }));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });
});