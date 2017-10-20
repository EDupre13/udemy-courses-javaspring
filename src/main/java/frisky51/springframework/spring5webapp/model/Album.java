package frisky51.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String producer;

    @ManyToMany
    @JoinTable(name = "artist_albums", joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private Set<Artist> artists = new HashSet<>();

    public Album() {}

    public Album(String title, String producer) {
       this.title = title;
       this.producer = producer;
    }

    public Album(String title, String producer, Set<Artist> artists) {
        this.title = title;
        this.producer = producer;
        this.artists = artists;
    }

    public String get_Title() {
        return title;
    }

    public void set_Title(String title) {
        this.title = title;
    }

    public String get_Producer() {
        return producer;
    }

    public void set_Producer(String producer) {
        this.producer = producer;
    }

    public Set<Artist> get_Artists() {
        return artists;
    }

    public void set_Artists(Set<Artist> artists) {
        this.artists = artists;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        return id == album.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", producer='" + producer + '\'' +
                ", artists=" + artists +
                '}';
    }
}