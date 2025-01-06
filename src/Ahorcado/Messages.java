
package Ahorcado;

public class Messages {
    
    public enum ALERT {
        EXIT            ( "¿Salir del Juego del Ahorcado?" ),
        ALERT_          ( "ALERTA" ),
        MAX_PLAYERS     ( "Número máximo de jugadores: 4" ),
        MIN_PLAYERS     ( "Ingrese al menos un jugador." ),
        REMAINING_WORDS ( "Palabras necesarias restantes: " ),
        IN_REMAIN_WORDS ( "Ingrese las palabras restantes." ),
        MAX_WORDS       ( "Número máximo de palabras ingresadas." ),
        MIN_LETTERS     ( "Palabra con mínimo 6 letras." ),
        ROUND           ( "Ronda: " ),
        WORD            ( "Palabra: " ),
        SAME_LETTER     ( "La letra ya ha sido seleccionada." ),
        INCORRECT       ( "Incorrecto" ),
        CORRECT         ( "Correcto" ),
        EXISTENT_PLA    ( "Jugador existente." ),
        WORDS_AGAIN     ( "Palabras ya seleccionadas. ¿Agregar de nuevo?" ),
        EXISTENT_WOR    ( "Palabra existente." ),
        FAKE_WORD       ( "Palabra incorrecta." ),
        NEW_NAME        ( "Ingresar el nuevo nombre: " ),
        END_GAME        ( "¿Finalizar la Partida?" );

        private String valor;

        private ALERT( String v ) {
            valor = v;
        }
        
        public String tx(){
            return valor;
        }
    }    
}
