package frisky51.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "artists")
    private Set<Album> albums = new HashSet<>();

    public Artist() {}

    public Artist(String name) {
        this.name = name;
    }

    public Artist(String name, Set<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    public String getName() {
        return name;
    }

    public void setTitle(String name) {
        this.name = name;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setArtists(Set<Album> albums) {
        this.albums = albums;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        return id != null ? id.equals(artist.id) : artist.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", albums=" + albums +
                '}';
    }
}