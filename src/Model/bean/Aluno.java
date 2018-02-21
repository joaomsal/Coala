
package Model.bean;

/**
 *
 * @author RG 295
 */
public class Aluno {
    private String nome;
    private int id;
    private String notas;

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

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
