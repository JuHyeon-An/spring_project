const nav = document.getElementsByClassName(".navbar-link");
const navItem = document.querySelector(".has-dropdown");
const CLICKED_CLASS = "is-active";

function init() {
  $(".navbar-link").click(function () {
    $(this).parent().toggleClass(CLICKED_CLASS);
  });
}

init();
