Egypt = {

    /* Here we've just got some global level vars that persist regardless of State swaps */
    score: 0,

    difficulty: 1,

    /* If the music in your game needs to play through-out a few State swaps, then you could reference it here */
    music: null,

    /* Your game can check Bomber.orientated in internal loops to know if it should pause or not */
    orientated: true

};

Egypt.Boot = function (game) {
};

Egypt.Boot.prototype = {

    preload: function () {

    },

    create: function () {
        console.log()
        this.game.state.start('Preloader');

    }

};
