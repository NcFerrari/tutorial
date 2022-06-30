$(function () {
    // html()
    // text()
    // získat html nebo text

    let source = $("#vkladani .one");
    $("#vkladani .two").html(source.html());
    $("#vkladani .three").text(source.text());
    $("#vkladani .four").text(source.html());

    // append()
    // appendTo()
    // přidat za element

    $("#vkladani .three").append("<b>Ahoj, já jsem APPENDED</b>");
    $("<i>Ahoj, já jsem APPENDEDTO</i>").appendTo($("#vkladani .three"));
    $($("#vkladani .two").html()).appendTo($("#vkladani .three"));

    // prepend()
    // prependTo()
    // přidat před element

    $("#vkladani .one").prepend("<b>Ahoj, já jsem PREPENDED</b>");
    $("<i>Ahoj, já jsem PREPENDEDTO</i>").prependTo($("#vkladani .three"));

    // after()
    // insertAfter()

    $("#vkladani .one").after("<div id='pres_after'>Ahoj, jsem vložený přes <b>.after()</b></div>");
    $("#pres_after").insertAfter($("#vkladani .three"));

    // wrap()
    $("#vkladani .one").wrap("<div><b></b></div>");
});