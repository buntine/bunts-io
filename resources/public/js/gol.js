(function () {
  var w  = 110,
      h  = 82,
      r  = 120,
      canvas = document.getElementById("gol"),
      context = canvas.getContext("2d"),
      cw,
      ch;

  window.addEventListener("resize", resizeCanvas, false);
  resizeCanvas();

  function resizeCanvas() {
    canvas.width  = window.innerWidth;
    canvas.height = window.innerHeight;
    cw = ((window.innerWidth - 10) / w).toFixed(1);
    ch = ((window.innerHeight - 10) / h).toFixed(1);
  }

  function build_world() {
    var world = [],
        alive;

    for (var n=0; n<(w*h); n++) {
      alive = (n % 4 == 0) || (n % 14 == 0);
      world.push(alive);
    }

    return world;
  }

  function neighbours(c, s) {
    return s[c-1]     + s[c+1]     +
           s[c-w]     + s[c+w]     +
           s[c-(w-1)] + s[c-(w+1)] +
           s[c+(w-1)] + s[c+(w+1)];
  }

  function draw(c) {
    var cx = c % w,
        cy = Math.trunc(c / h),
        x  = cw * cx,
        y  = ch * cy;

    context.beginPath();
    context.fillRect(x, y, cw, ch);
    context.fillStyle = "#eee";
    context.fill();
  }

  (function step(state) {
    var sum,
        new_state = [];

    context.clearRect (0, 0, canvas.width, canvas.height);

    for (var c=0; c<state.length; c++) {
      sum = neighbours(c, state);

      if (state[c] == 1) {
        draw(c);
      }

      if (state[c] == 1 && (sum < 2 || sum > 3)) {
        new_state[c] = 0;
      } else if ((state[c] == 1 && (sum == 2 || sum == 3)) || (state[c] == 0 && sum == 3)) {
        new_state[c] = 1;
      } else {
        new_state[c] = state[c];
      }
    }

    setTimeout(function(){step(new_state);}, r);
  })(build_world());
}());
