/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.edu.sena.g_usuariosivag;

import co.edu.sena.g_usuariosivag.modelo.controlador.conexion;
import co.edu.sena.g_usuariosivag.modelo.vista.ManejadorPantallas;

/**
 *
 * @author lapin
 */
public class G_Usuariosivag {

    public static void main(String[] args) {
       conexion.conectar();
       
       
       ManejadorPantallas.abrirPantallaUsuario();
       
    }
}
