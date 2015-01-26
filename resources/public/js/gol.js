(function () {
  var w  = 50,
      h  = 50,
      cw = Math.round(document.body.clientWidth / w);
      ch = Math.round(document.body.clientHeight / h);
      r  = 5000,
      i  = [(4*w)+4, (5*w)+4, (6*w)+4, (6*w)+3, (5*w)+2],
      s  = build_world();

  function build_world() {
    var world = [],
        alive;

    for (var n=0; n<(w*h); n++) {
      alive = i.indexOf(n) > 0 ? 1 : 0;
      world.push(alive);
    }

    return world;
  }

  function neighbours(c) {
    return s[c-1]   + s[c+1]   +
           s[c-w]   + s[c+w]   +
           s[c-w-1] + s[c-w+1] +
           s[c+w-1] + s[c+w+1];
  }

  function clearWorld() {
    var cells = document.getElementsByClassName('cell');

    while(cells[0]) {
      cells[0].parentNode.removeChild(cells[0]);
    }
  }

  function draw(c) {
    var cx = c % w,
        cy = Math.round(c / h),
        x  = cw * cx,
        y  = ch * cy;

    document.write("<div class='cell' style='position:absolute;top:" + y + "px;left:" + x + "px;width:" + cw + "px;height:" + ch + ";background-color: #ccc;'>" + c + "</div>");
  }

  (function step() {
    var sum;

    clearWorld();

    for (var cell=0; cell<(w*h); cell++) {
      sum = neighbours(cell);
if (cell == 609) {
console.log(sum);
}

      if (sum < 2 || sum > 3) {
        s[cell] = 0;
      } else if (sum == 2 || sum == 3) {
        s[cell] = 1;
        draw(cell);
      }
    }

    setTimeout(step, r);
  })();
}());
