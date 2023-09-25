/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.g_usuariosivag.modelo.vista;

/**
 *
 * @author lapin
 */
public class ManejadorPantallas {
    private static VUsuario pantallaUsuario;
    public static void abrirPantallaUsuario (){
        
    pantallaUsuario = new VUsuario ();
    pantallaUsuario.setVisible(true);
    pantallaUsuario.setLocationRelativeTo(null);
    }
    public static void cerrarPantallaUsuario () {
    pantallaUsuario.setVisible(false);
    pantallaUsuario = null;
        
        
    }
    
    
}
