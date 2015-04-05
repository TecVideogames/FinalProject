
Egypt.MenuPrincipal = function (game) {

	this.background = null;
	// boton de jugar
	this.btnJugar = null;
	this.sprBtnJugar = null;
	// boton de instrucciones
	this.btnInstrucciones = null;
	this.sprBtnInstrucciones = null;
	// boton de puntuaciones
	this.btnPuntuaciones = null;
	this.sprBtnPuntuaciones = null;
	// boton de creditos
	this.btnCreditos = null;
	this.sprBtnCreditos = null;

};

Egypt.MenuPrincipal.prototype = {

	preload : function () {
		this.sprBtnJugar = this.game.load.spritesheet('sprBtnJugar', 'images/botonJugar.png', 195, 50);
		this.sprBtnJugar = this.game.load.spritesheet('sprBtnInstrucciones', 'images/botonInstrucciones.png', 195, 50);
		this.sprBtnJugar = this.game.load.spritesheet('sprBtnPuntuaciones', 'images/botonPuntuaciones.png', 195, 50);
		this.sprBtnJugar = this.game.load.spritesheet('sprBtnCreditos', 'images/botonCreditos.png', 195, 50);
	},

	create: function () {
		//this.preloadBar = this.add.sprite(0, 100, 'preloaderBar');
		//this.state.start('MainMenu');

		this.btnJugar = this.game.add.button(405,150,"sprBtnJugar",this.iniciarJuego,self,0,1);
		this.btnJugar = this.game.add.button(405,215,"sprBtnInstrucciones",this.iniciarJuego,self,0,1);
		this.btnJugar = this.game.add.button(405,280,"sprBtnPuntuaciones",this.iniciarJuego,self,0,1);
		this.btnJugar = this.game.add.button(405,345,"sprBtnCreditos",this.iniciarJuego,self,0,1);
		/*this.btnJugar.events.onInputOut.add(function(){
			this.btnJugar.key = "imgBtnJugar";
		},this);
		this.btnJugar.events.onInputOver.add(function(){
			this.btnJugar.key = "imgBtnJugarHover";
		},this);*/

	},

	iniciarJuego : function () {

		//this.game.state.start('MenuPrincipal');
		console.log("WOW");

	}

};
