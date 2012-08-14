function switchToLogin() {
	var element = document.getElementById("logCon");
	element.className = "log container";

	var registration = document.getElementById("regCon");
	registration.className += " hidden";
}

function switchToRegistration() {
	var registration = document.getElementById("regCon");
	registration.className = "reg container";

	var login = document.getElementById("logCon");
	login.className = "hidden";
}