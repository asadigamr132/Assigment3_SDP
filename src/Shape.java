public abstract class Shape {
    protected final int id;
    protected Renderer renderer;
    protected Shape(int id, Renderer renderer){
        this.id = id;
        this.renderer = renderer;
    }
    public abstract String execute();

    public void setImplementation(Renderer renderer){
        this.renderer = renderer;
    }

    public int getId(){
        return id;
    }
}
