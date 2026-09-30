import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class main {
    static String getFileExtension(String filename) {
        if (filename == null) {
            return null;
        }
        int dotIndex = filename.lastIndexOf(".");
        if (dotIndex >= 0) {
            return filename.substring(dotIndex + 1);
        }
        return "";
    }
    public static void main (String[] args) throws IOException{
        String path = args[0];

        File f = new File(path);
        if(f.exists() && !f.isDirectory()) { 
            System.out.println(getFileExtension(path));
            if ( getFileExtension(path).equals("jpg") | getFileExtension(path).equals("png") ) {
                BufferedImage image = ImageIO.read(f);
    
                int width = image.getWidth();
                int height = image.getHeight();
    
                int[][][] pixels = new int[height][width][3];

                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        int rgb = image.getRGB(x, y);
                        pixels[y][x][0] = (rgb >> 16) & 0xFF;  //  red
                        pixels[y][x][1] = (rgb >>  8) & 0xFF;  // green
                        pixels[y][x][2] =  rgb        & 0xFF;  // blue
                    }
                }
                /*
                System.out.println("R=" + pixels[0][0][0]
                                + " G=" + pixels[0][0][1]
                                + " B=" + pixels[0][0][2]);
                 */
                int[][] matr = new int[height][width];
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        matr[y][x]= (pixels[y][x][0]+pixels[y][x][0]+pixels[y][x][0])/ 3;
                    }
                }



                
            }else{

                System.out.println(path + " must be an jpg or an png file");
            }
            
        }else{
            System.out.println(path + " does not exist");
        }
        


    }
}




