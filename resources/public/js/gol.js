(function () {
  var w = 5,
      h = 5,
      r = 500,
      i = [w+1, w+2, (2*w)+1];
      s = build_world();

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
    return s[(c-1)]   + s[(c+1)]   +
           s[(c-w)]   + s[(c+w)]   +
           s[(c-w-1)] + s[(c-w+1)] +
           s[(c+w-1)] + s[(c+w+1)];
  }

  (function step() {
    for (var cell=0; cell<(w*h); cell++) {
      var sum = neighbours(cell);

      if (sum < 2 || sum > 3) {
        s[cell] = 0;
      } else if (sum == 2 || sum == 3) {
        s[cell] = 1;
      }
    }

    console.log(s)

    setTimeout(step, r);
  })();
}());
