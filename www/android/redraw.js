var redraw = function() {
	cordova.exec(null, function(err) {
		/* error occured when cordova tried to call redraw */
		console.log("Error calling redraw: ", err);
	}, "Redraw", "redraw", []);
};

module.exports = redraw;