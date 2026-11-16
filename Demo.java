class Demo{
    public static void main(String args[]){
        ControllRoom c1=new ControllRoom();
        c1.addObservers(new Helicopter());
        c1.addObservers(new Tank());
        c1.addObservers(new Submarine());
        
    }
}
