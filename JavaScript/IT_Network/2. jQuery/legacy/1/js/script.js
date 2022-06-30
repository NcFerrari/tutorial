$(document).ready(function () {
    $("#result").click(function () {
        let firstNumber = $("#firstNumber").val();
        let secondNumber = $("#secondNumber").val();
        let result = parseInt(firstNumber) + parseInt(secondNumber);
        alert(result);
    });

    //https://api.jquery.com/category/events/

    $(window).on("click", function () {
        console.log("yes");
    });

    $(window).resize(function () {
        console.log(window.innerWidth, window.innerHeight);
    });

    $("#field").focus(function () {
        console.log("získán focus: " + $("#field").val());
    });

    $("#field").change(function () {
        console.log("změna focusu: " + $("#field").val());
    });

    $("#field").blur(function () {
        console.log("Ztráta focusu: " + $("#field").val());
    });

    $("#field").mouseenter(function () {
        console.log("MYŠKA!!");
    });

    $("#field").mouseleave(function () {
        console.log("myš je pryč");
    });

    $("#field").keydown(function () {
        console.log($("#field").val());
    });

    $("#field").keypress(function () {
        console.log($("#field").val());
    });

    $("#field").keyup(function () {
        console.log($("#field").val());
    });


});