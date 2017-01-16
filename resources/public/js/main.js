document.getElementById("projects").addEventListener("click", function(e) {
  e.preventDefault();

  var nav = document.getElementById("nav");
  var submenu = document.getElementById("submenu");

  if (nav.classList.contains("nav_large")) {
    nav.classList.remove("nav_large");
    submenu.style.height = "0";
    submenu.style.opacity = 0;
  } else {
    nav.classList.add("nav_large");
    submenu.style.height = "60px";
    submenu.style.opacity = 1.0;
  }
});

document.getElementById("contact").addEventListener("click", function(e) {
  var tweenable = new Tweenable(),
      contact = this,
      email = document.getElementById("swagmail");

  tweenable.tween({
    from: {opacity: 1.0},
    to: {opacity: 0.0},
    duration: 600,
    step: function(c){
      contact.style.opacity = c.opacity;
    },
    finish: function(){
      contact.style.display = "none";
      email.style.display = "block";

      tweenable.tween({
        from: {opacity: 0.0},
        to: {opacity: 1.0},
        duration: 600,
        step: function(c){
          email.style.opacity = c.opacity;
        }
      });
    }
  });

  return false;
});
