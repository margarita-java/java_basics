import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\r_aru\\Desktop\\src";
        String dstFolder = "C:\\Users\\r_aru\\Desktop\\dst";

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Папка с изображениями пуста или не существует.");
            return;
        }

        int numCores = Runtime.getRuntime().availableProcessors();
        int filesPerThread = (int) Math.ceil(files.length / (double) numCores);

        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[numCores];

        for (int i = 0; i < numCores; i++) {
            int startIdx = i * filesPerThread;
            int endIdx = Math.min(startIdx + filesPerThread, files.length);

            File[] filesSubset = new File[endIdx - startIdx];
            System.arraycopy(files, startIdx, filesSubset, 0, filesSubset.length);

            threads[i] = new Thread(new ImageResizer(filesSubset, dstFolder));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total Duration: " + (System.currentTimeMillis() - start) + " ms");
    }
}