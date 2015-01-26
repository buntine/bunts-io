(function () {
  var w  = 100,
      h  = 100,
      cw = Math.round(document.body.clientWidth / w);
      ch = Math.round(document.body.clientHeight / h);
      r  = 100,
      i  = [1045, 1145, 1046, 1047, 1048, 1148, 1248, 1348];

  function build_world() {
    var world = [],
        alive;

    for (var n=0; n<(w*h); n++) {
      alive = i.indexOf(n) >= 0 ? 1 : 0;
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

  function clearWorld() {
    var cells = document.getElementsByClassName('cell');

    while(cells[0]) {
      cells[0].parentNode.removeChild(cells[0]);
    }
  }

  function draw(c) {
    var cx = c % w,
        cy = Math.trunc(c / h),
        x  = cw * cx,
        y  = ch * cy;

    document.write("<div class='cell' style='position:absolute;top:" + y + "px;left:" + x + "px;width:" + cw + "px;height:" + ch + ";background-color: #ccc;'></div>");
  }

  (function step(state) {
    var sum,
        new_state = [];

    clearWorld();

    for (var cell=0; cell<state.length; cell++) {
      sum = neighbours(cell, state);
      if (state[cell] == 1 && (sum < 2 || sum > 3)) {
        new_state[cell] = 0;
      } else if ((state[cell] == 1 && (sum == 2 || sum == 3)) || (state[cell] == 0 && sum == 3)) {
        new_state[cell] = 1;
        draw(cell);
      } else {
        new_state[cell] = state[cell];
      }
    }
    setTimeout(function(){step(new_state);}, r);
  })(build_world());
}());
