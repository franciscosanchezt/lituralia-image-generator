package com.campusdual.lituraliaimagegenerator;

import com.campusdual.lituraliaimagegenerator.domain.Genre;
import com.campusdual.lituraliaimagegenerator.domain.Opinion;
import com.campusdual.lituraliaimagegenerator.domain.Publisher;
import com.campusdual.lituraliaimagegenerator.repositories.GenreRepository;
import com.campusdual.lituraliaimagegenerator.repositories.OpinionRepository;
import com.campusdual.lituraliaimagegenerator.repositories.PublisherRepository;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class APublisherGenerator implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(APublisherGenerator.class);

    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    OpinionRepository opinionRepository;

    public static final boolean isGenreActive = false;
    public static final boolean isPublisherActive = false;
    public static final boolean isOpinionActive = true;

    @Override
    public void run(String... strings) throws Exception {
        log.info("PUBLISHER GENERATOR START");
        if (isPublisherActive) {
            List<String> names = Arrays.asList("Aliados Editorial",
                                               "Mundo Comic",
                                               "Luna de Libros",
                                               "Me Encanta leer",
                                               "Editorial Ocaso",
                                               "Editorial Normas",
                                               "Salamandra",
                                               "Chidori Books",
                                               "Ediciones Kilob",
                                               "Editorial Noctis",
                                               "Ediciones Babilonia",
                                               "Editorial Mundo",
                                               "Atalaya",
                                               "Editorial Jove",
                                               "Editorial Meridional",
                                               "Hechiceros de la Costa",
                                               "Vechia Gal",
                                               "Olympus Galicia",
                                               "Kalandrakys",
                                               "Praia Edicions");

            String[] images = new String[20];
            for (int i = 0; i < images.length; i++) {
                try {
                    images[i] = AvatarGenerator.encodeFileToBase64Binary(new File(getClass().getClassLoader().getResource("logos/logo(" + (i + 1) + ").jpg").getFile()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            List<Publisher> all = publisherRepository.findAll();
            log.info("FOUND " + all.size() + " publishers");

            int i = 0;
            for (Publisher publisher : all) {
                System.out.println(publisher);
                publisher.setPublisherName(names.get(i % 20));
                publisher.setPublisherDesc(generateDescription("Publisher", publisher.getPublisherName()));

                publisher.setPublisherLogo(images[i % 20]);
                publisherRepository.saveAndFlush(publisher);
                i++;
                System.out.println(publisher);
            }
        } else
            log.info("PUBLISHER GENERATOR OFF");

        log.info("PUBLISHER GENERATOR END");

        log.info("GENRE GENERATOR START");
        if (isGenreActive) {

            List<Genre> all = genreRepository.findAll();
            log.info("FOUND " + all.size() + " genres");

            int i = 0;
            for (Genre genre : all) {
                genre.setGenreDesc(generateDescription("Genre", genre.getGenreName()));
                genreRepository.saveAndFlush(genre);
            }
        } else
            log.info("GENRE GENERATOR OFF");

        log.info("GENRE GENERATOR END");

        log.info("OPINION GENERATOR START");
        if (isOpinionActive) {
            List<String> reviews = Arrays.asList("Great", "Terrible", "Awesome", "Good", "Bad", "Hated it", "Loved It!!");
            List<String> reviewss = Arrays.asList("Some books are almost impossible to review. If a book is bad, how easily can we dwell on its flaws! But if the book is good, how do you give any recommendation that is equal the book? Unless you are an author of equal worth to the one whose work you review, what powers of prose and observation are you likely to have to fitly adorn the work",
                                                  "Books exist in time and place and our experience of them is affected by the specific time and place in which we encounter them. Sometimes an uplifting or inspiring book can change the path of a life that has wandered onto a wrong course. Sometimes a book, discovered early on, can form part of the foundation of who we are. Or, discovered late, can offer insight into the journey we have taken to date.",
                                                  "Far over the misty mountains cold To dungeons deep and caverns old We must away ere break of day To seek the pale enchanted gold",
                                                  "To call this the epitome in which all high fantasy should be judged does not quite suffice; this is simply one of the best books that has ever been written or will ever be written. The Hobbit defines the high fantasy genre along with its sequel, of course, and has been an inspiration to countless authors and readers alike.",
                                                  "Those words keep sounding in my head since I read this book. Gosh, probably the most haunting not to mention frightening book I've ever read. 1984 should also be included in the horror genre",
                                                  "Winston Smith is an open source developer who writes his code offline because his ISP has installed packet sniffers that are regulated by the government under the Patriot Act. It's really for his own protection, though. From, like, terrorists and DVD pirates and stuff. Like every good American, he drinks Coca-Cola and his processed food has desensitized his palate to all but four flavors: sweet, salty-so-that-you-will-drink-more-coca-cola, sweet, and Cooler Ranch",
                                                  "Not a particularly good novel, but it is a very good essay. On the novel front, the characters are bland and you only care about them because of the awful things they live through. As a novel all the political exposition is heavyhanded, and the message completely overrides any sense of storytelling. As an essay, the points it makes can be earthshaking. It seems everyone who has so much as gotten a parking ticket thinks he lives in a 1984-dystopia.",
                                                  "This was an up and down kind of read for me. There were parts that I really enjoyed and parts that I found extremely difficult to maneuver through. I'm glad that I decided to pick it up and give it a go, because it's one that I've been curious about for a long time. I can definitely see why so many people love this book. It explores a lot of things that we see happening in the world today. I can't say I'm leaving it as a massive fan, but I'm sure it's one that I'll continue to think about.",
                                                  "The most memorable and MOST DISTURBING vision of a world gone mad utterly bat-shit psycho that I have ever experienced. Ever!!! ",
                                                  "YOU. ARE. THE. DEAD. Oh my God. I got the chills so many times toward the end of this book. It completely blew my mind. It managed to surpass my high expectations AND be nothing at all like I expected. Or in Newspeak \"Double Plus Good",
                                                  "The novel is set in Airstrip One, formerly Great Britain, a province of the superstate Oceania, whose residents are victims of perpetual war, omnipresent government surveillance and public manipulation",
                                                  "This was the book that started my love affair with the dystopian genre. And maybe indirectly influenced my decision to do a politics degree. I was only 12 years old when I first read it but I suddenly saw how politics could be taken and manipulated to tell one hell of a scary and convincing story. I'm a lot more well-read now but, back then, this was a game-changer. I started to think about things differently. I started to think about 2 + 2 = 5 and I wanted to read more books that explored",
                                                  "What can I possibly say about this amazing novel, 1984 by George Orwell, that hasn't been already said by many who have read the book for over half a century. When it is said that the book is 'haunting', 'nightmarish', and 'startling' any reader would have to agree! This well known novel grips the reader from the beginning and does not even let go of the grip at the finished reading",
                                                  "Goodness gracious this was very unsettling. I'm already a pretty paranoid person, so the idea of Big Brother was both very intriguing but also extremely frightening",
                                                  "I really wanted to like this book. I think my low opinion is partially my fault, because I drove into the story with high expectations due to rave reviews. I need to learn not to do that.",
                                                  "Ladies and gentlemen. Direct your attention to the performer in print. You will be amazed, dazzled and mystified by the daring feats you are about to witness. Well, that might be overstating a bit. The story does open with drama, though. A circus menagerie has gotten loose and there is mayhem. The narrator, Jacob, sees the ringmaster murdered. We then scoot ahead to the present. Jacob is in his 90s and looks back, revisiting his",
                                                  "Just to put it out there, I’ll admit straight off the bat that I’m one of the people who enjoyed this book. It was a fast read (which I always appreciate, because I’m perpetually drowning in a list of books TBR) and it was fairly easy to get through. I also didn’t see the end coming",
                                                  "This book was PERFECT and I loved it. I want to read it again and again, and I can't recommend the audio book enough",
                                                  "It's truly admirable to place the plot on a moving train and its roving fairgrounds... it's like living in a cotton candy cloud. There were plenty of chances to dash the reader away, to make poetry out of the circus workers' vagrant conditions, to use the animals as characters, not just decor,... to avoid cliche. This novel is written concisely, but with often description so vague the reader just g",
                                                  "It's the 1930's, in the midst of the great depression and prohibition. At 23, Jacob Jankowski is just days away from taking his final exams at Cornell and becoming a veterinarian. He plans to join his fathers practice. Then he gets the devastating news that both his parents were killed in an automobile accident. They were behind on their mortgage and both their house and his fathers practice belong to the bank. There's nothing left for Jacob, no home to go to anymore. In a daz");

            List<Opinion> all = opinionRepository.findAll();
            log.info("FOUND " + all.size() + " opinons");
            for (Opinion opinion : all) {
                int rand = new Random().nextInt(10);
                int rand2 = new Random().nextInt(100);
                String review = (rand > 5 ? reviewss.get(rand2 % 20) : reviews.get(rand2 % 7));
                opinion.setReview(review);
                opinionRepository.saveAndFlush(opinion);
            }
        } else
            log.info("OPINION GENERATOR OFF");

        log.info("OPINION GENERATOR END");
    }

    public static String generateDescription(String entity, String name) {
        return String.format("Description of %s %s", entity, name);
    }


}