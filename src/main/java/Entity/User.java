package Entity;
/*
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;*/
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class User {

   // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Long chatId;

    public User() {
    }

    public User(String username, Long chatId) {
        this.username = username;
        this.chatId = chatId;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }
}
