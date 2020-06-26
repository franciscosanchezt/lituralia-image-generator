package com.campusdual.lituraliaimagegenerator;

import static org.junit.jupiter.api.Assertions.*;

import com.campusdual.lituraliaimagegenerator.domain.Author;
import com.campusdual.lituraliaimagegenerator.domain.Genre;
import com.campusdual.lituraliaimagegenerator.domain.Publisher;
import ij.ImagePlus;
import ij.gui.Roi;
import ij.process.ColorProcessor;
import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.imageio.ImageIO;
import com.campusdual.lituraliaimagegenerator.domain.Book;
import org.hibernate.stat.CollectionStatistics;
import org.junit.jupiter.api.Test;

class BookCoverGeneratorTest {


    @Test
    void name() throws IOException {

        Publisher publisher = Publisher.builder().publisherName("Test Publisher").build();
        Genre genre1 = Genre.builder().genreName("Genre - 1").build();
        Genre genre2 = Genre.builder().genreName("Genre - 2").build();
        Author author1 = Author.builder().authorName("Author - 1").build();
        Author author2 = Author.builder().authorName("Author - 2").build();
        Book book = Book.builder()
                        .title("Book")
                        .publisher(publisher)
                        .authors(new HashSet<>(Arrays.asList(author1,author2)))
                        .genres(new HashSet<>(Arrays.asList(genre1,genre2)))
                        .build();
//        System.out.println(BookCoverGenerator.generateBookCover(book));


    }


}