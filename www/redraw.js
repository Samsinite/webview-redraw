var redraw = function() {
	/* default to no-op */
}

if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.redraw) {
    window.plugins.redraw = redraw
}

if (module.exports) {
  module.exports = redraw;
}