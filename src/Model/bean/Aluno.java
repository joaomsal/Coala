
package Model.bean;

/**
 *
 * @author RG 295
 */
public class Aluno {
    private String nome;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   public Turma turma= new Turma();
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
       
 
    
    
    
    
    
}
