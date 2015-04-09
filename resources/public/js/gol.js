(function () {
  var w      = 110,
      h      = 82,
      r      = 60,
      cvs    = document.getElementById("gol"),
      ctx    = cvs.getContext("2d"),
      seed   = [((w * 20) + 50), ((w * 21) + 52), ((w * 22) + 49),
             ((w * 22) + 50), ((w * 22) + 53), ((w * 22) + 54), ((w * 22) + 55)],
      glider = [0, (w + 1), (w + 2), (w * 2), (w * 2 + 1)],
      mixin  = [],
      start_colour = 9496061,
      end_colour   = 882784,
      colours = ["90E5FD", "8DE2F9", "8AE0F6", "87DEF3", "85DCF0", "82D9EC", "7FD7E9", "7DD5E6", "7AD3E3", "77D0E0", "75CEDC", "72CCD9", "6FCAD6", "6DC8D3", "6AC5D0", "67C3CC", "65C1C9", "62BFC6", "5FBCC3", "5DBAC0", "5AB8BC", "57B6B9", "55B4B6", "52B1B3", "4FAFB0", "4DADAC", "4AABA9", "47A8A6", "45A6A3", "42A4A0", "3FA29C", "3DA099", "3A9D96", "379B93", "359990", "32978C", "2F9489", "2D9286", "2A9083", "278E80", "258C7C", "228979", "1F8776", "1D8573", "1A8370", "17806C", "157E69", "127C66", "0F7A63", "0D7860"], // TODO: Generate this array from start_colour and end_colour. See Asciano.
      colour = 0,
      cw,
      ch;

  window.addEventListener("resize", resize_canvas, false);
  resize_canvas();
  inc_colour();

  document.getElementById("content").addEventListener("click", function(e) {
    var cell = cell_for(e.clientX, e.clientY);
    mixin = fjs.map(function(o) { return cell + o; }, glider)
  });

  function cell_for(x, y) {
    var cx = Math.round(x / cw),
        cy = Math.round(y / ch);
    return (Math.max(cy - 1, 0) * w) + cx;
  }

  function resize_canvas() {
    cvs.width  = window.innerWidth;
    cvs.height = window.innerHeight;
    cw = Math.round(((window.innerWidth - 10) / w) * 100) / 100;
    ch = Math.round(((window.innerHeight - 10) / h) * 100) / 100;
  }

  function inc_colour() {
    colour += 1;

    if (colour >= colours.length) {
      setTimeout(dec_colour, 100);
    } else {
      setTimeout(inc_colour, 100);
    }
  }

  function dec_colour() {
    colour -= 1;

    if (colour <= 0) {
      setTimeout(inc_colour, 100);
    } else {
      setTimeout(dec_colour, 100);
    }
  }

  function build_world() {
    var world = [];

    for (var n=0; n<(w*h); n++) {
      world.push(seed.indexOf(n) > -1 ? 1 : 0);
    }

    return world;
  }

  function neighbours(c, s) {
    return s[c-1]   + s[c+1]   +
           s[c-w]   + s[c+w]   +
           s[c-w-1] + s[c-w+1] +
           s[c+w-1] + s[c+w+1];
  }

  function draw(c) {
    var cx     = c % w,
        cy     = Math.trunc(c / w),
        x      = cw * cx,
        y      = ch * cy;

    ctx.beginPath();
    ctx.fillStyle   = "#" + colours[colour];
    ctx.lineWidth   = 1;
    ctx.strokeStyle = "#fff";
    ctx.fillRect(x, y, cw, ch);
    ctx.strokeRect(x, y, cw, ch);
  }

  (function step(state) {
    var sum,
        new_state = [],
        alive = 0;

    ctx.clearRect (0, 0, cvs.width, cvs.height);

    for (var c=0; c<state.length; c++) {
      sum = neighbours(c, state);

      if (state[c] == 1) {
        alive += 1;
        draw(c);
      }

      if (sum == 2) {
        new_state[c] = state[c];
      } else if (sum == 3) {
        new_state[c] = 1;
      } else {
        new_state[c] = 0;
      }
    }

    if (mixin.length > 0) {
      fjs.each(function(c){ new_state[c] = 1; }, mixin);
      mixin = [];
    }

    setTimeout(function(){step(new_state);}, r);
  })(build_world());
}());
