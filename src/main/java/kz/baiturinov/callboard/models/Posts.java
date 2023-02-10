package kz.baiturinov.callboard.models;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String names;
    private String description;
    @Column(name = "min_price")
    private int minPrice;
    @Column(name = "currency_price")
    private int currencyPrice;
    private byte[] photos;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Person userId;

    public Posts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(int currencyPrice) {
        this.currencyPrice = currencyPrice;
    }

    public byte[] getPhotos() {
        return photos;
    }

    public void setPhotos(byte[] photos) {
        this.photos = photos;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Person getUserId() {
        return userId;
    }

    public void setUserId(Person userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Posts{"
                + "id=" + id
                + ", names='" + names + '\''
                + ", description='" + description + '\''
                + ", minPrice=" + minPrice
                + ", currentPrice=" + currencyPrice
                + ", photos=" + Arrays.toString(photos)
                + ", status=" + status
                + ", userId=" + userId
                + '}';
    }
}
