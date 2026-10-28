package cursos.model;
public class Curso {

    private int id;
    private int codCur;
    private String nomCur;
    private String ciclo;
    private int numCre;

    public Curso() {
    }

    public Curso(int id, int codCur, String nomCur, String ciclo, int numCre) {
        this.id = id;
        this.codCur = codCur;
        this.nomCur = nomCur;
        this.ciclo = ciclo;
        this.numCre = numCre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodCur() {
        return codCur;
    }

    public void setCodCur(int codCur) {
        this.codCur = codCur;
    }

    public String getNomCur() {
        return nomCur;
    }

    public void setNomCur(String nomCur) {
        this.nomCur = nomCur;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getNumCre() {
        return numCre;
    }

    public void setNumCre(int numCre) {
        this.numCre = numCre;
    }
}
