package org.campusdual.lituraliaimagegenerator;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.imageio.ImageIO;
import org.campusdual.lituraliaimagegenerator.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("book_covers")
public class BookCoverGenerator implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(org.campusdual.lituraliaimagegenerator.BookCoverGenerator.class);

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... strings) throws Exception {
//        bookRepository.findAll().forEach(System.out::println);

        Random random = new Random();
        ColorProcessor ip = new ColorProcessor(400, 600);
        ip.setBackgroundValue(random.nextInt());
        ip.setColor(random.nextInt());
        ip.fill();
        ip.drawRect(50, 50, 300, 500);
        ImagePlus imp = new ImagePlus("Book X", ip);

        imp.draw();

        ByteArrayOutputStream baso = new ByteArrayOutputStream();
        ImageIO.write(imp.getBufferedImage(), "png", baso);
        baso.flush();
        byte[] imagebyte = baso.toByteArray();
        baso.close();
        System.out.println(Base64.getEncoder().encodeToString(imagebyte));


    }
}