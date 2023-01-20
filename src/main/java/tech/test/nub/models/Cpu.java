package tech.test.nub.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cpus")
public class Cpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private String model;
    private String socket;
    @Column(name = "clock_speed")
    private Double clockSpeed;
    @Column(name = "number_of_cores")
    private Integer numberOfCores;
    @Column(name = "number_of_threads")
    private Integer numberOfThreads;
    private String Tdp;
    private BigDecimal price;
    private Boolean updated;
    private Boolean deleted;

    public Cpu() {
    }

    public Cpu(Integer id, String brand, String model, String socket, Double clockSpeed, Integer numberOfCores, Integer numberOfThreads, String tdp, BigDecimal price, Boolean updated, Boolean deleted) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.socket = socket;
        this.clockSpeed = clockSpeed;
        this.numberOfCores = numberOfCores;
        this.numberOfThreads = numberOfThreads;
        Tdp = tdp;
        this.price = price;
        this.updated = updated;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getUpdated() {
        return updated;
    }

    public void setUpdated(Boolean updated) {
        this.updated = updated;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public Double getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(Double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public Integer getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(Integer numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public Integer getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(Integer numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTdp() {
        return Tdp;
    }

    public void setTdp(String tdp) {
        Tdp = tdp;
    }
}
