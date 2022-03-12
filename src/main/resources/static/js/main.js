$('.plus-money').on("click", function(e){
    e.preventDefault();

    let calUrl = "/calculator";
    let calOption = "width=400px, height=700px, scrollbars=yes, left=700px, top=280px;";

    window.open(calUrl, "계산기 팝업", calOption)
})