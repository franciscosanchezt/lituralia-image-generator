package com.campusdual.lituraliaimagegenerator;

import com.campusdual.lituraliaimagegenerator.domain.Author;
import com.campusdual.lituraliaimagegenerator.domain.Book;
import com.campusdual.lituraliaimagegenerator.repositories.BookRepository;
import ij.ImagePlus;
import ij.gui.Roi;
import ij.process.ColorProcessor;
import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookCoverGenerator implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(BookCoverGenerator.class);

    @Autowired
    BookRepository bookRepository;

    public static final boolean isActive = false;

    @Override
    public void run(String... strings) throws Exception {
        log.info("BOOK GENERATOR START");
        if (isActive) {

            List<String> synopsis = Arrays.asList("The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it, To Kill A Mockingbird became both an instant bestseller and a critical success when it was first published in 1960. It went on to win the Pulitzer Prize in 1961 and was later made into an Academy Award-winning film, also a classic.",
                                                  "The year 1984 has come and gone, but George Orwell's prophetic, nightmarish vision in 1949 of the world we were becoming is timelier than ever. 1984 is still the great modern classic of \"negative utopia\"—a startlingly original and haunting novel that creates an imaginary world that is completely convincing, from the first sentence to the last four words. No one can deny the novel's hold on the imaginations of whole generations, or the power of its admonitions—a power that seems to grow, not lessen, with the passage of time.",
                                                  "A farm is taken over by its overworked, mistreated animals. With flaming idealism and stirring slogans, they set out to create a paradise of progress, justice, and equality. Thus the stage is set for one of the most telling satiric fables ever penned—a razor-edged fairy tale for grown-ups that records the evolution from revolution against tyranny to a totalitarianism just as terrible.\n" +
                                                  "When Animal Farm was first published, Stalinist Russia was seen as its target. Today it is devastatingly clear that wherever and whenever freedom is attacked, under whatever banner, the cutting clarity and savage comedy of George Orwell’s masterpiece have a meaning and message still ferociously fresh.",
                                                  "Guy Montag is a fireman. His job is to burn books, which are forbidden, being the source of all discord and unhappiness. Even so, Montag is unhappy; there is discord in his marriage. Are books hidden in his house? The Mechanical Hound of the Fire Department, armed with a lethal hypodermic, escorted by helicopters, is ready to track down those dissidents who defy society to preserve and read books",
                                                  "Brave New World is a dystopian novel by English author Aldous Huxley, written in 1931 and published in 1932. Largely set in a futuristic World State, inhabited by genetically modified citizens and an intelligence-based social hierarchy, the novel anticipates huge scientific advancements in reproductive technology, sleep-learning, psychological manipulation and classical conditioning that are combined to make a dystopian society which is challenged by only a single individual: the story's protagonist",
                                                  "Offred is a Handmaid in the Republic of Gilead. She may leave the home of the Commander and his wife once a day to walk to food markets whose signs are now pictures instead of words because women are no longer allowed to read. She must lie on her back once a month and pray that the Commander makes her pregnant, because in an age of declining births, Offred and the other Handmaids are valued only if their ovaries are viable. Offred can remember the years before, when she lived and made love with her husband, Luke; when she played with and protected her daughter; when she had a job, money of her own, and access to knowledge. But all of that is gone now",
                                                  "Seconds before the Earth is demolished to make way for a galactic freeway, Arthur Dent is plucked off the planet by his friend Ford Prefect, a researcher for the revised edition of the The Hitch Hiker's Guide to the Galaxy who, for the last fifteen years, has been posing as an out of work actor",
                                                  "This edition is the original 1818 text, which preserves the hard-hitting and politically charged aspects of Shelley's original writing, as well as her unflinching wit and strong female voice. This edition also includes a new introduction and suggestions for further reading by author and Shelley",
                                                  "Selected by the Modern Library as one of the 100 best novels of all time, Slaughterhouse-Five, an American classic, is one of the world's great antiwar books. Centering on the infamous firebombing of Dresden, Billy Pilgrim's odyssey through time reflects the mythic journey of our own fractured lives as we search for meaning in what we fear most",
                                                  "In order to develop a secure defense against a hostile alien race's next attack, government agencies breed child geniuses and train them as soldiers. A brilliant young boy, Andrew \"Ender\" Wiggin lives with his kind but distant parents, his sadistic brother Peter, and the person he loves more than anyone else, his sister",
                                                  "IN THE YEAR 2044, reality is an ugly place. The only time teenage Wade Watts really feels alive is when he's jacked into the virtual utopia known as the OASIS. Wade's devoted his life to studying the puzzles hidden within this world's digital confines, puzzles that are based on their creator's obsession with the pop culture of decades past and that promise massive power and fortune to whoever can unlock them",
                                                  "After a dust storm nearly kills him and forces his crew to evacuate while thinking him dead, Mark finds himself stranded and completely alone with no way to even signal Earth that he’s alive—and even if he could get word out, his supplies would be gone long before a rescue could arrive",
                                                  "The story, told with an almost documentary verisimilitude, is an account of the attempt, through a hair-raising twenty-four hours on a remote jungle island, to avert a global emergency--a crisis triggered by today's headlong rush (virtually unchecked by any government or scientific watchdogs) ",
                                                  "et on the desert planet Arrakis, Dune is the story of the boy Paul Atreides, heir to a noble family tasked with ruling an inhospitable world where the only thing of value is the \"spice\" melange, a drug capable of extending life and enhancing consciousness. Coveted across the known universe, melange is a prize worth killing for...",
                                                  "A father and his son walk alone through burned America. Nothing moves in the ravaged landscape save the ash on the wind. It is cold enough to crack stones, and when the snow falls it is gray. The sky is dark. Their destination is the coast, although they don’t know what, if anything, awaits",
                                                  "This is the way the world ends: with a nanosecond of computer error in a Defense Department laboratory and a million casual contacts that form the links in a chain letter of death. And here is the bleak new world of the day after: a world stripped of its institutions and emptied of 99 percent of its people. A world in which a handful of panicky survivors choose sides",
                                                  "In Anthony Burgess's influential nightmare vision of the future, criminals take over after dark. Teen gang leader Alex narrates in fantastically inventive slang that echoes the violent intensity of youth rebelling against society. Dazzling and transgressive, A Clockwork Orange is a frightening fable about good and evil and the meaning of human freedom",
                                                  "For use in schools and libraries only. When brain surgery makes a mouse into a genius, dull-witted Charlie Gordon wonders if it might also work for him.",
                                                  "From the Booker Prize-winning author of The Remains of the Day and When We Were Orphans, comes an unforgettable edge-of-your-seat mystery that is at once heartbreakingly tender and morally courageous about what it means to be human.",
                                                  "So begins the Time Traveller’s astonishing firsthand account of his journey 800,000 years beyond his own era—and the story that launched H.G. Wells’s successful career and earned him his reputation as the father of science fiction. With a speculative leap that still fires the imagination, Wells sends his brave explorer to face a future burdened with our greatest hopes...and our darkest fears. A pull of the Time Machine’s lever propels him to the age of a slowly dying Earth.  There he discovers two bizarre races—the ethereal Eloi and the subterranean Morlocks—who not only symbolize the duality of human nature, but offer a terrifying portrait of the men of tomorrow as well.  Published in 1895, this masterpiece of invention captivated readers on the threshold of a new century. Thanks to Wells’s expert storytelling and provocative insight, The Time Machine will continue to enthrall readers for generations to come");

            Optional<Book> byId = bookRepository.findById(10);
            if (byId.isPresent()) {
                Book book = byId.get();
            }

            List<Book> all = bookRepository.findAll();
            int i = 0;
            for (Book book : all) {
                System.out.println(book.getCover());
                String newCover = generateBookCover(book);
                System.out.println(newCover);
                book.setCover(newCover);

                book.setSynopsis(synopsis.get(i++ % 20));
                bookRepository.saveAndFlush(book);
            }
        } else
            log.info("BOOK GENERATOR OFF");
        log.info("BOOK GENERATOR END");
    }

    public static String generateDescription(String entity, String name) {
        return String.format("Description of %s %s", entity, name);
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
        ip.drawString(book.getTitle(), 100, 150, Color.gray);

        ip.setFont(new Font("Dialog", Font.PLAIN, 20));
        int y = 350;
        Set<Author> authors1 = book.getAuthors();
        for (Author author : authors1) {
            ip.drawString(author.getAuthorName(), 100, y, Color.gray);
            y += 50;
        }

        ip.setFont(new Font("Dialog", Font.PLAIN, 20));
        if (book.getPublisher() != null)
            ip.drawString(book.getPublisher().getPublisherName(), 100, 580, Color.gray);

        ImagePlus imp = new ImagePlus("Book X", ip);

        imp.draw();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(imp.getBufferedImage(), "png", byteArrayOutputStream);
        byteArrayOutputStream.flush();
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return (Base64.getEncoder().encodeToString(toByteArray));
    }
}