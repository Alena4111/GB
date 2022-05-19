package alena.gromtseva.flowers.dto;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrdersDto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "number")
    private String number;

}
