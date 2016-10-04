/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 73433810
 */
public class SalasBeans {
    private String nome;
    private int id_sala;

    public SalasBeans() {
    }

    
    public SalasBeans(String nome, int id_sala) {
        this.nome = nome;
        this.id_sala = id_sala;
    }
    
    public SalasBeans(int id){
        this.id_sala = id;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }
    
    

    public SalasBeans(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    
}
