package com.campusdual.lituraliaimagegenerator;

import com.campusdual.lituraliaimagegenerator.domain.Author;
import com.campusdual.lituraliaimagegenerator.domain.Book;
import ij.ImagePlus;
import ij.gui.Roi;
import ij.process.ColorProcessor;
import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import javax.imageio.ImageIO;
import com.campusdual.lituraliaimagegenerator.repositories.BookRepository;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("book_covers")
public class BookCoverGenerator implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(com.campusdual.lituraliaimagegenerator.BookCoverGenerator.class);

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... strings) throws Exception {
//        Optional<Book> byId = bookRepository.findById(10);
//        if(byId.isPresent()){
//            Book book = byId.get();
//        }


        List<Book> all = bookRepository.findAll();
        for (Book book : all) {
            System.out.println(book.getCover());
            String newCover = generateBookCover(book);
            System.out.println(newCover);
            book.setCover(newCover);
            bookRepository.saveAndFlush(book);
        }


    }


    public static String generateBookCover(Book book) throws IOException {
        Random random = new Random();
        ColorProcessor ip = new ColorProcessor(400, 600);
        ip.setColor(random.nextInt());
        ip.fill();
        Roi roi = new Roi(50, 50, 300, 500);
        ip.setRoi(roi);
        ip.setValue(random.nextInt());
        ip.fill();

        ip.setFont(new Font("Dialog", Font.BOLD, 30));
        ip.drawString(book.getTitle(), 100 , 150, Color.gray);

        ip.setFont(new Font("Dialog", Font.PLAIN, 20));
        int y = 350;
        Set<Author> authors1 = book.getAuthors();
        for(Author author: authors1){
            ip.drawString(author.getAuthorName(), 100 , y, Color.gray);
            y+=50;
        }

        ip.setFont(new Font("Dialog", Font.PLAIN, 20));
        ip.drawString(book.getPublisher().getPublisherName(), 100 , 580, Color.gray);

        ImagePlus imp = new ImagePlus("Book X", ip);

        imp.draw();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(imp.getBufferedImage(), "png", byteArrayOutputStream);
        byteArrayOutputStream.flush();
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return(Base64.getEncoder().encodeToString(toByteArray));
    }
}