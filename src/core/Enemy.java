package core;




public class Enemy{
    public Coordinates cords;

    public Enemy(){
    }

    public void setCords(Coordinates cords){
        this.cords = cords;
    }

    public Coordinates getEnemyCords(){
        return this.cords;
    }

}