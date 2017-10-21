package frisky51.springframework.spring5webapp.controllers;

import frisky51.springframework.spring5webapp.repositories.AlbumRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumController {

    private AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @RequestMapping("/albums")
    public String getAlbums(Model model) {

        model.addAttribute("albums", albumRepository.findAll());

        return "albums";
    }
}
