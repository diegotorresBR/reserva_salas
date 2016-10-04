/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.towel.el.annotation.*;
/**
 *
 * @author 73433810
 */
public class ReservaBeans {
    
    
    
   private int id_sala;
   
   @Resolvable(colName = "Inicio")
   private String data_reserva_inicio;
   
   @Resolvable(colName = "Final")
   private String data_reserva_fim;
   
   @Resolvable (colName = "Descricao")
   private String descricao;
   
   @Resolvable (colName = "Reserva Feita por")
   private String funcionario;
   
   @Resolvable(colName =  "Numero da Reserva")
   private long id;//id da reserva
   
   @Resolvable(colName = "Sala")
   private String nome_sala;

    public ReservaBeans(int id_sala, String funcionario, String dataInicio, String dataFinal, String descricao) {
        this.id = id;
        this.id_sala = id_sala;
        this.funcionario = funcionario;
        this.data_reserva_inicio = dataInicio;
        this.data_reserva_fim = dataFinal;
        this.descricao = descricao;
    }
    
    public ReservaBeans(String data_inicio, String dataFim, long id){
        
        this.id = id;
        this.data_reserva_inicio = data_reserva_inicio;
        this.data_reserva_fim =  dataFim;
        
    }
    
    public ReservaBeans(String data_inicio, long id){
        this.data_reserva_inicio = data_inicio;
        this.id = id;
    }

    public ReservaBeans(String datainicio, String data_fim,long id, String desc, String funcio, String sala) {
        
        this.id = id;
        this.data_reserva_inicio = datainicio;
        this.data_reserva_fim = data_fim;
        this.descricao = desc;
        this.funcionario = funcio;
        this.nome_sala = sala;
        
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData_reserva_inicio() {
        return data_reserva_inicio;
    }

    public String getData_reserva_fim() {
        return data_reserva_fim;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getfuncionario() {
        return funcionario;
    }

    public int getId_sala() {
        return id_sala;
    }
    
    
    
    
}
