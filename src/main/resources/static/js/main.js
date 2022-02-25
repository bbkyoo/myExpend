$('.plus-money').on("click", function(e){
    e.preventDefault();

    let calUrl = "/calculator";
    let calOption = "width=400px, height=700px, scrollbars=yes;"

    window.open(calUrl, "계산기 팝업",calOption)
})