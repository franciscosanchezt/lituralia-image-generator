package com.campusdual.lituraliaimagegenerator;

import com.campusdual.lituraliaimagegenerator.domain.Author;
import com.campusdual.lituraliaimagegenerator.domain.Book;
import com.campusdual.lituraliaimagegenerator.repositories.AuthorRepository;
import com.campusdual.lituraliaimagegenerator.repositories.BookRepository;
import ij.ImagePlus;
import ij.gui.Roi;
import ij.process.ColorProcessor;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("author_avatars")
public class AvatarGenerator implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AvatarGenerator.class);

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... strings) throws Exception {

        String[] images = new String[16];
        for (int i = 0; i < images.length; i++) {
            try {
                images[i] = encodeFileToBase64Binary(new File(getClass().getClassLoader().getResource("256x256/256_" + (i+1) +".png" ).getFile()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        int i = 0;
//        List<Author> all = authorRepository.findAll();
//        for(Author author : all){
//            author.setAuthorPortrait(images[i%16]);
//            i++;
//            authorRepository.saveAndFlush(author);
//        }



    }
    private static String encodeFileToBase64Binary(File file){
        String encodedfile = "";
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return encodedfile;
    }


}