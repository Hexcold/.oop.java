import java.util.ArrayList;

public class Pencil {
    private float thickness;
    private Lead tip; //lead da ponta
    private ArrayList<Lead> barrel; //grafites no cano

    // Construtor do Pencil 
    public Pencil(float thickness) {
        this.thickness = thickness;
        this.barrel = new ArrayList<>();
    }

    public String toString() {
        String saida = "calibre: " + thickness + ", bico: ";
        if (this.tip != null)
            saida += "[" + this.tip + "]";
        else
            saida += "[]";
        saida += ", tambor: {";
            for (Lead g : barrel)
                saida += "[" + g + "]";
        return saida + "}";
    }

    //insere um lead no barril
    public boolean insert(Lead lead) {
        if(this.thickness != lead.getThickness()) {
            Solver.write("fail: calibre incompatível");
            return false;
        }
        this.barrel.add(lead);
        return true;
    }

    //remove e retorna o lead da ponta
    public Lead remove() {
        if(this.tip == null) {
            Solver.write("fail: nao existe grafite no bico");
            return null;
        }
        Lead backup = this.tip;
        this.tip = null;
        return backup;
    }

    // se a ponta estiver vazia, puxa o próximo lead do barril
    public boolean pull() {
        if (this.tip != null) {
            Solver.write("fail: ja existe grafite no bico");
            return false;
        }
        if (this.barrel.size() == 0) {
            Solver.write("fail: nao existe grafite no barril");
            return false;
        }
        this.tip = this.barrel.remove(0);
        return true;
    }

    //se tiver grafite suficiente no bico, gaste e retorne true
    //lembre que os últimos 10mm não podem ser utilizados
    public void writePage() {
        if(this.tip == null) {
            Solver.write("fail: nao existe grafite no bico");
            return;
        }
        if (this.tip.getSize() == 10) {
            Solver.write("fail: tamanho insuficiente");
            return;
        }
        int finalSize = this.tip.getSize() - this.tip.usagePerSheet();
        if(finalSize >= 10) {
            this.tip.setSize(finalSize);
        } else {
            this.tip.setSize(10);
            Solver.write("fail: folha incompleta");
        }
    }
}