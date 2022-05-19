package alena.gromtseva.flowers.dto;

import javax.persistence.*;

@Entity
@Table(name = "flower")
public class FlowerDto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String orderId;

    @Column(name = "price")
    private String flowerId;

}