package org.campusdual.lituraliaimagegenerator;

import static org.junit.jupiter.api.Assertions.*;

import ij.ImagePlus;
import ij.gui.Roi;
import ij.process.ColorProcessor;
import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;
import javax.imageio.ImageIO;
import org.campusdual.lituraliaimagegenerator.domain.Book;
import org.junit.jupiter.api.Test;

class BookCoverGeneratorTest {


    @Test
    void name() throws IOException {

        System.out.println(generateBookCover(Book.builder().title("Book").build()));


    }

    private String generateBookCover(Book book) throws IOException {
        Random random = new Random();
        ColorProcessor ip = new ColorProcessor(400, 600);
        ip.setColor(random.nextInt());
        ip.fill();
        Roi roi = new Roi(50, 50, 300, 500);
        ip.setRoi(roi);
        ip.setValue(random.nextInt());
        ip.fill();

        ip.setFont(new Font("Dialog", Font.BOLD, 30));
        ip.drawString(book.getTitle(), 100 , 300, Color.gray);

        ip.setFont(new Font("Dialog", Font.PLAIN, 20));
        String authors = "Author 1,Author Number 2";
        authors = authors.replace(",", "\n");
        ip.drawString(authors, 100 , 500, Color.gray);

        ip.setFont(new Font("Dialog", Font.PLAIN, 20));
        ip.drawString("Publisher", 100 , 580, Color.gray);

        ImagePlus imp = new ImagePlus("Book X", ip);

        imp.draw();

        ByteArrayOutputStream baso = new ByteArrayOutputStream();
        ImageIO.write(imp.getBufferedImage(), "png", baso);
        baso.flush();
        byte[] imagebyte = baso.toByteArray();
        baso.close();
        return(Base64.getEncoder().encodeToString(imagebyte));
    }
}