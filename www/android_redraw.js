var redraw = function() {
	cordova.exec(null, function(err) {
		/* error occured when cordova tried to call redraw */
		console.log("Error calling redraw: ", err);
	}, "Redraw", "redraw");
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