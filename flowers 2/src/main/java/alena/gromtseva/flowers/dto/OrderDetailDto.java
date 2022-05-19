package alena.gromtseva.flowers.dto;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetailDto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "flower_id")
    private String flowerId;

    @Column(name = "phone")
    private String phone;

}
