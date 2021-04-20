package softuni.spring_fund_exam.init;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.spring_fund_exam.model.entities.enums.BandName;
import softuni.spring_fund_exam.model.service.ArtistServiceModel;
import softuni.spring_fund_exam.services.interfaces.ArtistService;

import java.util.Arrays;

import static softuni.spring_fund_exam.model.entities.enums.BandName.*;

@Component
public class DataInit implements CommandLineRunner {
    private final String QUEEN_CAREER = "Queen are a British rock band formed in London in 1970. Their classic line-up was Freddie Mercury (lead vocals, piano), Brian May (guitar, vocals), Roger Taylor (drums, vocals) and John Deacon (bass). Their earliest works were influenced by progressive rock, hard rock and heavy metal, but the band gradually ventured into more conventional and radio-friendly works by incorporating further styles, such as arena rock and pop rock.";
    private final String METALLICA_CAREER = "Metallica is an American heavy metal band. The band was formed in 1981 in Los Angeles by vocalist/guitarist James Hetfield and drummer Lars Ulrich, and has been based in San Francisco for most of its career. The band's fast tempos, instrumentals and aggressive musicianship made them one of the founding \"big four\" bands of thrash metal, alongside Megadeth, Anthrax and Slayer. Metallica's current lineup comprises founding members and primary songwriters Hetfield and Ulrich, longtime lead guitarist Kirk Hammett, and bassist Robert Trujillo. Guitarist Dave Mustaine and bassists Ron McGovney, Cliff Burton and Jason Newsted are former members of the band.";
    private final String MADONNA_CAREER = "Madonna Louise Ciccone - born and raised in Michigan, Madonna moved to New York City in 1978 to pursue a career in modern dance. After performing as a drummer, guitarist, and vocalist in the rock bands Breakfast Club and Emmy, she rose to solo stardom with her debut studio album, Madonna (1983). She followed it with a series of successful albums, including all-time bestsellers Like a Virgin (1984) and True Blue (1986) as well as Grammy Award winners Ray of Light (1998) and Confessions on a Dance Floor (2005).";


    private final ModelMapper modelMapper;
    private final ArtistService artistService;

    @Autowired
    public DataInit(ModelMapper modelMapper, ArtistService artistService) {
        this.modelMapper = modelMapper;
        this.artistService = artistService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.artistService.isEmpty()) {
            this.artistService.persist(new ArtistServiceModel(QUEEN, QUEEN_CAREER));
            this.artistService.persist(new ArtistServiceModel(METALLICA, METALLICA_CAREER));
            this.artistService.persist(new ArtistServiceModel(MADONNA, MADONNA_CAREER));
        }
    }
}
