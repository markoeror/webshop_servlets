$(function () {

        // automatski padajuci meni
        $("ul.nav li.dropdown").hover(function () {
                $(".dropdown-menu", this).fadeIn()
        }, function () {
                $(".dropdown-menu", this).fadeOut("fast")
        }) // hover prelaz
});



$(function () {
        // tooltip aktivacija
        $('[data-toggle="tooltip"]').tooltip()
})

function citati() {
        quotes = new Array(6);
        authors = new Array(6);
        quotes[0] = "Tko spava, nije budan.";
        authors[0] = "Alan Ford ";
        quotes[1] = "Ako vodimo računa o minutima, godine će brinuti same o sebi.";
        authors[1] = "Benjamin Franklin ";
        quotes[2] = "Vreme je tu dovoljno dugo za one koji su spremni da ga iskoriste.";
        authors[2] = "Leonardo da Vinci ";
        quotes[3] = "Vreme je vrednije od novca. Možete dobiti više novca, ali ne možete dobiti više vremena";
        authors[3] = "Jim Rohn ";
        quotes[4] = "Kaniš li pobjediti, ne smiješ izgubiti";
        authors[4] = "Broj 1 ";
        quotes[5] = "Bolje živjeti 100 godina kao milijunaš, nego 7 dana u bjedi.";
        authors[5] = "Bob Rock ";
        quotes[6] = "Mnogo ljudi ne brine oko svog novca sve dok ne nestane, a drugi isto to rade – sa svojim vremenom."
        authors[6] = "Gete ";
    
    
        index = Math.floor(Math.random() * quotes.length);
        document.getElementById("citat").innerHTML = quotes[index]
        document.getElementById("author").innerHTML = authors[index]
    }