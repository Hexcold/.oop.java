class Pencil {
    private float thickness;
    private Lead tip;

    public Pencil(float thickness) {
        this.thickness = thickness;
        this.tip = null;
    }

    public float getThickness() {
        return this.thickness;
    }

    public void setThickness(float value) {
        this.thickness = value;
    }

    public boolean hasGrafite() {
        if(this.tip != null){
            return true;
        }
        return false;
    }

    public boolean insert(Lead grafite) {
        if(this.tip == null){
            if(grafite.getThickness() == this.thickness) {
                this.tip = grafite;
                return true;
            }
            System.out.println("fail: calibre incompativel");
        } else {
            System.out.println("fail: ja existe grafite");
        }
        return false;
    }

    public Lead remove() {
        if(this.tip != null){
            this.tip = null;
            return this.tip;
        }
        return null;
    }

    public void writePage() {
        if(this.tip == null){
            System.out.println("fail: nao existe grafite");
            return;
        }

        if(this.tip.getSize() > 10){
            if(tip.getSize() - tip.usagePerSheet() < 10){
                tip.setSize(10);
                System.out.println("fail: folha incompleta");
                return;
            }
            tip.setSize(tip.getSize() - tip.usagePerSheet());
        }else{
            System.out.println("fail: tamanho insuficiente");
        }

    }

    public String toString() {
        String saida = "calibre: " + thickness + ", grafite: ";
        if (tip != null)
            saida += "[" + tip + "]";
        else
            saida += "null";
        return saida;
    }
}