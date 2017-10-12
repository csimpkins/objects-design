public class CatGame {
    public static void main(String[] args) {
        Larry larry = new Larry();
        Thread fosterThread = new Thread(new Foster(larry), "Foster");
        Thread macThread = new Thread(new Mac(larry), "Mac");
        fosterThread.start();
        macThread.start();
    }
}
