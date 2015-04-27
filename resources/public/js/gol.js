(function () {
  var w = 110,
      h = 82,
      r = 50,
      cvs = document.getElementById("gol"),
      ctx = cvs.getContext("2d"),
      seed = [((w * 20) + 50), ((w * 21) + 52), ((w * 22) + 49),
             ((w * 22) + 50), ((w * 22) + 53), ((w * 22) + 54), ((w * 22) + 55)],
      glider = [0, (w + 1), (w + 2), (w * 2), (w * 2 + 1)],
      mixin = [],
      colours = gradient(),
      colour = 0,
      cw,
      ch;

  window.addEventListener("resize", resize_canvas, false);
  resize_canvas();
  inc_colour();

  document.getElementById("content").addEventListener("click", function(e) {
    var cell = cell_for(e.clientX, e.clientY);
    mixin = fjs.map(function(o) {return cell + o;}, glider)
  });

  function gradient() {
    var rgb,
        range = ["90e5fd", "0d7860"],
        length = 50,
        colours = [range[0]],
        to_i = function(s) {return parseInt(s, 16);},
        to_h = function(i) {return i.toString(16);},
        split_parts = function(s) {
          return fjs.map(function(i){
            return s.slice(i, i + 2);
          }, [0, 2, 4]);
        },
        merge = function(a, b){
          var merged = [];

          for (var i=0; i<a.length; i++){
            merged.push([a[i], b[i]]);
          }

          return merged;
        },
        steps = fjs.map(function(s){
          return parseInt((to_i(s[0]) - to_i(s[1])) / length);
        }, merge.apply(this, (fjs.map(split_parts, range))));

    while (colours.length < length) {
      rgb = merge(split_parts(colours[colours.length - 1]), steps);
      rgb = fjs.map(function(s){
        return to_h(to_i(s[0]) - s[1]);
      }, rgb);

      colours.push(rgb.join(""));
    }

    return colours;
  }

  function cell_for(x, y) {
    var cx = Math.round(x / cw),
        cy = Math.round(y / ch);
    return (Math.max(cy - 1, 0) * w) + cx;
  }

  function resize_canvas() {
    cvs.width = window.innerWidth;
    cvs.height = window.innerHeight;
    cw = Math.round(((window.innerWidth - 10) / w) * 100) / 100;
    ch = Math.round(((window.innerHeight - 10) / h) * 100) / 100;
  }

  function inc_colour() {
    var f;

    colour += 1;
    f = (colour >= colours.length) ? dec_colour : inc_colour;
    setTimeout(f, r);
  }

  function dec_colour() {
    var f;

    colour -= 1;
    f = (colour <= 0) ? inc_colour : dec_colour;
    setTimeout(f, r);
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
    var cx = c % w,
        cy = Math.trunc(c / w),
        x = cw * cx,
        y = ch * cy;

    ctx.beginPath();
    ctx.fillStyle = "#" + colours[colour];
    ctx.lineWidth = 1;
    ctx.strokeStyle = "#fff";
    ctx.fillRect(x, y, cw, ch);
    ctx.strokeRect(x, y, cw, ch);
  }

  (function step(state) {
    var sum,
        new_state = [],
        alive = 0;

    ctx.clearRect(0, 0, cvs.width, cvs.height);

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
      fjs.each(function(c){new_state[c] = 1;}, mixin);
      mixin = [];
    }

    setTimeout(function(){step(new_state);}, r);
  })(build_world());
}());
