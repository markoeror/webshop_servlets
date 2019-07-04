// test_poruka = /^[ -~\n]{1,800}$/; ovo bi trebalo da radi za polje za poruku
function proveri() {
	let testIme = /^[a-zA-Z '-]{2,32}$/g
	let testMail = /^[a-z0-9]+_?([.]?[a-z0-9]+)*@[a-z0-9]+[.-]?[a-z0-9]+\.[a-z]{2,5}$/g
	let testTel = /^0\d\d\/\d{3}-\d{3,4}$/g
/* 	let testWeb = /^(https?(:\/\/))?www\.[a-z0-9]+[-.]?[a-z0-9]+\.[a-z]{2,7}$/g */

	let testPass = /^[\d\w]{8,}$/g



	let ime = document.formular.ime.value;
	let prezime = document.formular.prezime.value;
	let email = document.formular.email.value;
	let telefon = document.formular.telefon.value;
	/* let web = document.formular.web.value; */
	let password = document.formular.password.value;
	let password1 = document.formular.password1.value;


	let rezultatIme = ime.match(testIme);
	let rezultatPrezime = prezime.match(testIme);
	let rezultatMail = email.match(testMail);
	let rezultatTel = telefon.match(testTel);
	/* let rezultatWeb = web.match(testWeb); */
	let rezultatPass = password.match(testPass);
	let rezultatPass1 = password1.match(testPass)



	if (rezultatIme == null) {
		alert("Ime nije ok!");
		document.formular.ime.focus();
	}
	else if (rezultatPrezime == null) {
		alert("Prezime nije ok!");
		document.formular.prezime.focus();
	}
	else if (rezultatMail == null) {
		alert("E-mail nije ok!");
		document.formular.email.focus();
	}
	else if (rezultatTel == null) {
		alert("Telefon nije ok!");
		document.formular.telefon.focus();
	}

	else if (rezultatPass == null) {
		alert("Password nije ok!");
		document.formular.password.focus();
	}
	else if (rezultatPass1 == rezultatPass) {
		alert("Password nije potvrđen!");
		document.formular.password.focus();
	}
	else {
		document.formular.POŠALJI();
		window.open("odgovor.html");
		document.formular.reset();
	}
};

function closeOnLoad() {
	setTimeout(function () {
		window.close();
	},
		5000
	);
};
