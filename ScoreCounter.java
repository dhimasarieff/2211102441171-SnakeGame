import greenfoot.*;

public class ScoreCounter extends Actor {
    private int score = 0;
    private GreenfootImage image;

    public ScoreCounter() {
        // Inisialisasi teks dan gambar skor
        image = new GreenfootImage("Score: 0", 24, Color.WHITE, Color.BLACK);
        setImage(image);
    }

    public void act() {
        // Perbarui teks skor setiap kali act dipanggil
        image.clear();
        image.drawString("Score: " + score, 10, 30);
    }

    public void addToScore(int points) {
        score += points;
    }
}
