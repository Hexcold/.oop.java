class Pencil {
    private float thickness;
    private Lead tip;

    public Pencil(float thickness) {
        this.thickness = thickness;
        this.tip = null;
    }

    public float getThickness() {
    }

    public void setThickness(float value) {
        
    }

    public boolean hasGrafite() {
        if(this.tip != null){
            return true;
        }
        return false;
    }

    public boolean insert(Lead grafite) {
        if(this.tip == null){
            if(grafite.getThickness() == this.thickness){
                grafite.getThickness();
                return true;
            }
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
            return;
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