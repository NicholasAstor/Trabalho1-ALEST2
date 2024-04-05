public class Vec2 {
    private int x;
    private int y;

    public Vec2(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public void increaseX(){
        this.x++;
    }

    public void decreaseX(){
        this.x--;
    }

    public void increaseY(){
        this.y++;
    }

    public void decreaseY(){
        this.y--;
    }

    @Override
    public String toString(){
        return "X: "+this.x+" Y: " + this.y;
    }
}
