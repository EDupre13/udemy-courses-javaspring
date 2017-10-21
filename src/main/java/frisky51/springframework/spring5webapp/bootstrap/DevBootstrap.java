package frisky51.springframework.spring5webapp.bootstrap;

import frisky51.springframework.spring5webapp.model.Album;
import frisky51.springframework.spring5webapp.model.Artist;
import frisky51.springframework.spring5webapp.model.Producer;
import frisky51.springframework.spring5webapp.repositories.AlbumRepository;
import frisky51.springframework.spring5webapp.repositories.ArtistRepository;
import frisky51.springframework.spring5webapp.repositories.ProducerRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AlbumRepository albumRepository;
    private ArtistRepository artistRepository;
    private ProducerRepository producerRepository;

    public DevBootstrap(AlbumRepository albumRepository,
                        ArtistRepository artistRepository,
                        ProducerRepository producerRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.producerRepository = producerRepository;
    }

    private void initData() {
        Producer matt = new Producer("Matt Bayles");
        producerRepository.save(matt);

        Artist tfot = new Artist("The Fall Of Troy");
        Album manipulator = new Album("Manipulator", matt);

        tfot.getAlbums().add(manipulator);
        manipulator.getArtists().add(tfot);

        artistRepository.save(tfot);
        albumRepository.save(manipulator);

        Producer omar = new Producer("Omar Rodriguez-Lopez");
        producerRepository.save(omar);

        Artist marsvolta = new Artist("The Mars Volta");
        Album francesthemute = new Album("Frances The Mute", omar);

        marsvolta.getAlbums().add(francesthemute);
        francesthemute.getArtists().add(marsvolta);

        artistRepository.save(marsvolta);
        albumRepository.save(francesthemute);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}