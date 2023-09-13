import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class codigo_5_2023_2 {

    static ArrayList<String> playlist = new ArrayList<String>();
    static String list = "Crear playlist";

    public static void menu() {
        try{
            switch(Integer.parseInt(JOptionPane.showInputDialog("¿Que deseas hacer?\n1 = "+list+"\n2 = Ver canciones guardadas\n3 = Eliminar una cancion o limpiar playlist\n4 = Salir"))){
                case 1 -> agregar();
                case 2 -> impresion();
                case 3 -> remover();
                case 4 -> salir();
                default -> mensaje();
            }
        }catch(Exception e){
            menu();
        }
    }
    
    public static void agregar() {
        do{
            playlist.add(JOptionPane.showInputDialog("Ingresa una cancion"));
        }while(JOptionPane.showConfirmDialog(null, "Quieres agregar otra cancion?", null, 0)== 0);
        list = "Agregar una cancion a la playlist";
        menu();
    }
    
    public static void impresion() {
        if(playlist.isEmpty()){
            JOptionPane.showMessageDialog(null, "Aun no creas una playlist");
            menu();
        }else{
            JOptionPane.showMessageDialog(null, lista());
            menu();
        }
    }

    public static void remover() {
        if(playlist.size()>=1){
            try{
                switch(Integer.parseInt(JOptionPane.showInputDialog("Elije una opcion:\n1 = Eliminar una cancion\n2 = limpiar playlist\n3 = Volver al menu"))){
                    case 1 -> elimina();
                    case 2 -> limpiar();
                    case 3 -> menu();
                    default -> mensaje2();
                }
            }catch(Exception e){
                remover();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tu playlist esta vacia.");
            menu();
        }
    }
    
    public static String lista() {
        int j = 1;
        String canciones = "";
        for(int i = 0 ; i < playlist.size() ; i++){
            canciones = canciones + j + " " + playlist.get(i) + "\n";
            j++;
        }
        return canciones;
    }
    
    public static void elimina() {
        try{
            eliminacion(Integer.parseInt(JOptionPane.showInputDialog(lista() + "En que numero esta la cancion que deseas eliminar?"))-1);
        }catch(HeadlessException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debes seleccionar un numero, intenta de nuevo.");
            elimina();
        }
        if(playlist.size()>=1){
            list = "Agregar una cancion a la playlist";
            menu();
        }else{
            JOptionPane.showMessageDialog(null, "Tu playlist esta vacia.");
            list = "Crear playlist";
            menu();
        }
    }

    public static void eliminacion(int posicion) {
        if(JOptionPane.showConfirmDialog(null, "Estas seguro de querer eliminar esta cancion '" + playlist.get(posicion) + "'?", null, 0)== 0){
            playlist.remove(posicion);
            comparacion();
        }else{
            JOptionPane.showMessageDialog(null, "Ok!!!");
            list = "Agregar una cancion a la playlist";
            menu();
        }
    }
    
    public static void limpiar() {
        playlist.clear();
        list = "Crear playlist";
        menu();
    }
    
    public static void comparacion() {
        if(playlist.size()==0){
            list = "Crear playlist";
            menu();
        }else{
            list = "Agregar una cancion a la playlist";
            menu();
        }
    }
    
    public static void mensaje() {
        JOptionPane.showMessageDialog(null, "Debes seleccionar un numero, intenta de nuevo.");
        menu();
    }
    
    public static void mensaje2() {
        JOptionPane.showMessageDialog(null, "Debes seleccionar un numero, intenta de nuevo.");
        remover();
    }
    
    public static void salir() {
        JOptionPane.showMessageDialog(null, "Adios");
    }

    public static void main(String[] args) {
        menu();
    }
}