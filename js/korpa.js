//prodavnica kalkulacija
document.getElementById("proizvodi").addEventListener("submit", ukupanIznos);
function ukupanIznos(event) {
  event.preventDefault();

  var narPrvi = parseInt(document.getElementById("jedan").value, 10) || 0,
    narDrugi = parseInt(document.getElementById("dva").value, 10) || 0,
    narTreci = parseInt(document.getElementById("tri").value, 10) || 0,
    narCetvrti = parseInt(document.getElementById("cetiri").value, 10) || 0,
    narPeti = parseInt(document.getElementById("pet").value, 10) || 0,
    narSesti = parseInt(document.getElementById("sest").value, 10) || 0,
    narSedmi = parseInt(document.getElementById("sedam").value, 10) || 0,
    narOsmi = parseInt(document.getElementById("osam").value, 10) || 0,
    narDeveti = parseInt(document.getElementById("devet").value, 10) || 0,
    narDeseti = parseInt(document.getElementById("deset").value, 10) || 0,
    narJedanaesti = parseInt(document.getElementById("jedanaest").value, 10) || 0,
    narDvanaesti = parseInt(document.getElementById("dvanaest").value, 10) || 0;

  
    console.log(narPrvi);
    console.log(narDrugi);
    console.log(narTreci);
    
  
  var ukupnoProizvoda = narPrvi + narDrugi + narTreci + narCetvrti + narPeti + narSesti + narSedmi + narOsmi + narDeveti + narDeseti + narJedanaesti + narDvanaesti;

  var bezIsporuke = ((narPrvi * 40150) + (narDrugi * 40150) + (narTreci * 42350) + (narCetvrti * 42350) + (narPeti * 25300) + (narSesti * 25300) + (narSedmi * 71500) + (narOsmi * 71500) + (narDeveti * 64900) + (narDeseti * 70400) + (narJedanaesti * 70400) + (narDvanaesti * 70400));

  var izracunaj = "RSD: " + (bezIsporuke).toFixed(2);


  document.getElementById("txt-izracunaj").value = izracunaj;

  document.getElementById("rezultati").innerHTML = "Ukupno proizvoda: " + ukupnoProizvoda + "<br>";
  document.getElementById("rezultati1").innerHTML = "Da bi ste uspešno završili naručivanje morate biti prijavljeni. " + "<br>";

}