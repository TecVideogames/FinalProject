
Egypt.Preloader = function (game) {

	this.background = null;
	this.preloadBar = null;

	this.ready = false;

};

Egypt.Preloader.prototype = {

	preload: function () {

		// Menu principal
		this.load.image('imgBtnJugar', 'images/botonJugar.png');
		
		this.load.image('imgBtnInstrucciones', 'images/botonInstrucciones.png');
		
		this.load.image('imgBtnPuntuaciones', 'images/botonPuntuaciones.png');
	
		this.load.image('imgBtnCreditos', 'images/botonCreditos.png');
		
		/*this.load.spritesheet('particles', 'images/particles.png', 2, 2);
		this.load.spritesheet('city', 'images/city.png', 16, 16);
		this.load.bitmapFont('rollingThunder', 'images/rolling-thunder.png', 'images/rolling-thunder.xml');*/

	},

	create: function () {

		//this.state.start('MainMenu');

	},

	update: function () {

		// if (this.cache.isSoundDecoded('titleMusic') && this.ready == false)
		// {
			// this.ready = true;
			// this.state.start('MainMenu');
		// }
		this.game.state.start('MenuPrincipal');


	}

};
