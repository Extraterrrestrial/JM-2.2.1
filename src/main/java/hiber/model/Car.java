package hiber.model;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int car_id;

    @Column(name = "series")
    private int series;

    @Column(name = "model")
    private String model;

    @OneToOne(mappedBy = "car",cascade = CascadeType.ALL)
    private User user;

    public Car() {
    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}