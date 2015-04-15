/**
 * FinalProject
 * 
 * Main program for the game's execution
 * 
 * Game Description: 
 * 
 * @authors Marco Antonio César Peyrot Carrión  A00815262
 *          Mario Sergio Fuentes Juarez         A01036141
 *          Omar Manjarrez Osornio              A00815248
 * 
 * @version 1.0
 * @date 06/ABR/2015
 */

package finalproject;
 
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;

public class FinalProject extends Applet implements Runnable, KeyListener, 
        MouseListener, MouseMotionListener {
    
    // Game global variables
    int iMouseX; // Mouse pointer position in the x axis
    int iMouseY; // Mouse pointer position in the y axis
    int iMouseReleasedX; // Mouse pointer position in the x axis when released
    int iMouseReleasedY; // Mouse pointer position in the y axis when released
    int iAppletWidth = 640; // Applet's width
    int iAppletHeight = 480; // Applet's height
    int iDificultad; // Game difficulty
    char chPantallaDungeon;
    boolean boolPresionado; // Check if mouse is pressed
    boolean boolHombreMujer; // Male or female player selected
    boolean boolSonidoMusica; // Activate music
    boolean boolSonidoEfectos; // Activate special effects
    boolean bPaused;
    private String strPantalla; // Screens
    private Image imaImagenApplet;   // Image to be proyected in the applet
    private Image imaImagenMenuPrincipal; //Image to be proyected in the left
                                          //side of the principal menu
    private Image imaTituloMenuPrincipal; //Image to be proyected on the top of
                                          //the principal menu
    private Graphics graGraficaApplet;  // Graphic object of the applet
    private Sat_VisualObject vioTxtAudio; // ViObject for audio text
    private Sat_VisualObject vioTxtCreditos; // ViObject for creditos text
    private Sat_VisualObject vioTxtDificultad; // ViObject for dificutad text
    private Sat_VisualObject vioTxtInstrucciones; // ViObject for instr. text
    private Sat_VisualObject vioTxtOpciones; // ViObject for opciones text
    private Sat_VisualObject vioTxtSelecciona; // ViObject for selecciona text
        
    // TEMPORALS
    private Sat_Player satPlayer[] = new Sat_Player[4]; // Player object
    private Sat_Player satMummy[] = new Sat_Player[4]; // Mummy object
        
    // button array for main menu
    private msf_Button arrBtnMenuPrincipal [] = new msf_Button [3]; 
    private String arrStrMenuPrincipal [][] = new String [3][2];
    
    // button array for options menu
    private msf_Button arrBtnMenuOpciones [] = new msf_Button [3]; 
    private String arrStrMenuOpciones [][] = new String [3][2];
    
    // button array for audio menu
    private msf_Button arrBtnMenuAudio [] = new msf_Button [3]; 
    private String arrStrMenuAudio [][] = new String [3][2];
    
    // button array for difficulty menu
    private msf_Button arrBtnMenuDificultad [] = new msf_Button [4]; 
    private String arrStrMenuDificultad [][] = new String [4][2];
    
    // button for returning from instructions menu
    private msf_Button btnRegresarInstrucciones;
    private String strBtnRegresarInstrucciones [] = new String [2];
    
    // button for returning from credits menu
    private msf_Button btnRegresarCreditos;
    private String strBtnRegresarCreditos [] = new String [2];
    
    // button array for player selection menu
    private msf_Button arrBtnSeleccionarJugador [] = new msf_Button [4]; 
    private String arrStrSeleccionarJugador [][] = new String [4][2];
    
    // button array for map menu
    private msf_Button arrBtnMapa [] = new msf_Button [5]; 
    private String arrStrMapa [][] = new String [5][2];
    
    // button array for in-game menu
    private msf_Button arrBtnJuego [] = new msf_Button [4]; 
    private String arrStrJuego [][] = new String [4][2];
    
    // button for returning from win or loose menu
    private msf_Button btnFinMapa;
    private String strBtnFinMapa;
    
    // button array for options menu
    private msf_Button arrBtnOpciones [] = new msf_Button [3];
    private String arrStrOpciones [][] = new String[3][2];
    
    // button array for dungeon options menu
    private msf_Button arrBtnDungeonOptions [] = new msf_Button [4];
    private String arrStrDungeonOptions [][] = new String[4][2];
    
    // Dungeon logical setup
    private Sat_Dungeon dunTomb;
    
    // Structure image array
    private String arrStrStructures [] = new String[7];
    private Sat_Structure arrSttStructures [] = new Sat_Structure[7];
	
    /** 
     * init
     * 
     * Overwritten method from class <code>Applet</code>.<P>
     * Used to initialize variables, objects and functionality
     */
    public void init() {
        // make applet of size 640,480        
        setSize(iAppletWidth, iAppletHeight);
        
        // Initialize bPaused flag
        bPaused = false;
        
        // main screen name
        strPantalla = "menuPrincipal";
        
        // bool pressed
        boolPresionado = false;
        
        // initialization of difficulty
        iDificultad = 0;
        
        // initialization of screen
        chPantallaDungeon = 'j';
        
        // initialization of screens titles
        vioTxtAudio = new msf_VioObject(249,20,143,90,"txtAudio.png");
        vioTxtCreditos = new msf_VioObject(220,20,199,90,"txtCreditos.png");
        vioTxtDificultad = new msf_VioObject(207,20,226,90,"txtDificultad.png");
        vioTxtInstrucciones = new msf_VioObject(170,20,301,90,"txtInstrucciones.png");
        vioTxtOpciones = new msf_VioObject(210,20,220,90,"txtOpciones.png");
        vioTxtSelecciona = new msf_VioObject(40,20,560,90,"txtSeleccionaUnPersonaje.png");        
//        private Sat_VisualObject vioTxtCreditos; // ViObject for creditos text
//        private Sat_VisualObject vioTxtDificultad; // ViObject for dificutad text
//        private Sat_VisualObject vioTxtInstrucciones; // ViObject for instr. text
//        private Sat_VisualObject vioTxtOpciones; // ViObject for opciones text
//        private Sat_VisualObject vioTxtSelecciona; // ViObject for selecciona text
        
        // released
        iMouseReleasedX = -1;
        iMouseReleasedY = -1;
        
        // initialize sound booleans
        boolSonidoMusica = true;
        boolSonidoEfectos = true;
        
        // Initialize visual object for screen titles
                
        // TEMPORALS for gifs
        for (int iI = 0; iI < 4; iI ++) {
            satPlayer[iI] = new Sat_Player();
            satPlayer[iI].setIPosX((250 + 49 * iI));
            satPlayer[iI].setIPosY(110);
        }
        
        for (int iI = 0; iI < 2; iI ++) {
            satMummy[iI] = new Sat_Player();
            satMummy[iI].setIPosX((250 + 49 * iI));
            satMummy[iI].setIPosY(240);
        }
        
        for (int iI = 0; iI < 2; iI ++) {
            satPlayer[iI].setImageIcon("sprite_mujer_" + iI + ".png", 49, 116);
            satMummy[iI].setImageIcon("sprite_momia_" + iI + ".gif", 49, 116);
            //satMummy[iI].setImageIcon("ImageNotFound.jpg", 49, 116);
        }
        
        for (int iI = 2; iI < 4; iI ++) {
            satPlayer[iI].setImageIcon("sprite_mujer_" + iI + ".gif", 49, 116);
            //satPlayer[iI].setImageIcon("ImageNotFound.jpg", 49, 116);
        }
        
        // Initialize main menu
        for (int iI = 0; iI < 3; iI ++) {
            arrStrMenuPrincipal[iI][0] = "btnMenuPrincipal_" + iI + "_0.png";
            arrStrMenuPrincipal[iI][1] = "btnMenuPrincipal_" + iI + "_1.png";
            arrBtnMenuPrincipal[iI] = new msf_Button(405, 180 + iI * 65,
                    190, 50, arrStrMenuPrincipal[iI][0]);
        }
        
        //Initialize image of the left side
        URL urlImagenMenuPrincipal = this.getClass().getResource
                ("imaMenuPrincipal.png");
        imaImagenMenuPrincipal = Toolkit.getDefaultToolkit().getImage
                (urlImagenMenuPrincipal);
        URL urlTextoMenuPrincipal = this.getClass().getResource
                ("txtMenuPrincipal.png");
        imaTituloMenuPrincipal = Toolkit.getDefaultToolkit().getImage
                (urlTextoMenuPrincipal);
        
        // Initialize instruccions return button
        strBtnRegresarInstrucciones[0] = "btnInstrucciones_0.png";
        strBtnRegresarInstrucciones[1] = "btnInstrucciones_1.png";
        btnRegresarInstrucciones = new msf_Button(229, 425, 182, 49, 
                strBtnRegresarInstrucciones[0]);
        
        // Initialize credits return button
        strBtnRegresarCreditos[0] = "btnCreditos_0.png";
        strBtnRegresarCreditos[1] = "btnCreditos_1.png";
        btnRegresarCreditos = new msf_Button(229, 425, 182, 49, 
                strBtnRegresarCreditos[0]);
        
        // Select Player
        
        // zero indicates male selection, one indicates woman selection
        boolHombreMujer = false;
        // player button

        // male button (originally chosen)
        arrStrSeleccionarJugador[0][0] = "btnSeleccionarJugador_0_0.png";
        // OJO CAMBIE EL INDICE!!!!!
        arrStrSeleccionarJugador[0][1] = "btnSeleccionarJugador_0_1.png";
        arrBtnSeleccionarJugador[0] = new msf_Button(85, 120,
                200, 180, arrStrSeleccionarJugador[0][1]);
        // woman button (originally not chosen)
        arrStrSeleccionarJugador[1][0] = "btnSeleccionarJugador_1_0.png";
        arrStrSeleccionarJugador[1][1] = "btnSeleccionarJugador_1_1.png";
        arrBtnSeleccionarJugador[1] = new msf_Button(360, 120,
                200, 180, arrStrSeleccionarJugador[1][0]);
        
        // navigation button
        for(int iI = 2; iI < 4; iI ++) {
            arrStrSeleccionarJugador[iI][0] = 
                    "btnSeleccionarJugador_" + iI + "_0.png";
            arrStrSeleccionarJugador[iI][1] = 
                    "btnSeleccionarJugador_" + iI + "_1.png";
            arrBtnSeleccionarJugador[iI] = new msf_Button(133 + (iI - 2) * 192,
                    425, 182, 49, arrStrSeleccionarJugador[iI][0]);
        }
        
        // Initialize map
        // navigation buttons
        for(int iI = 0; iI < 2; iI ++) {
            arrStrMapa[iI][0] = "btnMapa_" + iI + "_0.png";
            arrStrMapa[iI][1] = "btnMapa_" + iI + "_1.png";
            arrBtnMapa[iI] = new msf_Button(133 + iI * 192, 425,
                    182, 49, arrStrMapa[iI][0]);
        }
        // Dungeon buttons
        for(int iI = 2; iI < 5; iI ++){
            arrStrMapa[iI][0] = "btnMapa_" + iI + "_0.png";
            arrStrMapa[iI][1] = "btnMapa_" + iI + "_1.png";
        }
        
        // All dungeon buttons have a specific location
        arrBtnMapa[2] = new msf_Button(25,20,
                    212,100,arrStrMapa[2][0]);
        arrBtnMapa[3] = new msf_Button(iAppletWidth - 235, 130,
                    212,100,arrStrMapa[3][0]);
        arrBtnMapa[4] = new msf_Button(iAppletWidth - 580, 250,
                    212,100,arrStrMapa[4][0]);
       
        // menu button
        arrStrDungeonOptions[0][0] = "btnDungeon_" + 0 + "_0.png";
            arrStrDungeonOptions[0][1] = "btnDungeon_" + 0 + "_1.png";
            arrBtnDungeonOptions[0] = new msf_Button(5, 435,
                    150, 40, arrStrDungeonOptions[0][0]);
       
        // buttons inside menu
        for (int iI = 1; iI < 4; iI ++) {
            arrStrDungeonOptions[iI][0] = "btnDungeon_" + iI + "_0.png";
            arrStrDungeonOptions[iI][1] = "btnDungeon_" + iI + "_1.png";
            arrBtnDungeonOptions[iI] = new msf_Button(312, 208 + 75 * (iI - 2),
                    182, 49, arrStrDungeonOptions[iI][0]);
        }      
        
        // option buttons
        for(int iI = 0 ; iI < 2 ; iI ++) {
            arrStrOpciones[iI][0] = "btnMenuOpciones_" + iI + "_0.png";
            arrStrOpciones[iI][1] = "btnMenuOpciones_" + iI + "_1.png";
            arrBtnOpciones[iI] = new msf_Button(229, 150 + iI * 65, 182, 49, 
                    arrStrOpciones[iI][0]);
        }
        // navigation button (return, 3)
        arrStrOpciones[2][0] = "btnMenuOpciones_" + 2 + "_0.png";
        arrStrOpciones[2][1] = "btnMenuOpciones_" + 2 + "_1.png";
        arrBtnOpciones[2] = new msf_Button(133, 425,
                182, 49, arrStrOpciones[2][0]);
        
        // Initialize difficulty menu
        // difficulty buttons
        arrStrMenuDificultad[0][0] = "btnMenuDificultad_" + 0 + "_0.png";
        arrStrMenuDificultad[0][1] = "btnMenuDificultad_" + 0 + "_1.png";
        arrBtnMenuDificultad[0] = new msf_Button(229, 150, 182, 49, 
                arrStrMenuDificultad[0][1]);
        
        for(int iI = 1 ; iI < 3 ; iI ++) {
            arrStrMenuDificultad[iI][0] = "btnMenuDificultad_" + iI + "_0.png";
            arrStrMenuDificultad[iI][1] = "btnMenuDificultad_" + iI + "_1.png";
            arrBtnMenuDificultad[iI] = new msf_Button(229, 150 + iI * 65, 182,
                    49, arrStrMenuDificultad[iI][0]);
        }
        
        // return button
        arrStrMenuDificultad[3][0] = "btnMenuDificultad_" + 3 + "_0.png";
        arrStrMenuDificultad[3][1] = "btnMenuDificultad_" + 3 + "_1.png";
        arrBtnMenuDificultad[3] = new msf_Button(133, 425,
                182, 49, arrStrMenuDificultad[3][0]);
        
        // Initialize audio menu
        // audio buttons
        for(int iI = 0 ; iI < 2 ; iI ++) {
            arrStrMenuAudio[iI][0] = "btnMenuAudio_" + iI + "_0.png";
            arrStrMenuAudio[iI][1] = "btnMenuAudio_" + iI + "_1.png";
            arrBtnMenuAudio[iI] = new msf_Button(130 + 260 * iI, 200, 100, 100, 
                    arrStrMenuAudio[iI][0]);
        }
        // return button
        arrStrMenuAudio[2][0] = "btnMenuAudio_" + 2 + "_0.png";
        arrStrMenuAudio[2][1] = "btnMenuAudio_" + 2 + "_1.png";
        arrBtnMenuAudio[2] = new msf_Button(133, 425,
                182, 49, arrStrMenuAudio[2][0]);

        // Dungeon Structures
        for(int iI = 1; iI < 4; iI ++) {
            arrStrStructures[iI] = "room_type" + iI + ".png";
            arrSttStructures[iI] = new Sat_Structure();
            arrSttStructures[iI].setImageIcon(arrStrStructures[iI], 449, 440);
        }
        for(int iI = 4; iI < 7; iI ++) {
            arrStrStructures[iI] = "hall_type" + (iI - 3) + ".png";
            arrSttStructures[iI] = new Sat_Structure();
            arrSttStructures[iI].setImageIcon(arrStrStructures[iI], 449, 440);
        }
              
        // Add mouse listening capability
	addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);     
    }
	
    /** 
     * start
     * 
     * Overwritten method from class <code>Applet</code>.<P>
     * In this method the thread for the animation is created and i initialized
     * this method is called after the init or when the user visits another page
     * and then returns
     * 
     */
    public void start () {
        // declare the thread
        Thread th = new Thread (this);
        // start the thread
        th.start ();
    }
	
    /** 
     * run
     * 
     * Overwritten method from class <code>Thread</code>.<P>
     * In this method the thread is executed, which contains the game's
     * instructions
     */
    public void run () {     
        // Infinite game loop
        while (true) { 
            actualiza();
            checaColision();
            repaint();
            try	{
                // the thread sleeps
                Thread.sleep (70);
            }
            catch (InterruptedException iexError) {
                System.out.println("Game Error " + 
                        iexError.toString());
            }
	}
    }
	
    /** 
     * actualiza
     * 
     * Method used for updating objects position, behavior and status
     * 
     */
    public void actualiza() {
        
        // Update main menu options
        switch (strPantalla) {
            case "menuPrincipal":
                for (int iI = 0; iI < 3; iI ++) {
                    if (arrBtnMenuPrincipal[iI].pointerInside(iMouseX,iMouseY)){

                        arrBtnMenuPrincipal[iI].setImageIcon(
                                arrStrMenuPrincipal[iI][1],
                                arrBtnMenuPrincipal[iI].getWidth(),
                                arrBtnMenuPrincipal[iI].getHeight());

                        if(arrBtnMenuPrincipal[iI].pointerInside(
                                iMouseReleasedX,iMouseReleasedY)){
                            switch (iI) {
                                case 0:
                                    strPantalla = "seleccionarJugador";
                                    iMouseReleasedX = -1;
                                    iMouseReleasedY = -1;
                                    break;
                                case 1:
                                    strPantalla = "instruccions";
                                    iMouseReleasedX = -1;
                                    iMouseReleasedY = -1;
                                    break;
                                case 2:
                                    strPantalla = "credits";
                                    iMouseReleasedX = -1;
                                    iMouseReleasedY = -1;
                                    break;
                            }
                            arrBtnMenuPrincipal[iI].setImageIcon(
                                    arrStrMenuPrincipal[iI][0],
                                arrBtnMenuPrincipal[iI].getWidth(),
                                arrBtnMenuPrincipal[iI].getHeight());
                        }
                    } else {
                        arrBtnMenuPrincipal[iI].setImageIcon(
                                arrStrMenuPrincipal[iI][0],
                                arrBtnMenuPrincipal[iI].getWidth(),
                                arrBtnMenuPrincipal[iI].getHeight());
                    }
                }
                break;
            case "seleccionarJugador":

                // Check player selection
                // Male button
                if (arrBtnSeleccionarJugador[0].pointerInside(iMouseX, iMouseY)
                        && arrBtnSeleccionarJugador[0].pointerInside(
                                iMouseReleasedX, iMouseReleasedY) && 
                        boolHombreMujer) {
                    // update boolean
                    boolHombreMujer = !boolHombreMujer;
                    // mark man selection
                    arrBtnSeleccionarJugador[0].setImageIcon(
                            arrStrSeleccionarJugador[0][1],
                            arrBtnSeleccionarJugador[0].getWidth(),
                            arrBtnSeleccionarJugador[0].getHeight());
                    // unmark woman selection
                    arrBtnSeleccionarJugador[1].setImageIcon(
                            arrStrSeleccionarJugador[1][0],
                            arrBtnSeleccionarJugador[1].getWidth(),
                            arrBtnSeleccionarJugador[1].getHeight());
                }
                // Woman button
                if (arrBtnSeleccionarJugador[1].pointerInside(iMouseX, iMouseY)
                        && arrBtnSeleccionarJugador[1].pointerInside(
                                iMouseReleasedX,iMouseReleasedY) &&
                        !boolHombreMujer) {
                    // update boolean
                    boolHombreMujer = !boolHombreMujer;
                    // mark woman selection
                    arrBtnSeleccionarJugador[1].setImageIcon(
                            arrStrSeleccionarJugador[1][1],
                            arrBtnSeleccionarJugador[1].getWidth(),
                            arrBtnSeleccionarJugador[1].getHeight());
                    // unmark man selection
                    arrBtnSeleccionarJugador[0].setImageIcon(
                            arrStrSeleccionarJugador[0][0],
                            arrBtnSeleccionarJugador[0].getWidth(),
                            arrBtnSeleccionarJugador[0].getHeight());
                }
                // Check navigation buttons
                for(int iI = 2; iI < 4; iI ++) {
                    if (arrBtnSeleccionarJugador[iI].pointerInside(iMouseX, 
                            iMouseY)) {
                        arrBtnSeleccionarJugador[iI].setImageIcon(
                                arrStrSeleccionarJugador[iI][1],
                                arrBtnSeleccionarJugador[iI].getWidth(),
                                arrBtnSeleccionarJugador[iI].getHeight());

                        if (arrBtnSeleccionarJugador[iI].pointerInside(
                                iMouseReleasedX, iMouseReleasedY)) {
                            switch (iI) {
                                case 2:
                                    strPantalla = "menuPrincipal";
                                    iMouseReleasedX = -1;
                                    iMouseReleasedY = -1;
                                    break;
                                case 3:
                                    strPantalla = "mapa";
                                    iMouseReleasedX = -1;
                                    iMouseReleasedY = -1;
                                    break;
                            }
                            boolHombreMujer = false;
                            arrBtnSeleccionarJugador[0].setImageIcon(
                                    arrStrSeleccionarJugador[0][1],
                                arrBtnSeleccionarJugador[0].getWidth(),
                                arrBtnSeleccionarJugador[0].getHeight());
                            arrBtnSeleccionarJugador[1].setImageIcon(
                                    arrStrSeleccionarJugador[1][0],
                                arrBtnSeleccionarJugador[1].getWidth(),
                                arrBtnSeleccionarJugador[1].getHeight());
                        }
                    } else {
                        arrBtnSeleccionarJugador[iI].setImageIcon(
                                arrStrSeleccionarJugador[iI][0],
                                arrBtnSeleccionarJugador[iI].getWidth(),
                                arrBtnSeleccionarJugador[iI].getHeight());
                    }
                }
                break;
            case "instruccions":
                if (btnRegresarInstrucciones.pointerInside(iMouseX, iMouseY)) {
                        btnRegresarInstrucciones.setImageIcon(
                                strBtnRegresarInstrucciones[1],
                                btnRegresarInstrucciones.getWidth(),
                                btnRegresarInstrucciones.getHeight());

                        if (btnRegresarInstrucciones.pointerInside(
                                iMouseReleasedX, iMouseReleasedY)) {
                            
                            if (bPaused) {
                                strPantalla = "dungeon";
                            } else {
                                strPantalla = "menuPrincipal";
                            }
                            iMouseReleasedX = -1;
                            iMouseReleasedY = -1;
                        }
                    } else {
                        btnRegresarInstrucciones.setImageIcon(
                                strBtnRegresarInstrucciones[0],
                                btnRegresarInstrucciones.getWidth(),
                                btnRegresarInstrucciones.getHeight());
                    }
                break;
            case "credits":
                if (btnRegresarCreditos.pointerInside(iMouseX, iMouseY)) {
                        btnRegresarCreditos.setImageIcon(
                                strBtnRegresarCreditos[1],
                                btnRegresarCreditos.getWidth(),
                                btnRegresarCreditos.getHeight());
                        if (btnRegresarCreditos.pointerInside(iMouseReleasedX,
                                iMouseReleasedY)) {
                            strPantalla = "menuPrincipal";
                            iMouseReleasedX = -1;
                            iMouseReleasedY = -1;
                        }
                    } else {
                        btnRegresarCreditos.setImageIcon(
                                strBtnRegresarCreditos[0],
                                btnRegresarCreditos.getWidth(),
                                btnRegresarCreditos.getHeight());
                    }
                break;
            case "mapa":
                for (int iI = 0; iI < 5; iI ++) {
                    if(arrBtnMapa[iI].pointerInside(iMouseX, iMouseY)) {

                        arrBtnMapa[iI].setImageIcon(
                                arrStrMapa[iI][1],
                                arrBtnMapa[iI].getWidth(),
                                arrBtnMapa[iI].getHeight());

                        if(arrBtnMapa[iI].pointerInside(iMouseReleasedX,
                                iMouseReleasedY)) {
                            switch (iI) {
                                case 0:
                                    strPantalla = "seleccionarJugador";
                                    iMouseReleasedX = -1;
                                    iMouseReleasedY = -1;
                                    break;
                                case 1:
                                    strPantalla = "opciones";
                                    iMouseReleasedX = -1;
                                    iMouseReleasedY = -1;
                                    break;
                                case 2:
                                case 3:
                                case 4:
                                    strPantalla = "dungeon";
                                    iMouseReleasedX = -1;
                                    iMouseReleasedY = -1;
                                    dunTomb = new Sat_Dungeon(3);
                                    break;
                            }
                        }
                    } 
                    else {
                        arrBtnMapa[iI].setImageIcon(
                                arrStrMapa[iI][0],
                                arrBtnMapa[iI].getWidth(),
                                arrBtnMapa[iI].getHeight());
                    }
                }
                break;
            case "opciones":
                for (int iI = 0; iI < 3; iI ++) {
                    if (arrBtnOpciones[iI].pointerInside(iMouseX, iMouseY)) {
                        arrBtnOpciones[iI].setImageIcon(arrStrOpciones[iI][1],
                                arrBtnOpciones[iI].getWidth(), 
                                arrBtnOpciones[iI].getHeight());
                        
                        if (arrBtnOpciones[iI].pointerInside(iMouseReleasedX,
                                iMouseReleasedY)) {
                            switch (iI) {
                                case 0:
                                    strPantalla = "dificultad";
                                    iMouseReleasedX = -1;
                                    iMouseReleasedY = -1;
                                    break;
                                case 1:
                                    strPantalla = "audio";
                                    iMouseReleasedX = -1;
                                    iMouseReleasedY = -1;
                                    break;
                                case 2:
                                    strPantalla = "mapa";
                                    iMouseReleasedX = -1;
                                    iMouseReleasedY = -1;
                                    break;
                            }
                        }
                    }
                    else {
                        arrBtnOpciones[iI].setImageIcon(arrStrOpciones[iI][0],
                                arrBtnOpciones[iI].getWidth(), 
                                arrBtnOpciones[iI].getHeight());                        
                    }
                }
                break;
            case "dificultad":

                // Check difficulty selection
                // easy button
                if (arrBtnMenuDificultad[0].pointerInside(iMouseX, iMouseY)
                        && arrBtnMenuDificultad[0].pointerInside(
                                iMouseReleasedX, iMouseReleasedY) &&
                        iDificultad != 0) {
                    
                    // update difficulty
                    iDificultad = 0;
                    // mark easy selection
                    arrBtnMenuDificultad[0].setImageIcon(
                            arrStrMenuDificultad[0][1],
                            arrBtnMenuDificultad[0].getWidth(),
                            arrBtnMenuDificultad[0].getHeight());
                    // unmark the rest of the buttons
                    arrBtnMenuDificultad[1].setImageIcon(
                            arrStrMenuDificultad[1][0],
                            arrBtnMenuDificultad[1].getWidth(),
                            arrBtnMenuDificultad[1].getHeight());
                    arrBtnMenuDificultad[2].setImageIcon(
                            arrStrMenuDificultad[2][0],
                            arrBtnMenuDificultad[2].getWidth(),
                            arrBtnMenuDificultad[2].getHeight());
                }
                // medium button
                else if (arrBtnMenuDificultad[1].pointerInside(iMouseX, iMouseY)
                        && arrBtnMenuDificultad[1].pointerInside(
                                iMouseReleasedX, iMouseReleasedY) &&
                        iDificultad != 1) {
                    // update difficulty
                    iDificultad = 1;
                    // mark medium selection
                    arrBtnMenuDificultad[1].setImageIcon(
                            arrStrMenuDificultad[1][1],
                            arrBtnMenuDificultad[1].getWidth(),
                            arrBtnMenuDificultad[1].getHeight());
                    // unmark the rest of the buttons
                    arrBtnMenuDificultad[0].setImageIcon(
                            arrStrMenuDificultad[0][0],
                            arrBtnMenuDificultad[0].getWidth(),
                            arrBtnMenuDificultad[0].getHeight());
                    arrBtnMenuDificultad[2].setImageIcon(
                            arrStrMenuDificultad[2][0],
                            arrBtnMenuDificultad[2].getWidth(),
                            arrBtnMenuDificultad[2].getHeight());
                }
                // hard button
                else if (arrBtnMenuDificultad[2].pointerInside(iMouseX, iMouseY)
                        && arrBtnMenuDificultad[2].pointerInside(
                                iMouseReleasedX, iMouseReleasedY) && 
                        iDificultad != 2) {
                    // update difficulty
                    iDificultad = 2;
                    // mark hard selection
                    arrBtnMenuDificultad[2].setImageIcon(
                            arrStrMenuDificultad[2][1],
                            arrBtnMenuDificultad[2].getWidth(),
                            arrBtnMenuDificultad[2].getHeight());
                    // unmark the rest of the buttons
                    arrBtnMenuDificultad[0].setImageIcon(
                            arrStrMenuDificultad[0][0],
                            arrBtnMenuDificultad[0].getWidth(),
                            arrBtnMenuDificultad[0].getHeight());
                    arrBtnMenuDificultad[1].setImageIcon(
                            arrStrMenuDificultad[1][0],
                            arrBtnMenuDificultad[1].getWidth(),
                            arrBtnMenuDificultad[1].getHeight());
                }
                // Check navigation buttons
                if (arrBtnMenuDificultad[3].pointerInside(iMouseX, iMouseY)) {
                        arrBtnMenuDificultad[3].setImageIcon(
                                arrStrMenuDificultad[3][1],
                                arrBtnMenuDificultad[3].getWidth(),
                                arrBtnMenuDificultad[3].getHeight());

                    if (arrBtnMenuDificultad[3].pointerInside(iMouseReleasedX,
                            iMouseReleasedY)) {
                        strPantalla = "opciones";
                        iMouseReleasedX = -1;
                        iMouseReleasedY = -1;
                        // reset difficulty selection                        
                        iDificultad = 0;
                        arrBtnMenuDificultad[0].setImageIcon(
                                arrStrMenuDificultad[0][1],
                            arrBtnMenuDificultad[0].getWidth(),
                            arrBtnMenuDificultad[0].getHeight());
                        arrBtnMenuDificultad[1].setImageIcon(
                                arrStrMenuDificultad[1][0],
                            arrBtnMenuDificultad[1].getWidth(),
                            arrBtnMenuDificultad[1].getHeight());
                        arrBtnMenuDificultad[2].setImageIcon(
                                arrStrMenuDificultad[2][0],
                            arrBtnMenuDificultad[2].getWidth(),
                            arrBtnMenuDificultad[2].getHeight());
                    }
                } else {
                    arrBtnMenuDificultad[3].setImageIcon(
                            arrStrMenuDificultad[3][0],
                            arrBtnMenuDificultad[3].getWidth(),
                            arrBtnMenuDificultad[3].getHeight());
                }
                break;
            case "audio":
                // check music button
                if (arrBtnMenuAudio[0].pointerInside(iMouseX, iMouseY)
                        && arrBtnMenuAudio[0].pointerInside(iMouseReleasedX,
                                iMouseReleasedY)) {
                    iMouseReleasedX = -1;
                    iMouseReleasedY = -1;
                    if (boolSonidoMusica) {
                        arrBtnMenuAudio[0].setImageIcon(arrStrMenuAudio[0][1],
                                arrBtnMenuAudio[0].getWidth(),
                                arrBtnMenuAudio[0].getHeight());
                        
                    } else if (!boolSonidoMusica) {
                        arrBtnMenuAudio[0].setImageIcon(arrStrMenuAudio[0][0],
                                arrBtnMenuAudio[0].getWidth(),
                                arrBtnMenuAudio[0].getHeight());  
                    }
                    boolSonidoMusica = !boolSonidoMusica;
                }
                // check music button
                if (arrBtnMenuAudio[1].pointerInside(iMouseX,iMouseY)
                        && arrBtnMenuAudio[1].pointerInside(iMouseReleasedX,
                                iMouseReleasedY)) {
                    
                    iMouseReleasedX = -1;
                    iMouseReleasedY = -1;
                    
                    if (boolSonidoEfectos) {
                        arrBtnMenuAudio[1].setImageIcon(arrStrMenuAudio[1][1],
                                arrBtnMenuAudio[1].getWidth(),
                                arrBtnMenuAudio[0].getHeight());
                    } else {
                        arrBtnMenuAudio[1].setImageIcon(arrStrMenuAudio[1][0],
                                arrBtnMenuAudio[1].getWidth(),
                                arrBtnMenuAudio[1].getHeight());
                    }
                    boolSonidoEfectos = !boolSonidoEfectos;
                }
                // Check navigation buttons
                if (arrBtnMenuAudio[2].pointerInside(iMouseX,iMouseY)) {
                        arrBtnMenuAudio[2].setImageIcon(arrStrMenuAudio[2][1],
                                arrBtnMenuAudio[2].getWidth(),
                                arrBtnMenuAudio[2].getHeight());

                    if (arrBtnMenuAudio[2].pointerInside(iMouseReleasedX,
                            iMouseReleasedY)) {
                        strPantalla = "opciones";
                        iMouseReleasedX = -1;
                        iMouseReleasedY = -1;
                    }
                } else {
                    arrBtnMenuAudio[2].setImageIcon(arrStrMenuAudio[2][0],
                            arrBtnMenuAudio[2].getWidth(),
                            arrBtnMenuAudio[2].getHeight());
                }
                break;

            case "dungeon":               
                // menu button
                if (arrBtnDungeonOptions[0].pointerInside(iMouseX, iMouseY)) {
                    arrBtnDungeonOptions[0].setImageIcon(
                            arrStrDungeonOptions[0][1],
                            arrBtnDungeonOptions[0].getWidth(),
                            arrBtnDungeonOptions[0].getHeight());
 
                    if (arrBtnDungeonOptions[0].pointerInside(iMouseReleasedX,
                            iMouseReleasedY)) {
                        bPaused = !bPaused;
                        iMouseReleasedX = -1;
                        iMouseReleasedY = -1;
                    }
                }
                else {
                    arrBtnDungeonOptions[0].setImageIcon(
                            arrStrDungeonOptions[0][0],
                            arrBtnDungeonOptions[0].getWidth(),
                            arrBtnDungeonOptions[0].getHeight());
                }
               
                // menu buttons
                if(bPaused) {
                    for (int iI = 1; iI < 4; iI ++) {

                        if (arrBtnDungeonOptions[iI].pointerInside(iMouseX,
                                iMouseY)) {
                            arrBtnDungeonOptions[iI].setImageIcon(
                                    arrStrDungeonOptions[iI][1],
                                    arrBtnDungeonOptions[iI].getWidth(),
                                    arrBtnDungeonOptions[iI].getHeight());

                            if (arrBtnDungeonOptions[iI].pointerInside(
                                    iMouseReleasedX, iMouseReleasedY)) {
                                switch (iI) {
                                    case 1:
                                        bPaused = false;

                                        iMouseReleasedX = -1;
                                        iMouseReleasedY = -1;
                                        break;
                                    case 2:
                                        strPantalla = "instruccions";
                                        iMouseReleasedX = -1;
                                        iMouseReleasedY = -1;
                                        break;
                                   case 3:
                                        strPantalla = "mapa";
                                        bPaused = false;
                                        iMouseReleasedX = -1;
                                        iMouseReleasedY = -1;
                                        break;
                                }
                                arrBtnDungeonOptions[iI].setImageIcon(
                                        arrStrDungeonOptions[iI][0],
                                    arrBtnDungeonOptions[iI].getWidth(),
                                    arrBtnDungeonOptions[iI].getHeight());
                            }
                        } else {
                            arrBtnDungeonOptions[iI].setImageIcon(
                                    arrStrDungeonOptions[iI][0],
                                    arrBtnDungeonOptions[iI].getWidth(),
                                    arrBtnDungeonOptions[iI].getHeight());
                        }
                    }
                }

                break;
        }
    }
	
    /**
     * checaColision
     * 
     * Method used to check for collisions between objects
     */
    public void checaColision(){
        // Not implemented
    }
	
    /**
     * update
     * 
     * Overwritten method from class <code>Applet</code>,
     * inherits from class container.<P>
     * It updates the container and defines when to use paint
     * 
     * @param graGrafico is the <code>Graphics Object</code> used to draw
     */
    public void update (Graphics graGrafico) {
        URL urlImagenFondo = this.getClass().getResource("background.png");
        
        // Initialize the DoubleBuffer
        if (imaImagenApplet == null) {
                imaImagenApplet = createImage (this.getSize().width, 
                        this.getSize().height);
                graGraficaApplet = imaImagenApplet.getGraphics();
        }

        // Update background image
        if (strPantalla.equals("mapa")) {
            urlImagenFondo = this.getClass().getResource("mapEgypt.png");
        }
        if(strPantalla.equals("dungeon")) {
            if(chPantallaDungeon == 'j'){
                urlImagenFondo = this.getClass().getResource("dungeon_base.png");
            }
            else if (chPantallaDungeon == 'g') {
                urlImagenFondo = this.getClass().getResource("ganaste.png");
            }
            else if (chPantallaDungeon == 'p') {
                urlImagenFondo = this.getClass().getResource("perdiste.png");
            }
        }
        if (strPantalla.equals("credits")) {
            urlImagenFondo = this.getClass().getResource(
                    "pantallaCreditos.png");
        }
        if (strPantalla.equals("instruccions")) {
            urlImagenFondo = this.getClass().getResource(
                    "pantallaInstrucciones.png");
        }
        
        Image imaImagenFondo = 
                Toolkit.getDefaultToolkit().getImage(urlImagenFondo);
        graGraficaApplet.drawImage(imaImagenFondo, 0, 
                 0, getWidth(), getHeight(), this);

        // Update the foreground
        graGraficaApplet.setColor(getForeground());
        paint(graGraficaApplet);

        // Paint the updated image
        graGrafico.drawImage(imaImagenApplet, 0, 0, this);
    }
    
    /**
     * paint
     * 
     * Overwritten method from class <code>Applet</code>,
     * inherits from class container.<P>
     * In this method the image is drawn in its updated position
     * 
     * @param graDibujo is an <code>Graphics</code> object used to draw.
     */
    public void paint(Graphics graDibujo) {
        
        // Choose screen
        switch (strPantalla) {
            case "menuPrincipal":
                //Display image
                graDibujo.drawImage(imaImagenMenuPrincipal, 40, 158, this);
                //Display title
                graDibujo.drawImage(imaTituloMenuPrincipal, 40, 30, this);
                // Display Buttons
                for (int i = 0; i < 3; i ++) {
                    arrBtnMenuPrincipal[i].paint(graDibujo, this);
                }
                break;
            case "seleccionarJugador":
                vioTxtSelecciona.paint(graDibujo, this);
                // Display buttons
                for (int i = 0; i < 4; i ++) {
                    arrBtnSeleccionarJugador[i].paint(graDibujo, this);
                }
                break;
            case "instruccions":
                // at this stage, the text wont be displayed
                //vioTxtInstrucciones.paint(graDibujo, this);
                // Display buttons
                btnRegresarInstrucciones.paint(graDibujo, this);
                break;
            case "credits":
                // at this stage, the text wont be displayed
                //vioTxtCreditos.paint(graDibujo, this);
                // Display buttons
                btnRegresarCreditos.paint(graDibujo, this);
                break;
            case "mapa":      
                for (int i = 0; i < 5; i ++) {
                    arrBtnMapa[i].paint(graDibujo, this);
                }
                break;
            case "opciones":
                vioTxtOpciones.paint(graDibujo, this);
                // Display buttons
                for (int i = 0; i < 3 ; i ++) {
                    arrBtnOpciones[i].paint(graDibujo, this);
                }
                break;
            case "dificultad":
                vioTxtDificultad.paint(graDibujo, this);
                // Display buttons
                for (int i = 0; i < 4 ; i ++) {
                    arrBtnMenuDificultad[i].paint(graDibujo, this);
                }
                break;
            case "audio":
                vioTxtAudio.paint(graDibujo, this);
                // Display buttons
                for (int i = 0; i < 3 ; i ++) {
                    arrBtnMenuAudio[i].paint(graDibujo, this);
                }
                break;
            case "dungeon":
                // dummy variable for navigating between screens in dungeon
                // game screen
                if (chPantallaDungeon == 'j') {
                    // Display buttons                
                    arrBtnDungeonOptions[0].paint(graDibujo, this);
                    // Dsiplay dungeon structures according to player's position
                    arrSttStructures[dunTomb.getIDungeonPos()].paint(graDibujo, 
                            this);
                    if (bPaused) {
                        for (int iI = 1; iI < 4 ; iI ++) {
                            // Display buttons    
                            arrBtnDungeonOptions[iI].paint(graDibujo, this);
                        }
                    }
                    else {
                        // paint animations
                        for (int iI = 0; iI < 4; iI ++) {
                            satPlayer[iI].paint(graDibujo, this);
                        }

                        for (int iI = 0; iI < 2; iI ++) {
                            satMummy[iI].paint(graDibujo, this);
                        }
                    }
                }
                else if (chPantallaDungeon == 'j') {
                    for (int iI = 0; iI < 4; iI ++) {
                        satPlayer[iI].paint(graDibujo, this);
                    }
                    
                    for (int iI = 0; iI < 2; iI ++) {
                        satMummy[iI].paint(graDibujo, this);
                    } 
                }
                break;
        }
    }
    
    /**
     * keyTyped
     * 
     * Metodo sobrescrito de la interface <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar una 
     * tecla que no es de accion.
     * 
     * @param keyEvent es el <code>KeyEvent</code> que se genera en al presionar
     * 
     */
    public void keyTyped(KeyEvent keyEvent) {
        // no hay codigo pero se debe escribir el metodo
    }

    /**
     * keyPressed
     * 
     * Metodo sobrescrito de la interface <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al dejar presionada
     * alguna tecla.
     * 
     * @param keyEvent es el <code>KeyEvent</code> que se genera en al presionar
     * 
     */
    public void keyPressed(KeyEvent keyEvent) {
        // no hay codigo pero se debe escribir el metodo
    }

    /**
     * keyReleased
     * Metodo sobrescrito de la interface <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar la tecla.
     * 
     * @param keyEvent es el <code>KeyEvent</code> que se genera en al soltar.
     * 
     */
    public void keyReleased(KeyEvent keyEvent) {  
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            // Select a random dungeon structure
            do {
                int iNewPosX = (int) Math.floor(Math.random() * 12);
                int iNewPosY = (int) Math.floor(Math.random() * 12);
                
                dunTomb.setIPosX(iNewPosX);
                dunTomb.setIPosY(iNewPosY);
                
            } while (dunTomb.getIDungeonPos() < 1 || 
                    dunTomb.getIDungeonPos() > 6);
        }
        // navigation between dungeon screens ()
        if (strPantalla.equals("dungeon")) {
            // lost screen
            if (keyEvent.getKeyCode() == 'P') {
                chPantallaDungeon = 'p';
            }
            // win screen
            if (keyEvent.getKeyCode() == 'G') {
                chPantallaDungeon = 'g';
            }
            // j screen
            if (keyEvent.getKeyCode() == 'J') {
                chPantallaDungeon = 'j';
            }
        }
    }

    /**
     * mouseClicked
     * 
     * Perform actions if mouse is clicked
     * 
     * @param mseEvent is an <code> MouseEvent </code> object used to read mouse
     */
    @Override
    public void mouseClicked(MouseEvent mseEvent) {
        // Not supported
    }

    /**
     * mousedPressed
     * 
     * Perform actions if mouse is pressed
     * 
     * @param mseEvent is an <code> MouseEvent </code> object used to read mouse
     */
    @Override
    public void mousePressed(MouseEvent mseEvent) {
        boolPresionado = true;
    }

    /**
     * mouseReleased
     * 
     * Perform actions if mouse is released
     * 
     * @param mseEvent is an <code> MouseEvent </code> object used to read mouse
     */
    @Override
    public void mouseReleased(MouseEvent mseEvent) {
        boolPresionado = false;
        iMouseReleasedX = mseEvent.getX();
        iMouseReleasedY = mseEvent.getY();
    }

    /**
     * mouseEntered
     * 
     * Perform actions if mouse enters the applet
     * 
     * @param mseEvent is an <code> MouseEvent </code> object used to read mouse
     */
    @Override
    public void mouseEntered(MouseEvent mseEvent) {
        // Not supported
    }

    /**
     * mouseExited
     * 
     * Perform actions if mouse exits the applet
     * 
     * @param mseEvent is an <code> MouseEvent </code> object used to read mouse
     */
    @Override
    public void mouseExited(MouseEvent mseEvent) {
        // Not supported
    }

    /**
     * mouseDragged
     * 
     * Perform actions if mouse is dragged
     * 
     * @param mseEvent is an <code> MouseEvent </code> object used to read mouse
     */
    @Override
    public void mouseDragged(MouseEvent mseEvent) {
        iMouseX = mseEvent.getX();
        iMouseY = mseEvent.getY();
    }

    /**
     * mouseMoved
     * 
     * Perform actions if mouse is moved
     * 
     * @param mseEvent is an <code> MouseEvent </code> object used to read mouse
     */
    @Override
    public void mouseMoved(MouseEvent mseEvent) {
        iMouseX = mseEvent.getX();
        iMouseY = mseEvent.getY();
    }
}