package com.campusdual.lituraliaimagegenerator;

import com.campusdual.lituraliaimagegenerator.domain.Author;
import com.campusdual.lituraliaimagegenerator.repositories.AuthorRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AvatarGenerator implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AvatarGenerator.class);

    @Autowired
    AuthorRepository authorRepository;

    public static final boolean isActive = false;

    @Override
    public void run(String... strings) throws Exception {
        log.info("AVATAR GENERATOR START");
        if (isActive) {
            String[] images = new String[16];
            for (int i = 0; i < images.length; i++) {
                try {
                    images[i] = encodeFileToBase64Binary(new File(getClass().getClassLoader().getResource("256x256/256_" + (i + 1) + ".png").getFile()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            List<String> bios = Arrays.asList("American novelist, short story writer, essayist, playwright, screenwriter and poet, was born August 22, 1920 in Waukegan, Illinois. He graduated from a Los Angeles high school in 1938. Although his formal education ended there, he became a \"student of life,\" selling newspapers on L.A. street corners from 1938 to 1942, spending his nights in the public library and his days at the typewriter. He became a full-time writer in 1943, and contributed numerous short stories to periodicals before publishing a collection of them, Dark Carnival, in 1947.",
                                              "English writer and one of the most prominent members of the famous Huxley family. He spent the latter part of his life in the United States, living in Los Angeles from 1937 until his death in 1963. Best known for his novels and wide-ranging output of essays, he also published short stories, poetry, travel writing, and film stories and scripts. Through his novels and essays Huxley functioned as an examiner and sometimes critic of social mores, norms and ideals",
                                              "English author, comic radio dramatist, and musician. He is best known as the author of the Hitchhiker's Guide to the Galaxy series. Hitchhiker's began on radio, and developed into a \"trilogy\" of five books (which sold more than fifteen million copies during his lifetime) as well as a television series, a comic book series, a computer game, and a feature film that was completed after Adams' death. The series has also been adapted for live theatre using various scripts",
                                              "Born in Indianapolis, later the setting for many of his novels. He attended Cornell University from 1941 to 1943, where he wrote a column for the student newspaper, the Cornell Daily Sun. Vonnegut trained as a chemist and worked as a journalist before joining the U.S. Army and serving in World War II.",
                                              "Born in Washington and grew up in California, Arizona, and Utah. He served a mission for the LDS Church in Brazil in the early 1970s. Besides his writing, he teaches occasional classes and workshops and directs plays",
                                              "Novelist, screenwriter, father, and full-time geek. His first novel, Ready Player One, was a New York Times and USA Today bestseller, appeared on numerous “best of the year” lists, and is set to be adapted into a motion picture by Warner Bros. and director Steven Spielberg. His second novel, ARMADA, debuted at #4 on the NYT Bestseller list and is being made into a film by Universal Pictures. Ernie lives in Austin, Texas, with his family, a time-traveling DeLorean, and a large collection of classic video games",
                                              "He is a lifelong space nerd and a devoted hobbyist of subjects such as relativistic physics, orbital mechanics, and the history of manned spaceflight. He also mixes a mean cocktail. He lives in California. Andy’s next book, ARTEMIS, is available now.\n",
                                              "one of the most successful novelists of his generation, admired for his meticulous scientific research and fast-paced narrative. He graduated summa cum laude and earned his MD from Harvard Medical School in 1969. His first novel, Odds On (1966), was written under the pseudonym John Lange and was followed by seven more Lange novels. He also wrote as Michael Douglas and Jeffery Hudson. His novel A Case of Need won the Edgar Award in 1969.",
                                              "American novelist and playwright. He has written ten novels in the Southern Gothic, western, and post-apocalyptic genres and has also written plays and screenplays. He received the Pulitzer Prize in 2007 for The Road, and his 2005 novel No Country for Old Men was adapted as a 2007 film of the same name, which won four Academy Awards, including Best Picture",
                                              "King was born the second son of Donald and Nellie Ruth Pillsbury King. After his father left them when Stephen was two, he and his older brother, David, were raised by his mother. Parts of his childhood were spent in Fort Wayne, Indiana, where his father's family was at the time, and in Stratford, Connecticut. When Stephen was eleven, his mother brought her children back to Durham, Maine, for good. Her parents, Guy and Nellie Pillsbury, had become incapacitated with old age, and Ruth King was persuaded by her sisters to take over the physical care of them. Other family members provided a small house in Durham and financial support",
                                              "British novelist, critic and composer. He was also a librettist, poet, playwright, screenwriter, essayist, travel writer, broadcaster, translator, linguist and educationalist. Born in Manchester, he lived for long periods in Southeast Asia, the USA and Mediterranean Europe as well as in England. His fiction includes the Malayan trilogy (The Long Day Wanes) on the dying days of Britain's empire in the East; the Enderby quartet of novels about a poet and his muse; Nothing Like the Sun, a recreation of Shakespeare's love-life; A Clockwork Orange",
                                              "American author best known for his Hugo award-winning short story and Nebula award-winning novel Flowers for Algernon. Keyes was given the Author Emeritus honor by the Science Fiction and Fantasy Writers of America in 2000",
                                              "British novelist of Japanese origin and Nobel Laureate in Literature (2017). His family moved to England in 1960. Ishiguro obtained his Bachelor's degree from the University of Kent in 1978 and his Master's from the University of East Anglia's creative writing course in 1980. He became a British citizen in 1982. He now lives in London",
                                              "Born to a working class family in Kent, England. Young Wells received a spotty education, interrupted by several illnesses and family difficulties, and became a draper's apprentice as a teenager. The headmaster of Midhurst Grammar School, where he had spent a year, arranged for him to return as an \"usher,\" or student teacher. Wells earned a government scholarship in 1884, to study biology under Thomas Henry Huxley at the Normal School of Science. Wells earned his bachelor of science and doctor of science degrees at the University of London",
                                              "Russian-born, American author, a professor of biochemistry, and a highly successful writer, best known for his works of science fiction and for his popular science books",
                                              "Born in Kabul, Afghanistan, in 1965. In 1970 Hosseini and his family moved to Iran where his father worked for the Embassy of Afghanistan in Tehran. In 1973 Hosseini's family returned to Kabul, and Hosseini's youngest brother was born in July of that year",
                                              "Born and raised in Santa Monica, California, Julie Clark grew up reading books on the beach while everyone else surfed. After attending college at University of the Pacific, and a brief stint working in the athletic department at University of California, Berkeley, she returned home to Santa Monica to teach. She now lives there with her two young sons and a golden doodle with poor impulse control",
                                              "New York Times bestselling author of ALL THE MISSING GIRLS, THE PERFECT STRANGER, and THE LAST HOUSE GUEST, a Reese Witherspoon Book Club pick. She has also written several books for young adults, including COME FIND ME, FRAGMENTS OF THE LOST, and THE SAFEST LIES. She grew up in New Jersey, graduated from MIT, and lives in North Carolina with her husband and two children",
                                              "Montreal, Canada. A graduate of McGill in History and Law, Catherine practices law in Montreal. An avid runner and skier, she's the author of numerous bestsellers including HIDDEN, FRACTURED, THE GOOD LIAR and I'LL NEVER TELL. Her works have been translated into multiple languages",
                                              "Jackson, Mississippi. After graduating from the University of Alabama with a degree in English and creative writing, she moved to New York City, where she worked in magazine publishing for nine years. She currently lives in Atlanta with her husband and daughter. She is working on her second novel");

            int i = 0;
            List<Author> all = authorRepository.findAll();
            for (Author author : all) {
                author.setAuthorPortrait(images[i % 16]);
                author.setAuthorBio(bios.get(i % 20));
                i++;
                authorRepository.saveAndFlush(author);
            }
        } else
            log.info("AVATAR GENERATOR OFF");

        log.info("AVATAR GENERATOR END");
    }


    public static String encodeFileToBase64Binary(File file) {
        String encodedfile = "";
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
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