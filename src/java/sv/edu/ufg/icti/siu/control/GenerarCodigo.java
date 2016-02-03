/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.control;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
public class GenerarCodigo {
    private char codigo[];
    private String aux;
    

    /**
     * @return the codigo
     */
    public char[] getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(char[] codigo) {
        this.codigo = codigo;
    }
    //si se puede hacer una mejor generacion dejo esto aqui
    //la fista tiene que filtrar el numero de mayusculas
    //o validar que la primera letra sea mayuscula
    public String generaELcodigo(String cod){
        String aux;
        String aux2;
        StringBuilder micod = new StringBuilder();
        for(int i=0;i<cod.length();i++){
            //asigno solo las letras mayusculas
            if(Character.isUpperCase(cod.charAt(i))){
                micod.append(cod.charAt(i));
            }
        }
        
        aux=micod.toString();
        
        return  aux;
    }

    /**
     * @return the aux
     */
    public String getAux() {
        return aux;
    }

    /**
     * @param aux the aux to set
     */
    public void setAux(String aux) {
        this.aux = aux;
    }
    
}
